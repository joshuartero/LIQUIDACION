package CLASES;

import java.util.ArrayList;

/**
 *
 * @author Joshua Ormachea
 */
public class Punto 
{   String nombre;
    String codigoFlc;
    ArrayList arrayServicios;

    public Punto(String nombre, String codigoFlc, ArrayList arrayServicios) {
        this.nombre = nombre;
        this.codigoFlc = codigoFlc;
        this.arrayServicios = arrayServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoFlc() {
        return codigoFlc;
    }

    public void setCodigoFlc(String codigoFlc) {
        this.codigoFlc = codigoFlc;
    }

    public ArrayList getArrayServicios() {
        return arrayServicios;
    }

    public void setArrayServicios(ArrayList arrayServicios) {
        this.arrayServicios = arrayServicios;
    }
}
