package INFORMACION;

import CLASES.CCONEXION;
import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.glass.events.KeyEvent;
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
public class JD_Agregar_Material_Punto extends javax.swing.JDialog {

    CCONEXION cConexion=new CCONEXION(); 
    Connection con=cConexion.getCon();
    Statement st;   ResultSet rs;
    JD_FLC jdflc;
    TextAutoCompleter textAutoCompleter;
    DefaultTableModel modelo;
    
    public JD_Agregar_Material_Punto(JD_FLC jdflc, boolean modal) {
        super(jdflc, modal);
        this.jdflc=jdflc;
        initComponents();
        
        crearAutoCompleter();
        cargarMateriales();
        
        setLocationRelativeTo(this);        
        jTextField4.requestFocus();
        textAutoCompleter.setMode(0); //INFIJO
        modelo=(DefaultTableModel) jTable1.getModel();
    }
    
    void crearAutoCompleter()
    {   textAutoCompleter = new TextAutoCompleter(jTextField4, new AutoCompleterCallback() 
        {   @Override
            public void callback(Object selectedItem) 
            {   try
                {   rs=st.executeQuery("SELECT CODIGO, UNIDAD FROM MATERIAL WHERE DESCRIPCION='"+selectedItem+"'");
                    if(rs.next())
                    {   jTextField3.setText(rs.getString(1));
                        jTextField5.setText(rs.getString(2));
                    }
                }
                catch (SQLException ex) {   JOptionPane.showMessageDialog(null, "ERROR DEBIDO A : "+ex.toString());}
            }
        });        
    }
    
    void cargarMateriales()
    {   try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT DESCRIPCION FROM MATERIAL");
            while(rs.next())
                textAutoCompleter.addItem(rs.getString(1));
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
    }
    
    void listarMateriales()
    {   try
        {   rs=st.executeQuery("SELECT M.CODIGO, M.DESCRIPCION, M.UNIDAD, PM.CANTIDAD "
                + "FROM PUNTO_MATERIAL PM INNER JOIN MATERIAL M ON PM.CODIGOMATERIAL=M.CODIGO "
                + "INNER JOIN PUNTO P ON PM.CODIGOPUNTO=P.CODIGO "
                + "WHERE PM.CODIGOPUNTO='"+codigoPunto(jTextField1.getText())+"' "
                + "AND P.CODIGOFLC='"+jTextField2.getText()+"'");
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("PUNTO");

        jTextField1.setEnabled(false);

        jLabel5.setText("FLC - CODIGO : ");

        jTextField2.setEnabled(false);

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
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "MATERIAL"));

        jLabel2.setText("CODIGO");

        jTextField3.setEnabled(false);

        jLabel3.setText("MATERIAL");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jButton3.setText("AGREGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("UNIDAD");

        jTextField5.setEnabled(false);

        jButton4.setText("BUSCAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("CANTIDAD");

        jTextField6.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("SALIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!camposVacios1())
        {   if(buscarMaterialEnLista(jTextField3.getText()))
            {   JOptionPane.showMessageDialog(this, "ESE MATERIAL YA ESTA EN LISTA");
                jTextField3.setText("");    jTextField4.setText("");
                jTextField5.setText("");    jTextField6.setText("");
            }
            else
            {   Object row[]={jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), jTextField6.getText()};
                modelo.addRow(row);
                jTextField3.setText("");    jTextField4.setText("");    jTextField5.setText("");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    boolean camposVacios1()
    {   boolean vacio=false;
        if(jTextField2.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "CODIGO NO VALIDO. PORFAVOR BUSQUE MATERIAL");
            jTextField2.requestFocus();
            vacio=true ;
        }
        else if(jTextField3.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "PORFAVOR BUSQUE MATERIAL");
            jTextField4.requestFocus();
            vacio=true ;
        }
        else if(jTextField6.getText().length()==0)
        {   JOptionPane.showMessageDialog(this, "PORFAVOR INGRESE CANTIDAD");
            jTextField6.requestFocus();
            vacio=true ;
        }
        return vacio;        
    }
    
    boolean buscarMaterialEnLista(String codMaterial)
    {   boolean encontrado=false;
        for(int i=0;i<jTable1.getRowCount();i++)
            if(codMaterial.compareTo((String) jTable1.getValueAt(i, 0))==0)
                encontrado=true;
        return encontrado;
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {   rs=st.executeQuery("SELECT CODIGO, UNIDAD FROM MATERIAL WHERE DESCRIPCION='"+jTextField4.getText()+"'");
            if(rs.next())
            {   jTextField3.setText(rs.getString(1));
                jTextField5.setText(rs.getString(2));
            }
            else JOptionPane.showMessageDialog(this, "NO EXISTE ESE MATERIAL");
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(null, "ERROR DEBIDO A : "+ex.toString());}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        try
        {   rs=st.executeQuery("SELECT CODIGO, UNIDAD FROM MATERIAL WHERE DESCRIPCION='"+jTextField4.getText()+"'");
            if(rs.next())
            {   jTextField3.setText(rs.getString(1));
                jTextField5.setText(rs.getString(2));
            }
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(null, "ERROR DEBIDO A : "+ex.toString());}
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_BACKSPACE)
            jTextField3.setText("");
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!tablaVacia())            
        {   //Recorremos toda la tabla
            for(int fila=0; fila<jTable1.getRowCount(); fila++)
            {   if(buscarMaterialEnPunto((String)jTable1.getValueAt(fila, 0)))
                    actualizarMaterial((String)jTable1.getValueAt(fila, 3), (String)jTable1.getValueAt(fila, 0));
                else
                    insertarMaterial(jTextField1.getText(), (String)jTable1.getValueAt(fila, 0), (String)jTable1.getValueAt(fila, 3));
            }
            JOptionPane.showMessageDialog(this, "CAMBIOS REALIZADOS CON EXITO");        }
    }//GEN-LAST:event_jButton2ActionPerformed

