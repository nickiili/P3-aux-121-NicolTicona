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
class Medicamento implements Serializable {

    private String nombre;
    private int cod;
    private int tipo;
    private double precio;

    public Medicamento(String nombre, int cod, int tipo, double precio) {
        this.nombre = nombre;
        this.cod = cod;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return cod;
    }

    public int getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " (cod=" + cod + ", tipo=" + tipo + ", precio=" + precio + ")";
    }
}
