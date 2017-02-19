package CLASES;

/**
 *
 * @author Joshua Ormachea
 */
public class Servicio 
{   String codigo;
    String descripcion;
    String unidad;
    int cantidad;

    public Servicio(String codigo, String descripcion, String unidad, int cantidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.cantidad=cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
