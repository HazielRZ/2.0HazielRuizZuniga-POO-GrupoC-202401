package Sucursales;

import Roles.Empleado;
import Roles.Gerente;
import Tarjeta.SolicitudTarjetaCredito;
import Roles.Roles;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class Sucursales {
    public static SolicitudTarjetaCredito[] listaSolicitudes;
    protected static String nombre;
    private static double fondo;
    protected final int id;

    private final String direccion;
    private final String telefono;
    private final List<Empleado> empleados;

    public Sucursales(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        Sucursales.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

        this.empleados = new ArrayList<>();
        fondo = 0.0;
    }

    // Método para realizar una inversión en la sucursal
    public static void invertir() {
        System.out.println("Ingrese el fondo que proveerá al banco de " + nombre + ": ");
        double cantidad = solicitarCantidad();
        fondo += cantidad;
        System.out.println("Este movimiento se realizó en la fecha: " + new Date());
        System.out.println("Gracias por invertir en la sucursal " + nombre + ".");
    }

    // Método para solicitar una cantidad al usuario
    private static double solicitarCantidad() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    // Método para obtener el fondo actual de la sucursal
    public double obtenerFondo() {
        return fondo;
    }


    public static Sucursales crearSucursalAcueducto() {

        return new SucursalAcueducto(1, "Acueducto", "123456789", "44324234");
    }

    public static Sucursales crearSucursalMadero() {
return new SucursalMadero(2, "Madero", "987654321", "234234324");
    }


    // Métodos para mostrar información detallada de la sucursal
    public void mostrarInformacionDetallada() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);


        System.out.println("Empleados:");
        for (Empleado empleado : empleados) {
            System.out.println("- " + empleado.getNombre());
        }

        System.out.println("Fondo: $" + obtenerFondo());
    }
}

