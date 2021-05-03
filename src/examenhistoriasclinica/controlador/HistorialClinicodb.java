/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.controlador;

import examenhistoriasclinica.conexionbd.Conexion;
import examenhistoriasclinica.modelo.HistorialClinico;
import examenhistoriasclinica.modelo.Paciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import examenhistoriasclinica.utilidades.Utilidades;

/**
 *
 * @author bmcue
 */
public class HistorialClinicodb {
    
    public boolean registrar(HistorialClinico historia) {
        boolean registrar = false;
       
        Statement stm = null;
        
        Connection con = null;
        
        String  sql = "INSERT INTO `examenhistoriaclinica`.`historialclinico` ( `edad`, `genero`, `ocupacion`,`profesion`,`antecedentes`,`enfermedades`,`idpaciente`) VALUES ( '" + historia.getEdad() + "', '" + historia.getGenero() + "', '" + historia.getOcupacion() + "', '" + historia.getProfesion()+ "', '"+ historia.getAntecedentesFamiliares() + "', '"+ historia.getEnfermedad() + "', '"+ historia.getIdPaciente() + "')";

        try {
            //Es una instancia de la conexion previamente creada.
            Conexion conexion = new Conexion();
            con = conexion.conectarBaseDatos();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return registrar;
    }
    
    public List<HistorialClinico> obtenerHistorias() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM examenhistoriaclinica.historialclinico INNER JOIN examenhistoriaclinica.paciente ON examenhistoriaclinica.historialclinico.idpaciente=examenhistoriaclinica.paciente.idpaciente ;";
        List<HistorialClinico> lista = new ArrayList<HistorialClinico>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                HistorialClinico c = new HistorialClinico();
                c.setIdHistorial(rs.getInt(1));
                c.setEdad(rs.getInt(2));
                c.setGenero(rs.getString(3));
                c.setOcupacion(rs.getString(4));
                c.setProfesion(rs.getString(5));
                c.setAntecedentesFamiliares(rs.getString(6));
                c.setEnfermedad(rs.getString(7));
                c.setIdPaciente(rs.getInt(8));
                //recuperamos los datos del paciente para presentar 
                Paciente paciente=new Paciente();
                paciente.setIdpaciente(rs.getInt(9));
                paciente.setNombre(rs.getString(10));
                paciente.setApellido(rs.getString(11));
                c.setPaciente(paciente);
                lista.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("ErrorListarPersonas:" + e.getMessage());
        }

        return lista;
    }
}
