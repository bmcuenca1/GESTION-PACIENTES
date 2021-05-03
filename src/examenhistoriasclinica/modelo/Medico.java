/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.modelo;

/**
 *
 * @author bmcue
 */
public class Medico {
    private int  idMedico;
    private String nombre;
    private String apellido;
    private String cedula;
    private String especialidad;

    public Medico(int idMedico, String nombre, String apellido, String cedula, String especialidad) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.especialidad = especialidad;
    }

    public Medico() {
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
