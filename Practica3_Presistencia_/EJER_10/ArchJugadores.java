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
class ArchJugadores {

    String archivo = "jugadores.txt";

    public void guardar(Jugador j) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(j.toString());
        } catch (Exception e) {
        }
    }

    public void mostrar() {
        System.out.println("\n--- JUGADORES ---");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                Jugador j = Jugador.from(l);
                System.out.println("Nombre: " + j.nombre + " | Nivel: " + j.nivel + " | Puntaje: " + j.puntaje);
            }
        } catch (Exception e) {
        }
    }

    public void buscar(String nombre) {
        System.out.println("\nBuscando: " + nombre);
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                Jugador j = Jugador.from(l);
                if (j.nombre.equalsIgnoreCase(nombre)) {
                    System.out.println("Encontrado → " + j.nombre + " | Nivel: " + j.nivel + " | Puntaje: " + j.puntaje);
                    return;
                }
            }
            System.out.println("No encontrado.");
        } catch (Exception e) {
        }
    }
}
