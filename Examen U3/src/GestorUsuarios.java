import Roles.Cliente;
import Roles.Empleado;
import Roles.Inversionista;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    // Listas privadas para almacenar clientes, empleados e inversionistas
    private static List<Cliente> clientes;
    private final List<Empleado> empleados;
    private final List<Inversionista> inversionistas;

    // Constructor para inicializar las listas
    public GestorUsuarios() {
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.inversionistas = new ArrayList<>();
    }

    // Métodos para agregar usuarios
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void agregarInversionista(Inversionista inversionista) {
        inversionistas.add(inversionista);
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

    public Empleado buscarEmpleadoPorId(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null; // Si no se encuentra el empleado
    }

    public Inversionista buscarInversionistaPorId(String id) {
        for (Inversionista inversionista : inversionistas) {
            if (inversionista.getId().equals(id)) {
                return inversionista;
            }
        }
        return null; // Retornar null si no se encuentra ningún inversionista con el ID dado
    }

    // Métodos para obtener la lista de clientes, empleados e inversionistas
    public static List<Cliente> getClientes() {
        return clientes;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Inversionista> getInversionistas() {
        return inversionistas;
    }
}

