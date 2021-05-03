/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenhistoriasclinica.vistaproyecto;

import examenhistoriasclinica.conexionbd.Conexion;
import examenhistoriasclinica.controlador.Examenesdb;
import examenhistoriasclinica.controlador.HistorialClinicodb;
import examenhistoriasclinica.controlador.Medicodb;
import examenhistoriasclinica.controlador.Pacientedb;
import examenhistoriasclinica.modelo.Examenes;
import examenhistoriasclinica.modelo.HistorialClinico;
import examenhistoriasclinica.modelo.Paciente;
import examenhistoriasclinica.modelo.Medico;
import examenhistoriasclinica.modeloTablas.ModelTablaExamenes;
import examenhistoriasclinica.modeloTablas.ModelTablaHistoriasClinicas;
import java.util.List;
import javax.swing.JOptionPane;
import examenhistoriasclinica.modeloTablas.ModelTablaPaciente;
import examenhistoriasclinica.utilidades.Utilidades;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author bmcue
 */
public class HistorialClinica extends javax.swing.JFrame {
    //metodos para gestionar un paciente 
    Paciente paciente;
    Pacientedb dbpacinte;
    ModelTablaPaciente modelopaciente;
    ModelTablaHistoriasClinicas modeloHistorias;
    ModelTablaExamenes modeloExamenes;
    boolean  modoguardar=true;
    int tipobusqueda=0;
    //pantalla historias clinicas
    HistorialClinico historila;
    int idpaciente;
    HistorialClinicodb dbhistorial;
    //pantalla examenes clinicos
    Examenes examen;
    int idpacientee;
    int idmedico;
    Examenesdb dbexamen;
    Medicodb dbmedico;


    /**
     * Creates new form HistorialClinica
     */
    public HistorialClinica() {
        //trer los pacientes
   
        
        initComponents();
        cargarPaciente();
        cargar_lista_historias();
        cargar_comboboxmedicos();
        cargar_lista_examenes();
        //llenarComboboxPacientes();
        jbotoneditar.setEnabled(false);
        jbotoneliminar.setEnabled(false);
        txtexamenfecha.setName("yyyy-mm-dd");
        Date fecha_actual=new Date();
        String fecha=Utilidades.devolverFecha(fecha_actual);
        txtexamenfecha.setText(fecha);
        
    }
    
    public void cargar_comboboxmedicos(){
        System.out.println("entra a cargar los medico s");
        dbmedico=new Medicodb();
        List<Medico> lista=dbmedico.obtenerMedicos();
        jcomboexamenesmedico.removeAllItems();
        for(int i=0;i<lista.size();i++){
            jcomboexamenesmedico.addItem(lista.get(i).getApellido()+" "+lista.get(i).getNombre()+" - "+lista.get(i).getEspecialidad());
            System.out.println(lista.get(i).getApellido()+"medico");
        }
         jcomboexamenesmedico.setSelectedIndex(-1);
    }

    public void cargarPaciente()
    {
        dbpacinte=new Pacientedb();
        List<Paciente> pacientes=dbpacinte.obtenerPacientes();
        modelopaciente=new ModelTablaPaciente(pacientes,this);
        tablapacientes.setModel(modelopaciente);
        //llenar los pacientes combo bnox
        jComboBoxpacientes.removeAllItems();
        for(int i=0;i<pacientes.size();i++){
            jComboBoxpacientes.addItem(pacientes.get(i).getApellido()+" "+pacientes.get(i).getNombre());
            System.out.println(pacientes.get(i).getApellido());
        }
         jComboBoxpacientes.setSelectedIndex(-1);
        jcomboexamenpaciente.removeAllItems();
        for(int i=0;i<pacientes.size();i++){
            jcomboexamenpaciente.addItem(pacientes.get(i).getApellido()+" "+pacientes.get(i).getNombre());
            System.out.println(pacientes.get(i).getApellido());
        }
        jcomboexamenpaciente.setSelectedIndex(-1);
     
    } 
    
    public void cargar_lista_historias(){
        dbhistorial=new HistorialClinicodb();
        List<HistorialClinico> lista=dbhistorial.obtenerHistorias();
        modeloHistorias=new ModelTablaHistoriasClinicas(lista, this);
        jTableHistorias.setModel(modeloHistorias);
        
    }
    
