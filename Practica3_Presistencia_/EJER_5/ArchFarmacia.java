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
import java.util.Comparator;
import java.util.List;

class ArchFarmacia {

    private String nombreArchivo;

    public ArchFarmacia(String na) {
        nombreArchivo = na;
    }

    public void crearArchivo(List<Farmacia> lista) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(lista);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Farmacia> leer() throws Exception {
        File f = new File(nombreArchivo);
        if (!f.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (List<Farmacia>) ois.readObject();
        }
    }

    // a) Mostrar medicamentos para la tos en sucursal X
    public void mostrarMedicamentosTos(int suc) throws Exception {
        List<Farmacia> lista = leer();
        for (Farmacia f : lista) {
            if (f.getSucursal() == suc) {
                System.out.println("Medicamentos para tos en sucursal " + suc + ":");
                f.mostrarMedicamentosTipo(1);
                return;
            }
        }
        System.out.println("Sucursal " + suc + " no encontrada.");
    }

    // b) Mostrar sucursal y dirección donde está TapSin
    public void mostrarSucursalConTapsin() throws Exception {
        List<Farmacia> lista = leer();
        boolean encontrado = false;
        for (Farmacia f : lista) {
            Medicamento m = f.buscarMedicamento("Tapsin");
            if (m != null) {
                System.out.println(f);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("(Tapsin no encontrado en ninguna sucursal)");
        }
    }

    // c) Buscar medicamentos por tipo
    public void buscarMedicamentosPorTipo(int tipo) throws Exception {
        List<Farmacia> lista = leer();
        for (Farmacia f : lista) {
            System.out.println("Sucursal " + f.getSucursal() + " – Tipo " + tipo + ":");
            f.mostrarMedicamentosTipo(tipo);
        }
    }

    // d) Ordenar farmacias por dirección
    public void ordenarPorDireccion() throws Exception {
        List<Farmacia> lista = leer();
        lista.sort(Comparator.comparing(Farmacia::getDireccion, Comparator.nullsFirst(String::compareTo)));
        for (Farmacia f : lista) {
            System.out.println(f);
        }
    }

    // e) Mover medicamentos de tipo X de farmacia A a farmacia Z
    public void moverMedicamentos(int tipo, int sucA, int sucZ) throws Exception {
        List<Farmacia> lista = leer();
        Farmacia a = null, z = null;
        for (Farmacia f : lista) {
            if (f.getSucursal() == sucA) {
                a = f;
            }
            if (f.getSucursal() == sucZ) {
                z = f;
            }
        }
        if (a == null) {
            System.out.println("Sucursal origen " + sucA + " no encontrada.");
            return;
        }
        if (z == null) {
            System.out.println("Sucursal destino " + sucZ + " no encontrada.");
            return;
        }
        a.moverMedicamentosTipo(tipo, z);
        crearArchivo(lista);
    }
}
