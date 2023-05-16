import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
    public static Map<String, double[]> cart;

    public static void addProduct(String nombre, double precio, double cantidad){
        cart.put(nombre, new double[]{precio, cantidad});
    }

    public static void removeProduct(String nombre){
        cart.remove(nombre);
    }

    public static void updateProduct(String nombre, double precio, double cantidad){
        cart.replace(nombre, new double[]{precio, cantidad});
    }

    public static void showCart(){
        double total = 0;

        for (Map.Entry<String, double[]> entry: cart.entrySet()) {
            String nombre = entry.getKey();
            double precio = entry.getValue()[0];
            double cantidad = entry.getValue()[1];
            System.out.println(nombre + " - $ " + precio + " cantidad: " + cantidad);
            total += precio * cantidad;
        }
        System.out.println("Total $" + total);

    }

    public static void showMenu(){
        System.out.println("=====================");
        System.out.println("1. Agregar al carrito");
        System.out.println("2. Eliminar del carrito");
        System.out.println("3. Actualizar el producto del carrito");
        System.out.println("4. Mostrar el carrito");
        System.out.println("0. Salir");
        System.out.println("=====================");
    }

    public static int leerEntero(String mensaje){
        System.out.println(mensaje);
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    public static double leerDouble(String mensaje){
        System.out.println(mensaje);
        Scanner entrada = new Scanner(System.in);
        return entrada.nextDouble();
    }
    public static String leerString(String mensaje){
        System.out.println(mensaje);
        Scanner entrada = new Scanner(System.in);
        return entrada.nextLine();
    }


    public static void operaMenu(){
        int op;
        String nombre;
        double precio, cantidad;

        do {
            showMenu();
            op = leerEntero("Selecciona una opción del menú");
            switch (op){
                case 1: // agregar
                    nombre = leerString("nombre producto: ");
                    precio = leerDouble("precio: ");
                    cantidad = leerDouble("cantidad: ");
                    addProduct(nombre, precio, cantidad);
                    break;
                case 2: // eliminar
                    nombre = leerString("nombre producto: ");
                    removeProduct(nombre);
                    break;
                case 3: // actualizar
                    nombre = leerString("nombre producto: ");
                    precio = leerDouble("precio: ");
                    cantidad = leerDouble("cantidad: ");
                    updateProduct(nombre, precio, cantidad);
                    break;
                case 4: // mostrar
                    showCart();
                    break;
                case 0: // salir
                    System.out.println("adios");
                    break;
                default:
                    System.out.println("Elije una opción correcta, machucao/a");
                    break;
            }
        } while (op != 0);
    }

    public static void main(String[] args){

        cart = new HashMap<String, double[]>();
        operaMenu();

    }
}
