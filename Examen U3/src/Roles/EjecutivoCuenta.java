package Roles;
import java.util.ArrayList;
import java.util.Date;

public class EjecutivoCuenta extends Empleado{
    private ArrayList<Persona> personas;

    public EjecutivoCuenta(Date fecha, String capturista, String gerente, String ejecutivoVentas, int id) {
        super(fecha, capturista, gerente, ejecutivoVentas,id);
        personas = new ArrayList<>();

    }



    public void registrarCliente(String nombre, String apellido) {
        personas.add(new Persona(nombre, apellido));
    }

    public Persona buscarCliente(String nombre, String apellido) {
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre) && persona.getApellido().equals(apellido)) {
                return persona;
            }
        }
        return null;
    }

    public void modificarNombreCliente(Persona persona, String nuevoNombre) {
        persona.setNombre(nuevoNombre);
    }

    public void modificarApellidoCliente(Persona persona, String nuevoApellido) {
        persona.setApellido(nuevoApellido);
    }

    public void eliminarCliente(Persona persona) {
        personas.remove(persona);
    }

    public void mostrarCliente() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Personas registradas:");
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }
    }
    public void solicitarTarjetaCredito(){

    }

    public class Persona {
        private String nombre;
        private String apellido;

        public Persona(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        @Override
        public String toString() {
            return nombre + " " + apellido;
        }
    }

}
