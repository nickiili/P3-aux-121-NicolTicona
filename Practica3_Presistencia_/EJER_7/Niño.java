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
class Niño extends Persona {

    private int edad;
    private double peso;
    private String talla;

    public Niño(String nombre, String apPat, String apMat, int ci, int edad, double peso, String talla) {
        this.nombre = nombre;
        this.apellidoPaterno = apPat;
        this.apellidoMaterno = apMat;
        this.ci = ci;
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getTalla() {
        return talla;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " (CI=" + ci + ", edad=" + edad + ", peso=" + peso + ", talla=" + talla + ")";
    }
}
