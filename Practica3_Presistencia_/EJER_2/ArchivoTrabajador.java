/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3_presistencia;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArchivoTrabajador {

    private String nombreArch = "trabajadores.dat";

    public ArchivoTrabajador() {
    }

    // a) Crear archivo
    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArch))) {
            oos.writeObject(new ArrayList<Trabajador>()); 
            System.out.println("Archivo creado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al crear archivo: " + e);
        }
    }

    // Leer lista de archivo
    private ArrayList<Trabajador> leerArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArch))) {
            return (ArrayList<Trabajador>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Guardar lista al archivo
    private void escribirArchivo(ArrayList<Trabajador> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArch))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            System.out.println("Error al escribir archivo: " + e);
        }
    }

    // b) Guardar trabajadores
    public void guardarTrabajador(Trabajador t) {
        ArrayList<Trabajador> lista = leerArchivo();
        lista.add(t);
        escribirArchivo(lista);
        System.out.println("Trabajador guardado.");
    }

    // c) Aumentar salario
    public void aumentarSalario(int aumento, Trabajador t) {
        ArrayList<Trabajador> lista = leerArchivo();
        for (Trabajador x : lista) {
            if (x.getCarnet() == t.getCarnet()) {
                x.setSalario(x.getSalario() + aumento);
            }
        }
        escribirArchivo(lista);
    }

    // d) Buscar trabajador con mayor salario
    public Trabajador buscarMayor() {
        ArrayList<Trabajador> lista = leerArchivo();
        if (lista.isEmpty()) {
            return null;
        }

        Trabajador mayor = Collections.max(lista, Comparator.comparingDouble(Trabajador::getSalario));
        return mayor;
    }

    // e) Ordenar por salario
    public void ordenarPorSalario() {
        ArrayList<Trabajador> lista = leerArchivo();
        lista.sort(Comparator.comparingDouble(Trabajador::getSalario));
        escribirArchivo(lista);
        System.out.println("Trabajadores ordenados por salario.");
    }

    // Mostrar todos
    public void mostrar() {
        ArrayList<Trabajador> lista = leerArchivo();
        System.out.println("=== LISTA DE TRABAJADORES ===");
        for (Trabajador t : lista) {
            System.out.println(t);
        }
    }
}
