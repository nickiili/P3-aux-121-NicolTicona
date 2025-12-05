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
import java.util.Arrays;

public class Charango implements Serializable {
    private static final long serialVersionUID = 1L;
    private String material;
    private int nroCuerdas;
    private boolean[] cuerdas; 

    public Charango(String material, boolean[] cuerdas) {
        if (cuerdas == null || cuerdas.length != 10)
            throw new IllegalArgumentException("cuerdas debe tener longitud 10");
        this.material = material;
        this.nroCuerdas = cuerdas.length;
        this.cuerdas = cuerdas;
    }

    public String getMaterial() { return material; }
    public int getNroCuerdas() { return nroCuerdas; }
    public boolean[] getCuerdas() { return cuerdas; }

    public int contarFalsas() {
        int c = 0;
        for (boolean b : cuerdas) if (!b) c++;
        return c;
    }

    @Override
    public String toString() {
        return "Charango(material=" + material
                + ", cuerdas=" + nroCuerdas
                + ", estado=" + Arrays.toString(cuerdas) + ")";
    }
}
