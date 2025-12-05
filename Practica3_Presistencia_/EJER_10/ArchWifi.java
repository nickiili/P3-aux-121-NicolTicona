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
class ArchWiFi {

    String archivo = "dispositivos_wifi.txt";

    public void guardar(DispositivoWiFi d) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(d.toString());
        } catch (Exception e) {
        }
    }

    public void mostrar() {
        System.out.println("\n--- DISPOSITIVOS WIFI ---");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                DispositivoWiFi d = DispositivoWiFi.from(l);
                System.out.println(d.mac + " | " + d.nombre + " | " + d.velocidad + " Mbps");
            }
        } catch (Exception e) {
        }
    }

    public void buscar(String mac) {
        System.out.println("\nBuscando MAC: " + mac);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                DispositivoWiFi d = DispositivoWiFi.from(l);
                if (d.mac.equalsIgnoreCase(mac)) {
                    System.out.println("Encontrado → " + d.mac + " | " + d.nombre + " | " + d.velocidad + " Mbps");
                    return;
                }
            }
        } catch (Exception e) {
        }
        System.out.println("No encontrado.");
    }
}