    public void cargar_lista_examenes (){
        dbexamen=new Examenesdb();
        List<Examenes> lista=dbexamen.obtenerExamenes();
        modeloExamenes=new ModelTablaExamenes(lista, this);
        jTableexamenes.setModel(modeloExamenes);
        Date fecha_actual=new Date();
        String fecha=Utilidades.devolverFecha(fecha_actual);
        txtexamenfecha.setText(fecha);
    }
    public void cargarPacientebusqueda(List datos)
    {
        
        modelopaciente=new ModelTablaPaciente(datos,this);
        tablapacientes.setModel(modelopaciente);
        
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtciudad = new javax.swing.JTextField();
        jButtonguardarpaciente = new javax.swing.JButton();
        jbotoneditar = new javax.swing.JButton();
        jbotoneliminar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablapacientes = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        buscar_paciente = new javax.swing.JTextField();
        jComboBoxtipobusqueda = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtgenero = new javax.swing.JTextField();
        txtocupacion = new javax.swing.JTextField();
        txtprofesion = new javax.swing.JTextField();
        txtantecedentes = new javax.swing.JTextField();
        txtenfermedades = new javax.swing.JTextField();
        botonhistorial = new javax.swing.JButton();
        jComboBoxpacientes = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableHistorias = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtexamennombre = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtexamentipo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtexamenfecha = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jcomboexamenesmedico = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jcomboexamenpaciente = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableexamenes = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("jLabel9");

        jTextField3.setText("jTextField3");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO PACIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(240, 240, 240));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombres :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cedula:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Telefono:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Ciudad:");

