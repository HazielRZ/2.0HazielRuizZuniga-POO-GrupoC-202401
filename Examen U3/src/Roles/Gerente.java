package Roles;

import java.util.Date;
import java.util.Scanner;


    public class Gerente extends Empleado {
        private Date fechaCreacion = new Date();
        private static Date fecha = new Date();
        private static Scanner scanner = new Scanner(System.in);

        public Gerente(int id,Roles Rol, String nombre, String apellido, String añoNacimiento, String ciudad, String estado,
                       String direccion, String sucursal, double salario, String RFC, String contraseña) {
            super(id,Rol, nombre, apellido, añoNacimiento, ciudad, estado, direccion, sucursal, salario, RFC,contraseña);
        }

    public static void registrarGerente() {
        System.out.println("registraremos un nuevo gerente: ");
        System.out.println("Ingrese el nombre: ");
        String nombreGerente = scanner.nextLine();
        System.out.println("ingrese el apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("ingrse año de nacimiento: ");
        String añoNacimiento = scanner.nextLine();
        System.out.println("ingrese ciudad de nacimiento: ");
        String cuidad = scanner.nextLine();
        System.out.println("ingrese Estado en el que nacio: ");
        String estado = scanner.nextLine();
        System.out.println("ingrese su direccion: ");
        String direccion = scanner.nextLine();
        System.out.println("ingrese sucursal a la que pertenece: ");
        String sucursal = scanner.nextLine();
        System.out.println("ingrese su salario: ");
        double salario = scanner.nextDouble();
        System.out.println("La fecha de registro es: ");
        System.out.println(fecha.getTime());
        System.out.println("ingrese su RFC");
        String RFC = scanner.nextLine();
        System.out.println("seria todo, hemos terminado.");
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
        this.fecha = fecha;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
