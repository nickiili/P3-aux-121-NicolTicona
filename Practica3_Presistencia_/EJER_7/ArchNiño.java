/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3_presistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
public class ArchNiño {

    private String archivo;

    public ArchNiño(String archivo) {
        this.archivo = archivo;
    }

    public void guardar(List<Niño> lista) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
        oos.writeObject(lista);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public List<Niño> leer() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
        List<Niño> lista = (List<Niño>) ois.readObject();
        ois.close();
        return lista;
    }
    // b) Peso adecuado segun talla y edad (criterio ejemplo)

    public void contarPesoAdecuado() throws Exception {
        List<Niño> lista = leer();
        int cont = 0;
        for (Niño n : lista) {
            double ideal = n.getEdad() * 2.5; // criterio ejemplo
            if (Math.abs(n.getPeso() - ideal) <= 3) {
                cont++;
            }
        }
        System.out.println("Niños con peso adecuado: " + cont + "\n");
    }

// c) Mostrar niños con peso inadecuado
    public void mostrarInadecuados() throws Exception {
        List<Niño> lista = leer();
        System.out.println("Niños con peso/talla inadecuada:");
        for (Niño n : lista) {
            double ideal = n.getEdad() * 2.5;
            if (Math.abs(n.getPeso() - ideal) > 3) {
                System.out.println(" - " + n);
            }
        }
        System.out.println();
    }
    // d) Promedio edad

    public void promedioEdad() throws Exception {
        List<Niño> lista = leer();
        double sum = 0;
        for (Niño n : lista) {
            sum += n.getEdad();
        }
        System.out.println("Promedio de edad = " + (sum / lista.size()) + "\n");
    }

// e) Buscar niño por carnet
    public void buscarPorCI(int ci) throws Exception {
        for (Niño n : leer()) {
            if (n.ci == ci) {
                System.out.println("Encontrado: " + n + "\n");
                return;
            }
        }
        System.out.println("No encontrado CI=" + ci + "\n");
    }

// f) Mostrar niños con la talla más alta
    public void tallaMasAlta() throws Exception {
        List<Niño> lista = leer();
        String maxT = "";
        for (Niño n : lista) {
            if (n.getTalla().compareTo(maxT) > 0) {
                maxT = n.getTalla();
            }
        }
        System.out.println("Niños con talla más alta (" + maxT + "):");
        for (Niño n : lista) {
            if (n.getTalla().equals(maxT)) {
                System.out.println(" - " + n);
            }
        }
        System.out.println();
    }
}
