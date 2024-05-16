public class Capturista extends Empleado {
    public Capturista(String nombre, String apellidos, int añoNacimiento, String ciudad, String estado,
                      String direccion, String sucursalPerteneciente, double salario,
                      String fechaInicioTrabajo, String contraseña) {
        super(nombre, apellidos, añoNacimiento, ciudad, estado, direccion, sucursalPerteneciente,
                salario, "Capturista", fechaInicioTrabajo, contraseña);
    }

    // Métodos específicos para el rol de Capturista
}
