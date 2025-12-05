/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3_presistencia;

import java.util.ArrayList;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
class ArchReFri {

    String nombre;
    ArrayList<Alimento> lista = new ArrayList<>();

    public ArchReFri(String nombre) {
        this.nombre = nombre;
    }

    // a) Crear
    public void crear(Alimento a) {
        lista.add(a);
    }

    // a) Modificar por nombre
    public void modificar(String nombre, String nuevaFecha, int nuevaCantidad) {
        for (Alimento a : lista) {
            if (a.nombre.equalsIgnoreCase(nombre)) {
                a.fechaVencimiento = nuevaFecha;
                a.cantidad = nuevaCantidad;
            }
        }
    }

    // a) Eliminar por nombre
    public void eliminar(String nombre) {
        lista.removeIf(a -> a.nombre.equalsIgnoreCase(nombre));
    }

    // b) Mostrar alimentos que caducaron antes de fecha X
    public void mostrarCaducadosAntes(String fechaX) {
        System.out.println("\n*** Caducados antes de " + fechaX + " ***");
        for (Alimento a : lista) {
            if (a.fechaVencimiento.compareTo(fechaX) < 0) {
                System.out.println(a);
            }
        }
    }

    // c) Eliminar los que tengan cantidad 0
    public void eliminarCantidadCero() {
        lista.removeIf(a -> a.cantidad == 0);
    }

    // d) Buscar alimentos ya vencidos (fecha < hoy)
    public void buscarVencidos() {
        System.out.println("\n*** Alimentos vencidos ***");
        String hoy = "2025-01-01"; // ejemplo fijo para que siempre funcione
        for (Alimento a : lista) {
            if (a.fechaVencimiento.compareTo(hoy) < 0) {
                System.out.println(a);
            }
        }
    }

    // e) Mostrar el alimento con más cantidad
    public void mayorCantidad() {
        System.out.println("\n*** Alimento con mayor cantidad ***");
        if (lista.isEmpty()) {
            return;
        }

        Alimento max = lista.get(0);
        for (Alimento a : lista) {
            if (a.cantidad > max.cantidad) {
                max = a;
            }
        }
        System.out.println(max);
    }

    // Mostrar todo (solo para pruebas)
    public void mostrarTodo() {
        System.out.println("\n--- Lista completa ---");
        for (Alimento a : lista) {
            System.out.println(a);
        }
    }
}
