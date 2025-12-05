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
class UsuarioSeg {

    String usuario;
    String password;

    public UsuarioSeg(String u, String p) {
        usuario = u;
        password = p;
    }

    public String toString() {
        return usuario + "," + password;
    }

    public static UsuarioSeg from(String s) {
        String[] p = s.split(",");
        return new UsuarioSeg(p[0], p[1]);
    }
}
