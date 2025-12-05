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
class Dataset {

    String nombre;
    int instancias;
    String algoritmo;

    public Dataset(String n, int i, String a) {
        nombre = n;
        instancias = i;
        algoritmo = a;
    }

    public String toString() {
        return nombre + "," + instancias + "," + algoritmo;
    }

    public static Dataset from(String s) {
        String[] p = s.split(",");
        return new Dataset(p[0], Integer.parseInt(p[1]), p[2]);
    }
}
