package Roles;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Inversionista {
    private static final Scanner scanner = new Scanner(System.in);
    private final Date fechaCreacion = new Date();

    private String nombre;
    private final String id;

    public Inversionista(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
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

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inversionista)) return false;
        Inversionista that = (Inversionista) o;
        return Objects.equals(id, that.id);
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
    public static void registrarNuevoInversionista() {
        System.out.println("Registro de un nuevo inversionista:");
        System.out.print("Ingrese el nombre del inversionista: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del inversionista: ");
        String id = scanner.nextLine();

        Inversionista nuevoInversionista = new Inversionista(nombre, id);

        System.out.println("¡Inversionista registrado correctamente!");
    }

    public void modificarDatos() {
        System.out.println("Modificación de datos de un inversionista:");
        System.out.println("Nombre actual: " + nombre);
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        setNombre(nuevoNombre);
        System.out.println("Datos modificados correctamente.");
    }

    public static void eliminarInversionista() {
        System.out.println("Eliminar inversionista:");
        System.out.print("Ingrese el ID del inversionista que desea eliminar: ");
        String id = scanner.nextLine();

        System.out.println("Inversionista eliminado correctamente.");
    }


}

