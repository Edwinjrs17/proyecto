/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import Logica.User;
import base_de_datos.conexion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edwin
 */
public class Registro_pacientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form Registro_pacientes
     */
    public Registro_pacientes() {
        initComponents();
        mostrar_datos("");
    }

    public void selecionar_datos() {
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            nomTxt.setText(jTable1.getValueAt(fila, 0).toString());
            celTxt.setText(jTable1.getValueAt(fila, 1).toString());
            cedTxt.setText(jTable1.getValueAt(fila, 2).toString());
            fechTxt.setText(jTable1.getValueAt(fila, 3).toString());
            direTxt.setText(jTable1.getValueAt(fila, 4).toString());
            emailTxt.setText(jTable1.getValueAt(fila, 5).toString());
            especialista.setSelectedItem(jTable1.getValueAt(fila, 6).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un fila");
        }

    }

    public void modificar_datos() {
        User us = new User();
        us.setNombre(nomTxt.getText());
        us.setCelular(Integer.parseInt(celTxt.getText()));
        us.setCedula(Integer.parseInt(cedTxt.getText()));
        us.setCumpleaños(fechTxt.getText());
        us.setDireccion(direTxt.getText());
        us.setEmail(emailTxt.getText());
        us.setContraseña(especialista.getSelectedItem().toString());
        conexion cn = new conexion("proyecto_poo");
        Connection con = cn.conectar();
        try {
            String query = "UPDATE `ingreso pacientes` SET `nombre`='" + us.getNombre() + "',`celular`='" + us.getCelular() + "',`cedula`='" + us.getCedula() + "',`fecha`='" + us.getCumpleaños() + "',`direccion`='" + us.getDireccion() + "',`correo`='" + us.getEmail() + "',`control`='" + us.getControl() + "' WHERE Nombre='" + nomTxt.getText() + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
            mostrar_datos("paciente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede realizar la actualización de datos");
        }
    }

    public void insertar_datos() {
        conexion cn = new conexion("proyecto_poo");
        Connection con = cn.conectar();
        User us = new User();
        us.setNombre(nomTxt.getText());
        us.setCelular(Integer.parseInt(celTxt.getText()));
        us.setCedula(Integer.parseInt(cedTxt.getText()));
        us.setCumpleaños(fechTxt.getText());
        us.setDireccion(direTxt.getText());
        us.setEmail(emailTxt.getText());
        us.setContraseña(especialista.getSelectedItem().toString());
        if (us.getNombre().isEmpty() || us.getCelular() == 0 || us.getCedula() == 0 || us.getCumpleaños().isEmpty() || us.getDireccion().isEmpty() || us.getEmail().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
        } else {
            if (us.getControl().equals("Seleccionar") || us.getControl().equals(" ")) {
                JOptionPane.showMessageDialog(null, "Seleccione un campo por favor");
            } else {
                try {
                    String query = "INSERT INTO `ingreso pacientes`(`nombre`, `celular`, `cedula`, `fecha`, `direccion`, `correo`, `control`) VALUES ('" + us.getNombre() + "','" + us.getCelular() + "','" + us.getCedula() + "','" + us.getCumpleaños() + "','" + us.getDireccion() + "','" + us.getEmail() + "','" + us.getControl() + "')";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Paciente registrado con exito");
                    mostrar_datos("paciente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se puedo registrar al paciente");
                    Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void eliminar_datos() {
        conexion cn = new conexion("proyecto_poo");
        Connection con = cn.conectar();
        int fila = jTable1.getSelectedRow();
        String valor = jTable1.getValueAt(fila, 0).toString();
        int op = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar estos datos?", "Eliminar Resitro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_NO_OPTION) {
            String query = "DELETE FROM `ingreso pacientes` WHERE nombre='" + valor + "'";

            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.executeUpdate();
                mostrar_datos("paciente");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se puedo eliminar del registro");
            }
        }
    }

    public void mostrar_datos(String tabla) {
        String sql = "SELECT * FROM `ingreso pacientes`" + tabla;
        Statement st;
        DefaultTableModel model = new DefaultTableModel();
        conexion cn = new conexion("proyecto_poo");
        Connection con = cn.conectar();
        System.out.println(sql);

        model.addColumn("nombre");
        model.addColumn("celular");
        model.addColumn("cedula");
        model.addColumn("fecha de nacimiento");
        model.addColumn("Dirección");
        model.addColumn("correo electronico");
        model.addColumn("control");
        jTable1.setModel(model);

        String[] datos = new String[7];

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                model.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registro_pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buscarTxt = new javax.swing.JTextField();
        nomTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        celTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cedTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        direTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fechTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        especialista = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 469, 203));

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_iconos/icons8-save-32.png"))); // NOI18N
        jButton1.setText("Imprimir Registro");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_iconos/icons8-search-32.png"))); // NOI18N
        jButton3.setText("Buscar Paciente");
        jButton3.setBorder(null);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_iconos/icons8-delete-32.png"))); // NOI18N
        jButton4.setText("Eliminar Paciente");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_iconos/icons8-add-32.png"))); // NOI18N
        jButton5.setText("Ingresar Paciente");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_iconos/imagenes_iconos.png"))); // NOI18N
        jButton6.setText("Editar Datos");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 14, -1, -1));

        buscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarTxtKeyReleased(evt);
            }
        });
        getContentPane().add(buscarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 12, 163, -1));
        getContentPane().add(nomTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 37, 163, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 37, 53, 19));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("celular:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 73, -1, -1));
        getContentPane().add(celTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 71, 163, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("cedula:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 98, 53, 23));
        getContentPane().add(cedTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 100, 163, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Dirección:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 127, -1, -1));
        getContentPane().add(direTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 127, 163, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha de nacimiento:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 14, -1, -1));
        getContentPane().add(fechTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 12, 100, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Correo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 37, -1, 19));
        getContentPane().add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 37, 160, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Control:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 73, 46, -1));

        especialista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Medicina General", "Fisioterapia", "Nefrologia", "Cardiologia", " " }));
        getContentPane().add(especialista, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 68, 158, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Document documento = new Document();

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Registro_pacientes.pdf"));
            documento.open();

            PdfPTable pdft = new PdfPTable(7);
            pdft.addCell("nombre");
            pdft.addCell("celular");
            pdft.addCell("cedula");
            pdft.addCell("fecha de nacimiento");
            pdft.addCell("Dirección");
            pdft.addCell("correo electronico");
            pdft.addCell("control");

            try {
                String query = "SELECT * FROM `ingreso pacientes`";
                conexion cn = new conexion("proyecto_poo");
                Connection con = cn.conectar();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    do {
                        pdft.addCell(rs.getString(1));
                        pdft.addCell(rs.getString(2));
                        pdft.addCell(rs.getString(3));
                        pdft.addCell(rs.getString(4));
                        pdft.addCell(rs.getString(5));
                        pdft.addCell(rs.getString(6));
                        pdft.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(pdft);
                }
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "El reporte de los pacientes ha sido creado con exito");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        eliminar_datos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buscarTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyReleased
        mostrar_datos(buscarTxt.getText());
    }//GEN-LAST:event_buscarTxtKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        insertar_datos();
        nomTxt.setText("");
        celTxt.setText("");
        cedTxt.setText("");
        direTxt.setText("");
        fechTxt.setText("");
        emailTxt.setText("");
        especialista.setSelectedItem("Seleccionar");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        modificar_datos();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        selecionar_datos();
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JTextField cedTxt;
    private javax.swing.JTextField celTxt;
    private javax.swing.JTextField direTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JComboBox<String> especialista;
    private javax.swing.JTextField fechTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nomTxt;
    // End of variables declaration//GEN-END:variables
}
