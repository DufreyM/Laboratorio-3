import java.util.UUID;

public class snack extends Producto{
    private int gramos; 
    private int sabor; //Escogí int como tipo de dato debido a que voy a permitir que el usuario ingrese un número solo con tipos limitados de tamaño lo mismo con sabor.
    private int tamaño; //

    public snack(int tipoproductoproducto, UUID iD, String nombre, int cantidadDisponible, int cantidadVendidos, int estado, double precio,
            int gramos, int sabor, int tamaño) {
        super(tipoproductoproducto, iD, nombre, cantidadDisponible, cantidadVendidos, estado, precio);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamaño = tamaño;
    }
    public int getGramos() {
        return gramos;
    }
    public void setGramos(int gramos) {
        this.gramos = gramos;
    }
    public int getSabor() {
        return sabor;
    }
    public void setSabor(int sabor) {
        this.sabor = sabor;
    }
    public int getTamaño() {
        return tamaño;
    }
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    @Override
    public String toString() {
        return "snack [gramos=" + gramos + ", sabor=" + sabor + ", tamaño=" + tamaño + "]";
    }

    @Override
public String toCSVString() {
    return super.toCSVString() + String.format(",%d,%d,%d", gramos, sabor, tamaño);
}

}
