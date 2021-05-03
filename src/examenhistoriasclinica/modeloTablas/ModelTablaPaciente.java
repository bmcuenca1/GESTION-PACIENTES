/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.modeloTablas;

import examenhistoriasclinica.modelo.Paciente;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import examenhistoriasclinica.vistaproyecto.HistorialClinica;
/**
 *
 * @author bmcue
 */
public class ModelTablaPaciente extends AbstractTableModel{
     public String[] m_colNames = {"CÉDULA", "NOMBRES", "APELLIDOS", "DIRECCIÓN", "TELEFONO", "CIUDAD"};

    public List<Paciente> paciente;

    private ModelosVistatablas comunicacionPaciente;
    
    private HistorialClinica historialclinica;
    
    public ModelTablaPaciente(List<Paciente> paciente,HistorialClinica historialclinica) {
        this.paciente = paciente;
        this.historialclinica=historialclinica;
    }

    @Override
    public int getRowCount() {
        return paciente.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paciente macData = paciente.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return macData.getCedula();
            case 1:
                return macData.getNombre();
            case 2:
                return macData.getApellido();
            case 3:
                return macData.getDireccion();
            case 4:
                return macData.getTelefono();
            case 5:
                return macData.getCiudad();
        }
        System.out.println("Select paciente?" + macData.toString());
        return new String();
    }

    //Sirve para definir los nombres de las columnas
    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        historialclinica.clickPaciente(paciente.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.\
    }
    
}
