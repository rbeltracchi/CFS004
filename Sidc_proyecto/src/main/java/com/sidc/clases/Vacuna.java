
package com.sidc.clases;

import java.util.Date;
import java.util.List;

public class Vacuna {

    private String nombre;
    private int meses;
    private Date fechaVencimiento;
    private int idVacuna;
    private List<Sede> sedes;
    private List<Persona> personas;

    public Vacuna() {
    }
 public Vacuna(String nombre, int meses, Date fechaVencimiento, int idVacuna) {
        this.nombre = nombre;
        this.meses = meses;
        this.fechaVencimiento = fechaVencimiento;
        this.idVacuna = idVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public void setFecha(int meses) {
        this.meses = meses;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "nombre=" + nombre + ", meses=" + meses + ", fechaVencimiento=" + fechaVencimiento + ", idVacuna=" + idVacuna + ", sedes=" + sedes + '}';
    }

}