        textnombre.setBackground(new java.awt.Color(255, 204, 255));
        textnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textnombreActionPerformed(evt);
            }
        });

        txtapellido.setBackground(new java.awt.Color(255, 204, 255));

        txtcedula.setBackground(new java.awt.Color(255, 204, 255));

        txttelefono.setBackground(new java.awt.Color(255, 204, 255));

        txtdireccion.setBackground(new java.awt.Color(255, 204, 255));

        txtciudad.setBackground(new java.awt.Color(255, 204, 255));

        jButtonguardarpaciente.setBackground(new java.awt.Color(255, 255, 0));
        jButtonguardarpaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/disco-flexible.png"))); // NOI18N
        jButtonguardarpaciente.setText("GUARDAR");
        jButtonguardarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonguardarpacienteActionPerformed(evt);
            }
        });

        jbotoneditar.setBackground(new java.awt.Color(255, 255, 0));
        jbotoneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jbotoneditar.setText("EDITAR");
        jbotoneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotoneditarActionPerformed(evt);
            }
        });

        jbotoneliminar.setBackground(new java.awt.Color(255, 255, 0));
        jbotoneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jbotoneliminar.setText("ELIMINAR");
        jbotoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotoneliminarActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/examenhistoriasclinica/vistaproyecto/busqueda-de-datos.png"))); // NOI18N
        jButton3.setText("BUSQUEDA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tablapacientes.setBackground(new java.awt.Color(204, 255, 255));
        tablapacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablapacientes);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("LISTA DE PACIENTES:");

        jComboBoxtipobusqueda.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jComboBoxtipobusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "Nombres" }));
        jComboBoxtipobusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxtipobusquedaActionPerformed(evt);
            }
        });
        jComboBoxtipobusqueda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxtipobusquedaPropertyChange(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escoba.png"))); // NOI18N
        jButton1.setText("LIMPIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(0, 255, 204));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setText("PACIENTES:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paciente.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paciente1.png"))); // NOI18N
        jButton4.setText("IMPRIMIR REPORTE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(textnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)
                        .addGap(41, 41, 41)
                        .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jButtonguardarpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jbotoneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jbotoneliminar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(buscar_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBoxtipobusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton3)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(textnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4))
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5))
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonguardarpaciente)
                    .addComponent(jbotoneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jbotoneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(buscar_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jComboBoxtipobusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );

        jTabbedPane2.addTab("PACIENTES", jPanel4);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "HISTORIAL CLINICO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Edad:");

        txtedad.setBackground(new java.awt.Color(255, 204, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Genero:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Ocupacion:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Profesion:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Enfermedades:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Antecedentes:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Paciente:");

        txtgenero.setBackground(new java.awt.Color(255, 204, 255));

        txtocupacion.setBackground(new java.awt.Color(255, 204, 255));

        txtprofesion.setBackground(new java.awt.Color(255, 204, 255));
        txtprofesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprofesionActionPerformed(evt);
            }
        });

        txtantecedentes.setBackground(new java.awt.Color(255, 204, 255));

        txtenfermedades.setBackground(new java.awt.Color(255, 204, 255));
        txtenfermedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtenfermedadesActionPerformed(evt);
            }
        });

        botonhistorial.setBackground(new java.awt.Color(153, 255, 102));
        botonhistorial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonhistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salvar.png"))); // NOI18N
        botonhistorial.setText("GUARDAR");
        botonhistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonhistorialActionPerformed(evt);
            }
        });

        jComboBoxpacientes.setMaximumRowCount(100);
        jComboBoxpacientes.setToolTipText("");
        jComboBoxpacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxpacientesActionPerformed(evt);
            }
        });

        jTableHistorias.setBackground(new java.awt.Color(255, 204, 204));
        jTableHistorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTableHistorias);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hostpital-building_icon-icons.com_73530.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonhistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel11))))
                                        .addGap(29, 29, 29)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtprofesion, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtantecedentes, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtenfermedades, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxpacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtedad, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                            .addComponent(txtgenero))))))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtprofesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtantecedentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtenfermedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxpacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonhistorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jComboBoxpacientes.getAccessibleContext().setAccessibleName("");

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane2.addTab("HISTORIAL CLINICO", jScrollPane1);
        jScrollPane1.getAccessibleContext().setAccessibleParent(jPanel3);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exames Medicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtexamennombre.setBackground(new java.awt.Color(255, 204, 204));
        txtexamennombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtexamennombreActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Nombre examen:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Tipo examen:");

        txtexamentipo.setBackground(new java.awt.Color(255, 204, 204));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Fecha examen:");

        txtexamenfecha.setBackground(new java.awt.Color(255, 204, 204));
        txtexamenfecha.setToolTipText("asdasd");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Medico:");

        jcomboexamenesmedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcomboexamenesmedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboexamenesmedicoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Paciente:");

        jcomboexamenpaciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcomboexamenpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboexamenpacienteActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 255, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save_as_22027.png"))); // NOI18N
        jButton5.setText("GUARDAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTableexamenes.setBackground(new java.awt.Color(255, 204, 255));
        jTableexamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTableexamenes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcomboexamenesmedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtexamenfecha))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtexamentipo))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtexamennombre, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcomboexamenpaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtexamennombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtexamentipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtexamenfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboexamenesmedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboexamenpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("EXAMENES", jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textnombreActionPerformed

    private void jButtonguardarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonguardarpacienteActionPerformed
        // TODO add your handling code here:
        System.out.println("TOCO EL BOTON ");
        //primero verificar que los campos esten llenos
        if(textnombre.getText().length()>0){
            if(txtapellido.getText().length()>0){
                if(txtcedula.getText().length()>0){
                    if(txttelefono.getText().length()>0){
                        if(txtdireccion.getText().length()>0){
                           if(txtciudad.getText().length()>0){
                              if(modoguardar){
                                  paciente=new Paciente();
                              }
                              paciente.setNombre(textnombre.getText());
                              paciente.setApellido(txtapellido.getText());
                              paciente.setCedula(txtcedula.getText());
                              paciente.setTelefono(txttelefono.getText());
                              paciente.setDireccion(txtdireccion.getText());
                              paciente.setCiudad(txtciudad.getText());
                              dbpacinte=new Pacientedb();
                              if(modoguardar){//creado un nuevo paciente
                               
                                if(dbpacinte.registrarPaciente(paciente)){
                                   JOptionPane.showMessageDialog(rootPane,"Paciente registrado con exito ","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                                   limpiar_campos_paciente();
                                   cargarPaciente();
                                }else{
                                   JOptionPane.showMessageDialog(rootPane, "No se pudo registrar el paciente","ERROR",JOptionPane.ERROR_MESSAGE);

                                }
                              }else{//editando un  paciente 
                                  if(dbpacinte.actualizar(paciente)){
                                   JOptionPane.showMessageDialog(rootPane,"Paciente editado con exito ","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                                   limpiar_campos_paciente();
                                   cargarPaciente();
                                   modoguardar=true;
                                   jbotoneditar.setEnabled(false);
                                   jbotoneliminar.setEnabled(false                                                                                                                            );
                                }else{
                                   JOptionPane.showMessageDialog(rootPane, "No se pudo editar el paciente","ERROR",JOptionPane.ERROR_MESSAGE);

                                }
                              }
                              
                            }else{
                               JOptionPane.showMessageDialog(rootPane, "Ingrese la ciudad","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                           }
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Ingrese direccion","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Ingrese telefono","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Ingrese cedula","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                }
            }else{
               JOptionPane.showMessageDialog(rootPane, "Ingrese apellido","ADVERTENCIA",JOptionPane.WARNING_MESSAGE); 
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ingrese nombres","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
        }
        if(txtapellido.getText().length()>0){
            
        }
    }//GEN-LAST:event_jButtonguardarpacienteActionPerformed

    private void jbotoneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotoneditarActionPerformed
        // TODO add your handling code here:
        textnombre.setText(paciente.getNombre());
        txtapellido.setText(paciente.getApellido());
        txtcedula.setText(paciente.getCedula());
        txtdireccion.setText(paciente.getDireccion());
        txtciudad.setText(paciente.getCiudad());
        txttelefono.setText(paciente.getTelefono());  
        modoguardar=false;
      
    }//GEN-LAST:event_jbotoneditarActionPerformed

    private void jbotoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotoneliminarActionPerformed
        // TODO add your handling code here:
        //ELEMETOS PARA ELIMINAR 
        dbpacinte=new Pacientedb();
        if(dbpacinte.eliminar(paciente)){
            JOptionPane.showMessageDialog(rootPane,"Paciente eliminado con exito ","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                                  limpiar_campos_paciente();
                                   cargarPaciente();
                                   modoguardar=true;
                                   jbotoneditar.setEnabled(false);
                                   jbotoneliminar.setEnabled(false);
        }else{
                                               JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar el paciente","ERROR",JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jbotoneliminarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(buscar_paciente.getText().length()>0){
            dbpacinte=new Pacientedb();
            List pacientes=dbpacinte.buscar_paciente(buscar_paciente.getText(),tipobusqueda);
            if(pacientes.size()>0){
                cargarPacientebusqueda(pacientes);
            }else{
                cargarPacientebusqueda(pacientes);
                String mensaje="";
                
                if(tipobusqueda==0){
                    mensaje=" pacientes con ese numero de cedula";
                }else{
                    mensaje=" pacientes con esos nombres";
                }
                
                
                    JOptionPane.showMessageDialog(rootPane, "No se encontraron "+mensaje,"ADVERTENCIA",JOptionPane.WARNING_MESSAGE);

            }
            
        }else{
          JOptionPane.showMessageDialog(rootPane, "Ingrese texto a buscar ","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // TODO add your handling code here:
         cargarPaciente();
         buscar_paciente.setText("");
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxtipobusquedaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxtipobusquedaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxtipobusquedaPropertyChange

    private void jComboBoxtipobusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxtipobusquedaActionPerformed
        // TODO add your handling code here:
        String item=(String)jComboBoxtipobusqueda.getSelectedItem();
        buscar_paciente.setText("");
        if(item.equals("Cedula")){
            tipobusqueda=0;
        }else{
            tipobusqueda=1;
        }
    }//GEN-LAST:event_jComboBoxtipobusquedaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxpacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxpacientesActionPerformed
        // TODO add your handling code here:
        String item=(String)jComboBoxpacientes.getSelectedItem();
        dbpacinte=new Pacientedb();
        List<Paciente> pacientes=dbpacinte.obtenerPacientes();
        for(int i=0;i<pacientes.size();i++)
        {
            String d=pacientes.get(i).getApellido()+" "+pacientes.get(i).getNombre();
            System.out.println("llega inform");
            System.out.println(d);
            if(d!=null&&item!=null){
                if(d.toUpperCase().equals(item.toUpperCase())){
                    idpaciente=pacientes.get(i).getIdpaciente();
                }
            }

        }
    }//GEN-LAST:event_jComboBoxpacientesActionPerformed

    private void botonhistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonhistorialActionPerformed
        // TODO add your handling code here:
        System.out.println("GUARDAR HISTORIAL ");
        if(txtedad.getText().length()>0){
            if(txtgenero.getText().length()>0){
                if(txtocupacion.getText().length()>0){
                    if(txtprofesion.getText().length()>0){
                        if(txtantecedentes.getText().length()>0){
                            if(txtenfermedades.getText().length()>0){
                                if(idpaciente>0){
                                    dbhistorial=new HistorialClinicodb();
                                    historila=new HistorialClinico();
                                    historila.setGenero(txtgenero.getText());
                                    boolean paso_numero=false;
                                    try{
                                        historila.setEdad(Integer.parseInt(txtedad.getText()));
                                        paso_numero=true;
                                    }catch(Exception e){
                                        JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros en la edad","ERROR",JOptionPane.ERROR_MESSAGE); 
                                           txtedad.setFocusable(true);
                                    }
                                    
                                    historila.setOcupacion(txtocupacion.getText());
                                    historila.setProfesion(txtprofesion.getText());
                                    historila.setAntecedentesFamiliares(txtantecedentes.getText());
                                    historila.setEnfermedad(txtenfermedades.getText());
                                    historila.setIdPaciente(idpaciente);
                                    if(paso_numero){
                                       if(dbhistorial.registrar(historila)){
                                        JOptionPane.showMessageDialog(rootPane,"Historial clinico registrado con exito ","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                                        limpiar_campos_historial();
                                        cargar_lista_historias();
                                        
                                    }else{
                                    JOptionPane.showMessageDialog(rootPane, "No se pudo registrar la hiatoria ","ERROR",JOptionPane.ERROR_MESSAGE);
                                    } 
                                    }
                                    
                                }else{
                                    JOptionPane.showMessageDialog(rootPane, "Seleccione el Paciente","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);

                                }
                            }else{
                                JOptionPane.showMessageDialog(rootPane, "Ingrese Sus enfermedades","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Ingrese sus Antecedentes","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Ingrese su profesion","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Ingrese Su ocupacion","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Ingrese El genero","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ingrese Edad","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonhistorialActionPerformed

    private void txtenfermedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtenfermedadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtenfermedadesActionPerformed

    private void txtprofesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprofesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprofesionActionPerformed

    private void txtexamennombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtexamennombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtexamennombreActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //guardar  un examen medico 
        if(txtexamennombre.getText().length()>0){
            if(txtexamentipo.getText().length()>0){
                if(txtexamenfecha.getText().length()>0){
                   if(idmedico>0){
                       if(idpacientee>0){
                           examen=new Examenes();
                           dbexamen=new Examenesdb();
                           examen.setNombreExamen(txtexamennombre.getText());
                           examen.setTipoExamen(txtexamentipo.getText());
                           boolean paso_fecha=false;
                           try{
                               Date fe=Utilidades.devolverFechaDate(txtexamenfecha.getText());
                               if(fe!=null){
                                    examen.setFecha(fe);
                                    paso_fecha=true;
                               }else{
                                              JOptionPane.showMessageDialog(rootPane, "Ingrese correctamente la fecha con el formato yyy/mm/dd ejemplo 2021/12/31","ERROR",JOptionPane.ERROR_MESSAGE); 

                               }
                               
                           }catch(Exception e){
                                JOptionPane.showMessageDialog(rootPane, "Ingrese correctamente la fecha con el formato yyy-mm-dd ejemplo 2021/12/31","ERROR",JOptionPane.ERROR_MESSAGE); 
                           }
                           examen.setIdMedico(idmedico);
                           examen.setIdPaciente(idpacientee);
                           if(paso_fecha){
                               if(dbexamen.registrar(examen)){
                                   limpiar_examenes();
                                   cargar_lista_examenes();
                                   JOptionPane.showMessageDialog(rootPane,"Examen registrado con exito ","ÉXITO",JOptionPane.INFORMATION_MESSAGE);
                                }else{
                                    JOptionPane.showMessageDialog(rootPane, "No se pudo registrar el examen","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                           }
                           
                       }else{
                           JOptionPane.showMessageDialog(rootPane, "Seleccione Paciente","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                       }
                   }else{
                       JOptionPane.showMessageDialog(rootPane, "Seleccione un medico","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                   }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Ingrese Fecha del examen","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Ingrese tipo examen","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ingrese Nombredel examen","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jcomboexamenpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboexamenpacienteActionPerformed
        // TODO add your handling code here:
        String item=(String)jcomboexamenpaciente.getSelectedItem();
        dbpacinte=new Pacientedb();
        List<Paciente> pacientes=dbpacinte.obtenerPacientes();
        for(int i=0;i<pacientes.size();i++)
        {
            String d=pacientes.get(i).getApellido()+" "+pacientes.get(i).getNombre();
            if(d!=null&&item!=null){
                if(d.toUpperCase().equals(item.toUpperCase())){
                    idpacientee=pacientes.get(i).getIdpaciente();
                }
            }

        }
    }//GEN-LAST:event_jcomboexamenpacienteActionPerformed

    private void jcomboexamenesmedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboexamenesmedicoActionPerformed
        // TODO add your handling code here:
        String item=(String)jcomboexamenesmedico.getSelectedItem();
        //con metodos de la clase String quitar profesion
        
        
        dbmedico=new Medicodb();
        List<Medico> lista=dbmedico.obtenerMedicos();
        for(int i=0;i<lista.size();i++)
        {
            String d=lista.get(i).getApellido()+" "+lista.get(i).getNombre();
            if(d!=null&&item!=null){
                String [] partes=item.split("-");
                item=partes[0].trim();
                if(d.toUpperCase().equals(item.toUpperCase())){
                    idmedico=lista.get(i).getIdMedico();
                }
            }

        }
    }//GEN-LAST:event_jcomboexamenesmedicoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:S
        System.out.println("boton para generar el reporte");
        String path="C:\\Users\\bmcue\\Documents\\NetBeansProjects\\ExamenHistoriasClinica\\src\\reporte\\report1.jrxml";
        JasperReport reporte;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //reporte=(JasperReport)JRLoader.loadObjectFromLocation(path);
            JasperReport jr = JasperCompileManager.compileReport(path);
            
            
            JasperPrint jasperPrint;
            Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/examenhistoriaclinica","root","root");
            Conexion c = null;
            JasperPrint jp = JasperFillManager.fillReport(jr,null,con);
            JasperViewer.viewReport(jp);
                   con.close();
            
            
            
        } catch(Exception ex) {
            Logger.getLogger(HistorialClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistorialClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialClinica().setVisible(true);
            }
        });
    }
    
    public void limpiar_campos_historial(){
        txtedad.setText("");
        txtgenero.setText("");
        txtocupacion.setText("");
        txtprofesion.setText("");
        txtantecedentes.setText("");
        txtenfermedades.setText("");
        jComboBoxpacientes.setSelectedIndex(-1);
        idpaciente=0;
               
    }
    
    public void limpiar_examenes(){
        txtexamennombre.setText("");
        txtexamentipo.setText("");
        txtexamenfecha.setText("");
        jcomboexamenesmedico.setSelectedIndex(-1);
        jcomboexamenpaciente.setSelectedIndex(-1);
        idmedico=0;
        idpacientee=0;
    }
    
    public void llenarComboboxPacientes(){
        dbpacinte=new Pacientedb();
        List<Paciente> pacientes=dbpacinte.obtenerPacientes();
        //jComboBoxprueba=new JComboBox();
         
    }
    
    public void limpiar_campos_paciente(){
        textnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
        txtdireccion.setText("");
        txtciudad.setText("");
        txttelefono.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonhistorial;
    private javax.swing.JTextField buscar_paciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonguardarpaciente;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxpacientes;
    private javax.swing.JComboBox<String> jComboBoxtipobusqueda;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableHistorias;
    private javax.swing.JTable jTableexamenes;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton jbotoneditar;
    private javax.swing.JButton jbotoneliminar;
    private javax.swing.JComboBox<String> jcomboexamenesmedico;
    private javax.swing.JComboBox<String> jcomboexamenpaciente;
    private javax.swing.JTable tablapacientes;
    private javax.swing.JTextField textnombre;
    private javax.swing.JTextField txtantecedentes;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtciudad;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtenfermedades;
    private javax.swing.JTextField txtexamenfecha;
    private javax.swing.JTextField txtexamennombre;
    private javax.swing.JTextField txtexamentipo;
    private javax.swing.JTextField txtgenero;
    private javax.swing.JTextField txtocupacion;
    private javax.swing.JTextField txtprofesion;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    public void clickPaciente(Paciente get) {
        jbotoneditar.setEnabled(true);
        jbotoneliminar.setEnabled(true);
        limpiar_campos_paciente();
        paciente=get;
     
    }

    public void clickHistoria(HistorialClinico get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clickExamen(Examenes get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
class FondoPanel extends JPanel
    {
        private Image imagen;
        
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("fondo.jpg")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
    
