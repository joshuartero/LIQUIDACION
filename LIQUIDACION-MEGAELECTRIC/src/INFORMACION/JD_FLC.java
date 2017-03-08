package INFORMACION;

import CLASES.CCONEXION;
import TABLA.HEADER.ColumnGroup;
import TABLA.HEADER.GroupableTableHeader;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Joshua Ormachea
 */
public class JD_FLC extends javax.swing.JDialog {

    JIF_Formato_Liquidacion_Campo jifflc;
    CCONEXION cConexion=new CCONEXION(); 
    Connection con=cConexion.getCon();
    Statement st;   ResultSet rs;
    DefaultTableModel modelo, modeloTablaPreliquidacion;
    DefaultListModel modeloLista1, modeloLista2;
    
    public JD_FLC(JIF_Formato_Liquidacion_Campo jifflc, boolean modal) {
        super(JOptionPane.getFrameForComponent(jifflc), modal);
        this.jifflc=jifflc;
        initComponents();
        
        modelo=(DefaultTableModel) jTable1.getModel();
        modeloTablaPreliquidacion=(DefaultTableModel) jTable2.getModel();
        modeloLista1=new DefaultListModel();
        modeloLista2=new DefaultListModel();
        jList1.setModel(modeloLista1);
        jList2.setModel(modeloLista2);
        
        setLocationRelativeTo(this);
    }
    
