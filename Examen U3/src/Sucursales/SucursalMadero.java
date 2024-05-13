package Sucursales;

import Roles.Gerente;
import utils.IDManager;

import java.util.Date;

public class SucursalMadero extends Sucursales {
    private int numeroEmpleados;
    private static final Gerente gerente2 = new Gerente(new Date(), "EDER", "", "", IDManager.generarIDEmpleado());

    public SucursalMadero(int id, String nombre, String direccion, String telefono) {
        super(id, nombre, direccion, telefono, gerente2);

    }

    // Métodos específicos de la Sucursal Madero

    public static void invertir() {
        invertir(); // Llamada al método invertir de la clase base
        System.out.println("Gracias por invertir en la sucursal Madero.");
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }
}
