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
import java.util.*;
import java.text.SimpleDateFormat;

class Alimento {

    String nombre;
    String fechaVencimiento;
    int cantidad;

    public Alimento(String nombre, String fechaVencimiento, int cantidad) {
        this.nombre = nombre;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + " | Vence: " + fechaVencimiento + " | Cantidad: " + cantidad;
    }
}
