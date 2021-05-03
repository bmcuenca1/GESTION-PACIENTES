/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.controlador;

import examenhistoriasclinica.conexionbd.Conexion;
import examenhistoriasclinica.modelo.Examenes;
import examenhistoriasclinica.modelo.Medico;
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
public class Examenesdb {
    public boolean registrar(Examenes examenes) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        
        String  sql = "INSERT INTO `examenhistoriaclinica`.`examenes` (`nombreexamen`, `tipoexamen`, `idmedico`, `idpaciente`,`fecha`) VALUES ('" + examenes.getNombreExamen() + "', '" + examenes.getTipoExamen() + "', '" + examenes.getIdMedico() + "', '" + examenes.getIdPaciente() + "', '" +Utilidades.devolverFecha(examenes.getFecha())+"');";

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
    public boolean actualizar(Examenes examenes) {
        // Conexion con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizar = false;
        //Contatenando la opcion de actualizacion
        String sql = "UPDATE `examenhistoriaclinica`.`examenes` SET `nombreexamen` = '" + examenes.getNombreExamen() + "', `tipoexamen` = '" +examenes.getTipoExamen() + "', `idmedico` = '" + examenes.getIdMedico() + "', `idpaciente` = '" +examenes.getIdPaciente() + "', `fecha` = '" +Utilidades.devolverFecha(examenes.getFecha()) +  "' WHERE (`idexamenes` = '" + examenes.getIdExamenes()+ "');";
        try {
            Conexion con = new Conexion();
            connect = con.conectarBaseDatos();
            //Puente entre la conexion y el codigo
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return actualizar;
    }
    
     public boolean eliminar(Examenes examenes) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `examenhistoriaclinica`.`examenes` WHERE (`idexamenes` = '" + String.valueOf(examenes.getIdExamenes()) + "');";
        try {
            connect = new Conexion().conectarBaseDatos();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
     
     public List<Examenes> obtenerExamenes() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM examenhistoriaclinica.examenes "
                + "INNER JOIN examenhistoriaclinica.paciente ON examenhistoriaclinica.examenes.idpaciente=examenhistoriaclinica.paciente.idpaciente  "
                + "INNER JOIN examenhistoriaclinica.medico ON examenhistoriaclinica.examenes.idmedico=examenhistoriaclinica.medico.idmedico;";
        List<Examenes> listamedicos = new ArrayList<Examenes>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
              Examenes c = new Examenes();
                c.setIdMedico(rs.getInt(1));
                c.setNombreExamen(rs.getString(2));
                c.setTipoExamen(rs.getString(3));
                c.setIdMedico(rs.getInt(4));
                c.setIdPaciente(rs.getInt(5));
                c.setFecha(Utilidades.devolverFechaDate(rs.getString(6)));
                Paciente pa=new Paciente();
                pa.setIdpaciente(rs.getInt(7));
                pa.setNombre(rs.getString(8));
                pa.setApellido(rs.getString(9));
                c.setPaciente(pa);
                Medico me=new Medico();
                me.setIdMedico(rs.getInt(14));
                me.setNombre(rs.getString(15));
                me.setApellido(rs.getString(16));
                me.setEspecialidad(rs.getString(18));
                c.setMedico(me);
                listamedicos.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("ErrorListarPersonas:" + e.getMessage());
        }

        return listamedicos;
    }
}
