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
class ArchZoo {

    String nombre;
    ArrayList<Zoologico> lista = new ArrayList<>();

    public ArchZoo(String nombre) {
        this.nombre = nombre;
    }

    // a) Crear
    public void crear(Zoologico z) {
        lista.add(z);
    }

    // a) Modificar
    public void modificar(int id, String nuevoNombre) {
        for (Zoologico z : lista) {
            if (z.id == id) {
                z.nombre = nuevoNombre;
            }
        }
    }

    // a) Eliminar
    public void eliminar(int id) {
        lista.removeIf(z -> z.id == id);
    }

    // b) Zoológicos con mayor variedad
    public void listarMayorVariedad() {
        System.out.println("\n*** Zoológicos con mayor variedad ***");
        if (lista.isEmpty()) {
            return;
        }

        int max = 0;
        for (Zoologico z : lista) {
            if (z.variedad() > max) {
                max = z.variedad();
            }
        }

        for (Zoologico z : lista) {
            if (z.variedad() == max) {
                System.out.println(z);
            }
        }
    }

    // c) Zoológicos vacíos y eliminarlos
    public void eliminarVacios() {
        System.out.println("\n*** Eliminando zoológicos vacíos ***");
        for (Zoologico z : lista) {
            if (z.nroAnimales == 0) {
                System.out.println("Eliminado: " + z.nombre);
            }
        }
        lista.removeIf(z -> z.nroAnimales == 0);
    }

    // d) Mostrar animales especie X
    public void mostrarEspecie(String especie) {
        System.out.println("\n*** Animales de especie: " + especie + " ***");
        for (Zoologico z : lista) {
            for (int i = 0; i < z.nroAnimales; i++) {
                if (z.animales[i].especie.equalsIgnoreCase(especie)) {
                    System.out.println("En zoo " + z.nombre + ": " + z.animales[i]);
                }
            }
        }
    }

    // e) Mover animales de zoo X a Y
    public void moverAnimales(int x, int y) {
        Zoologico zx = null, zy = null;

        for (Zoologico z : lista) {
            if (z.id == x) {
                zx = z;
            }
            if (z.id == y) {
                zy = z;
            }
        }

        if (zx == null || zy == null) {
            return;
        }

        System.out.println("\n*** Moviendo animales de " + zx.nombre + " a " + zy.nombre + " ***");

        for (int i = 0; i < zx.nroAnimales; i++) {
            zy.agregarAnimal(zx.animales[i]);
        }
        zx.nroAnimales = 0; // quedó vacío
    }

    // Mostrar general
    public void mostrarTodo() {
        System.out.println("\n--- Zoológicos ---");
        for (Zoologico z : lista) {
            System.out.println(z);
            for (int i = 0; i < z.nroAnimales; i++) {
                System.out.println("   - " + z.animales[i]);
            }
        }
    }
}
