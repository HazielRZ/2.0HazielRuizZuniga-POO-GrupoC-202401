import Roles.Cliente;
import Roles.Empleado;
import Roles.Inversionista;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    // Listas privadas para almacenar clientes, empleados e inversionistas
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Inversionista> inversionistas = new ArrayList<>();

    // evitar que se creen instancias de GestorUsuarios
    private GestorUsuarios() {

    }

    // Métodos para buscar usuarios por ID
    public static Cliente buscarClientePorID(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente
    }

    public static Empleado buscarEmpleadoPorId(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null;
        // Si no se encuentra el empleado
    }

    // Métodos para obtener la lista de clientes, empleados e inversionistas
    public static List<Cliente> getClientes() {
        return clientes;
    }

    // Métodos para agregar usuarios
    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public static void agregarInversionista(Inversionista inversionista) {
        inversionistas.add(inversionista);
    }

    public static Inversionista buscarInversionistaPorId(int id) {
        for (Inversionista inversionista : inversionistas) {
            if (inversionista.getId() == id) {
                return inversionista;
            }
        }
        return null; // Retornar null si no se encuentra ningún inversionista con el ID dado
    }

    public static List<Empleado> getEmpleados() {
        return empleados;
    }

    public static List<Inversionista> getInversionistas() {
        return inversionistas;
    }
}