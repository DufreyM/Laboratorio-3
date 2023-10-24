import java.util.UUID;

public class bebida extends Producto{
    private int mililitros; 
    private String tipo;

    public bebida(int tipoproductoproducto, UUID iD, String nombre, int cantidadDisponible, int cantidadVendidos, int estado, double precio,
            int mililitros, String tipo) {
        super(tipoproductoproducto, iD, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.mililitros = mililitros;
        this.tipo = tipo;
    }
    public int getMililitros() {
        return mililitros;
    }
    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "bebida [mililitros=" + mililitros + ", tipo=" + tipo + "]";
    } 

    @Override
public String toCSVString() {

    return super.toCSVString() + String.format(",%d,%s", mililitros, tipo);
}

    
}
