package Roles;

import utils.IDManager;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Cliente {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    //Datos personales sobre el cliente
    private static int id = 0;
    private String nombre, apellido, RFC, Bdate, estado, ciudad, CURP, direccion, sucursalRegistro, fechaRegistro;
    private String contraseña;
    //Datos sobre la tarjeta del cliente
    private String numeroTarjeta, CVV, clabeInterbancaria, fechaVencimiento, fechaUso;
    private final Date fechaCreacion = new Date();
    private double saldo;

    public Cliente(int id, String nombre, String apellido, String RFC, String Bdate, String estado, String ciudad, String CURP, String direccion, String sucursalRegistro, String fechaRegistro, String numeroTarjeta, String CVV, String clabeInterbancaria, String fechaVencimiento, String fechaUso, double saldo) {
        this.id = id;
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
        this.numeroTarjeta = numeroTarjeta;
        this.CVV = CVV;
        this.clabeInterbancaria = clabeInterbancaria;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaUso = fechaUso;
        this.saldo = saldo;
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

        return new Cliente(id, nombre, apellido, RFC, fechaNacimiento, estado, ciudad, "", direccion, sucursal, "", "", "", "", "", "",0.0);
    }

    // Método para generar una tarjeta de débito
    public void generarTarjetaDebito() {
        StringBuilder numerosAleatorios = new StringBuilder();
        // Generar 16 números aleatorios para la tarjeta
        for (int i = 0; i < 16; i++) {
            int numero = random.nextInt(10);
            numerosAleatorios.append(numero);
        }
        numeroTarjeta = numerosAleatorios.toString();

        // Generar 18 números aleatorios para la clabe interbancaria
        numerosAleatorios = new StringBuilder(); // Reiniciar para la nueva generación
        for (int i = 0; i < 18; i++) {
            int inter = random.nextInt(10);
            numerosAleatorios.append(inter);
        }
        clabeInterbancaria = numerosAleatorios.toString();
    }
    public static void modificarDatosCliente(Cliente cliente) {
        if (cliente != null) {
            System.out.println("Modificar datos del cliente:");
            System.out.print("Nuevo nombre: ");
            cliente.setNombre(scanner.nextLine());
            System.out.print("Nuevo apellido: ");
            cliente.setApellido(scanner.nextLine());
            System.out.print("Nuevo RFC: ");
            cliente.setRFC(scanner.nextLine());
            System.out.print("Nueva fecha de nacimiento: ");
            cliente.setBdate(scanner.nextLine());
            System.out.print("Nuevo estado: ");
            cliente.setEstado(scanner.nextLine());
            System.out.print("Nueva ciudad: ");
            cliente.setCiudad(scanner.nextLine());
            System.out.print("Nueva dirección: ");
            cliente.setDireccion(scanner.nextLine());
            System.out.print("Nueva sucursal de registro: ");
            cliente.setSucursalRegistro(scanner.nextLine());
            System.out.println("Datos modificados correctamente.");
        } else {
            System.out.println("Cliente con ID " + id + " no encontrado.");
        }
    }

    public static void eliminarCliente(Cliente cliente) {
        // Lógica para eliminar un cliente de la base de datos
        // Por ejemplo, podrías tener una lista de clientes y eliminar el cliente de esa lista
        System.out.println("Cliente eliminado correctamente.");
    }

    public static void verTarjetasCliente(Cliente cliente) {
        // Lógica para ver las tarjetas del cliente
        System.out.println("Tarjetas del cliente:");
        // Aquí podrías imprimir las tarjetas asociadas a este cliente
    }

    public static void solicitarTarjetaCredito(Cliente cliente) {
        // Lógica para solicitar tarjeta de crédito
        // Primero, verifica si el cliente cumple con los requisitos para solicitar una tarjeta de crédito
        // Si cumple, puedes generar una nueva tarjeta de crédito y asociarla al cliente
        System.out.println("Tarjeta de crédito solicitada correctamente.");
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

    // getters y setters...
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public void setBdate(String Bdate) {
        this.Bdate = Bdate;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
