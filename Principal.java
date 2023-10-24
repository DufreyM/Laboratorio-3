/**
 * Nombre del programa: Laboratorio No. 3 - Herencia
 * Descripción: 
 * Proyecto realizado para la clase de Programación orientada a objetos
 * Autor: Leonardo Dufrey Mejía Mejía
 * Fecha de creación: 20 de octubre de 2023
 * Fecha de última modificación: 23 de octubre de 2023
 * Fuentes de información: [crédito a toda fuente de información que haya aportado al desarrollo del programa]
 */

import java.util.Scanner;

public class Principal {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Inventario uvg = new Inventario();
        uvg.cargarProductosDesdeCSV();
        Scanner teclado = new Scanner(System.in);
        String opciones = "1. Agregar Producto. \n 2. Inventario. \n 3. Buscar Producto por ID. \n 4. Salir";
        int op = 0;
        boolean continuar = true;
        while (continuar) {
            System.out.println(opciones);
            System.out.print("Ingrese la opción deseada: ");
            op = teclado.nextInt();
            teclado.nextLine(); 
            switch (op) {
                case 1:
                    uvg.añadirProducto();
                    break;
                case 2:
                    uvg.mostrarProductos();
                    break;
                case 3:
                    uvg.BuscarID();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Ingrese un número válido");
            }
        }

    }
}
