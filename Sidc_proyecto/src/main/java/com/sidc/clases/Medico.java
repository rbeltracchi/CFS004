
package com.sidc.clases;

public class Medico {

    private int matricula;
    private String especialidad;
    private String contraseña;
    private int dniMedico;
    private String nombre;
    private String apellido;

    public Medico() {
    }

    public Medico(int matricula, String especialidad, String contraseña, int dniMedico, String nombre, String apellido) {
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.contraseña = contraseña;
        this.dniMedico = dniMedico;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getDniMedico() {
        return dniMedico;
    }

    public void setDniMedico(int dni) {
        this.dniMedico = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
