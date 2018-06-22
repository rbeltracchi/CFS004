
package com.sidc.clases;

import java.io.Serializable;
import java.util.List;

public class Sede implements Serializable {

    private Integer idSede;
    private String nombre;
    private String calle;
    private Integer numero;
    private Integer piso;
    private String letra;    
    private String telefono;
    private String email;
    private List<Vacuna> vacunas;

    public Sede() {
    }

    public Sede( String nombre, String calle, Integer numero, Integer piso, String letra, String telefono, String email) {
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public List<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
