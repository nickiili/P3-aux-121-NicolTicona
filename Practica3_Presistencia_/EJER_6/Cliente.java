/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3_presistencia;

import java.io.Serializable;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private int codCliente;
    private String ci;
    private String nombre;
    private String apellido;

    public Cliente(int codCliente, String ci, String nombre, String apellido) {
        this.codCliente = codCliente;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodCliente() {
        return codCliente;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (codCliente=" + codCliente + ")";
    }
}
