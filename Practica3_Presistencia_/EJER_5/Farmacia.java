/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3_presistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//CI: 6786427
class Farmacia implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Farmacia(String n, int s, String d) {
        nombreFarmacia = n;
        sucursal = s;
        direccion = d;
    }

    public void agregarMedicamento(Medicamento m) {
        if (m != null) {
            medicamentos.add(m);
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public Medicamento buscarMedicamento(String nom) {
        if (nom == null) {
            return null;
        }
        for (Medicamento m : medicamentos) {
            if (m != null && nom.equalsIgnoreCase(m.getNombre())) {
                return m;
            }
        }
        return null;
    }

    public void mostrarMedicamentosTipo(int tipo) {
        boolean found = false;
        for (Medicamento m : medicamentos) {
            if (m != null && m.getTipo() == tipo) {
                System.out.println("  " + m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("  (ninguno)");
        }
    }

    public void moverMedicamentosTipo(int tipo, Farmacia destino) {
        if (destino == null) {
            return;
        }
        Iterator<Medicamento> it = medicamentos.iterator();
        while (it.hasNext()) {
            Medicamento m = it.next();
            if (m != null && m.getTipo() == tipo) {
                destino.agregarMedicamento(m);
                it.remove(); // elimina correctamente de la lista origen
            }
        }
    }

    @Override
    public String toString() {
        return "Sucursal " + sucursal + " - " + direccion;
    }
}
