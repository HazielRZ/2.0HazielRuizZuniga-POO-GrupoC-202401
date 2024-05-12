package Sucursales;

public class SucursalAcueducto extends Sucursales {
    private int numeroEmpleados;

    public SucursalAcueducto(String gerente, String nombre, String apellido, String id, int numeroEmpleados) {
        super(gerente, nombre, apellido, id);
        this.numeroEmpleados = numeroEmpleados;
    }

    // Métodos específicos de la Sucursal1
    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }
}
