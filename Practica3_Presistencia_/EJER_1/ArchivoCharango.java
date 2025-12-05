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

public class ArchivoCharango {

    private final String nombreArchivo;

    public ArchivoCharango(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Charango> leerTodos() {
        File f = new File(nombreArchivo);
        if (!f.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (ArrayList<Charango>) ois.readObject();
        } catch (EOFException eof) {
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void sobreEscribir(ArrayList<Charango> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardar(Charango c) {
        ArrayList<Charango> lista = leerTodos();
        lista.add(c);
        sobreEscribir(lista);
    }
}
