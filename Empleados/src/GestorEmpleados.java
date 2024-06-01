import java.util.ArrayList;
import java.util.Scanner;

public class GestorEmpleados {
    private static ArrayList<Empleado> listaEmpleados;

    public GestorEmpleados() {
        listaEmpleados = new ArrayList<>();
    }

    public static void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public static void mostrarEmpleados() {
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado);
        }
    }

    public static void eliminarEmpleado(int idEmpleado) {
        listaEmpleados.removeIf(empleado -> empleado.getId() == idEmpleado);
    }

    // Método para modificar un empleado por su ID
    public void modificarEmpleado(int idEmpleado, String nombre, String apellidos, int añoNacimiento, String ciudad,
                                  String estado, String direccion, String sucursalPerteneciente, double salario,
                                  String fechaInicioTrabajo, String contraseña) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getId() == idEmpleado) {
                empleado.setNombre(nombre);
                empleado.setApellidos(apellidos);
                empleado.setAñoNacimiento(añoNacimiento);
                empleado.setCiudad(ciudad);
                empleado.setEstado(estado);
                empleado.setDireccion(direccion);
                empleado.setSucursalPerteneciente(sucursalPerteneciente);
                empleado.setSalario(salario);
                empleado.setFechaInicioTrabajo(fechaInicioTrabajo);
                empleado.setContraseña(contraseña);
                break;
            }
        }
    }
    public static void registrarNuevoEjecutivo(Scanner scanner) {
        System.out.println("Ingrese los datos del nuevo ejecutivo:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Año de nacimiento: ");
        int añoNacimiento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Sucursal perteneciente: ");
        String sucursalPerteneciente = scanner.nextLine();

        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Fecha de inicio de trabajo (dd/mm/yyyy): ");
        String fechaInicioTrabajo = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        // Una vez que tengas todos los datos, puedes crear un nuevo objeto EjecutivoCuenta

        EjecutivoCuenta nuevoEjecutivo = new EjecutivoCuenta(nombre, apellidos, añoNacimiento, ciudad, estado,
                direccion, sucursalPerteneciente, salario,
                fechaInicioTrabajo, contraseña);
        agregarEmpleado(nuevoEjecutivo);
    }
    public static void registrarCapturista(Scanner scanner) {
        System.out.println("Ingrese los datos del nuevo Capturista:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Año de nacimiento: ");
        int añoNacimiento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Sucursal perteneciente: ");
        String sucursalPerteneciente = scanner.nextLine();

        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Fecha de inicio de trabajo (dd/mm/yyyy): ");
        String fechaInicioTrabajo = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        // Una vez que tengas todos los datos, puedes crear un nuevo objeto EjecutivoCuenta

        Capturista nuevoCapturista = new Capturista(nombre, apellidos, añoNacimiento, ciudad, estado,
                direccion, sucursalPerteneciente, salario,
                fechaInicioTrabajo, contraseña);
        agregarEmpleado(nuevoCapturista);
    }

    // Otros métodos necesarios para la gestión de empleados
}
