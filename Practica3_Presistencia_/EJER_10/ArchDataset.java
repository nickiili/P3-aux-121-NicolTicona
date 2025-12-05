/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3_presistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
class ArchDataset {

    String archivo = "dataset.txt";

    public void guardar(Dataset d) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(d.toString());
        } catch (Exception e) {
        }
    }

    public void mostrar() {
        System.out.println("\n--- DATASETS ---");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                Dataset d = Dataset.from(l);
                System.out.println(d.nombre + " | Inst: " + d.instancias + " | Algoritmo: " + d.algoritmo);
            }
        } catch (Exception e) {
        }
    }

    public void buscar(String n) {
        System.out.println("\nBuscando dataset: " + n);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                Dataset d = Dataset.from(l);
                if (d.nombre.equalsIgnoreCase(n)) {
                    System.out.println("Encontrado → " + d.nombre + " | " + d.instancias + " | " + d.algoritmo);
                    return;
                }
            }
            System.out.println("No encontrado.");
        } catch (Exception e) {
        }
    }
}
