package utils;

public class IDManager {
    private static int ultimoIDEmpleado = 0;
    private static int ultimoIDCliente = 0;
    private static int ultimoIDInversionista = 0;

    public static int generarIDEmpleado() {
        return ++ultimoIDEmpleado;
    }

    public static int generarIDCliente() {
        return ++ultimoIDCliente;
    }

    public static int generarIDInversionista() {
        return ++ultimoIDInversionista;
    }
}
