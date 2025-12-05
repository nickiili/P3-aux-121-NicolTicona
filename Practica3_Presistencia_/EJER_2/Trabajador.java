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
import java.io.Serializable;

public class Trabajador implements Serializable {

    private String nombre;
    private int carnet;
    private double salario;

    public Trabajador(String nombre, int carnet, double salario) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCarnet() {
        return carnet;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Trabajador{"
                + "nombre='" + nombre + '\''
                + ", carnet=" + carnet
                + ", salario=" + salario
                + '}';
    }
}
