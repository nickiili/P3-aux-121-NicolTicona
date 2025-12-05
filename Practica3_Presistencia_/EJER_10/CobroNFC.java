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
class CobroNFC {

    String id;
    double monto;
    String fecha;

    public CobroNFC(String i, double m, String f) {
        id = i;
        monto = m;
        fecha = f;
    }

    public String toString() {
        return id + "," + monto + "," + fecha;
    }

    public static CobroNFC from(String s) {
        String[] p = s.split(",");
        return new CobroNFC(p[0], Double.parseDouble(p[1]), p[2]);
    }
}
