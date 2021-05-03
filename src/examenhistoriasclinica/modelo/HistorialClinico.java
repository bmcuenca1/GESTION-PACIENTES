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
public class HistorialClinico {
    private int idHistorial;
    private int edad;
    private String genero;
    private String ocupacion;
    private String profesion;
    private String antecedentesFamiliares;
    private String enfermedad;
    private int idPaciente;
    private Paciente paciente;

    public HistorialClinico(int idHistorial, int edad, String genero, String ocupacion, String profesion, String antecedentesFamiliares, String enfermedad, int idPaciente) {
        this.idHistorial = idHistorial;
        this.edad = edad;
        this.genero = genero;
        this.ocupacion = ocupacion;
        this.profesion = profesion;
        this.antecedentesFamiliares = antecedentesFamiliares;
        this.enfermedad = enfermedad;
        this.idPaciente = idPaciente;
    }
    
     

    public HistorialClinico() {
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public void setAntecedentesFamiliares(String antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    public Paciente getPaciente(){
        return paciente;
    }
    
    public void setPaciente(Paciente paciente){
        this.paciente=paciente;
    }
    
}
