package utils;

import java.util.HashMap;
import java.util.Map;

public class ControlAcceso {
    // Mapas para almacenar las credenciales y sucursales de empleados y clientes
    private static final Map<String, String> credencialesEmpleados = new HashMap<>();
    private static final Map<String, String> credencialesClientes = new HashMap<>();
    private static final Map<String, String> sucursalesEmpleados = new HashMap<>();
    private static final Map<String, String> sucursalesClientes = new HashMap<>();

    // Método para inicializar las credenciales de empleados y clientes
    public static void inicializarCredenciales() {
        credencialesEmpleados.put("id_empleado_1", "contraseña_1");
        credencialesEmpleados.put("id_empleado_2", "contraseña_2");

        credencialesClientes.put("id_cliente_1", "contraseña_1");
        credencialesClientes.put("id_cliente_2", "contraseña_2");
    }

    // Métodos para autenticar empleados y clientes
    public static boolean autenticarEmpleado(String id, String contraseña) {
        return credencialesEmpleados.containsKey(id) && credencialesEmpleados.get(id).equals(contraseña);
    }

    public static boolean autenticarCliente(int id, String contraseña) {
        return credencialesClientes.containsKey(id) && credencialesClientes.get(id).equals(contraseña);
    }

    // Métodos para asignar y obtener sucursales de empleados y clientes
    public static void asignarSucursalEmpleado(String idEmpleado, String sucursal) {
        sucursalesEmpleados.put(idEmpleado, sucursal);
    }

    public static void asignarSucursalCliente(String idCliente, String sucursal) {
        sucursalesClientes.put(idCliente, sucursal);
    }

    public static String obtenerSucursalEmpleado(String idEmpleado) {
        return sucursalesEmpleados.get(idEmpleado);
    }

    public static String obtenerSucursalCliente(String idCliente) {
        return sucursalesClientes.get(idCliente);
    }
}
