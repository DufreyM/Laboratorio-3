import java.util.UUID;

public class ropa extends Producto{
    private String color; 
    private String material;


    public ropa(int tipoproductoproducto, UUID iD, String nombre, int cantidadDisponible, int cantidadVendidos, int estado, double precio,
             String color, String material) {
        super(tipoproductoproducto, iD, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.color = color;
        this.material = material;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    @Override
    public String toString() {
        return "color=" + color + ", material=" + material + "]";
    } 
    @Override
public String toCSVString() {
    
    return super.toCSVString() + String.format(",%s,%s", color, material);
}

}