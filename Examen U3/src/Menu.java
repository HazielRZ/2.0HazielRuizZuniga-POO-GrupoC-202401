import Roles.Cliente;
import Roles.Empleado;
import Roles.GestorUsuarios;
import Sucursales.Gerente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenuCliente() {
        while (true) {
            System.out.println("----- Menú Cliente -----");
            System.out.println("1. Ver tarjetas");
            if (puedeSolicitarTarjeta(cliente)) {
                System.out.println("2. Solicitar tarjeta de débito");
                System.out.println("3. Solicitar tarjeta de crédito");
            }
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    // Lógica para ver las tarjetas del cliente
                    break;
                case 2:
                    // Lógica para solicitar tarjeta de débito
                    break;
                case 3:
                    // Lógica para solicitar tarjeta de crédito
                    break;
                case 0:
                    System.out.println("Saliendo del menú cliente.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static boolean puedeSolicitarTarjeta(Cliente cliente) {

        return true; // Por ahora siempre retorna true
    }

    public static void mostrarMenuEmpleado(Empleado empleado) {
        switch (empleado.getRol()) {
            case GERENTE:
                mostrarMenuGerente((Gerente) empleado);
                break;
            case EJECUTIVO_CUENTA:
                mostrarMenuEjecutivoCuenta();
                break;
            case CAPTURISTA:
                mostrarMenuCapturista();
                break;
            default:
                System.out.println("Rol de empleado no reconocido.");
                break;
        }
    }

    private static void mostrarMenuGerente(Gerente gerente) {
        while (true) {
            System.out.println("Menú de Gerente");
            System.out.println("1. Realizar operaciones con clientes");
            System.out.println("2. Realizar operaciones con empleados");
            System.out.println("3. Realizar operaciones con inversionistas");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    mostrarMenuOperacionesClientes();
                    break;
                case 2:
                    // Lógica para realizar operaciones con empleados
                    break;
                case 3:
                    // Lógica para realizar operaciones con inversionistas
                    break;
                case 0:
                    System.out.println("Saliendo del menú de Gerente.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void mostrarMenuEjecutivoCuenta() {
        // Implementación del menú para Ejecutivo de Cuenta
    }

    private static void mostrarMenuCapturista() {
        // Implementación del menú para Capturista
    }

    private static void mostrarMenuOperacionesClientes() {
        while (true) {
            System.out.println("Menú de Operaciones con Clientes");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Modificar datos de cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Ver tarjetas del cliente");
            System.out.println("5. Solicitar tarjeta de crédito");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarNuevoCliente();
                    break;
                case 2:
                    modificarDatosCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    // Lógica para ver las tarjetas del cliente
                    break;
                case 5:
                    // Lógica para solicitar tarjeta de crédito
                    break;
                case 0:
                    System.out.println("Saliendo del menú de Operaciones con Clientes.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void registrarNuevoCliente() {
        Cliente cliente = Cliente.registrarCliente();

    }

    private static void modificarDatosCliente() {
        System.out.println("Ingrese el ID del cliente que desea modificar:");
        int id = scanner.nextInt();
        Cliente cliente = GestorUsuarios.buscarClientePorID(id);
        if (cliente != null) {

            modificarDatosCliente();
        } else {
            System.out.println("No se encontró ningún cliente con el ID proporcionado.");

        }
    }

    private static void eliminarCliente() {
        System.out.println("Ingrese el ID del cliente que desea eliminar:");
         int id = scanner.nextInt();
        Cliente clienteAEliminar = GestorUsuarios.buscarClientePorID(id);
        if (clienteAEliminar != null) {
            GestorUsuarios.getClientes().remove(clienteAEliminar);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con el ID proporcionado.");
        }
    }

    private static int leerOpcion() {
        int opcion = -1;
        boolean opcionValida = false;

        while (!opcionValida) {
            try {
                opcion = scanner.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }

        return opcion;
    }
}
