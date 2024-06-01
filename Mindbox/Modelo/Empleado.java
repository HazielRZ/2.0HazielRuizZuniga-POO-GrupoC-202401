package Modelo;

import utils.ValidadorRFC;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Usuario {
    protected String rfc;
    protected List<Materia> materiasImpartidas;
    protected double sueldo;

    //constructor
    public Empleado(String nombre, String apellidos, String fechaNacimiento, String sexo, String ciudad, String estado,
                    String direccion, String fechaRegistro, String rol, double sueldo,String nombreUsuario, String contrasena) {
        super(nombre, apellidos, fechaNacimiento, sexo, ciudad, estado, direccion, fechaRegistro, rol, nombreUsuario,contrasena);
        this.sueldo = sueldo;
        this.rfc = ValidadorRFC.generarRFC(this);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public List<Materia> getMateriasImpartidas() {
        return materiasImpartidas;
    }

    public void setMateriasImpartidas(List<Materia> materiasImpartidas) {
        this.materiasImpartidas = materiasImpartidas;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
