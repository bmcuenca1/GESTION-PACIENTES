/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.controlador;

import examenhistoriasclinica.conexionbd.Conexion;
import examenhistoriasclinica.modelo.Paciente;
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
public class Pacientedb {
    public boolean registrarPaciente(Paciente paciente) {
        boolean registrar = false;
        //Interfaz de acceso a la base de datos
        Statement stm = null;
        //Conexion con la base de datos.
        Connection con = null;
        
        String  sql = "INSERT INTO `examenhistoriaclinica`.`paciente` (`nombre`, `apellido`, `cedula`, `telfono`, `direccion`, `ciudad`) VALUES ('" + paciente.getNombre() + "', '" + paciente.getApellido() + "', '" + paciente.getCedula() + "', '" + paciente.getTelefono() + "', '" + paciente.getDireccion() + "', '" + paciente.getCiudad() + "');";

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
    public boolean actualizar(Paciente paciente) {
        // Conexion con la base de datos.
        Connection connect = null;
        //Interfaz de acceso a la base de datos.
        Statement stm = null;
        // retorno del metodo cuando se realice la actualizacion
        boolean actualizar = false;
        //Contatenando la opcion de actualizacion
        String sql = "UPDATE `examenhistoriaclinica`.`paciente` SET `nombre` = '" + paciente.getNombre() + "', `apellido` = '" +paciente.getApellido() + "', `cedula` = '" + paciente.getCedula() + "', `telfono` = '" + paciente.getTelefono() + "', `direccion` = '" + paciente.getDireccion() + "', `ciudad` = '" + paciente.getCiudad() +  "' WHERE (`idpaciente` = '" + paciente.getIdpaciente()+ "');";
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
    
     public boolean eliminar(Paciente paciente) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;
        String sql = "DELETE FROM `examenhistoriaclinica`.`paciente` WHERE (`idpaciente` = '" + String.valueOf(paciente.getIdpaciente()) + "');";
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
     
     public List<Paciente> obtenerPacientes() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM examenhistoriaclinica.paciente;";
        List<Paciente> listaPersonas = new ArrayList<Paciente>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Paciente c = new Paciente();
                c.setIdpaciente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setCedula(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setDireccion(rs.getString(6));
                c.setCiudad(rs.getString(7));
               
                listaPersonas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("ErrorListarPersonas:" + e.getMessage());
        }

        return listaPersonas;
    }
     
     public List<Paciente> buscar_paciente(String texto,int tipo) {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql="";
        if(tipo==0){
             sql = "SELECT * FROM examenhistoriaclinica.paciente where cedula like '%" + texto + "%';";
        }else{
             sql = "SELECT * FROM examenhistoriaclinica.paciente where nombre like '%" + texto + "%';";
        }
        List<Paciente> listaPersonas = new ArrayList<Paciente>();
        try {
            co = new Conexion().conectarBaseDatos();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Paciente c = new Paciente();
                c.setIdpaciente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setCedula(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setDireccion(rs.getString(6));
                c.setCiudad(rs.getString(7));
               
                listaPersonas.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("ErrorListarPersonas:" + e.getMessage());
        }

        return listaPersonas;
    }
     
}
