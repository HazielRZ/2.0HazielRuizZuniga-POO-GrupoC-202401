package Roles;

import utils.IDManager;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class Gerente extends Empleado {
    private Date fechaCreacion = new Date();
    private Date fecha = new Date();

    public Gerente(Date fecha, String capturista, String gerente, String ejecutivoVentas, int id) {
        super(fecha, capturista, gerente, ejecutivoVentas, id);
    }

    public void registrarGerente() {
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
        System.out.println("ingrese su rol: ");
        String rol = scanner.nextLine();
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

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public StringBuilder getNumerosAleatorios() {
        return numerosAleatorios;
    }

    public void setNumerosAleatorios(StringBuilder numerosAleatorios) {
        this.numerosAleatorios = numerosAleatorios;
    }

    public String getCapturista() {
        return capturista;
    }

    public void setCapturista(String capturista) {
        this.capturista = capturista;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getEjecutivoVentas() {
        return ejecutivoVentas;
    }

    public void setEjecutivoVentas(String ejecutivoVentas) {
        this.ejecutivoVentas = ejecutivoVentas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
