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
class ArchEmpresas {

    String archivo = "empresas.txt";

    public void guardar(Empresa e) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(e.toString());
        } catch (Exception ex) {
        }
    }

    public void mostrar() {
        System.out.println("\n--- EMPRESAS ---");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                Empresa e = Empresa.from(l);
                System.out.println(e.nombre + " | " + e.rubro + " | Emp: " + e.empleados);
            }
        } catch (Exception ex) {
        }
    }

    public void buscar(String nombre) {
        System.out.println("\nBuscando empresa: " + nombre);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                Empresa e = Empresa.from(l);
                if (e.nombre.equalsIgnoreCase(nombre)) {
                    System.out.println("Encontrada → " + e.nombre + " | " + e.rubro + " | Emp: " + e.empleados);
                    return;
                }
            }
        } catch (Exception ex) {
        }
        System.out.println("No encontrada.");
    }
}
