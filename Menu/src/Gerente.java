public class Gerente extends Empleado {
    public Gerente(String nombre, String apellidos, int añoNacimiento, String ciudad, String estado,
                   String direccion, Sucursal sucursalPerteneciente, double salario,
                   String fechaInicioTrabajo, String contraseña) {
        super(nombre, apellidos, añoNacimiento, ciudad, estado, direccion, sucursalPerteneciente,
                salario, "Gerente", fechaInicioTrabajo, contraseña);
    }

    // Métodos específicos para el rol de Gerente
}
