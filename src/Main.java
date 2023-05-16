import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> tareas;

    // subalgoritmo
    public static void addTask(String task){
        tareas.add(task);
    }

    public static int searchTask(String task){
        return tareas.indexOf(task);
    }

    public static void deleteTask(String task){
        tareas.remove(searchTask(task));
    }

    public static void updateTask(String task){
        int pos = searchTask(task);
        String newTask = leerString("Ingresa la nueva tarea: ");
        tareas.set(pos, newTask);

        tareas.set(searchTask(task), leerString("Ingresa la nueva tarea: "));
    }

    public static void showTasks(){
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println(tareas.get(i));
        }
    }

    public static void showMenu(){
        System.out.println("=====================");
        System.out.println("1. Agregar Tarea");
        System.out.println("2. Eliminar Tarea");
        System.out.println("3. Mostrar todas las tareas");
        System.out.println("4. Actualizar tarea");
        System.out.println("0. Salir");
        System.out.println("=====================");
    }

    public static int leerEntero(String mensaje){
        System.out.println(mensaje);
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }
    public static String leerString(String mensaje){
        System.out.println(mensaje);
        Scanner entrada = new Scanner(System.in);
        return entrada.nextLine();
    }

    // algoritmo
    public static void main(String[] args) {

        tareas = new ArrayList<String>();
        int opcion;
        do {
            showMenu();
            opcion = leerEntero("Selecciona una opción: ");
            String task;
            switch (opcion){
                case 1: // agregar una tarea
                    task = leerString("Ingresa la tarea: ");
                    addTask(task);
                    break;
                case 2: // eliminar una tarea
                    task = leerString("Ingresa la tarea que quieres eliminar");
                    deleteTask(task);
                    break;
                case 3: // mostrar las tareas
                    showTasks();
                    break;
                case 4:
                    updateTask(leerString("Ingresa la tarea que quieres actualizar:"));
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Debes ingresar una opción correcta");
                    break;
            }

        } while (opcion != 0);
    }
}