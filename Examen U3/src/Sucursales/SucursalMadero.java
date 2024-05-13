package Sucursales;

import Roles.Gerente;

public class SucursalMadero extends Sucursales {
    private int numeroEmpleados;

    public SucursalMadero(String sucursalMadero, String s, String number, Gerente gerente, int i) {
        // Asignar valores predeterminados
        super(2,nombre, "Dirección predeterminada", "Teléfono predeterminado", null); // Suponiendo que no hay gerente inicialmente
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