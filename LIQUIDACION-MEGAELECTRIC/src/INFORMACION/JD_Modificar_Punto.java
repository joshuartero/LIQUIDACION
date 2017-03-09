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
public class JD_Modificar_Punto extends javax.swing.JDialog {

    CCONEXION cConexion=new CCONEXION(); 
    Connection con=cConexion.getCon();
    Statement st;   ResultSet rs;
    JD_FLC jdflc;
    DefaultTableModel modelo;    
    
    public JD_Modificar_Punto(JD_FLC jdflc, boolean modal) {
        super(jdflc, modal);
        initComponents();
        
        this.jdflc=jdflc;
        setLocationRelativeTo(this);
        modelo=(DefaultTableModel) jTable1.getModel();
        jTextField5.setText(jdflc.jTextField11.getText());
    }
    
    void listarServiciosDePunto()
    {   limpiarTabla();
        try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT S.CODIGO, S.DESCRIPCION, S.UNIDAD, PS.CANTIDAD "
                + "FROM PUNTO_SERVICIO PS "
                + "INNER JOIN SERVICIO S ON PS.CODIGOSERVICIO=S.CODIGO "
                + "INNER JOIN PUNTO P ON PS.CODIGOPUNTO=P.CODIGO "
                + "WHERE P.PUNTO='"+jTextField1.getText()+"' AND P.CODIGOFLC='"+jTextField5.getText()+"'");
            while(rs.next())
            {   Object row[]={rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};                
                modelo.addRow(row);
            }
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("SERVICIO"));

        jLabel2.setText("CODIGO");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("SERVICIO");

        jTextField3.setEnabled(false);

        jButton3.setText("AGREGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("UNIDAD");

        jTextField4.setEnabled(false);

        jButton4.setText("BUSCAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("CANTIDAD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("PUNTO");

        jLabel5.setText("FLC - CODIGO : ");

        jTextField5.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton1.setText("MODIFICAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "UNIDAD", "CANTIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton5.setText("DEL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT DESCRIPCION, UNIDAD FROM SERVICIO WHERE CODIGO='"+jTextField2.getText()+"'");
            if(rs.next())
            {   jTextField3.setText(rs.getString(1));
                jTextField4.setText(rs.getString(2));
            }
            else 
            {   JOptionPane.showMessageDialog(this, "NO EXISTE ESE SERVICIO");
                jTextField3.setText("");
            }
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!camposVacios1())
        {   if(buscarServicioEnLista(jTextField2.getText()))
            {   JOptionPane.showMessageDialog(this, "ESE SERVICIO YA ESTA EN LISTA");                
                jTextField2.setText("");    jTextField3.setText("");
                jTextField4.setText("");    jTextField6.setText("");
            }
            else
            {   Object row[]={jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField6.getText()};
                modelo.addRow(row);  
                jTextField2.setText("");    jTextField3.setText("");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    boolean buscarServicioEnLista(String codServicio)
    {   boolean encontrado=false;
        for(int i=0;i<jTable1.getRowCount();i++)
            if(codServicio.compareTo((String) jTable1.getValueAt(i, 0))==0)
               encontrado=true;            
        return encontrado;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!camposVacios2())            
        {   actualizar_Y_O_GuardarServicios();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    void actualizar_Y_O_GuardarServicios()
    {   //Recorremos toda la tabla
        for(int fila=0; fila<jTable1.getRowCount(); fila++)
        {   if(buscarServicioEnPunto((String)jTable1.getValueAt(fila, 0)))//ENCUENTRA SERVICIO ASIGNADO A PUNTO
            {   actualizarServicio((String)jTable1.getValueAt(fila, 3), (String)jTable1.getValueAt(fila, 0));
            }
            else
            {   insertarServicio(jTextField1.getText(), (String)jTable1.getValueAt(fila, 0), (String)jTable1.getValueAt(fila, 3));
            }
        }
        JOptionPane.showMessageDialog(this, "CAMBIOS REALIZADOS CON EXITO");
    }
    
    void actualizarServicio(String cantidad, String codigoServicio)
    {   try
        {   st.executeUpdate("UPDATE PUNTO_SERVICIO SET CANTIDAD='"+cantidad+"' "
                + "WHERE CODIGOPUNTO=(SELECT CODIGO FROM PUNTO WHERE PUNTO='"+jTextField1.getText()+"' "
                + "AND CODIGOFLC='"+jTextField5.getText()+"') AND CODIGOSERVICIO='"+codigoServicio+"';");                        
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
    }
    
    void insertarServicio(String punto, String codigoServicio, String cantidad)
    {   try
        {   st.executeUpdate("INSERT INTO PUNTO_SERVICIO VALUES "
                + "( (SELECT CODIGO FROM PUNTO WHERE PUNTO='"+punto+"' "
                + "AND CODIGOFLC='"+jTextField5.getText()+"') ,"
                + "'"+codigoServicio+"','"+cantidad+"')");
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
    }
    
    boolean buscarServicioEnPunto(String codigoServicio)
    {   boolean encontrado=false;
        try
        {   rs=st.executeQuery("SELECT PS.CODIGOSERVICIO FROM PUNTO_SERVICIO PS INNER JOIN PUNTO P "
                + "ON PS.CODIGOPUNTO=P.CODIGO WHERE P.PUNTO='"+jTextField1.getText()+"' "
                + "AND P.CODIGOFLC='"+jTextField5.getText()+"';");
            while(rs.next())
            {   if(rs.getString(1).compareTo(codigoServicio)==0)
                    encontrado=true;
            }            
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
        return encontrado;
    }
    
    public void limpiarTabla() 
    {   int filas = jTable1.getRowCount();
        while (filas > 0) 
        {   modelo.removeRow(filas - 1);
            filas--;
        }
    } 
            
    boolean camposVacios1()
    {   boolean vacio=false;
        if(jTextField2.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "PORFAVOR INGRESE CODIGO");
            jTextField2.requestFocus();
            vacio=true ;
        }
        else if(jTextField3.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "PORFAVOR BUSQUE SERVICIO");
            jTextField2.requestFocus();
            vacio=true ;
        }
        else if(jTextField6.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "PORFAVOR INGRESE CANTIDAD");
            jTextField6.requestFocus();
            vacio=true ;
        }
        return vacio;        
    }
    
    boolean camposVacios2()
    {   boolean vacio=false;
        if(jTextField1.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "PORFAVOR INGRESE PUNTO");
            jTextField1.requestFocus();
            vacio=true ;
        }
        else if(modelo.getRowCount()==0)
        {   JOptionPane.showMessageDialog(this, "PORFAVOR AGREGUE SERVICIOS");
            jTextField2.requestFocus();
            vacio=true ;
        }
        return vacio;        
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT DESCRIPCION, UNIDAD FROM SERVICIO WHERE CODIGO='"+jTextField2.getText()+"'");
            if(rs.next())
            {   jTextField3.setText(rs.getString(1));
                jTextField4.setText(rs.getString(2));
            }
            else JOptionPane.showMessageDialog(this, "NO EXISTE ESE SERVICIO");
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(jTable1.getSelectedRow()==-1)
            JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN SERVICIO A ELIMINAR");
        else
        {   int opc=JOptionPane.showConfirmDialog(this, "ESTA SEGURO QUE QUIERE ELIMINAR\n"+
                jTable1.getValueAt(jTable1.getSelectedRow(), 1));
            if(opc==JOptionPane.YES_OPTION)    
            {   try
                {   st.executeUpdate("DELETE FROM PUNTO_SERVICIO WHERE "
                        + "CODIGOSERVICIO='"+jTable1.getValueAt(jTable1.getSelectedRow(), 0)+"' "
                        + "AND CODIGOPUNTO=(SELECT CODIGO FROM PUNTO WHERE PUNTO='"+jTextField1.getText()+"')");
                    listarServiciosDePunto();
                    JOptionPane.showMessageDialog(this, "SE ELIMINO EL SERVICIO\n"+
                            jTable1.getValueAt(jTable1.getSelectedRow(), 1));
                }
                catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
