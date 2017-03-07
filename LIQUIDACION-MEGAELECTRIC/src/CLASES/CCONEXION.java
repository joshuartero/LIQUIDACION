package CLASES;

/**
 *
 * @author Joshua Ormachea
 */
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class CCONEXION
{   
    Connection con=null; 
    Statement st;   ResultSet rs;
    String servidor="", usuarioDB, passwordDB;
    
    public CCONEXION()
    {   try
        {   Class.forName("com.mysql.jdbc.Driver");
            servidor = "jdbc:mysql://localhost:3306/megaelectric?zeroDateTimeBehavior=convertToNull";
            usuarioDB="root";
            passwordDB=""; 
            con= DriverManager.getConnection(servidor,usuarioDB,passwordDB); 
            st = con.createStatement();
//            JOptionPane.showMessageDialog(null,"EXITO EN LA CONEXION");
        }
        catch(SQLException | ClassNotFoundException ex)
        {   JOptionPane.showMessageDialog(null, ex, "ERROR EN LA CONEXION CON LA BD"+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            con=null;
        }       
    }
    
    ArrayList<Imagen> getImagenes() 
    {   ArrayList<Imagen> lista = new ArrayList();
        try 
        {   ResultSet rs = st.executeQuery("SELECT imagen,nombre FROM Imagenes"); 
            while (rs.next())
            {   Imagen imagen=new Imagen();
                Blob blob = rs.getBlob("imagen");
                String nombre = rs.getObject("nombre").toString();
                byte[] data = blob.getBytes(1, (int)blob.length());
                BufferedImage img = null;
                try 
                {   img = ImageIO.read(new ByteArrayInputStream(data));
                } 
                catch (IOException ex)  {   JOptionPane.showMessageDialog(null, "ERROR DEBIDO A : "+ex.toString()); }
                
                imagen.setImagen(img);
                imagen.setNombre(nombre);
                lista.add(imagen);
            }
            rs.close();
        } 
        catch (SQLException ex) {   JOptionPane.showMessageDialog(null, "ERROR DEBIDO A : "+ex.toString()); }
        return lista;
    }    

    public Connection getCon() {
        return con;
    }    
}
