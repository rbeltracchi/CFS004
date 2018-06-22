
package com.sidc.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HistoriaClinica {
    private int id;
    private List<Antecedente> historial;
    private List<String> alergias;
    private List<Vacuna> vacunas;
    private String grupoSanguineo;

    public HistoriaClinica(int id, String grupoSanguineo) {
        this.id = id;
        this.grupoSanguineo = grupoSanguineo;
    }

    


    public HistoriaClinica() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }

    public List<Antecedente> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Antecedente> historial) {
        this.historial = historial;
    }


    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

}
