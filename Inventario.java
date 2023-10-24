import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>(); 
    Scanner scanner = new Scanner(System.in); 

    public Inventario(){
    }

    /**
     * @param tipoproductoproducto
     * @param iD
     * @param nombre
     * @param cantidadDisponible
     * @param cantidadVendidos
     * @param estado
     * @param precio
     * @param gramos
     * @param sabor
     * @param tamaño
     * @param color
     * @param material
     * @param mililitros
     * @param tipo
     */
    public void agregarProducto(int tipoproductoproducto, UUID iD, String nombre, int cantidadDisponible, int cantidadVendidos, int estado, double precio,
        int gramos, int sabor, int tamaño, String color, String material, int mililitros, String tipo){
        switch (tipoproductoproducto){
            case 1: 
            snack snack = new snack(tipoproductoproducto, iD, nombre, cantidadDisponible, cantidadVendidos, estado, precio,
            gramos, sabor, tamaño);
            productos.add(snack); 
            break;
            case 2: 
            bebida bebida = new bebida(tipoproductoproducto, iD, nombre, cantidadDisponible, cantidadVendidos, estado, precio,
            mililitros, tipo); 
            productos.add(bebida); 
            break; 
            case 3:
            ropa ropa = new ropa(tipoproductoproducto, iD, nombre, cantidadDisponible, cantidadVendidos, estado, precio, color, material); 
            productos.add(ropa);  
            break;
            case 4:
            System.out.println("Saber");
            break; 
        }
        }
        
        /**
         * 
         */
        public void añadirProducto() { //Le pido al usuario todos los datos que necesito para crear al jugador.
            System.out.println("Bienvenido a continuación, agrega la información del jugador, si no aplica solo escribe 0");

            int tipoproductoproducto;
        
            // Este while es para verificar que ingrese una opción válida
            while (true) {
                System.out.println("Ingrese el número según el tipo de producto que es: \n 1. Snack. \n 2. Bebida. \n 3. ropa");
                tipoproductoproducto = scanner.nextInt();
        
                // Verificamos si la opción ingresada es válida (1, 2 o 3)
                if (tipoproductoproducto == 1 || tipoproductoproducto == 2 || tipoproductoproducto == 3) {
                    break;
                } else {
                    System.out.println("Opción no válida. Por favor, ingrese 1, 2 o 3.");
                }
            }

            UUID ID = UUID.randomUUID(); //Lo uso para generar el ID. 

            System.out.println("Ingrese el nombre del producto");
            String nombreproducto = scanner.next();
        
            System.out.println("Ingrese la cantidad disponible");
            int cantidadDisponibleproducto = scanner.nextInt();
        
            System.out.println("Ingrese la cantidad de producto vendido");
            int cantidadVendidosproducto = scanner.nextInt();
        
            System.out.println("Ingrese el estado del producto \n 1. Disponible \n 2. No disponible");
            int estadoproducto = scanner.nextInt();
        
            System.out.print("Ingrese el precio del producto Q."); 
            double precioproducto = scanner.nextDouble();

            System.out.println("Ingrese el sabor del producto \n 0. N/A \n 1. Barbacoa. \n 2. Picante \n 3. Natural (únicamente snacks)");
            int saborproducto = scanner.nextInt();
        
            System.out.println("Ingrese los gramos del producto (únicamente snacks)");
            int gramosproducto = scanner.nextInt();
        
            System.out.println("Ingrese el tamaño del producto. \n 0. N/A \n 1. Individual. \n 2. Familiar (únicamente snacks)");
            int tamañoproducto = scanner.nextInt();
        
            System.out.println("Ingrese el color del producto (únicamente ropa) 0. N/A");
            String colorproducto = scanner.next();
        
            System.out.println("Ingrese el material del producto (únicamente ropa) 0. N/A");
            String materialproducto = scanner.next();

            System.out.println("Ingrese los mililitros de la bebida (únicamente bebidas)");
            int mililitrosbebida = scanner.nextInt();

            System.out.println("Ingrese el tipo de bebida (únicamente bebidas)");
            String tipoproducto = scanner.next();
        
            
            agregarProducto(tipoproductoproducto, ID, nombreproducto, cantidadDisponibleproducto, cantidadVendidosproducto, estadoproducto, precioproducto,
        gramosproducto, saborproducto, tamañoproducto, colorproducto, materialproducto, mililitrosbebida, tipoproducto);
            System.out.println("Producto agregado exitosamente");
            guardarProductosEnCSV();
        }

        /**
         * Muestra los productos
         */
        public void mostrarProductos() {
        Scanner teclado = new Scanner(System.in); 
        int op = 0;
        System.out.println("Ingrese la lista de productos que desea ver: \n 1. Snacks. \n 2. Bebidas. \n 3. Ropa. \n 4. Total tienda");
        op = teclado.nextInt();
        teclado.nextLine();
        
        switch (op){
        case 1: 
        if (!productos.isEmpty()) {
            double ventas = 0; 
            ArrayList<snack> snacks = new ArrayList<>(); // Crear una lista para los snacks
                for (Producto productos : productos) {
                    if (productos instanceof snack) {
                        snack snack = (snack) productos;
                        snacks.add(snack);
                        System.out.println("ID: " + productos.getID() + " Nombre: " + productos.getNombre());
                        System.out.println("--------------------------------------"); 
                        ventas = ventas + (productos.getPrecio() * productos.getCantidadVendidos());
                }
            }
              System.out.println("Total de snacks " + snacks.size()); 
              System.out.println("----------------------------------");
              System.out.println("El total de ventas de la categoría snack es: " + ventas);
        }
        break; 
        case 2: 
        if (!productos.isEmpty()) {
            double ventas = 0; 
            ArrayList<bebida> bebidas = new ArrayList<>(); // Crear una lista para las bebidas
                for (Producto productos : productos) {
                    if (productos instanceof bebida) {
                        bebida bebida = (bebida) productos;
                        bebidas.add(bebida);
                        System.out.println("ID: " + productos.getID() + " Nombre: " + productos.getNombre());
                        System.out.println("--------------------------------------"); 
                        ventas = ventas + (productos.getPrecio() * productos.getCantidadVendidos()); 
                }
                
            }
            System.out.println("Total de bebidas: " + bebidas.size()); 
            System.out.println("----------------------------------");
            System.out.println("El total de ventas de la categoría bebidas es: " + ventas);
        }
        break; 
        case 3:
        if (!productos.isEmpty()) {
            double ventas = 0;
            ArrayList<ropa> ropalis = new ArrayList<>(); // Crear una lista para los snacks
                for (Producto productos : productos) {
                    if (productos instanceof ropa) {
                        ropa rop = (ropa) productos;
                        ropalis.add(rop);
                        System.out.println("ID: " + productos.getID() + " Nombre: " + productos.getNombre());
                        System.out.println("--------------------------------------"); 
                        ventas = ventas + (productos.getPrecio() * productos.getCantidadVendidos()); 
                }
            }
            System.out.println("Total de ropa: " + ropalis.size());
            System.out.println("----------------------------------");
            System.out.println("El total de ventas de la categoría ropa es: " + ventas);
        }
        break;
        
        case 4: 
         if (!productos.isEmpty()) {
            double ventas = 0;
                for (Producto productos : productos) {
                        ventas = ventas + (productos.getPrecio() * productos.getCantidadVendidos()); 
            }
            System.out.println("----------------------------------");
            System.out.println("El total de ventas de la tienda es: " + ventas);
        break; 
         }
        }
    }

    /**
     * @param id
     * @return
     */
    public Producto buscarProductoPorID(UUID id) {
        for (Producto producto : productos) {
            if (producto.getID().equals(id)) {
                return producto; 
            }
        }
        return null; 
    }
    

    /**
     * 
     */
    public void BuscarID() {
        System.out.println("Ingrese el ID del producto que desea buscar: ");
        String idStr = scanner.next();
        UUID id;
        try {
            id = UUID.fromString(idStr); 
        } catch (IllegalArgumentException e) {
            System.out.println("ID no válido.");
            return;
        }
    
        Producto productoEncontrado = buscarProductoPorID(id);
    
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado:");
            System.out.println("ID: " + productoEncontrado.getID());
            System.out.println("Nombre: " + productoEncontrado.getNombre());
            
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    /**
     * 
     */
    public void guardarProductosEnCSV() {
        try {
            FileWriter fileWriter = new FileWriter("productos.csv", false); 
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            for (Producto producto : productos) {
                printWriter.println(producto.toCSVString());
            }
            
            printWriter.close();
            System.out.println("Productos guardados en productos.csv");
        } catch (IOException e) {
            System.out.println("Error al guardar los productos en CSV: " + e.getMessage());
        }
    }
    /**
     * 
     */
    public void cargarProductosDesdeCSV() {
        productos.clear();
        String csvFile = "productos.csv";
    
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
    
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length >= 7) { // Cambiamos a 7 para permitir líneas con al menos 7 elementos
                    System.out.println("Leyendo línea del CSV: " + line);
                    int tipoproductoproducto = Integer.parseInt(parts[0]);
                    UUID id = UUID.fromString(parts[1]);
                    String nombre = parts[2];
                    int cantidadDisponible = Integer.parseInt(parts[3]);
                    int cantidadVendidos = Integer.parseInt(parts[4]);
                    int estado = Integer.parseInt(parts[5]);
                    double precio = Double.parseDouble(parts[6]);
    
                    if (tipoproductoproducto == 1) { // SNACK
                        if (parts.length >= 10) {
                            int gramos = Integer.parseInt(parts[7]);
                            int sabor = Integer.parseInt(parts[8]);
                            int tamaño = Integer.parseInt(parts[9]);
                            productos.add(new snack(tipoproductoproducto, id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, gramos, sabor, tamaño));
                        } else {
                            // Manejo de error o registro de la línea incorrecta
                            System.err.println("Línea incompleta para tipo de producto 1 (SNACK): " + line);
                        }
                    }
                    if (tipoproductoproducto == 2) { // BEBIDA
                        if (parts.length >= 9) {
                            int mililitros = Integer.parseInt(parts[7]);
                            String tipo = parts[8];
                            productos.add(new bebida(tipoproductoproducto, id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, mililitros, tipo));
                        } else {
                            // Manejo de error o registro de la línea incorrecta
                            System.err.println("Línea incompleta para tipo de producto 2 (BEBIDA): " + line);
                        }
                    }
                    if (tipoproductoproducto == 3) { // ROPA
                        if (parts.length >= 9) {
                            String color = parts[7];
                            String material = parts[8];
                            productos.add(new ropa(tipoproductoproducto, id, nombre, cantidadDisponible, cantidadVendidos, estado, precio, color, material));
                        } else {
                            // Manejo de error o registro de la línea incorrecta
                            System.err.println("Línea incompleta para tipo de producto 3 (ROPA): " + line);
                        }
                    }
                } else {
                    // Manejo de error o registro de la línea incorrecta
                    System.err.println("Línea incompleta: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar productos desde CSV: " + e.getMessage());
        }
    }
    
    
}

