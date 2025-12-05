/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
package com.mycompany.practica3_presistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ArchBiblioteca {

    private String nombreArchivo;

    public ArchBiblioteca(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardar(List<Libro> libros, List<Cliente> clientes, List<Prestamo> prestamos) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(libros);
            oos.writeObject(clientes);
            oos.writeObject(prestamos);
        }
    }

    @SuppressWarnings("unchecked")
    public ListaDatos leer() throws Exception {
        File f = new File(nombreArchivo);
        if (!f.exists()) {
            // archivo no existe -> devolver listas vacías en vez de lanzar excepción
            return new ListaDatos(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            List<Libro> libros = (List<Libro>) ois.readObject();
            List<Cliente> clientes = (List<Cliente>) ois.readObject();
            List<Prestamo> prestamos = (List<Prestamo>) ois.readObject();
            return new ListaDatos(
                    libros != null ? libros : new ArrayList<>(),
                    clientes != null ? clientes : new ArrayList<>(),
                    prestamos != null ? prestamos : new ArrayList<>()
            );
        }
    }

    // a) Listar los libros cuyo precio estén entre x e y
    public void listarLibrosEntre(double x, double y) throws Exception {
        ListaDatos ld = leer();
        System.out.println("Libros con precio entre " + x + " y " + y + ":");
        boolean found = false;
        for (Libro l : ld.libros) {
            if (l.getPrecio() >= x && l.getPrecio() <= y) {
                System.out.println(" - " + l);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" (ninguno)");
        }
        System.out.println();
    }

    // b) Calcular ingreso total generado por un libro específico (por código)
    public void ingresoTotalPorLibro(int codLibro) throws Exception {
        ListaDatos ld = leer();
        double ingreso = 0;
        Libro libro = null;
        for (Libro l : ld.libros) {
            if (l.getCodLibro() == codLibro) {
                libro = l;
                break;
            }
        }
        if (libro == null) {
            System.out.println("Libro no encontrado: " + codLibro + "\n");
            return;
        }
        for (Prestamo p : ld.prestamos) {
            if (p.getCodLibro() == codLibro) {
                ingreso += p.getCantidad() * libro.getPrecio();
            }
        }
        System.out.println("Ingreso total por libro '" + libro.getTitulo() + "' = " + ingreso + "\n");
    }

    // c) Mostrar la lista de libros que nunca fueron prestados
    public void listarLibrosNuncaPrestados() throws Exception {
        ListaDatos ld = leer();
        Set<Integer> vendidos = new HashSet<>();
        for (Prestamo p : ld.prestamos) {
            vendidos.add(p.getCodLibro());
        }
        System.out.println("Libros nunca prestados:");
        boolean found = false;
        for (Libro l : ld.libros) {
            if (!vendidos.contains(l.getCodLibro())) {
                System.out.println(" - " + l);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" (ninguno)");
        }
        System.out.println();
    }

    // d) Mostrar todos los clientes que prestaron un libro específico
    public void clientesQueCompraronLibro(int codLibro) throws Exception {
        ListaDatos ld = leer();
        Set<Integer> codClientes = new LinkedHashSet<>();
        for (Prestamo p : ld.prestamos) {
            if (p.getCodLibro() == codLibro) {
                codClientes.add(p.getCodCliente());
            }
        }
        System.out.println("Clientes que prestaron el libro cod=" + codLibro + ":");
        boolean found = false;
        for (Cliente c : ld.clientes) {
            if (codClientes.contains(c.getCodCliente())) {
                System.out.println(" - " + c);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" (ninguno)");
        }
        System.out.println();
    }

    // e) Definir el libro más prestado (por cantidad total)
    public void libroMasPrestado() throws Exception {
        ListaDatos ld = leer();
        if (ld.prestamos.isEmpty()) {
            System.out.println("No hay prestamos.\n");
            return;
        }
        Map<Integer, Integer> contador = new HashMap<>(); // codLibro -> total cantidad
        for (Prestamo p : ld.prestamos) {
            contador.put(p.getCodLibro(), contador.getOrDefault(p.getCodLibro(), 0) + p.getCantidad());
        }
        int mejorCod = -1;
        int max = -1;
        for (Map.Entry<Integer, Integer> e : contador.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                mejorCod = e.getKey();
            }
        }
        if (mejorCod == -1) {
            System.out.println("No hay prestamos.\n");
            return;
        }
        for (Libro l : ld.libros) {
            if (l.getCodLibro() == mejorCod) {
                System.out.println("Libro más prestado: " + l + " (cantidad prestada total=" + max + ")\n");
                return;
            }
        }
        System.out.println("Libro más prestado (código " + mejorCod + ") no está en la lista de libros.\n");
    }

    // f) Mostrar el cliente que tuvo más préstamos (por número de registros de préstamo)
    public void clienteConMasPrestamos() throws Exception {
        ListaDatos ld = leer();
        if (ld.prestamos.isEmpty()) {
            System.out.println("No hay prestamos.\n");
            return;
        }
        Map<Integer, Integer> contador = new HashMap<>(); // codCliente -> num prestamos
        for (Prestamo p : ld.prestamos) {
            contador.put(p.getCodCliente(), contador.getOrDefault(p.getCodCliente(), 0) + 1);
        }
        int mejor = -1, codMejor = -1;
        for (Map.Entry<Integer, Integer> e : contador.entrySet()) {
            if (e.getValue() > mejor) {
                mejor = e.getValue();
                codMejor = e.getKey();
            }
        }
        if (codMejor == -1) {
            System.out.println("No hay prestamos.\n");
            return;
        }
        for (Cliente c : ld.clientes) {
            if (c.getCodCliente() == codMejor) {
                System.out.println("Cliente con más préstamos: " + c + " (nPrestamos=" + mejor + ")\n");
                return;
            }
        }
        System.out.println("Cliente con más préstamos (código " + codMejor + ") no está en la lista de clientes.\n");
    }

    static class ListaDatos {

        List<Libro> libros;
        List<Cliente> clientes;
        List<Prestamo> prestamos;

        ListaDatos(List<Libro> l, List<Cliente> c, List<Prestamo> p) {
            libros = l;
            clientes = c;
            prestamos = p;
        }
    }

}
