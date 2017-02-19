package CLASES;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JoshuaOrmachea
 */
public class CGeneral 
{   public void limpiarTabla(JTable jTable1, DefaultTableModel model) 
    {   int filas = jTable1.getRowCount();        
        while (filas > 0) 
        {   model.removeRow(filas - 1);
            filas--;
        }
    }    

    public boolean estaCerrado(JInternalFrame jif, JDesktopPane desktopPane)
    {   JInternalFrame[] activos=desktopPane.getAllFrames();
        boolean cerrado=true;
        int i=0;
        while (i<activos.length && cerrado)
        {   if(activos[i]==jif)
                cerrado=false;
            i++;
        }
        return cerrado;
    }
    
    public void mostrarCentrar(JInternalFrame jif, JDesktopPane desktopPane)
    {   int x=(desktopPane.getWidth()/2)-jif.getWidth()/2;
        int y=(desktopPane.getHeight()/2)-jif.getHeight()/2;        
        jif.setLocation(x, y);        
        desktopPane.add(jif);        
        jif.setVisible(true);        
    }
        
    public String formatoDecimal(String decimal) {
        return decimal.replace(',', '.');
    }
}
