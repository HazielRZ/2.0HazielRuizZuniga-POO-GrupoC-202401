//faltaria solamente iniciar sesion

import java.util.ArrayList;
import java.util.Scanner;

import Utils.IDManager;
public class Inversionista {
    static Scanner scanner = new Scanner(System.in);

    private String nombre;
    private double inversion;

    public Inversionista(String nombre, double inversion) {
        this.nombre = nombre;
        this.inversion = inversion;
    }
    public static void IdInversionista() {
       // Llama al método generarIDInversionista() de la clase IdManager
    int idGenerado = IDManager.generarIDInversionista();
        
    }


    static int opcion;

    public static void menuInversionista(){
        do {
            System.out.println("Antes seguir, requerimos que ingrese su contraseña. ");
            System.out.println("ingrese su contraseña: ");
            String contraseña = scanner.nextLine();
            ArrayList<Inversionista> inversionistas = new ArrayList<>();
            System.out.println("Menú de opciones:");
            System.out.println("1. Agregar inversionista");
            System.out.println("2. Eliminar inversionista");
            System.out.println("3. Modificar inversionista");
            System.out.println("4. Calcular inversión total");
            System.out.println("5. Buscar inversionista");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
    
            opcion = scanner.nextInt();
    
            switch (opcion) {
                case 1:
                    agregarInversionista(inversionistas, scanner);
                    break;
                case 2:
                    eliminarInversionista(inversionistas, scanner);
                    break;
                case 3:
                    modificarInversionista(inversionistas, scanner);
                    break;
                case 4:
                    calcularInversionTotal(inversionistas);
                    break;
                case 5:
                    buscarInversionista(inversionistas, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    
        scanner.close();
    }
    //metodo para agregar inversionistas
    private static void agregarInversionista(ArrayList<Inversionista> inversionistas, Scanner scanner) {
        System.out.print("Ingrese el nombre del inversionista: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la inversión del inversionista: ");
        double inversion = scanner.nextDouble();

        scanner.nextLine(); // Consumir el salto de línea

        Inversionista inversionista = new Inversionista(nombre, inversion);
        inversionistas.add(inversionista);

        System.out.println("Inversionista agregado exitosamente.");
    }

    //metodo para elminar inversionista
    private static void eliminarInversionista(ArrayList<Inversionista> inversionistas, Scanner scanner) {
        System.out.print("Ingrese el nombre del inversionista que desea eliminar: ");
        String nombre = scanner.nextLine();

        boolean inversionistaEncontrado = false;

        for (Inversionista inversionista : inversionistas) {
            if (inversionista.getNombre().equals(nombre)) {
                inversionistas.remove(inversionista);
                inversionistaEncontrado = true;
                break;
            }
        }

        if (inversionistaEncontrado) {
            System.out.println("Inversionista eliminado exitosamente.");
        } else {
            System.out.println("No se encontró el inversionista especificado.");
        }
    }
    //metodo para modificar inversionista
    private static void modificarInversionista(ArrayList<Inversionista> inversionistas, Scanner scanner) {
        System.out.print("Ingrese el nombre del inversionista que desea modificar: ");
        String nombre = scanner.nextLine();

        boolean inversionistaEncontrado = false;

        for (Inversionista inversionista : inversionistas) {
            if (inversionista.getNombre().equals(nombre)) {
                System.out.print("Ingrese el nuevo nombre del inversionista: ");
                String nuevoNombre = scanner.nextLine();

                System.out.print("Ingrese la nueva inversión del inversionista: ");
                double nuevaInversion = scanner.nextDouble();

                scanner.nextLine(); // Consumir el salto de línea

                inversionista.setNombre(nuevoNombre);
                inversionista.setInversion(nuevaInversion);

                inversionistaEncontrado = true;
                break;
            }
        }
    }
     //metodo para buscar inversionista
     public static void buscarInversionista(ArrayList<Inversionista> inversionistas, Scanner scanner){
        for (Inversionista inversionista : inversionistas) {
           System.out.println("esta es la lista de inversionistas: ");
           System.out.println(inversionista);
        }
     }
    private static void calcularInversionTotal(ArrayList<Inversionista> inversionistas) {
        double inversionTotal = 0;

        // Sumar las inversiones de todos los inversionistas
        for (Inversionista inversionista : inversionistas) {
            inversionTotal += inversionista.getInversion();
        }

        System.out.println("La inversión total es: " + inversionTotal);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getInversion() {
        return inversion;
    }

    public void setInversion(double inversion) {
        this.inversion = inversion;
    }
}


    