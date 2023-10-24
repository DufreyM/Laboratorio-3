import java.util.UUID;

public class Producto {
    protected UUID ID; 
    protected String nombre; 
    protected int CantidadDisponible; 
    protected int CantidadVendidos; 
    protected int estado; 
    protected double precio;
    protected int tipoproductoproducto;
    
    //Constructor de la clase productos
    public Producto(int tipoproductoproducto, UUID iD, String nombre, int cantidadDisponible, int cantidadVendidos, int estado, double precio) {
        this.tipoproductoproducto =  tipoproductoproducto;
        ID = iD;
        this.nombre = nombre;
        CantidadDisponible = cantidadDisponible;
        CantidadVendidos = cantidadVendidos;
        this.estado = estado;
        this.precio = precio;
    }
    public UUID getID() {
        return ID;
    }
    public void setID(UUID iD) {
        ID = iD;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidadDisponible() {
        return CantidadDisponible;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        CantidadDisponible = cantidadDisponible;
    }
    public int getCantidadVendidos() {
        return CantidadVendidos;
    }
    public void setCantidadVendidos(int cantidadVendidos) {
        CantidadVendidos = cantidadVendidos;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Producto [ID=" + ID + ", nombre=" + nombre + ", CantidadDisponible=" + CantidadDisponible
                + ", CantidadVendidos=" + CantidadVendidos + ", estado=" + estado + ", precio=" + precio + "]";
    }

    public String toCSVString() {
        return String.format("%d,%s,%s,%d,%d,%d,%.2f", tipoproductoproducto, ID, nombre, CantidadDisponible, CantidadVendidos, estado, precio);
    }
    
}
