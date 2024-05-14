import Roles.*;
import Sucursales.Sucursales;
import Tarjeta.SolicitudTarjetaCredito;
import Tarjeta.TipoTarjeta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    static TipoTarjeta tipoTarjeta;
    private static Cliente cliente;
    private static Empleado empleado;
    private static Inversionista inversionista;

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
        Roles rol = empleado.getRole();
        String menu = Roles.getMenuForRole(rol);
        if (menu != null) {
            System.out.println("Mostrando menú para: " + rol);
            System.out.println(menu);
        } else {
            System.out.println("Rol de empleado no reconocido.");
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
        while (true) {
            System.out.println("=== Menú para Capturista ===");
            System.out.println("1. Registrar nuevo ejecutivo de cuenta");
            System.out.println("2. Modificar datos de un ejecutivo de cuenta");
            System.out.println("3. Eliminar ejecutivo de cuenta");
            System.out.println("4. Buscar ejecutivo de cuenta");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarNuevoEjecutivoCuenta();
                    break;
                case 2:
                    modificarDatosEjecutivoCuenta();
                    break;
                case 3:
                    eliminarEjecutivoCuenta();
                    break;
                case 4:
                    buscarEjecutivoCuenta();
                    break;
                case 5:
                    System.out.println("Saliendo del menú para Capturista.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void buscarEjecutivoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del ejecutivo de cuenta: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del ejecutivo de cuenta: ");
        String apellido = scanner.nextLine();
        Capturista.EjecutivoCuenta ejecutivo = Capturista.buscarEjecutivo(nombre, apellido);
        if (ejecutivo != null) {
            System.out.println("Ejecutivo de cuenta encontrado: " + ejecutivo);
        } else {
            System.out.println("No se encontró ningún ejecutivo de cuenta con ese nombre y apellido.");
        }
    }

    private static void eliminarEjecutivoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del ejecutivo de cuenta: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del ejecutivo de cuenta: ");
        String apellido = scanner.nextLine();
        Capturista.EjecutivoCuenta ejecutivo = Capturista.buscarEjecutivo(nombre, apellido);
        if (ejecutivo != null) {
            Capturista.eliminarEjecutivo(ejecutivo);
        } else {
            System.out.println("No se encontró ningún ejecutivo de cuenta con ese nombre y apellido.");
        }
    }

    private static void modificarDatosEjecutivoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del ejecutivo de cuenta que desea modificar: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del ejecutivo de cuenta que desea modificar: ");
        String apellido = scanner.nextLine();
        Capturista.EjecutivoCuenta ejecutivo = Capturista.buscarEjecutivo(nombre, apellido);
        if (ejecutivo != null) {
            System.out.print("Ingrese el nuevo nombre del ejecutivo de cuenta: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo apellido del ejecutivo de cuenta: ");
            String nuevoApellido = scanner.nextLine();
            System.out.print("Ingrese el nuevo correo del ejecutivo de cuenta: ");
            String nuevoCorreo = scanner.nextLine();
            Capturista.modificarDatos(ejecutivo, nuevoNombre, nuevoApellido, nuevoCorreo);
        } else {
            System.out.println("No se encontró ningún ejecutivo de cuenta con ese nombre y apellido.");
        }
    }

    private static void registrarNuevoEjecutivoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del nuevo ejecutivo de cuenta: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del nuevo ejecutivo de cuenta: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el correo del nuevo ejecutivo de cuenta: ");
        String correo = scanner.nextLine();
        Capturista.agregarEjecutivo(nombre, apellido, correo);
    }

    private static void mostrarMenuEjecutivoCuenta() {
        while (true) {
            System.out.println("=== Menú para Ejecutivo de Cuenta ===");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Modificar datos de un cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Solicitar tarjeta de crédito para un cliente");
            System.out.println("6. Salir");
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
                    GestorUsuarios.buscarClientePorID(cliente.getId());
                    break;
                case 5:
                    SolicitudTarjetaCredito.solicitarTarjetaCredito(cliente, tipoTarjeta);
                    break;
                case 6:
                    System.out.println("Saliendo del menú para Ejecutivo de Cuenta.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
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
        Inversionista.modificarDatos(inversionista);

    }

    private static void eliminarInversionista() {
        Inversionista.eliminarInversionista(inversionista);
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
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        return opcion;
    }
}
