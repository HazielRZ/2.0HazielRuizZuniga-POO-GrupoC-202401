package Sucursales;

public class SucursalAcueducto extends Sucursales {
    private int numeroEmpleados;

    public SucursalAcueducto(String nombre, String direccion, String telefono, Gerente gerente, int numeroEmpleados) {
        super(nombre, direccion, telefono, gerente);
        this.numeroEmpleados = numeroEmpleados;
    }

    // Métodos específicos de la Sucursal Acueducto
    @Override
    public void invertir() {
        super.invertir();
        System.out.println("Gracias por invertir en la sucursal Acueducto.");
    }
    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }
}
