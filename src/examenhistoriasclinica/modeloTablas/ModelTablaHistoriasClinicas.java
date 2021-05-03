/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.modeloTablas;

import examenhistoriasclinica.modelo.HistorialClinico;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import examenhistoriasclinica.vistaproyecto.HistorialClinica;
/**
 *
 * @author bmcue
 */
public class ModelTablaHistoriasClinicas extends AbstractTableModel{
     public String[] m_colNames = {"PACIENTE", "EDAD", "GENERO", "OCUPACION", "PROFESION", "ANTECEDENTES","ENFERMEDADES"};

    public List<HistorialClinico> historia;

    private ModelosVistatablas comunicacionHistoria;
    
    private HistorialClinica historialclinica;
    
    public ModelTablaHistoriasClinicas(List<HistorialClinico> historia,HistorialClinica historialclinica) {
        this.historia = historia;
        this.historialclinica=historialclinica;
    }

    @Override
    public int getRowCount() {
        return historia.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HistorialClinico macData = historia.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return macData.getPaciente().getApellido()+" "+macData.getPaciente().getNombre();
            case 1:
                return macData.getEdad();
            case 2:
                return macData.getGenero();
            case 3:
                return macData.getOcupacion();
            case 4:
                return macData.getProfesion();
            case 5:
                return macData.getAntecedentesFamiliares();
            case 6:
                return macData.getEnfermedad();
        }
        System.out.println("Select historia?" + macData.toString());
        return new String();
    }

    //Sirve para definir los nombres de las columnas
    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        historialclinica.clickHistoria(historia.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.\
    }
    
}
