package INFORMACION;

import CLASES.Imagen;
import CLASES.CCONEXION;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joshua Ormachea
 */
public class JIF_Mantenimiento_Material extends javax.swing.JInternalFrame {
    
    CCONEXION cConexion=new CCONEXION();
    Connection con=cConexion.getCon();
    Statement st;   ResultSet rs;
    DefaultTableModel modelo;
    
    String ruta, nombre;
    
    public JIF_Mantenimiento_Material() {
        initComponents();
        
        modelo=(DefaultTableModel) jTable1.getModel();
        listarMateriales();
    }
    
    void listarMateriales()
    {   try 
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM MATERIAL ORDER BY DESCRIPCION");
            while(rs.next())
            {   Object row[]={rs.getString(1), rs.getString(2), rs.getString(3)};
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

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MATERIALES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "IMAGEN"));

        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton4.setText("ELEGIR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("ESTABLECER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("ELIMINAR");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "MATERIAL"));

        jLabel1.setText("MATERIAL");

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "MATERIAL", "UND"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("CODIGO");

        jLabel3.setText("DESCRIPCION");

        jLabel4.setText("UNIDAD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3)))
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JD_Agregar_Material jdam=new JD_Agregar_Material(this, true);
        jdam.setVisible(true);
        if(jdam.isVisible()==false)
        {   limpiarTabla();
            listarMateriales();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTextField2.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        jTextField3.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
        jTextField4.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2));
        mostrarMaterial();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jTable1.getSelectedRow()<0)
            JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN MATERIAL");
        else
        {   int opc=JOptionPane.showConfirmDialog(this, "REALMENTE DESEA ELIMINAR ESE MATERIAL ?");
            if(opc==JOptionPane.YES_OPTION)
            {   try 
                {   st.executeUpdate("DELETE FROM MATERIAL WHERE CODIGO='"+jTextField2.getText()+"'");
                    JOptionPane.showMessageDialog(this, "MATERIAL ELIMINADO");
                    limpiarTabla();
                    listarMateriales();
                    jTextField2.setText("");    jTextField3.setText("");    jTextField4.setText("");
                }
                catch (SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }                    
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        if(evt.getKeyCode()==38 || evt.getKeyCode()==40)
        {   jTextField2.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            jTextField3.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
            jTextField4.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2));          
            mostrarMaterial();
        }
    }//GEN-LAST:event_jTable1KeyReleased

    void mostrarMaterial()
    {   try 
        {   ResultSet rs2 = st.executeQuery("SELECT IMAGEN,NOMBREIMAGEN FROM MATERIAL WHERE CODIGO='"+(String) jTable1.getValueAt(jTable1.getSelectedRow(), 0)+"'"); 
            if(rs2.next())
            {   if(rs2.getString(1)!=null)
                {   Imagen imagen=new Imagen();
                    Blob blob = rs2.getBlob("IMAGEN");
                    String nombres = rs2.getString("NOMBREIMAGEN");
                    if(!(nombres.compareTo("")==0))
                    {   byte[] data = blob.getBytes(1, (int)blob.length());
                        BufferedImage img = null;
                        try 
                        {   img = ImageIO.read(new ByteArrayInputStream(data));
                        } 
                        catch (IOException ex)  {   JOptionPane.showMessageDialog(null, "ERROR DEBIDO A : "+ex.toString()); }
                        imagen.setImagen(img);
                        imagen.setNombre(nombre);
                        ImageIcon icon = new ImageIcon(imagen.getImagen().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT));
                        jLabel5.setText("");
                        jLabel5.setIcon(icon);                    
                    }                    
                }
                else                    
                {   jLabel5.setText("Sin Imagen");
                    jLabel5.setIcon(null);
                }
            }
        } 
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }        
    }
    
    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        try 
        {   rs=st.executeQuery("SELECT * FROM MATERIAL WHERE DESCRIPCION LIKE '%"+jTextField1.getText()+"%' ORDER BY DESCRIPCION");
            limpiarTabla();
            while(rs.next())
            {   Object row[]={rs.getString(1), rs.getString(2), rs.getString(3)};
                modelo.addRow(row);
            }
            jTextField2.setText("");    jTextField3.setText("");    jTextField4.setText("");
        } 
        catch (SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser elegirImagen = new JFileChooser("D:\\COOPSOL\\MEGAELECTRIC\\MATERIALES");
        elegirImagen.setMultiSelectionEnabled(false);
        int o = elegirImagen.showOpenDialog(this);
        if(o == JFileChooser.APPROVE_OPTION)
        {   ruta = elegirImagen.getSelectedFile().getAbsolutePath();
            nombre = elegirImagen.getSelectedFile().getName();
            Image imagenexterna=new ImageIcon(ruta).getImage();
            Image preview = Toolkit.getDefaultToolkit().getImage(ruta);
            if(preview != null)
            {   jLabel5.setText("");
                ImageIcon icon;
                if(imagenexterna.getWidth(null)>jLabel5.getWidth() || imagenexterna.getHeight(null)>jLabel5.getHeight())
                    icon = new ImageIcon(preview.getScaledInstance(jLabel5.getWidth(), jLabel5.getHeight(), Image.SCALE_DEFAULT));
                else
                    icon = new ImageIcon(preview.getScaledInstance(preview.getWidth(null), preview.getHeight(null), Image.SCALE_DEFAULT));                
                jLabel5.setIcon(icon);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(jTextField2.getText().length()==0)
            JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN MATERIAL DE LA LISTA");
        else
        {   if(jLabel5.getIcon()==null)
                JOptionPane.showMessageDialog(this, "PORFAVOR ELEGIR UNA IMAGEN");
            else
            {   int opc=JOptionPane.showConfirmDialog(this, "REALMENTE DESEA ASIGNAR ESA IMAGEN AL MATERIAL:\n"
                    + "CODIGO : "+jTextField2.getText()+"\nDESCRIPCION : "+jTextField3.getText());
                if(opc==JOptionPane.YES_OPTION)
                {   try 
                    {   String update = "UPDATE MATERIAL SET IMAGEN=?, NOMBREIMAGEN=? WHERE CODIGO='"+jTextField2.getText()+"'";
                        PreparedStatement ps = con.prepareStatement(update);
                        File file = new File(ruta);
                        FileInputStream fis = new FileInputStream(file);
                        ps.setBinaryStream(1,fis,(int)file.length());
                        ps.setString(2, nombre);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "IMAGEN ESTABLECIDA PARA EL MATERIAL "+jTextField2.getText());
                    } 
                    catch (FileNotFoundException | SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(jTextField2.getText().length()==0)
            JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN MATERIAL DE LA LISTA");
        else
        {   int opc=JOptionPane.showConfirmDialog(this, "REALMENTE DESEA ELIMINAR ESA IMAGEN");
            if(opc==JOptionPane.YES_OPTION)
            {   try 
                {   st.executeUpdate("UPDATE MATERIAL SET IMAGEN=NULL, NOMBREIMAGEN=NULL WHERE CODIGO='"+jTextField2.getText()+"'");
                    JOptionPane.showMessageDialog(this, "IMAGEN ELIMINADA CON EXITO");
                    jLabel5.setIcon(null);
                    jLabel5.setText("Sin Imagen");
                }               
                catch (SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTable1.getSelectedRow()<0)
            JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN MATERIAL");
        else
        {   try 
            {   st.executeUpdate("UPDATE MATERIAL SET CODIGO='"+jTextField2.getText()+"', "
                    + "DESCRIPCION='"+jTextField3.getText()+"', UNIDAD='"+jTextField4.getText()+"' "
                    + "WHERE CODIGO='"+jTextField2.getText()+"'");
                JOptionPane.showMessageDialog(this, "CAMBIOS REALIZADOS CON EXITO");
                limpiarTabla();
                listarMateriales();
            }
            catch (SQLException ex) {   JOptionPane.showMessageDialog(this,"ERROR DEBIDO A : "+ex.toString()); }                    
        }
    }//GEN-LAST:event_jButton3ActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
