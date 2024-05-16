import Tarjetas.MenuTarjeta;
import Tarjetas.SistemaTarjetas;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuEmpleados {
    private final Scanner scanner;

    public MenuEmpleados(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenuGerente() {
        System.out.println("Operaciones disponibles para Gerente de Sucursal:");
        System.out.println("1. Operaciones Empleados");
        System.out.println("2. Operaciones Clientes");
        System.out.println("3. Operaciones con Tarjetas");
        System.out.println("4. Operaciones Inversionistas");
        System.out.println("5. Volver al menú principal");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                menuOperacionesEmpleados(scanner);
                break;
            case 2:
                menuOperacionesClientes(scanner,GestorClientes.listaClientes);
                break;
            case 3:
                MenuTarjeta.menuOperacionesConTarjetas(scanner, SistemaTarjetas.sistemaTarjetas);
                break;
            case 4:
                Inversionista.menuInversionista();
                break;
            case 5:
                // Volver al menú principal
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void mostrarMenuCapturista() {
        System.out.println("Operaciones disponibles para Capturista:");
        System.out.println("1. Operaciones Ejecutivos de Cuenta");
        System.out.println("2. Volver al menú principal");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                menuOperacionesCapturista(scanner);
                break;
            case 2:
                // Volver al menú principal
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void mostrarMenuEjecutivoCuenta() {
        System.out.println("Operaciones disponibles para Ejecutivo de Cuenta:");
        System.out.println("1. Operaciones Tarjeta");
        System.out.println("2. Operaciones Clientes");
        System.out.println("3. Volver al menú principal");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                MenuTarjeta.menuOperacionesConTarjetas(scanner, SistemaTarjetas.sistemaTarjetas);
                break;
            case 2:
                menuOperacionesClientes(scanner, GestorClientes.listaClientes);
                break;
            case 3:
                // Volver al menú principal
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
    public static void menuOperacionesClientes(Scanner scanner, ArrayList<Cliente> listaClientes) {
        int opcion;
        do {
            System.out.println("\nMenú de Operaciones con Clientes:");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Ver datos de un cliente por ID");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Mostrar todos los clientes");
            System.out.println("6. Volver al menú principal");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    GestorClientes.registrarCliente(scanner, listaClientes);
                    break;
                case 2:
                    GestorClientes.datosClientePorID(scanner, listaClientes);
                    break;
                case 3:
                    GestorClientes.modificarCliente(scanner, listaClientes);
                    break;
                case 4:
                    GestorClientes.eliminarCliente(scanner, listaClientes);
                    break;
                case 5:
                    GestorClientes.mostrarClientes(listaClientes);
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
    public static void menuOperacionesEmpleados(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nMenú de Operaciones con Empleados:");
            System.out.println("1. Registrar nuevo ejecutivo de cuenta");
            System.out.println("2. Registrar nuevo capturista");
            System.out.println("3. Mostrar todos los empleados");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Volver al menú principal");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    GestorEmpleados.registrarNuevoEjecutivo(scanner);
                    break;
                case 2:
                    GestorEmpleados.registrarCapturista(scanner);
                    break;
                case 3:
                    GestorEmpleados.mostrarEmpleados();
                    break;
                case 4:
                    System.out.print("Ingrese el ID del empleado que desea eliminar: ");
                    int idEmpleado = scanner.nextInt();
                    GestorEmpleados.eliminarEmpleado(idEmpleado);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
    public static void menuOperacionesCapturista(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nMenú de Operaciones de Capturista:");
            System.out.println("1. Registrar nuevo ejecutivo de cuenta");
            System.out.println("2. Mostrar todos los empleados");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Volver al menú principal");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    GestorEmpleados.registrarNuevoEjecutivo(scanner);
                    break;
                case 2:
                    GestorEmpleados.mostrarEmpleados();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del empleado que desea eliminar: ");
                    int idEmpleado = scanner.nextInt();
                    GestorEmpleados.eliminarEmpleado(idEmpleado);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

}
