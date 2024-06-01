import java.util.Scanner;

public class EjecutivoCuenta extends Empleado {
    public EjecutivoCuenta(String nombre, String apellidos, int añoNacimiento, String ciudad, String estado,
                           String direccion, String sucursalPerteneciente, double salario,
                           String fechaInicioTrabajo, String contraseña) {
        super(nombre, apellidos, añoNacimiento, ciudad, estado, direccion, sucursalPerteneciente,
                salario, "Ejecutivo de Cuenta", fechaInicioTrabajo, contraseña);
    }

    // Métodos específicos para el rol de Ejecutivo de Cuenta
}
