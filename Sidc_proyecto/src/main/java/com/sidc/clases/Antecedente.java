
package com.sidc.clases;

import java.util.Date;

public class Antecedente {

    private int id;
    private Date fecha;
    private String especialidad;
    private String diagnostico;
    private int matricula;
    private HistoriaClinica historiaClinica;

    public Antecedente() {
    }

    public Antecedente(Date fecha, String especialidad, String diagnostico, int matricula) {
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.diagnostico = diagnostico;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

}
