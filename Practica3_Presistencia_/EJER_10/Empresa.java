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
class Empresa {

    String nombre;
    String rubro;
    int empleados;

    public Empresa(String n, String r, int e) {
        nombre = n;
        rubro = r;
        empleados = e;
    }

    public String toString() {
        return nombre + "," + rubro + "," + empleados;
    }

    public static Empresa from(String s) {
        String[] p = s.split(",");
        return new Empresa(p[0], p[1], Integer.parseInt(p[2]));
    }
}
