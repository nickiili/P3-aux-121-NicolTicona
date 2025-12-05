/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.practica3_presistencia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
public class Practica3_Presistencia {

    public static void main(String[] args) throws Exception {
        ArchivoCharango archivo = new ArchivoCharango("charangos.dat");

        ArrayList<Charango> inicial = archivo.leerTodos();
        if (inicial.isEmpty()) {
            archivo.guardar(new Charango("Roble", new boolean[]{true, true, true, true, true, true, true, true, true, true}));
            archivo.guardar(new Charango("Caoba", new boolean[]{true, false, false, false, false, false, false, true, true, true}));
            archivo.guardar(new Charango("Pino", new boolean[]{true, true, true, true, false, false, false, false, false, false}));
        }

        // Leer lista actual
        ArrayList<Charango> lista = archivo.leerTodos();

        // Mostrar lista original
        System.out.println("=== LISTA ORIGINAL ===");
        printList(lista);

        // b) Eliminar charangos con más de 6 falses
        List<Charango> filtrados = lista.stream()
                .filter(c -> c.contarFalsas() <= 6)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("\n=== ELIMINAR DEFECTUOSOS (>6 false) ===");
        printList(filtrados);

        // c) Listar por material 'Caoba'
        System.out.println("\n=== LISTAR POR MATERIAL 'Caoba' ===");
        filtrados.stream()
                .filter(c -> c.getMaterial().equalsIgnoreCase("Caoba"))
                .forEach(System.out::println);

        // d) Buscar charangos con 10 cuerdas
        System.out.println("\n=== BUSCAR CON 10 CUERDAS ===");
        filtrados.stream()
                .filter(c -> c.getNroCuerdas() == 10)
                .forEach(System.out::println);

        // e) Ordenar por material alfabéticamente
        System.out.println("\n=== ORDENAR POR MATERIAL ===");
        ArrayList<Charango> ordenados = new ArrayList<>(filtrados);
        ordenados.sort(Comparator.comparing(Charango::getMaterial, String.CASE_INSENSITIVE_ORDER));
        printList(ordenados);

    }

    private static void printList(List<Charango> list) throws Exception {
        System.out.println(listToSingleLine(list));
        System.out.println();
        // además imprimimos cada elemento en líneas separadas si prefieres:
        for (Charango c : list) {
            System.out.println(c);
        }
    }

    // Para reproducir exactamente el formato tipo lista que mostraste:
    private static String listToSingleLine(List<Charango> list) throws Exception {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toString());
            if (i < list.size() - 1) {
                sb.append(",\n ");
            }

