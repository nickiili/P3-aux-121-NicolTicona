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
class ArchCobros {

    String archivo = "cobros_nfc.txt";

    public void guardar(CobroNFC c) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(c.toString());
        } catch (Exception e) {
        }
    }

    public void mostrar() {
        System.out.println("\n--- COBROS NFC ---");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                CobroNFC c = CobroNFC.from(l);
                System.out.println(c.id + " | $" + c.monto + " | " + c.fecha);
            }
        } catch (Exception e) {
        }
    }

    public void buscar(String id) {
        System.out.println("\nBuscando transacción: " + id);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                CobroNFC c = CobroNFC.from(l);
                if (c.id.equalsIgnoreCase(id)) {
                    System.out.println("Encontrada → " + c.id + " | $" + c.monto + " | " + c.fecha);
                    return;
                }
            }
        } catch (Exception e) {
        }
        System.out.println("No encontrada.");
    }
}
