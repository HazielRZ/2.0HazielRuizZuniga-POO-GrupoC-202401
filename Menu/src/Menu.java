import Tarjetas.MenuTarjeta;
import Tarjetas.SistemaTarjetas;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private final Scanner scanner;
    public static  Sucursal sucursalActual = null;


    public Menu(Sucursal sucursalActual, GestorEmpleados gestorEmpleados, GestorClientes gestorClientes) {
        scanner = new Scanner(System.in);
        Menu.sucursalActual = sucursalActual;
    }

    public void mostrarMenuUsuario() {
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Empleado");
        System.out.println("2. Cliente");
        System.out.println("3. Salir");
    }

    public void iniciarSistema() {
        int opcionUsuario;

        do {
            mostrarMenuUsuario();
            opcionUsuario = scanner.nextInt();

            switch (opcionUsuario) {
                case 1:
                    // Lógica para el menú de empleados
                    iniciarSesionEmpleado(Menu.sucursalActual, GestorEmpleados.listaEmpleados);
                    break;
                case 2:
                    // Lógica para el menú de clientes
                    iniciarSesionCliente(Menu.sucursalActual, scanner, GestorClientes.listaClientes);
                    break;
                case 3:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
            }
        } while (opcionUsuario != 3);
    }
    public void manejarOpcionUsuario(int opcionUsuario, Sucursal sucursal) {
        switch (opcionUsuario) {
            case 1:
                mostrarEmpleadosPorSucursal(sucursalActual);
                iniciarSesionEmpleado(sucursal, GestorEmpleados.listaEmpleados);
                break;
            case 2:
                mostrarClientesPorSucursal(sucursalActual);
                iniciarSesionCliente(sucursal, scanner, GestorClientes.listaClientes);
                break;
            case 3:
                // Volver al menú principal
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
        }
    }

    private void mostrarClientesPorSucursal(Sucursal sucursalActual) {
        System.out.println("Clientes de la sucursal " + sucursalActual.getNombre());
        for (Cliente cliente : GestorClientes.getClientesPorSucursal(sucursalActual)) {
            System.out.println(cliente);
        }
    }

    private void iniciarSesionEmpleado(Sucursal sucursal,ArrayList<Empleado> empleados) {
        System.out.println("Ingrese su ID:");
        int id = scanner.nextInt();
        System.out.println("Ingrese su contraseña:");
        String password = scanner.next();

        // Verificar si las credenciales son válidas y obtener el rol del usuario
        String rol = autenticarEmpleado(id, password, sucursal, empleados);

        if (rol != null) {
            // Iniciar menú de operaciones para empleados
            mostrarMenuEmpleado(rol);
        } else {
            System.out.println("ID o contraseña incorrectos.");
        }
    }

    private void iniciarSesionCliente(Sucursal sucursal, Scanner scanner,ArrayList<Cliente>clientes) {
        System.out.println("Ingrese su ID:");
        int id = scanner.nextInt();
        System.out.println("Ingrese su contraseña:");
        String password = scanner.next();

        // Crear una instancia de SistemaTarjetas
        SistemaTarjetas sistemaTarjetas = new SistemaTarjetas();

        // Verificar si las credenciales son válidas y obtener el cliente
        Cliente cliente = autenticarCliente(id, password, sucursal, clientes);

        if (cliente != null) {
            // Iniciar menú de operaciones para clientes
            // Llamar al método menuOperacionesCliente a través de la instancia de SistemaTarjetas
            SistemaTarjetas.menuOperacionesCliente(scanner, cliente);
        } else {
            System.out.println("ID o contraseña incorrectos.");
        }
    }
    public void mostrarEmpleadosPorSucursal(Sucursal sucursal) {
        System.out.println("Empleados de la sucursal " + sucursal.getNombre());
        for (Empleado empleado : GestorEmpleados.getEmpleadosPorSucursal(sucursal)) {
            System.out.println(empleado);
        }
    }

    public void mostrarMenuEmpleado() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Gerente de Sucursal");
        System.out.println("2. Capturista");
        System.out.println("3. Ejecutivo de Cuenta");
        System.out.println("4. Volver al menú principal");

        int opcionEmpleado = scanner.nextInt();

        switch (opcionEmpleado) {
            case 1:
                // Lógica para mostrar el menú del Gerente de Sucursal
                mostrarMenuGerente();
                break;
            case 2:
                // Lógica para mostrar el menú del Capturista
                mostrarMenuCapturista();
                break;
            case 3:
                // Lógica para mostrar el menú del Ejecutivo de Cuenta
                mostrarMenuEjecutivoCuenta();
                break;
            case 4:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
        }
    }

    public String autenticarEmpleado(int id, String password, Sucursal sucursal, ArrayList<Empleado> empleados) {
        // Iterar sobre la lista de empleados para buscar una coincidencia de ID y contraseña
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id && empleado.getContraseña().equals(password) && empleado.getSucursalPerteneciente().equals(sucursal)) {
                // Devolver el rol si se encuentra una coincidencia
                return empleado.getRol();
            }
        }
        // Si no se encuentra una coincidencia, devolver null
        return null;
    }

    public Cliente autenticarCliente(int id, String password, Sucursal sucursal, ArrayList<Cliente> clientes) {
        // Iterar sobre la lista de clientes para buscar una coincidencia de ID y contraseña
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id && cliente.getContraseña().equals(password) && cliente.getSucursalRegistro().equals(sucursal)) {
                // Devolver el cliente si se encuentra una coincidencia
                return cliente;
            }
        }
        // Si no se encuentra una coincidencia, devolver null
        return null;
    }

    public void mostrarMenuEmpleado(String rol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        switch (rol) {
            case "Gerente":
                System.out.println("1. Opción para gerente");
                mostrarMenuGerente();

                break;
            case "Ejecutivo":
                System.out.println("1. Opción para ejecutivo");
                mostrarMenuEjecutivoCuenta();
                break;
            case "Capturista":
                System.out.println("1. Opción para capturista");
                mostrarMenuCapturista();
                break;
        }
        System.out.println("2. Volver al menú principal");
    }



    public void mostrarMenuGerente() {
        //  llamar al método para mostrar el menú del Gerente de Sucursal
        MenuEmpleados menuEmpleados = new MenuEmpleados(scanner);
        menuEmpleados.mostrarMenuGerente();
    }

    public void mostrarMenuCapturista() {
        //  llamar al método para mostrar el menú del Capturista
        MenuEmpleados menuEmpleados = new MenuEmpleados(scanner);
        menuEmpleados.mostrarMenuCapturista();
    }

    public void mostrarMenuEjecutivoCuenta() {
        // llamar al método para mostrar el menú del Ejecutivo de Cuenta
        MenuEmpleados menuEmpleados = new MenuEmpleados(scanner);
        menuEmpleados.mostrarMenuEjecutivoCuenta();
    }
}
