package Sucursales;

import Roles.Gerente;

public class SucursalAcueducto extends Sucursales {
    private int numeroEmpleados;

    public SucursalAcueducto(String sucursalAcueducto, String s, String number, Gerente gerente, int i) {
        // Asignar valores predeterminados
        super(1,nombre, "Dirección predeterminada", "Teléfono predeterminado", null);
        this.numeroEmpleados = 0;
    }


    // Métodos específicos de la Sucursal Acueducto

    public static void invertir() {
        invertir(); // Llamada al método invertir de la clase base
        System.out.println("Gracias por invertir en la sucursal Acueducto.");
    }
    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }
}
