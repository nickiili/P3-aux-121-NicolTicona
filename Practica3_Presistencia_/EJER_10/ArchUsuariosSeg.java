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
class ArchUsuariosSeg {

    String archivo = "usuarios_seguro.txt";

    public void guardar(UsuarioSeg u) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(u.toString());
        } catch (Exception e) {
        }
    }

    public void mostrar() {
        System.out.println("\n--- USUARIOS (CIFRADOS) ---");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                UsuarioSeg u = UsuarioSeg.from(l);
                System.out.println("Usuario: " + u.usuario + " | Pass: " + u.password);
            }
        } catch (Exception e) {
        }
    }

    public void buscar(String nombre) {
        System.out.println("\nBuscando usuario: " + nombre);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                UsuarioSeg u = UsuarioSeg.from(l);
                if (u.usuario.equalsIgnoreCase(nombre)) {
                    System.out.println("Encontrado → " + u.usuario + " | " + u.password);
                    return;
                }
            }
        } catch (Exception e) {
        }
        System.out.println("No encontrado.");
    }
}
