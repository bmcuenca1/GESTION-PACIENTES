
import examenhistoriasclinica.controlador.Pacientedb;
import examenhistoriasclinica.modelo.Paciente;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bmcue
 */
public class PruebaCone {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("EDITANDO EL USUARIO REGISTRADO ");
        Pacientedb daopaciente=new Pacientedb();
        
        System.out.println("LISTA TODOS LOS ELEMNETOS ");
        List<Paciente> lista_depacinetes=daopaciente.obtenerPacientes();
        for(int i=0;i<lista_depacinetes.size();i++){
            System.out.println("elemento  "+i+" - "+lista_depacinetes.get(i).getNombre());
        }
        System.out.println("eliminado el elemento ");
        Paciente paciente=new Paciente(1, "BYRON", "Prueba", "1104969033", "0987210091", "sauces", "Loja");
        
        if(daopaciente.eliminar(paciente)){
            System.out.println("Paciente eliminado ");
        }else{
            System.out.println("Paciente no se eleimino");
        }
        
        
    }
}
