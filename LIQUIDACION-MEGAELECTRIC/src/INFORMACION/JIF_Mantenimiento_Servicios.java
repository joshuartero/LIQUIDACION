package INFORMACION;

import CLASES.CCONEXION;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joshua Ormachea
 */
public class JIF_Mantenimiento_Servicios extends javax.swing.JInternalFrame {
    
    CCONEXION cConexion=new CCONEXION();
    Connection con=cConexion.getCon();
    Statement st;   ResultSet rs;
    DefaultTableModel modelo;
    
    public JIF_Mantenimiento_Servicios() {
        initComponents();
        
        modelo=(DefaultTableModel) jTable1.getModel();
        listarServicios();
    }
    
    void listarServicios()
    {   try 
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM SERVICIO ORDER BY PUNIT");
            while(rs.next())
            {   Object row[]={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                modelo.addRow(row);
            }
        } 
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }
    }
    
    public void limpiarTabla() 
    {   int filas = jTable1.getRowCount();
        while (filas > 0) 
        {   modelo.removeRow(filas - 1);
            filas--;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SERVICIOS");

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("SERVICIO");

        jLabel2.setText("CODIGO");

        jLabel3.setText("DESCRIPCION");

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "UNIDAD", "TR", "PUNIT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jLabel4.setText("UNIDAD");

        jLabel5.setText("TR");

        jLabel6.setText("PUNIT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField6)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(294, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(23, 23, 23))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(192, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JD_Agregar_Servicio jdas=new JD_Agregar_Servicio(this, true);
        jdas.setVisible(true);
        if(jdas.isVisible()==false)
        {   limpiarTabla();
            listarServicios();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTable1.getSelectedRow()<0)
        JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN SERVICIO");
        else
        {   int opc=JOptionPane.showConfirmDialog(this, "REALMENTE DESEA ELIMINAR ESE SERVICIO ?");
            if(opc==JOptionPane.YES_OPTION)
            {   try
                {   st.executeUpdate("DELETE FROM SERVICIO WHERE CODIGO='"+jTextField2.getText()+"'");
                    JOptionPane.showMessageDialog(this, "SERVICIO ELIMINADO");
                    limpiarTabla();
                    listarServicios();
                    jTextField2.setText("");    jTextField3.setText("");    jTextField4.setText("");
                    jTextField5.setText("");    jTextField6.setText("");
                }
                catch (SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTable1.getSelectedRow()<0)
            JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN SERVICIO");
        else
        {   try
            {   st.executeUpdate("UPDATE SERVICIO SET CODIGO='"+jTextField2.getText()+"', "
                + "DESCRIPCION='"+jTextField3.getText()+"', UNIDAD='"+jTextField4.getText()+"',"
                + "'"+jTextField5.getText()+"','"+jTextField6.getText()+"' "
                + "WHERE CODIGO='"+jTextField2.getText()+"'");
            JOptionPane.showMessageDialog(this, "CAMBIOS REALIZADOS CON EXITO");
            limpiarTabla();
            listarServicios();
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        try
        {   rs=st.executeQuery("SELECT * FROM SERVICIO WHERE DESCRIPCION "
                + "LIKE '%"+jTextField1.getText()+"%' ORDER BY PUNIT");
            limpiarTabla();
            while(rs.next())
            {   Object row[]={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                modelo.addRow(row);
            }
            jTextField2.setText("");    jTextField3.setText("");    jTextField4.setText("");
            jTextField5.setText("");    jTextField6.setText("");
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTextField2.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        jTextField3.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
        jTextField4.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2));
        jTextField5.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 3));
        jTextField6.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 4));  
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        if(evt.getKeyCode()==38 || evt.getKeyCode()==40)
        {   jTextField2.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            jTextField3.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
            jTextField4.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2));
            jTextField5.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 3));
            jTextField6.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 4));
        }
    }//GEN-LAST:event_jTable1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
