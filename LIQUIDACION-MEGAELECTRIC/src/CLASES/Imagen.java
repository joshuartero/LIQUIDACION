package CLASES;

import java.awt.Image;

/**
 *
 * @author Joshua
 */
public class Imagen {
    Image imagen;
    String nombre;

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }
}
