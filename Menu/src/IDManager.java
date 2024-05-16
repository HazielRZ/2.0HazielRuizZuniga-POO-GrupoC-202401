public class IDManager {
    private static int ultimoIDEmpleado = 0;
    private  int ultimoIDCliente = 0;
    private static int ultimoIDInversionista = 0;
    private static int ultimoIDSucursales = 0;

    public static int generarIDEmpleado() {
        return ++ultimoIDEmpleado;
    }
    public int generarIDCliente() {
        return ++ultimoIDCliente;
    }

    public static int generarIDInversionista() {
        return ++ultimoIDInversionista;
    }

    public static int generarIDSucursales() {
        return ++ultimoIDSucursales;
    }
}

