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
class Jugador {

    String nombre;
    int nivel;
    int puntaje;

    public Jugador(String n, int lv, int pts) {
        nombre = n;
        nivel = lv;
        puntaje = pts;
    }

    public String toString() {
        return nombre + "," + nivel + "," + puntaje;
    }

    public static Jugador from(String s) {
        String[] p = s.split(",");
        return new Jugador(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]));
    }
}
