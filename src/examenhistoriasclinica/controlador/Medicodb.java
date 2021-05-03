/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.controlador;

import examenhistoriasclinica.conexionbd.Conexion;
import examenhistoriasclinica.modelo.Medico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bmcue
 */
public class Medicodb {
    
    public boolean registrarMedico(Medico medico) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        
        String  sql = "INSERT INTO `examenhistoriaclinica`.`medico` (`nombre`, `apellido`, `cedula`, `especiaidad`) VALUES ('" + medico.getNombre() + "', '" + medico.getApellido() + "', '" + medico.getCedula() + "', '" + medico.getEspecialidad() + "');";

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
    public boolean actualizar(Medico medico) {
        // Conexion con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizar = false;
        //Contatenando la opcion de actualizacion
        String sql = "UPDATE `examenhistoriaclinica`.`medico` SET `nombre` = '" + medico.getNombre() + "', `apellido` = '" +medico.getApellido() + "', `cedula` = '" + medico.getCedula() + "', `especialidad` = '" + medico.getEspecialidad() +  "' WHERE (`idmedico` = '" + medico.getIdMedico()+ "');";
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
    
     public boolean eliminar(Medico medico) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `examenhistoriaclinica`.`medico` WHERE (`idmedico` = '" + String.valueOf(medico.getIdMedico()) + "');";
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
     
     public List<Medico> obtenerMedicos() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM examenhistoriaclinica.medico;";
        List<Medico> listamedicos = new ArrayList<Medico>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
              Medico c = new Medico();
                c.setIdMedico(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setCedula(rs.getString(4));
                c.setEspecialidad(rs.getString(5));
                
               
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
