/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.modelo;

import java.util.Date;

/**
 *
 * @author bmcue
 */
public class Examenes {
    private int idExamenes;
    private String nombreExamen;
    private String  tipoExamen;
    private Date fecha;
    private int idMedico;
    private int idPaciente;
    private Paciente paciente;
    private Medico medico;

    public Examenes() {
    }
    
    

    public Examenes(int idExamenes, String nombreExamen, String tipoExamen, Date fecha, int idMedico, int idPaciente) {
        this.idExamenes = idExamenes;
        this.nombreExamen = nombreExamen;
        this.tipoExamen = tipoExamen;
        this.fecha = fecha;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }
    
    

    public int getIdExamenes() {
        return idExamenes;
    }

    public void setIdExamenes(int idExamenes) {
        this.idExamenes = idExamenes;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
    
}
