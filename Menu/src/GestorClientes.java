import java.util.ArrayList;
import java.util.Scanner;

public class GestorClientes {
    protected static ArrayList<Cliente> listaClientes;
    public GestorClientes() {
        listaClientes = new ArrayList<>();
    }

    // Método para registrar un nuevo cliente
    public static void registrarCliente(Scanner scanner, ArrayList<Cliente> listaClientes) {
        System.out.println("\nRegistro de nuevo cliente:");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellidos: ");
        String apellidos = scanner.next();
        System.out.print("Año de nacimiento: ");
        int añoNacimiento = scanner.nextInt();
        System.out.print("Ciudad: ");
        String ciudad = scanner.next();
        System.out.print("Estado: ");
        String estado = scanner.next();
        System.out.print("Dirección: ");
        String direccion = scanner.next();
        System.out.print("Sucursal de registro: ");
        Sucursal sucursalRegistro = Menu.sucursalActual;  ;
        System.out.print("Contraseña: ");
        String contraseña = scanner.next();

        Cliente nuevoCliente = new Cliente(nombre, apellidos, añoNacimiento, ciudad, estado,
                direccion, sucursalRegistro, contraseña);
        listaClientes.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente.");

    }

    // cliente por ID
    public static void datosClientePorID(Scanner scanner, ArrayList<Cliente> listaClientes) {
        System.out.print("Ingrese el ID del cliente que desea ver: ");
        int idCliente = scanner.nextInt();
        Cliente clienteEncontrado = null;

        // Buscar el cliente por su ID
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                clienteEncontrado = cliente;
                break;
            }
        }

        // Mostrar los datos del cliente encontrado
        if (clienteEncontrado != null) {
            System.out.println("\nDatos del cliente:");
            System.out.println("ID: " + clienteEncontrado.getId());
            System.out.println("Nombre: " + clienteEncontrado.getNombre());
            System.out.println("Apellidos: " + clienteEncontrado.getApellidos());
            System.out.println("Año de nacimiento: " + clienteEncontrado.getAñoNacimiento());
            System.out.println("Ciudad: " + clienteEncontrado.getCiudad());
            System.out.println("Estado: " + clienteEncontrado.getEstado());
            System.out.println("RFC: " + clienteEncontrado.getRfc());
            System.out.println("CURP: " + clienteEncontrado.getCurp());
            System.out.println("Dirección: " + clienteEncontrado.getDireccion());
            System.out.println("Fecha de registro: " + clienteEncontrado.getFechaRegistro());
            System.out.println("Sucursal de registro: " + clienteEncontrado.getSucursalRegistro());
        } else {
            System.out.println("Cliente no encontrado con el ID proporcionado.");
        }
    }

    // Método para mostrar todos los clientes
    public static void mostrarClientes(ArrayList<Cliente> listaClientes) {
        System.out.println("\nLista de clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }
    }

    // Método para modificar un cliente existente
    public static void modificarCliente(Scanner scanner, ArrayList<Cliente> listaClientes) {
        // Implementar la lógica para modificar un cliente
        System.out.print("Ingrese el ID del cliente que desea eliminar: ");
        int idCliente = scanner.nextInt();

        Cliente clienteAEliminar = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                clienteAEliminar = cliente;
                break;
            }
        }
        if (clienteAEliminar != null) {
            listaClientes.remove(clienteAEliminar);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con el ID proporcionado.");
        }
    }

    // Método para eliminar un cliente existente
    public static void eliminarCliente(Scanner scanner, ArrayList<Cliente> listaClientes) {
        System.out.print("Ingrese el ID del cliente que desea modificar: ");
        int idCliente = scanner.nextInt();

        // Buscar el cliente por su ID
        Cliente clienteAModificar = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                clienteAModificar = cliente;
                break;
            }
        }

        // Modificar el cliente si se encuentra
        if (clienteAModificar != null) {
            System.out.println("\nIngrese los nuevos datos del cliente:");
            System.out.print("Nombre: ");
            clienteAModificar.setNombre(scanner.next());
            System.out.print("Apellidos: ");
            clienteAModificar.setApellidos(scanner.next());
            // Continuar con el resto de atributos según sea necesario

            System.out.println("Cliente modificado correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con el ID proporcionado.");
        }
    }

    public static Cliente[] getClientesPorSucursal(Sucursal sucursalActual) {
        ArrayList<Cliente> clientesEnSucursal = new ArrayList<>();

        // Iterar sobre la lista de clientes y agregar aquellos que pertenecen a la sucursal actual
        for (Cliente cliente : listaClientes) {
            if (cliente.getSucursalRegistro().equals(sucursalActual)) {
                clientesEnSucursal.add(cliente);
            }
        }

        // Convertir el ArrayList a un array de Cliente y devolverlo
        return clientesEnSucursal.toArray(new Cliente[0]);
    }
}
