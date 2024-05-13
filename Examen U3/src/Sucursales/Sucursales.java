package Sucursales;
import Roles.Empleado;
import Roles.Gerente;
import Tarjeta.SolicitudTarjetaCredito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class Sucursales {
    public static SolicitudTarjetaCredito[] listaSolicitudes;
    private final int id;
    protected static String nombre;
    private String direccion;
    private String telefono;
    private Gerente gerente;
    private List<Empleado> empleados;
    private static double fondo;

    public Sucursales(int id, String nombre, String direccion, String telefono, Gerente gerente) {
        this.id = id;
        Sucursales.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.gerente = gerente;
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


    // Métodos para gestionar empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }


    // Métodos para mostrar información detallada de la sucursal
    public void mostrarInformacionDetallada() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Gerente: " + gerente.getCapturista());

        System.out.println("Empleados:");
        for (Empleado empleado : empleados) {
            System.out.println("- " + empleado.getCapturista());
        }

        System.out.println("Fondo: $" + obtenerFondo());
    }
}