    boolean tablaVacia()
    {   boolean vacio=false;        
        if(modelo.getRowCount()==0)
        {   JOptionPane.showMessageDialog(this, "PORFAVOR AGREGUE MATERIALES");
            jTextField4.requestFocus();
            vacio=true ;
        }
        return vacio;        
    }
    
    boolean buscarMaterialEnPunto(String codigoMaterial)
    {   boolean encontrado=false;
        try
        {   rs=st.executeQuery("SELECT PM.CODIGOMATERIAL FROM PUNTO_MATERIAL PM INNER JOIN PUNTO P "
                + "ON PM.CODIGOPUNTO=P.CODIGO WHERE P.PUNTO='"+jTextField1.getText()+"';");
            while(rs.next())
            {   if(rs.getString(1).compareTo(codigoMaterial)==0)
                    encontrado=true;
            }            
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
        return encontrado;
    }
    
    void actualizarMaterial(String cantidad, String codigoMaterial)
    {   try
        {   st.executeUpdate("UPDATE PUNTO_MATERIAL SET CANTIDAD='"+cantidad+"' "
                + "WHERE CODIGOPUNTO=(SELECT CODIGO FROM PUNTO WHERE PUNTO='"+jTextField1.getText()+"' "
                + "AND CODIGOFLC='"+jTextField2.getText()+"'"
                + "AND CODIGOMATERIAL='"+codigoMaterial+"');");                        
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
    }
    
    void insertarMaterial(String punto, String codigoMaterial, String cantidad)
    {   try
        {   st.executeUpdate("INSERT INTO PUNTO_MATERIAL VALUES "
                + "( (SELECT CODIGO FROM PUNTO WHERE PUNTO='"+punto+"' "
                + "AND CODIGOFLC='"+jTextField2.getText()+"') ,"
                + "'"+codigoMaterial+"','"+cantidad+"')");
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A : "+ex.toString());}
    }
    
    String codigoPunto(String punto)
    {   String codigoPunto="";
        try
        {   rs=st.executeQuery("SELECT CODIGO FROM PUNTO WHERE PUNTO='"+punto+"' AND "
                + "CODIGOFLC='"+jTextField2.getText()+"'");
            if(rs.next())
                codigoPunto=rs.getString(1);
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(null, "ERROR DEBIDO A : "+ex.toString());}
        return codigoPunto;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTable1.getRowCount()==0)
            JOptionPane.showMessageDialog(this, "TABLA VACIA, AGREGUE MATERIALES");
        else if(jTable1.getSelectedRow()==-1)
            JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN MATERIAL A ELIMINAR");
        else 
        {   
//            JOptionPane.showMessageDialog(this, (String)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            eliminarDeBD(jTextField1.getText(), (String)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            JOptionPane.showMessageDialog(this, "MATERIAL ELIMINADO");
            modelo.removeRow(jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    void eliminarDeBD(String punto, String codigoMaterial)
    {   try
        {   st.executeUpdate("DELETE FROM PUNTO_MATERIAL WHERE CODIGOPUNTO="
                + "(SELECT CODIGO FROM PUNTO WHERE PUNTO='"+punto+"' "
                + "AND CODIGOFLC='"+jTextField2.getText()+"') AND CODIGOMATERIAL='"+codigoMaterial+"'");            
        }
        catch (SQLException ex) {   JOptionPane.showMessageDialog(null, "ERROR DEBIDO A : "+ex.toString());}
    }
    
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
