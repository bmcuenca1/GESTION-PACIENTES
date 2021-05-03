/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bmcue
 */
public class Utilidades {
    public static String devolverFecha(Date fecha) {
        try{
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            return f.format(fecha);
        }catch(Exception e){
            return null;
        }
        
    }
    
     public static Date devolverFechaDate(String fecha) {
         Date fecha_d=null;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try{
            fecha_d=f.parse(fecha);
        }catch(Exception e){
            return null;
        }
        return fecha_d;
    }
}
