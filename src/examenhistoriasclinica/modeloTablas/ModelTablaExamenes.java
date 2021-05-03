/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.modeloTablas;

import examenhistoriasclinica.modelo.Examenes;
import examenhistoriasclinica.utilidades.Utilidades;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import examenhistoriasclinica.vistaproyecto.HistorialClinica;
/**
 *
 * @author bmcue
 */
public class ModelTablaExamenes extends AbstractTableModel{
     public String[] m_colNames = {"PACIENTE", "MEDICO", "NOM EXAMEN", "TIPO", "FECHA DE EXAMEN"};

    public List<Examenes> examenes;

    private ModelosVistatablas comunicacionHistoria;
    
    private HistorialClinica historialclinica;
    
    public ModelTablaExamenes(List<Examenes> examenes,HistorialClinica historialclinica) {
        this.examenes = examenes;
        this.historialclinica=historialclinica;
    }

    @Override
    public int getRowCount() {
        return examenes.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Examenes macData = examenes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return macData.getPaciente().getApellido()+" "+macData.getPaciente().getNombre();
            case 1:
                return macData.getMedico().getNombre()+" "+macData.getMedico().getApellido()+" "+macData.getMedico().getEspecialidad();
            case 2:
                return macData.getNombreExamen();
            case 3:
                return macData.getTipoExamen();
            case 4:
                return Utilidades.devolverFecha(macData.getFecha());
            
        }
        System.out.println("Select examen?" + macData.toString());
        return new String();
    }

    //Sirve para definir los nombres de las columnas
    @Override
    public String getColumnName(int column) {
        return m_colNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        historialclinica.clickExamen(examenes.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.\
    }
    
}