            sb.append("]");
            return sb.toString();
        }

            System.out.println("--------------------------------");

            ArchivoTrabajador arch2 = new ArchivoTrabajador();
            arch2.crearArchivo();

            // Guardar trabajadores
            arch2.guardarTrabajador(new Trabajador("Juan", 111, 2000));
            arch2.guardarTrabajador(new Trabajador("Maria", 222, 2500));
            arch2.guardarTrabajador(new Trabajador("Pedro", 333, 1800));

            System.out.println("\n--- LISTA INICIAL ---");
            arch2.mostrar();

            // Aumentar salario
            arch2.aumentarSalario(500, new Trabajador("", 333, 0));

            System.out.println("\n--- DESPUÉS DE AUMENTO ---");
            arch2.mostrar();

            // Mayor salario
            Trabajador mayor = arch2.buscarMayor();
            System.out.println("\nTrabajador con mayor salario: " + mayor);

            // Ordenar
            arch2.ordenarPorSalario();
            System.out.println("\n--- ORDENADOS POR SALARIO ---");
            arch2.mostrar();

            System.out.println("------------------------------------------");
            ArchivoProducto arch3 = new ArchivoProducto("productos.dat");

            arch3.crearArchivo();

            arch3.guardarProducto(new Producto(1, "Arroz", 20));
            arch3.guardarProducto(new Producto(2, "Leche", 12));
            arch3.guardarProducto(new Producto(3, "Queso", 35));

            System.out.println("\n=== Buscar producto código 2 ===");
            arch3.buscaProducto(2);

            System.out.println("\n=== Promedio precios ===");
            System.out.println(arch3.promedioPrecios());

            System.out.println("\n=== Producto más caro ===");
            Producto caro = arch3.productoMasCaro();
            if (caro != null) {
                caro.mostrar();
            }
            System.out.println("------------------------------------");
            ArchiNota archN = new ArchiNota("notas.dat");
            archN.crearArchivo();

            // b) Agregar estudiantes
            archN.agregarNota(new Nota("Mate", 70, new Estudiante("1", "Luis", "Perez", "Lopez", 20)));
            archN.agregarNota(new Nota("Prog", 95, new Estudiante("2", "Ana", "Rojas", "Vega", 19)));
            archN.agregarNota(new Nota("Mate", 95, new Estudiante("3", "Maria", "Gomez", "Lara", 21)));

            // c) Promedio
            System.out.println("Promedio: " + archN.promedioNotas());

            // d) Mejor nota
            archN.mejoresNotas();

            // e) Eliminar materia
            archN.eliminarMateria("Mate");

            System.out.println("Después de eliminar materia Mate:");
            archN.mejoresNotas();

            System.out.println("------------------------------------");
            ArchFarmacia archF = new ArchFarmacia("farmacias.dat");

            Farmacia f1 = new Farmacia("Patito", 1, "Av. Siempre Viva 123");
            f1.agregarMedicamento(new Medicamento("Tapsin", 11, 1, 20));
            f1.agregarMedicamento(new Medicamento("Ibuprofeno", 22, 2, 10));

            Farmacia f2 = new Farmacia("Vida Sana", 2, "Calle Luna 45");
            f2.agregarMedicamento(new Medicamento("Antitusivo", 33, 1, 30));

            List<Farmacia> lista = new ArrayList<>();
            lista.add(f1);
            lista.add(f2);

            archF.crearArchivo(lista);

            System.out.println("--- Medicamentos tos sucursal 1 ---");
            archF.mostrarMedicamentosTos(1);
            System.out.println();

            System.out.println("--- Sucursal con Tapsin ---");
            archF.mostrarSucursalConTapsin();
            System.out.println();

            System.out.println("--- Buscar tipo 1 ---");
            archF.buscarMedicamentosPorTipo(1);
            System.out.println();

            System.out.println("--- Ordenar por dirección ---");
            archF.ordenarPorDireccion();
            System.out.println();

            System.out.println("--- Mover tipo 1 de suc1 a suc2 ---");
            archF.moverMedicamentos(1, 1, 2);
            System.out.println();

            System.out.println("--- Estado después del movimiento ---");
            archF.buscarMedicamentosPorTipo(1);

            System.out.println("------------------------------------------");
            ArchBiblioteca arch6 = new ArchBiblioteca("biblioteca.dat");

            // Datos de prueba
            List<Libro> libros = new ArrayList<>();
            libros.add(new Libro(101, "Java Básico", 50.0));
            libros.add(new Libro(102, "Estructuras de Datos", 80.0));
            libros.add(new Libro(103, "Algoritmos", 90.0));
            libros.add(new Libro(104, "Patrones de Diseño", 120.0));

            List<Cliente> clientes = new ArrayList<>();
            clientes.add(new Cliente(1, "1234567", "Ana", "Gomez"));
            clientes.add(new Cliente(2, "2345678", "Luis", "Perez"));
            clientes.add(new Cliente(3, "3456789", "Marta", "Diaz"));

            List<Prestamo> prestamos = new ArrayList<>();
            // cliente 1 compra 2 ejemplares del libro 101
            prestamos.add(new Prestamo(1, 101, new Date(), 2));
            // cliente 2 compra 1 ejemplar del libro 102
            prestamos.add(new Prestamo(2, 102, new Date(), 1));
            // cliente 3 compra 3 ejemplares del libro 101
            prestamos.add(new Prestamo(3, 101, new Date(), 3));
            // cliente 1 compra 1 ejemplar del libro 103
            prestamos.add(new Prestamo(1, 103, new Date(), 1));

            // Guardar datos (sobrescribe biblioteca.dat)
            arch6.guardar(libros, clientes, prestamos);

            // Llamadas a los incisos a) - f)
            arch6.listarLibrosEntre(60, 100);          // a)
            arch6.ingresoTotalPorLibro(101);           // b)
            arch6.listarLibrosNuncaPrestados();        // c)
            arch6.clientesQueCompraronLibro(101);      // d)
            arch6.libroMasPrestado();                  // e)
            arch6.clienteConMasPrestamos();            // f)
            System.out.println("----------------------------------");
            ArchNiño archni = new ArchNiño("ninos.dat");

            List<Niño> listaa = new ArrayList<>();
            listaa.add(new Niño("Ana", "Gomez", "Lopez", 111, 5, 13, "M"));
            listaa.add(new Niño("Luis", "Perez", "Diaz", 222, 7, 20, "L"));
            listaa.add(new Niño("Marta", "Soto", "Rios", 333, 6, 10, "S"));
            listaa.add(new Niño("Jose", "Lopez", "Mora", 444, 10, 35, "XL"));

            archni.guardar(listaa);

            archni.contarPesoAdecuado(); // b
            archni.mostrarInadecuados(); // c
            archni.promedioEdad(); // d
            archni.buscarPorCI(222); // e
            archni.tallaMasAlta(); // f

            System.out.println("----------------------------------");
            ArchReFri refri = new ArchReFri("MiRefri");

            // Crear alimentos
            refri.crear(new Alimento("Manzana", "2024-12-01", 5));
            refri.crear(new Alimento("Leche", "2024-11-20", 1));
            refri.crear(new Alimento("Huevos", "2025-02-10", 12));
            refri.crear(new Alimento("Yogurt", "2024-10-15", 0));

            refri.mostrarTodo();

            // Modificar
            refri.modificar("Leche", "2024-11-25", 2);

            // Eliminar por nombre
            refri.eliminar("Yogurt");

            // b) Caducados antes de X
            refri.mostrarCaducadosAntes("2024-12-01");

            // c) Eliminar cantidad 0
            refri.eliminarCantidadCero();

            // d) Buscar vencidos
            refri.buscarVencidos();

            // e) Mayor cantidad
            refri.mayorCantidad();

            refri.mostrarTodo();

            System.out.println("-----------------------------------");
            ArchZoo ref = new ArchZoo("Archivador");

            // Crear zoológicos
            Zoologico z1 = new Zoologico(1, "Safari Park");
            z1.agregarAnimal(new Animal("Felino", "Tigre", 3));
            z1.agregarAnimal(new Animal("Ave", "Guacamayo", 5));

            Zoologico z2 = new Zoologico(2, "BioZoo");
            z2.agregarAnimal(new Animal("Reptil", "Cocodrilo", 2));

            Zoologico z3 = new Zoologico(3, "MiniZoo"); // vacío

            ref.crear(z1);
            ref.crear(z2);
            ref.crear(z3);

            ref.mostrarTodo();

            // Modificar
            ref.modificar(2, "BioCentro");

            // b)
            ref.listarMayorVariedad();

            // c)
            ref.eliminarVacios();

            // d)
            ref.mostrarEspecie("Felino");

            // e)
            ref.moverAnimales(1, 2);

            ref.mostrarTodo();

            System.out.println("-------------------------------");
            // Instancias
            ArchJugadores aj = new ArchJugadores();
            ArchDataset ad = new ArchDataset();
            ArchUsuariosSeg aus = new ArchUsuariosSeg();
            ArchEmpresas ae = new ArchEmpresas();
            ArchCobros ac = new ArchCobros();
            ArchWiFi aw = new ArchWiFi();

            // Datos ejemplo AUTOMÁTICOS para mostrar funcionamiento
            aj.guardar(new Jugador("Alex", 12, 3200));
            aj.guardar(new Jugador("Marcos", 5, 900));

            ad.guardar(new Dataset("Iris", 150, "SVM"));
            ad.guardar(new Dataset("MNIST", 60000, "CNN"));

            aus.guardar(new UsuarioSeg("admin", "1234"));
            aus.guardar(new UsuarioSeg("juan", "abcd"));

            ae.guardar(new Empresa("TechCorp", "Software", 120));
            ae.guardar(new Empresa("AgroMax", "Agricultura", 80));

            ac.guardar(new CobroNFC("TX1001", 25.5, "2024-01-15"));
            ac.guardar(new CobroNFC("TX1002", 100.0, "2024-02-20"));

            aw.guardar(new DispositivoWiFi("AA:BB:CC:11:22:33", "Laptop", 300));
            aw.guardar(new DispositivoWiFi("FF:EE:DD:44:55:66", "Smartphone", 150));

            // Mostrar todo
            aj.mostrar();
            aj.buscar("Alex");

            ad.mostrar();
            ad.buscar("Iris");

            aus.mostrar();
            aus.buscar("juan");

            ae.mostrar();
            ae.buscar("TechCorp");

            ac.mostrar();
            ac.buscar("TX1002");

            aw.mostrar();
            aw.buscar("AA:BB:CC:11:22:33");
        return null;

        

    }

}
