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
class Zoologico {

    int id;
    String nombre;
    int nroAnimales;
    Animal animales[] = new Animal[30];

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nroAnimales = 0;
    }

    public void agregarAnimal(Animal a) {
        if (nroAnimales < 30) {
            animales[nroAnimales++] = a;
        }
    }

    public int variedad() {
        return nroAnimales;
    }

    @Override
    public String toString() {
        return "Zoo " + id + " - " + nombre + " | Variedad: " + nroAnimales;
    }
}
