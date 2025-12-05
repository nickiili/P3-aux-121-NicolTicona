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
class DispositivoWiFi {

    String mac;
    String nombre;
    int velocidad;

    public DispositivoWiFi(String m, String n, int v) {
        mac = m;
        nombre = n;
        velocidad = v;
    }

    public String toString() {
        return mac + "," + nombre + "," + velocidad;
    }

    public static DispositivoWiFi from(String s) {
        String[] p = s.split(",");
        return new DispositivoWiFi(p[0], p[1], Integer.parseInt(p[2]));
    }
}
