package Roles;

import utils.IDManager;

import java.util.Date;
import java.util.Scanner;


public class Gerente extends Empleado {
    private static Date fecha = new Date();
    private static Scanner scanner = new Scanner(System.in);
    private Date fechaCreacion = new Date();

    public Gerente(int id, Roles Rol, String nombre, String apellido, String añoNacimiento, String ciudad, String estado,
                   String direccion, String sucursal, double salario, String RFC, String contraseña) {
        super(id, Rol, nombre, apellido, añoNacimiento, ciudad, estado, direccion, sucursal, salario, RFC, contraseña);
    }


    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Gerente.fecha = fecha;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        Gerente.scanner = scanner;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
