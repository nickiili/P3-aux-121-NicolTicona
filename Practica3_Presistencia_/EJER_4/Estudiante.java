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

public class Estudiante implements Serializable {

    private String ru;
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;

    public Estudiante(String ru, String nombre, String paterno, String materno, int edad) {
        this.ru = ru;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    public String getRu() {
        return ru;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public int getEdad() {
        return edad;
    }

    public void mostrar() {
        System.out.println(ru + " - " + nombre + " " + paterno + " " + materno + " (" + edad + ")");
    }
}
