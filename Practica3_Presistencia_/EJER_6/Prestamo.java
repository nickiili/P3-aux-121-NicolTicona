/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3_presistencia;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    private int codCliente;
    private int codLibro;
    private Date fechaPrestamo;
    private int cantidad;

    public Prestamo(int codCliente, int codLibro, Date fechaPrestamo, int cantidad) {
        this.codCliente = codCliente;
        this.codLibro = codLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.cantidad = cantidad;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public int getCodLibro() {
        return codLibro;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Prestamo[cCliente=" + codCliente + ", cLibro=" + codLibro + ", cantidad=" + cantidad + "]";
    }
}
