import Roles.*;
import Sucursales.Sucursales;
import utils.ControlAcceso;
import utils.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.FileManager.EMPLEADOS_FILE;
import static utils.FileManager.INVERSIONISTAS_FILE;
import static utils.FileManager.CLIENTES_FILE;

public class SistemaBancario {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Empleado> empleados;
    private static List<Inversionista> inversionistas;
    private static List<Cliente>clientes;
    private static Sucursales sucursales;

    public static void main(String[] args) {
        cargarDatos(); // Cargar datos al inicio del programa
        sucursales = seleccionarSucursal();
        if (sucursales == null) {
            System.out.println("No se pudo seleccionar una sucursal. Saliendo del programa.");
            return;
        }

        if (empleados.isEmpty()) {
            Empleado empleadoPrueba = new Empleado(1, Roles.GERENTE, "Nombre", "Apellido", "Otro", "Info", "123456", "correo@example.com", "123", 1233, "123", "123");
            empleados.add(empleadoPrueba);
        }
        if (!FileManager.existeArchivo(EMPLEADOS_FILE) || !FileManager.existeArchivo(INVERSIONISTAS_FILE)) {
            ControlAcceso.inicializarCredenciales(empleados);
        }
        ControlAcceso.inicializarCredenciales(empleados); // Llama a inicializarCredenciales después de cargar los datos
        mostrarMenuInicio();
        guardarDatos(); // Guardar datos al finalizar el programa


    }

    private static void cargarDatos() {
        // Verificar si existe el archivo de empleados
        if (!FileManager.existeArchivo(FileManager.EMPLEADOS_FILE)) {
            // Si no existe, crear el archivo de empleados y agregar un gerente por defecto
            Empleado gerentePorDefecto = new Empleado(1, Roles.GERENTE, "Nombre", "Apellido", "Otro", "Info", "123456", "correo@example.com", "123", 1233, "123", "123");
            empleados = new ArrayList<>();
            empleados.add(gerentePorDefecto);
            FileManager.guardarLista(empleados, FileManager.EMPLEADOS_FILE);
        }

        // Cargar empleados y clientes como de costumbre
        try {
            empleados = FileManager.cargarLista(FileManager.EMPLEADOS_FILE, Empleado.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            inversionistas = FileManager.cargarLista(FileManager.INVERSIONISTAS_FILE, Inversionista.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            clientes = FileManager.cargarLista(FileManager.CLIENTES_FILE, Cliente.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void guardarDatos() {
        FileManager.guardarLista(empleados, EMPLEADOS_FILE);
        FileManager.guardarLista(inversionistas, INVERSIONISTAS_FILE);
        FileManager.guardarLista(clientes, CLIENTES_FILE);
    }

    private static Sucursales seleccionarSucursal() {
        // Crear las sucursales directamente
        Sucursales sucursalAcueducto = Sucursales.crearSucursalAcueducto();
        Sucursales sucursalMadero = Sucursales.crearSucursalMadero();

        System.out.println("Por favor, seleccione una sucursal:");
        System.out.println("1. Sucursal Acueducto");
        System.out.println("2. Sucursal Madero");
        System.out.print("Ingrese su opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        switch (opcion) {
            case 1:
                return sucursalAcueducto;
            case 2:
                return sucursalMadero;
            default:
                System.out.println("Opción inválida.");
                return null; // Devuelve null en caso de opción inválida
        }
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

    public static void iniciarSesionEmpleado() {
        System.out.println("Iniciar sesión como empleado");
        System.out.print("Ingrese su ID: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea pendiente

        // Obtener la contraseña del empleado
        Empleado empleado = GestorUsuarios.buscarEmpleadoPorId(idEmpleado);
        if (empleado != null) {
            System.out.print("Ingrese su contraseña: ");
            String contraseña = scanner.nextLine().trim(); // Eliminar espacios en blanco adicionales

            // Verificar la contraseña
            if (contraseña.equals(empleado.getContraseña())) {
                Menu.mostrarMenuEmpleado();
            } else {
                System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
            }
        } else {
            System.out.println("Empleado no encontrado. Por favor, inténtelo de nuevo.");
        }
    }

    private static void iniciarSesionCliente() {
        System.out.println("Iniciar sesión como cliente");
        System.out.print("Ingrese su ID: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine().trim(); // Eliminar espacios en blanco adicionales

        if (ControlAcceso.autenticarCliente(idCliente, contraseña)) {
            Cliente cliente = GestorUsuarios.buscarClientePorID(idCliente);
            if (cliente != null) {
                System.out.println("Inicio de sesión exitoso.");
                // Aquí puedes mostrar el menú del cliente o realizar otras operaciones necesarias
            } else {
                System.out.println("No se encontró al cliente. Por favor, inténtelo de nuevo.");
            }
        } else {
            System.out.println("Error: Credenciales incorrectas.");
        }
    }
}
