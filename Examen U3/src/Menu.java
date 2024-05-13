import Roles.Cliente;
import Roles.Gerente;
import Roles.Inversionista;
import Sucursales.Sucursales;
import Tarjeta.SolicitudTarjetaCredito;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

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
                    SolicitudTarjetaCredito.mostrarListaSolicitudes();
                    break;
                case 2:
                    System.out.println("No disponible por el momento");
                    break;
                case 3:
                    Cliente.solicitarTarjetaCredito();
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

    public static void mostrarMenuEmpleado() {
        switch (empleado.getRol()) {
            case GERENTE:
                mostrarMenuGerente((Gerente) empleado);
                break;
            case EJECUTIVOCUENTA:
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
                    mostrarMenuOperacionesInversionistas();
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
    private static void mostrarMenuOperacionesInversionistas() {
        while (true) {
            System.out.println("Menú de Operaciones con Inversionistas");
            System.out.println("1. Registrar nuevo inversionista");
            System.out.println("2. Modificar datos de inversionista");
            System.out.println("3. Eliminar inversionista");
            System.out.println("4. Ver lista de inversionistas");
            System.out.println("5. Invertir");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarNuevoInversionista();
                    break;
                case 2:
                    modificarDatosInversionista();
                    break;
                case 3:
                    eliminarInversionista();
                    break;
                case 4:
                    // Lógica para mostrar la lista de inversionistas
                    break;
                case 5:
                    invertir();
                    break;
                case 0:
                    System.out.println("Saliendo del menú de Operaciones con Inversionistas.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
    private static void mostrarMenuCapturista() {
        System.out.println("=== Menú para Capturista ===");
        System.out.println("1. Registrar nuevo ejecutivo de cuenta");
        System.out.println("2. Modificar datos de un ejecutivo de cuenta");
        System.out.println("3. Eliminar ejecutivo de cuenta");
        System.out.println("4. Buscar ejecutivo de cuenta");
        System.out.println("5. Salir");
    }

    private static void mostrarMenuEjecutivoCuenta() {
        System.out.println("=== Menú para Ejecutivo de Cuenta ===");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Modificar datos de un cliente");
        System.out.println("3. Eliminar cliente");
        System.out.println("4. Buscar cliente");
        System.out.println("5. Solicitar tarjeta de crédito para un cliente");
        System.out.println("6. Salir");
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
                    SolicitudTarjetaCredito.mostrarListaSolicitudes();
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
    private static void registrarNuevoInversionista() {
        Inversionista.registrarNuevoInversionista();
    }

    private static void modificarDatosInversionista() {
        Inversionista.modificarDatos();
    }

    private static void eliminarInversionista() {
       Inversionista.eliminarInversionista();
    }

    private static void invertir() {
        Sucursales.invertir();
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
