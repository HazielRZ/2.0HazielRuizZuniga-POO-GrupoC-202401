package Sucursales;

import Roles.Gerente;

public class SucursalMadero extends Sucursales {
    private int numeroEmpleados;

    public SucursalMadero(String nombre, String direccion, String telefono, Gerente gerente, int numeroEmpleados) {
        super(nombre, direccion, telefono, gerente);
        this.numeroEmpleados = numeroEmpleados;
    }

    // Métodos específicos de la Sucursal Madero
    @Override
    public void invertir() {
        super.invertir();
        System.out.println("Gracias por invertir en la sucursal Madero.");
    }
    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }
}