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

public class ArchivoProducto {

    private String nomA;

    public ArchivoProducto(String n) {
        nomA = n;
    }

    // a) Crear archivo vacío
    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            ArrayList<Producto> lista = new ArrayList<>();
            oos.writeObject(lista);
            System.out.println("Archivo creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Leer lista desde archivo
    private ArrayList<Producto> leerLista() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomA))) {
            return (ArrayList<Producto>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Guardar lista al archivo
    private void guardarLista(ArrayList<Producto> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // b) Guardar producto
    public void guardarProducto(Producto p) {
        ArrayList<Producto> lista = leerLista();
        lista.add(p);
        guardarLista(lista);
        System.out.println("Producto guardado.");
    }

    // c) Buscar producto por código
    public Producto buscaProducto(int c) {
        ArrayList<Producto> lista = leerLista();
        for (Producto p : lista) {
            if (p.getCodigo() == c) {
                p.mostrar();
                return p;
            }
        }
        System.out.println("No existe producto con ese código.");
        return null;
    }

    // d) Calcular promedio de precios
    public float promedioPrecios() {
        ArrayList<Producto> lista = leerLista();
        if (lista.isEmpty()) {
            return 0;
        }

        float suma = 0;
        for (Producto p : lista) {
            suma += p.getPrecio();
        }

        return suma / lista.size();
    }

    // e) Producto más caro
    public Producto productoMasCaro() {
        ArrayList<Producto> lista = leerLista();
        if (lista.isEmpty()) {
            return null;
        }

        Producto max = lista.get(0);
        for (Producto p : lista) {
            if (p.getPrecio() > max.getPrecio()) {
                max = p;
            }
        }
        return max;
    }
}
