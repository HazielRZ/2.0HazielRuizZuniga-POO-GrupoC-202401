package Roles;

import utils.IDManager;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Inversionista {
    private static final Scanner scanner = new Scanner(System.in);
    private final Date fechaCreacion = new Date();
    private final int id;
    private String nombre;

    public Inversionista(String nombre, String id) {
        this.nombre = nombre;
        this.id = IDManager.generarIDInversionista();
    }

    public static void registrarNuevoInversionista() {
        System.out.println("Registro de un nuevo inversionista:");
        System.out.print("Ingrese el nombre del inversionista: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del inversionista: ");
        String id = scanner.nextLine();

        Inversionista nuevoInversionista = new Inversionista(nombre, id);

        System.out.println("¡Inversionista registrado correctamente!");
    }

    public static void modificarDatos(Inversionista inversionista) {
        System.out.println("Modificación de datos de un inversionista:");
        System.out.println("Nombre actual: " + inversionista.getNombre());
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        inversionista.setNombre(nuevoNombre);
        System.out.println("Datos modificados correctamente.");
    }

    public static void eliminarInversionista(Inversionista inversionista) {
        System.out.println("Eliminar inversionista:");
        System.out.println("Nombre: " + inversionista.getNombre());
        System.out.println("ID: " + inversionista.getId());
        System.out.println("Inversionista eliminado correctamente.");
    }

    private double solicitarCantidad() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inversionista that)) return false;
        return Objects.equals(id, that.id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Inversionista{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}

