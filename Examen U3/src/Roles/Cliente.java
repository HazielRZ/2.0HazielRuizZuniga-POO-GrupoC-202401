package Roles;

import Tarjeta.TarjetaDebito;
import utils.IDManager;

import java.util.Scanner;

public class Cliente {
    private static final Scanner scanner = new Scanner(System.in);

    private final int id;
    private String nombre;
    private String apellido;
    private String RFC;
    private String Bdate;
    private String estado;
    private String ciudad;
    private final String CURP;
    private String direccion;
    private String sucursalRegistro;
    private final String fechaRegistro;
    private String contraseña;
    private final TarjetaDebito tarjetaDebito;

    public Cliente(int id, String nombre, String apellido, String RFC, String Bdate, String estado, String ciudad, String CURP, String direccion, String sucursalRegistro, String fechaRegistro, String contraseña) {
        this.id = IDManager.generarIDCliente();
        this.nombre = nombre;
        this.apellido = apellido;
        this.RFC = RFC;
        this.Bdate = Bdate;
        this.estado = estado;
        this.ciudad = ciudad;
        this.CURP = CURP;
        this.direccion = direccion;
        this.sucursalRegistro = sucursalRegistro;
        this.fechaRegistro = fechaRegistro;
        this.contraseña = contraseña;
        this.tarjetaDebito = new TarjetaDebito(); // Inicializa una tarjeta de débito para el cliente
    }

    public static Cliente registrarCliente() {
        System.out.println("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del usuario: ");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese fecha de nacimiento: ");
        String fechaNacimiento = scanner.nextLine();
        System.out.println("Ingrese estado en el que nació: ");
        String estado = scanner.nextLine();
        System.out.println("Ingrese ciudad de nacimiento: ");
        String ciudad = scanner.nextLine();
        System.out.println("Ingrese su dirección actual: ");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese su RFC: ");
        String RFC = scanner.nextLine();
        System.out.println("Ingrese sucursal de registro: ");
        String sucursal = scanner.nextLine();
        System.out.println("Ingrese la contraseña del cliente: ");
        String contraseña = scanner.nextLine();

        // Generar un ID único utilizando el IDManager
        int id = IDManager.generarIDCliente();

        return new Cliente(id, nombre, apellido, RFC, fechaNacimiento, estado, ciudad, "", direccion, sucursal, "", contraseña);
    }

    public static void solicitarTarjetaCredito() {
        // Lógica para solicitar tarjeta de crédito
        // Primero, verifica si el cliente cumple con los requisitos para solicitar una tarjeta de crédito
        // Si cumple, puedes generar una nueva tarjeta de crédito y asociarla al cliente
        System.out.println("Tarjeta de crédito solicitada correctamente.");
    }

    public void modificarDatosCliente() {
        System.out.println("Modificar datos del cliente:");
        System.out.print("Nuevo nombre: ");
        this.nombre = scanner.nextLine();
        System.out.print("Nuevo apellido: ");
        this.apellido = scanner.nextLine();
        System.out.print("Nuevo RFC: ");
        this.RFC = scanner.nextLine();
        System.out.print("Nueva fecha de nacimiento: ");
        this.Bdate = scanner.nextLine();
        System.out.print("Nuevo estado: ");
        this.estado = scanner.nextLine();
        System.out.print("Nueva ciudad: ");
        this.ciudad = scanner.nextLine();
        System.out.print("Nueva dirección: ");
        this.direccion = scanner.nextLine();
        System.out.print("Nueva sucursal de registro: ");
        this.sucursalRegistro = scanner.nextLine();
        System.out.println("Datos modificados correctamente.");
    }

    public void verTarjetasCliente() {
        System.out.println("Número de tarjeta de débito: " + tarjetaDebito.getNumeroTarjeta());
        System.out.println("Clabe interbancaria: " + tarjetaDebito.getClabeInterbancaria());
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getBdate() {
        return Bdate;
    }

    public void setBdate(String Bdate) {
        this.Bdate = Bdate;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSucursalRegistro() {
        return sucursalRegistro;
    }

    public void setSucursalRegistro(String sucursalRegistro) {
        this.sucursalRegistro = sucursalRegistro;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
