import Roles.Cliente;
import Roles.Empleado;
import Roles.Gerente;
import Roles.Inversionista;
import utils.ControlAcceso;
import utils.FileManager;
import Sucursales.Sucursales;
import Sucursales.SucursalAcueducto;
import Sucursales.SucursalMadero;
import utils.IDManager;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SistemaBancario {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Empleado> empleados;
    private static List<Inversionista> inversionistas;
    private static Sucursales sucursal;

    public static void main(String[] args) {
        cargarDatos();


        sucursal = seleccionarSucursal();
        if (sucursal == null) {
            System.out.println("No se pudo seleccionar una sucursal. Saliendo del programa.");
            return;
        }
        mostrarMenuInicio();
        guardarDatos();
        ControlAcceso.inicializarCredenciales();
    }
    private static Sucursales seleccionarSucursal() {
        System.out.println("Por favor, seleccione una sucursal:");
        System.out.println("1. Sucursal Acueducto");
        System.out.println("2. Sucursal Madero");
        System.out.print("Ingrese su opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        switch (opcion) {
            case 1:
                Gerente gerente1 = new Gerente(new Date(), "JUAN", "", "", IDManager.generarIDEmpleado());
                return new SucursalAcueducto(1, "Acueducto", "123456789", "44324234");
            case 2:
                Gerente gerente2 = new Gerente(new Date(), "EDER", "", "", IDManager.generarIDEmpleado());
                return new SucursalMadero(3, "MAdero", "987654321", "234234324");
            default:
                System.out.println("Opción inválida.");
                return null; // Devuelve null en caso de opción inválida
        }
    }




    private static void cargarDatos() {
        // Cargar datos del archivo al iniciar el programa
        empleados = FileManager.cargarLista(FileManager.EMPLEADOS_FILE);
        List<Cliente> clientes = FileManager.cargarLista(FileManager.CLIENTES_FILE);
        inversionistas = FileManager.cargarLista(FileManager.INVERSIONISTAS_FILE);

        // Inicializar el gestor de usuarios y agregar los usuarios cargados
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        for (Cliente cliente : clientes) {
            gestorUsuarios.agregarCliente(cliente);
        }
        for (Empleado empleado : empleados) {
            gestorUsuarios.agregarEmpleado(empleado);
        }
        for (Inversionista inversionista : inversionistas) {
            gestorUsuarios.agregarInversionista(inversionista);
        }
    }

    private static void guardarDatos() {
        // Guardar datos en el archivo al finalizar el programa
        FileManager.guardarLista(empleados, FileManager.EMPLEADOS_FILE);
        FileManager.guardarLista(GestorUsuarios.getClientes(), FileManager.CLIENTES_FILE);
        FileManager.guardarLista(inversionistas, FileManager.INVERSIONISTAS_FILE);
    }

    private static void mostrarMenuInicio() {
        while (true) {
            System.out.println("Bienvenido al Sistema Bancario");
            System.out.println("1. Iniciar sesión como empleado");
            System.out.println("2. Iniciar sesión como cliente");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    iniciarSesionEmpleado();
                    break;
                case 2:
                    iniciarSesionCliente();
                    break;
                case 3:
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void iniciarSesionEmpleado() {
        System.out.println("Iniciar sesión como empleado");
        System.out.print("Ingrese su ID: ");
        String idEmpleado = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        if (ControlAcceso.autenticarEmpleado(idEmpleado, contraseña)) {
            Menu.mostrarMenuEmpleado();
        } else {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
    }

    private static void iniciarSesionCliente() {
        System.out.println("Iniciar sesión como cliente");
        System.out.print("Ingrese su ID: ");
        int idCliente = scanner.nextInt();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        if (ControlAcceso.autenticarCliente(idCliente, contraseña)) {
            Cliente cliente = GestorUsuarios.buscarClientePorID(idCliente);
            if (cliente != null) {
                System.out.println("Inicio de sesión exitoso.");

                Menu.mostrarMenuCliente();
            } else {
                System.out.println("No se encontró al cliente. Por favor, inténtelo de nuevo.");
            }
        } else {
            System.out.println("Error: Credenciales incorrectas.");
        }
    }
}
