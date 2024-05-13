package Roles;
import utils.IDManager;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;
public class Empleado {
    private Date fechaCreacion = new Date(), fecha;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    StringBuilder numerosAleatorios = new StringBuilder();
    private Roles rol;
    String capturista, gerente, ejecutivoVentas;
    int id;

    public Empleado(Date fecha, String capturista, String gerente, String ejecutivoVentas, int id) {
        this.fecha = fecha;
        this.capturista = capturista;
        this.gerente = gerente;
        this.ejecutivoVentas = ejecutivoVentas;
        this.id = IDManager.generarIDEmpleado();
        this.fechaCreacion = fechaCreacion;

    }

    public Empleado() {
    }


    public Roles getRol(){
        return rol;
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
