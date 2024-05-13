package Sucursales;

import Roles.Gerente;

public class SucursalMadero extends Sucursales {
    private int numeroEmpleados;

    public SucursalMadero(int id, String nombre, String direccion, String telefono, Gerente gerente) {
        super(id, nombre, direccion, telefono, gerente);
        this.numeroEmpleados = 0; // Inicializa el número de empleados a 0
    }


    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }
}