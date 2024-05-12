package Roles;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Inversionista {
    private static final Scanner scanner = new Scanner(System.in);
    private final Date fechaCreacion = new Date();

    private final String nombre;
    private final String id;

    public Inversionista(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void fondoBancoMadero() {
        System.out.println("Ingrese el fondo que proveerá al banco de Madero: ");
        double fondoMadero = solicitarCantidad();
        System.out.println("Este movimiento se realizó en la fecha: " + fechaCreacion);
        System.out.println("Gracias por invertir en la sucursal Madero.");
    }

    public void fondoBancoAcueducto() {
        System.out.println("Ingrese el fondo que proveerá al banco de Acueducto: ");
        double fondoAcueducto = solicitarCantidad();
        System.out.println("Este movimiento se realizó en la fecha: " + fechaCreacion);
        System.out.println("Gracias por invertir en la sucursal Acueducto.");
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
}
