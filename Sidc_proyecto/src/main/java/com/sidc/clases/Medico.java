
package com.sidc.clases;

public class Medico {

    private int matricula;
    private String especialidad;
    private String contrase�a;
    private int dniMedico;
    private String nombre;
    private String apellido;

    public Medico() {
    }

    public Medico(int matricula, String especialidad, String contrase�a, int dniMedico, String nombre, String apellido) {
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.contrase�a = contrase�a;
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

    public String getContrase�a() {
        return contrase�a;
    }

    public void setContrase�a(String contrase�a) {
        this.contrase�a = contrase�a;
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
