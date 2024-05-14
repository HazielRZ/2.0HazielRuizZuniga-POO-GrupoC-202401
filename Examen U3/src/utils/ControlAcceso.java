package utils;

import Roles.Empleado;
import Roles.Roles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlAcceso {
    private static final Map<Integer, String> credencialesEmpleados = new HashMap<>();
    private static final Map<Integer, String> credencialesClientes = new HashMap<>();
    private static final Map<Integer, String> sucursalesEmpleados = new HashMap<>();
    private static final Map<Integer, String> sucursalesClientes = new HashMap<>();

    public static void inicializarCredenciales(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            Roles rol = empleado.getRole();
            if (rol == Roles.GERENTE || rol == Roles.CAPTURISTA || rol == Roles.EJECUTIVO_CUENTA) {
                credencialesEmpleados.put(empleado.getId(), empleado.getContraseña());
                sucursalesEmpleados.put(empleado.getId(), empleado.getSucursal());
            } else {
                credencialesClientes.put(empleado.getId(), empleado.getContraseña());
                sucursalesClientes.put(empleado.getId(), empleado.getSucursal());
            }
        }
    }

    public static boolean autenticarEmpleado(int id, String contraseña) {
        return credencialesEmpleados.containsKey(id) && credencialesEmpleados.get(id).equals(contraseña);
    }

    public static boolean autenticarCliente(int id, String contraseña) {
        return credencialesClientes.containsKey(id) && credencialesClientes.get(id).equals(contraseña);
    }

    public static void asignarSucursalEmpleado(int idEmpleado, String sucursal) {
        sucursalesEmpleados.put(idEmpleado, sucursal);
    }

    public static void asignarSucursalCliente(int idCliente, String sucursal) {
        sucursalesClientes.put(idCliente, sucursal);
    }

    public static String obtenerContraseñaEmpleado(int idEmpleado) {
        return credencialesEmpleados.get(idEmpleado);
    }

    public static String obtenerSucursalEmpleado(int idEmpleado) {
        return sucursalesEmpleados.get(idEmpleado);
    }

    public static String obtenerSucursalCliente(int idCliente) {
        return sucursalesClientes.get(idCliente);
    }
}