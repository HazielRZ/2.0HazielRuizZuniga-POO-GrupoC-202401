import Roles.Cliente;
import Roles.Empleado;
import Roles.Inversionista;
import utils.ControlAcceso;
import utils.FileManager;

import java.util.List;
import java.util.Scanner;

public class SistemaBancario {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Empleado> empleados;
    private static List<Inversionista> inversionistas;
    private static GestorUsuarios gestorUsuarios;

    public static void main(String[] args) {
        cargarDatos();
        mostrarMenuInicio();
        guardarDatos();
        ControlAcceso.inicializarCredenciales();
    }

    private static void cargarDatos() {
        // Cargar datos del archivo al iniciar el programa
        empleados = FileManager.cargarLista(FileManager.EMPLEADOS_FILE);
        List<Cliente> clientes = FileManager.cargarLista(FileManager.CLIENTES_FILE);
        inversionistas = FileManager.cargarLista(FileManager.INVERSIONISTAS_FILE);

        // Inicializar el gestor de usuarios y agregar los usuarios cargados
        gestorUsuarios = new GestorUsuarios();
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
        FileManager.guardarLista(gestorUsuarios.getClientes(), FileManager.CLIENTES_FILE);
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
            // Lógica para mostrar el menú de empleado
            // Por ejemplo: mostrarMenuEmpleado(idEmpleado);
        } else {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
    }

    private static void iniciarSesionCliente() {
        System.out.println("Iniciar sesión como cliente");
        System.out.print("Ingrese su ID: ");
        String idCliente = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        if (ControlAcceso.autenticarCliente(idCliente, contraseña)) {
            Cliente cliente = gestorUsuarios.buscarClientePorId(idCliente);
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