    void centrar(JTable tabla)
    {   DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int col=0; col<tabla.getColumnCount(); col++)
        {   if(col!=2)
                tabla.getColumnModel().getColumn(col).setCellRenderer(tcr);
        }        
    }
    
    void generarCodigo()//F12-03-25
    {   try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT MAX(CODIGO) FROM FLC");            
            if(rs.next())
            {   if(rs.getString(1)!=null)
                {   String codigo="F12-03-"+(Integer.parseInt(rs.getString(1).substring(7, 9))+1);
                    jTextField11.setText(codigo);                    
                }
                else
                    jTextField11.setText("F12-03-25");
            }            
        }
        catch(SQLException ex)  {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A: "+ex.toString());}
    }
    
    void guardarEnBD()
    {   try
        {   st.executeUpdate("INSERT INTO FLC (CODIGO) VALUES ('"+jTextField11.getText()+"')");            
            JOptionPane.showMessageDialog(this, "FORMATO DE LIQUIDACION DE CAMPO CREADO EXITOSAMENTE\nPORFAVOR COMPLETE LA INFORMACION");
        }
        catch(SQLException ex)  {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A: "+ex.toString());}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(){
            protected JTableHeader createDefaultTableHeader()
            {
                return new GroupableTableHeader(columnModel);
            }
            public boolean isCellEditable(int rowIndex, int colIndex)
            {   return false; //Las celdas no son editables.
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable(){
            protected JTableHeader createDefaultTableHeader()
            {
                return new GroupableTableHeader(columnModel);
            }
            public boolean isCellEditable(int rowIndex, int colIndex)
            {   return false; //Las celdas no son editables.
            }
        };
        jPanel14 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("UNIDAD DE NEGOCIOS ");

        jLabel2.setText("CONTRATISTA ");

        jLabel3.setText("OM N° ");

        jLabel4.setText("PEDIDO ABIERTO  N° ");

        jLabel5.setText("TIPO DE TRABAJO ");

        jLabel6.setText("DESCRIPCIÓN OBRA  ");

        jLabel7.setText("UBICACIÓN ");

        jLabel8.setText("SED / ALIMENTADOR ");

        jLabel9.setText("SUPERVISOR ENOSA ");

        jLabel10.setText("SUPERVISOR CONTRATISTA  ");

        jLabel11.setText("FECHA ELABORACIÓN DEL FLC ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6)
                    .addComponent(jTextField7)
                    .addComponent(jTextField9)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField8)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 196, Short.MAX_VALUE))
                    .addComponent(jTextField10))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("CODIGO");

        jTextField11.setEnabled(false);

        jLabel13.setText("VERSION");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setText("GUARDAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(184, 184, 184))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DATOS", jPanel1);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("PUNTOS"));

        jScrollPane2.setViewportView(jList1);

        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("REGISTRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("MODIFICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "CODIGO SAP", "DESCRIPCION", "UNIDAD", "<html><div style=text-align:center>TOTAL<br>EJECUTADO</div></html>"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PRELIQUIDACION DE SERVICIOS", jPanel2);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("PUNTOS"));

        jScrollPane3.setViewportView(jList2);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "CODIGO SAP", "DESCRIPCION", "UND", "<html><div style=text-align:center>ASIGNADO SALIDA<br>SAP REAL</div></html>", "<html><div style=text-align:center>TOTAL<br>INSTALADO</div></html>", "<html><div style=text-align:center>SALDO A<br>DEVOLVER</div></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(300);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(60);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(120);
            jTable2.getColumnModel().getColumn(5).setMaxWidth(120);
            jTable2.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "MATERIALES"));

        jButton5.setText("<html><div style=text-align:center>AGREGAR<br>O QUITAR</div></html>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PRELIQUIDACION DE MATERIAL NUEVO", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 982, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("MATERIAL RETIRADO DE CAMPO", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 982, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("OBSERVACIONES", jPanel5);

        jTabbedPane1.setSelectedIndex(2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(77, 77, 77))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JD_Registrar_Punto jdap=new JD_Registrar_Punto(this, true);
        jdap.setVisible(true);
        if(jdap.isVisible()==false)
        {   restablecerTabla();
            listarPuntos(modeloLista1);
            mostrarPuntos();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    void restablecerTabla()
    {   Object dataVector[][]={};
        Object columnIdentifiers[]={"ITEM", "CODIGO SAP", "DESCRIPCION", "UNIDAD", 
            "<html><div style=text-align:center>TOTAL<br>EJECUTADO</div></html>"};
        modelo.setDataVector(dataVector, columnIdentifiers);
    }
    
    void listarPuntos(DefaultListModel modelList)
    {   modelList.removeAllElements();
        try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT PUNTO FROM PUNTO WHERE "
                + "CODIGOFLC='"+jTextField11.getText()+"' ORDER BY PUNTO ASC");            
            while(rs.next())
            {   modelList.addElement(rs.getString(1));
            }            
        }
        catch(SQLException ex)  {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A: "+ex.toString());}
    }
    
     void mostrarPuntos()
    {   restablecerTabla();
        try
        {   st=con.createStatement();
            rs=st.executeQuery("SELECT DISTINCT PS.CODIGOPUNTO, P.PUNTO FROM PUNTO_SERVICIO PS INNER JOIN PUNTO P "
                + "ON PS.CODIGOPUNTO=P.CODIGO WHERE P.CODIGOFLC='"+jTextField11.getText()+"'");
            while(rs.next())
            {   modelo.addColumn(rs.getString(2));//Puntos
                mostrarServicios(rs.getString(1), rs.getString(2));
            }     
            modelo.addColumn("FLECHA 2%");   modelo.addColumn("CUELLOS AMARRES");
            ajustarAnchoColumas();
            agruparPuntos();
            totalEjecutado();
        }
        catch(SQLException ex)  {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A: "+ex.toString());}
    }
    
     void mostrarServicios(String codigoPunto, String punto)
    {   try
        {   Statement st2=con.createStatement();
            ResultSet rs2=st2.executeQuery("SELECT PS.CODIGOSERVICIO, S.DESCRIPCION, S.UNIDAD, PS.CANTIDAD FROM "
                + "PUNTO_SERVICIO PS INNER JOIN SERVICIO S ON PS.CODIGOSERVICIO=S.CODIGO INNER JOIN PUNTO P "
                + "ON PS.CODIGOPUNTO=P.CODIGO WHERE CODIGOPUNTO='"+codigoPunto+"' AND P.CODIGOFLC='"+jTextField11.getText()+"'");
            while(rs2.next())
            {   int fila=buscarServicioEnTabla(rs2.getString(2));
                int posCol=buscarPosicionDePuntoEnColumnasDeTabla(punto);
                if(fila==-1)//Servicio no esta en tabla
                {   int col=jTable1.getColumnCount();
                    Object row[]=new Object[col];
                    row[0]=jTable1.getRowCount()+1;
                    row[1]= rs2.getString(1);
                    row[2]= rs2.getString(2);
                    row[3]= rs2.getString(3);                    
                    row[posCol]=rs2.getString(4);
                    modelo.addRow(row);
                }
                else//Servicio ESTÁ en tabla
                   jTable1.setValueAt(rs2.getString(4), fila, posCol);
                //item++;
            }     
            
        }
        catch(SQLException ex)  {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A: "+ex.toString());}
    }
     
     int buscarServicioEnTabla(String descripcion)
    {   int fila=-1;
        for(int i=0; i<jTable1.getRowCount(); i++)
        {   if(descripcion.compareTo((String)jTable1.getValueAt(i, 2))==0)
                fila=i;
        }
        return fila;
    }
    
    int buscarPosicionDePuntoEnColumnasDeTabla(String punto)
    {   int col=-1;
        for(int i=0; i<jTable1.getColumnCount(); i++)
        {   if(punto.compareTo((String)jTable1.getColumnName(i))==0)
                col=i;
        }
        return col;
    }
    
    void ajustarAnchoColumas()
    {   ArrayList<Integer> anchos=new ArrayList<Integer>();
        anchos.add(50); anchos.add(80);    anchos.add(300);    anchos.add(60); anchos.add(80);
        for(int i = 0; i < anchos.size(); i++) 
            jTable1.getColumnModel().getColumn(i).setPreferredWidth(anchos.get(i));
    }
    
    void agruparPuntos()
    {   TableColumnModel cm = jTable1.getColumnModel();
        ColumnGroup g_name = new ColumnGroup("Puntos en los que se han instalado en campo (puntos deben coincidir con el croquis presentado)");
        for(int i=5; i<jTable1.getColumnCount(); i++)
           g_name.add(cm.getColumn(i));
        GroupableTableHeader header = (GroupableTableHeader)jTable1.getTableHeader();
        header.addColumnGroup(g_name);
    }
    
    void totalEjecutado()
    {   for(int fila=0; fila< jTable1.getRowCount(); fila++)
        {   int suma=0;
            for(int col=5; col< jTable1.getColumnCount()-2; col++)
            {   if(jTable1.getValueAt(fila, col)!=null)
                    suma+=Integer.parseInt((String) jTable1.getValueAt(fila, col));
            }
            jTable1.setValueAt(suma, fila, 4);
        }
    }
     
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jList1.getSelectedIndex()==-1)
            JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN PUNTO DE LA LISTA");
        else
        {   JD_Modificar_Punto jdrp=new JD_Modificar_Punto(this, true);
            jdrp.jTextField1.setText(jList1.getSelectedValue());
            jdrp.jTextField1.setEnabled(false);
            jdrp.listarServiciosDePunto();
            jdrp.setVisible(true);
            if(jdrp.isVisible()==false)
                mostrarPuntos();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        guardarCambiosDatosGenerales();
    }//GEN-LAST:event_jButton4ActionPerformed

     void guardarCambiosDatosGenerales()
    {   try
        {   st=con.createStatement();
            st.executeUpdate("UPDATE FLC SET UNDNEGOCIO='"+jTextField1.getText()+"'"
                + ",CONTRATISTA='"+jTextField2.getText()+"'"
                + ",OM_NRO='"+jTextField3.getText()+"'"
                + ",PEDIDOABIERTO_NRO='"+jTextField4.getText()+"'"
                + ",TIPOTRABAJO='"+jTextField5.getText()+"'"
                + ",DESCRIPCIONOBRA='"+jTextField6.getText()+"'"
                + ",UBICACION='"+jTextField7.getText()+"'"
                + ",SEDALIMENTADOR='"+jTextField8.getText()+"'"
                + ",SUPERVISORENOSA='"+jTextField9.getText()+"'"
                + ",SUPERVISORCONTRATISTA='"+jTextField10.getText()+"'"
                + ",FECHAELABORAFLC="+fechaActual(jDateChooser1)+" "
                + ",VERSION='"+jTextField12.getText()+"'"
                + " WHERE CODIGO='"+jTextField11.getText()+"'");            
            JOptionPane.showMessageDialog(this, "DATOS GENERALES GRABADOS");
        }
        catch(SQLException ex)  {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A: "+ex.toString());}
    }
    
    String fechaActual(JDateChooser date)
    {   String fechaActual="";
        if(date.getCalendar()!=null)
        {   Calendar calendar= date.getCalendar();
            int dia=calendar.get(Calendar.DAY_OF_MONTH);
            int mes=calendar.get(Calendar.MONTH)+1;
            int año=calendar.get(Calendar.YEAR);  
            fechaActual="'"+año+"-"+mes+"-"+dia+"'";
        }
        else    fechaActual="NULL";             
        return fechaActual;
    }
     
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jList1.getSelectedIndex()!=-1)
        {   try
            {   st.executeUpdate("DELETE FROM PUNTO WHERE PUNTO='"+jList1.getSelectedValue()+"' "
                    + "AND CODIGOFLC='"+jTextField11.getText()+"'");
                listarPuntos(modeloLista1);
                mostrarPuntos();
                JOptionPane.showMessageDialog(this, "PUNTO ELIMINADO CON EXITO");
            }
            catch(SQLException ex)  {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A: "+ex.toString());}
        }
        else JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN PUNTO DE LA LISTA");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if(jTabbedPane1.getSelectedIndex()==1)
        {   listarPuntos(modeloLista1);
            mostrarPuntos();
            centrar(jTable1);
        }
        if(jTabbedPane1.getSelectedIndex()==2)
        {   listarPuntos(modeloLista2);
            mostrarPuntosPreliquidacion();
            centrar(jTable2);
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    void mostrarPuntosPreliquidacion()
    {   restablecerTablaPreliquidacion();
        try
        {   rs=st.executeQuery("SELECT CODIGO, PUNTO FROM PUNTO WHERE "
                + "CODIGOFLC='"+jTextField11.getText()+"' ORDER BY PUNTO ASC");            
            while(rs.next())
            {   modeloTablaPreliquidacion.addColumn(rs.getString(2));//AGREGAR Puntos
                //modeloTablaPreliquidacion.addColumn("REF5643");//SOLO AGREGAR REFERENCIAS DE CADA PUNTO MAS NO LOS PUNTOS EN SI PARA AGRUPAR DE 3
                mostrarMateriales(rs.getString(1), rs.getString(2));
            }     
            modeloTablaPreliquidacion.addColumn("FLECHA 2%");   modeloTablaPreliquidacion.addColumn("CUELLOS AMARRES");
            ajustarAnchoColumasPreliquidacion();
            agruparPuntosPreliquidacion();
//            asignadoSalidaSAPReal();
            totalInstalado();
//            saldo_aDevolver();
        }
        catch(SQLException ex)  {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A: "+ex.toString());}
    }
    
    void restablecerTablaPreliquidacion()
    {   Object dataVector[][]={};
        Object columnIdentifiers[]={"ITEM", "CODIGO SAP", "DESCRIPCION", "UND", 
            "<html><div style=text-align:center>ASIGNADO SALIDA<br>SAP REAL</div></html>",
            "<html><div style=text-align:center>TOTAL<br>INSTALADO</div></html>",
            "<html><div style=text-align:center>SALDO A<br>DEVOLVER</div></html>"};
        modeloTablaPreliquidacion.setDataVector(dataVector, columnIdentifiers);
    }
    
    void mostrarMateriales(String codigoPunto, String punto)
    {   try
        {   Statement st2=con.createStatement();
            ResultSet rs2=st2.executeQuery("SELECT PM.CODIGOMATERIAL, M.DESCRIPCION, M.UNIDAD, "
                + "PM.CANTIDAD FROM PUNTO_MATERIAL PM INNER JOIN MATERIAL M ON "
                + "PM.CODIGOMATERIAL=M.CODIGO INNER JOIN PUNTO P ON PM.CODIGOPUNTO=P.CODIGO "
                + "WHERE PM.CODIGOPUNTO='"+codigoPunto+"' AND P.CODIGOFLC='"+jTextField11.getText()+"'");
            while(rs2.next())
            {   int fila=buscarMaterialEnTabla(rs2.getString(2));
                int posCol=buscarPosicionDePuntoEnColumnasDeTablaMateriales(punto);
                if(fila==-1)//Material no esta en tabla
                {   int col=jTable2.getColumnCount();
                    Object row[]=new Object[col];
                    row[0]=jTable2.getRowCount()+1;
                    row[1]= rs2.getString(1);
                    row[2]= rs2.getString(2);
                    row[3]= rs2.getString(3);                    
                    row[posCol]=rs2.getString(4);
                    modeloTablaPreliquidacion.addRow(row);                    
                }
                else//Material ESTÁ en tabla
                   jTable2.setValueAt(rs2.getString(4), fila, posCol);
            }     
            
        }
        catch(SQLException ex)  {   JOptionPane.showMessageDialog(this, "ERROR DEBIDO A: "+ex.toString());}
    }
    
    int buscarMaterialEnTabla(String descripcion)
    {   int fila=-1;
        for(int i=0; i<jTable2.getRowCount(); i++)
        {   if(descripcion.compareTo((String)jTable2.getValueAt(i, 2))==0)
                fila=i;
        }
        return fila;
    }
    
    int buscarPosicionDePuntoEnColumnasDeTablaMateriales(String punto)
    {   int col=-1;
        for(int i=0; i<jTable2.getColumnCount(); i++)
        {   if(punto.compareTo((String)jTable2.getColumnName(i))==0)
                col=i;
        }
        return col;
    }
    
    void ajustarAnchoColumasPreliquidacion()
    {   ArrayList<Integer> anchos=new ArrayList<Integer>();
        anchos.add(50);/*Item*/ anchos.add(80);/*Codigo SAP*/ anchos.add(300);/*Descripcion*/
        anchos.add(60);/*Unidad*/ anchos.add(120);/*Asignado Salida SAP Real*/ 
        anchos.add(120);/*Total Instalado*/ anchos.add(120);/*Saldo a Devolver*/
        for(int i = 0; i < anchos.size(); i++) 
            jTable2.getColumnModel().getColumn(i).setPreferredWidth(anchos.get(i));
    }
    
    void agruparPuntosPreliquidacion()
    {   TableColumnModel cm = jTable2.getColumnModel();
        ColumnGroup g_name = new ColumnGroup("Puntos en los que se han instalado en campo (puntos deben coincidir con el croquis presentado)");
        for(int i=7; i<jTable2.getColumnCount(); i++)
           g_name.add(cm.getColumn(i));
        GroupableTableHeader header = (GroupableTableHeader)jTable2.getTableHeader();
        header.addColumnGroup(g_name);
        
////        AGRUPAR DE A 3 PARA ESTO SOLO SE DEBE MOSTRAR LA REFERENCIA MAS NO EL PUNTO EN LA TABLA
//        TableColumnModel cm = jTable2.getColumnModel();
//        GroupableTableHeader header = (GroupableTableHeader)jTable2.getTableHeader();
//        ColumnGroup g_name = new ColumnGroup("Puntos en los que se han instalado en campo (puntos deben coincidir con el croquis presentado)");                
////        AGRUPAR DE A 3 FORMA MANUAL
//        ColumnGroup g_lang = new ColumnGroup((String)modeloLista2.elementAt(0));
//        g_lang.add(cm.getColumn(7));
//        g_name.add(g_lang);        
//        
//        ColumnGroup g_lang2 = new ColumnGroup((String)modeloLista2.elementAt(1));
//        g_lang2.add(cm.getColumn(8));
//        g_name.add(g_lang2);

////        AGRUPAR DE A 3 FORMA TOTAL
//        int poslista=0;
//        for(int col=7; col<jTable2.getColumnCount()-2; col++)
//        {   ColumnGroup g=new ColumnGroup((String)modeloLista2.elementAt(poslista));
//            g.add(cm.getColumn(col));
//            g_name.add(g);
//            poslista++;
//        }
        
//        g_name.add(cm.getColumn(jTable2.getColumnCount()-1));
//        g_name.add(cm.getColumn(jTable2.getColumnCount()-2));
//
//        header.addColumnGroup(g_name);
    }
    
    void totalInstalado()
    {   for(int fila=0; fila< jTable2.getRowCount(); fila++)
        {   int suma=0;
            for(int col=7; col< jTable2.getColumnCount()-2; col++)
            {   if(jTable2.getValueAt(fila, col)!=null)
                    suma+=Integer.parseInt((String) jTable2.getValueAt(fila, col));
            }
            jTable2.setValueAt(suma, fila, 5);
        }
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(jList2.getSelectedIndex()!=-1)
        {   JD_Agregar_Material_Punto jdam=new JD_Agregar_Material_Punto(this,true);
            jdam.jTextField1.setText(jList2.getSelectedValue());
            jdam.jTextField2.setText(jTextField11.getText());
            jdam.listarMateriales();
            jdam.setVisible(true);
            if(!jdam.isVisible())
                mostrarPuntosPreliquidacion();
        }
        else    JOptionPane.showMessageDialog(this, "PORFAVOR SELECCIONE UN PUNTO DE LA LISTA");
    }//GEN-LAST:event_jButton5ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public static com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField10;
    public static javax.swing.JTextField jTextField11;
    public static javax.swing.JTextField jTextField12;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    public static javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField jTextField8;
    public static javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
