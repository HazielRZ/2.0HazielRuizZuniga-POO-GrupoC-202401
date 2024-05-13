package Roles;

import java.util.List;

public class Capturista extends Empleado{
    private static List<EjecutivoCuenta> ejecutivos;

    public Capturista(List<EjecutivoCuenta> ejecutivos) {
        Capturista.ejecutivos = ejecutivos;
    }

    public static void  agregarEjecutivo(String nombre, String apellido, String correo) {
        ejecutivos.add(new EjecutivoCuenta(nombre, apellido, correo));
        System.out.println("Ejecutivo de cuenta agregado: " + nombre + " " + apellido);
    }

    public static EjecutivoCuenta buscarEjecutivo(String nombre, String apellido) {
        for (EjecutivoCuenta ejecutivo : ejecutivos) {
            if (ejecutivo.getNombre().equalsIgnoreCase(nombre) && ejecutivo.getApellido().equalsIgnoreCase(apellido)) {
                return ejecutivo;
            }
        }
        return null;
    }

    public static void modificarDatos(EjecutivoCuenta ejecutivo, String nuevoNombre, String nuevoApellido, String nuevoCorreo) {
        ejecutivo.setNombre(nuevoNombre);
        ejecutivo.setApellido(nuevoApellido);
        ejecutivo.setCorreo(nuevoCorreo);
        System.out.println("Datos de " + ejecutivo.getNombre() + " " + ejecutivo.getApellido() + " modificados.");
    }

    public static void eliminarEjecutivo(EjecutivoCuenta ejecutivo) {
        ejecutivos.remove(ejecutivo);
        System.out.println("Ejecutivo de cuenta eliminado: " + ejecutivo.getNombre() + " " + ejecutivo.getApellido());
    }

    public static void mostrarEjecutivos() {
        if (ejecutivos.isEmpty()) {
            System.out.println("No hay ejecutivos de cuenta registrados.");
        } else {
            System.out.println("Ejecutivos de cuenta registrados:");
            for (EjecutivoCuenta ejecutivo : ejecutivos) {
                System.out.println(ejecutivo);
            }
        }
    }

    public static class EjecutivoCuenta {

        private String nombre;
        private String apellido;
        private String correo;

        public EjecutivoCuenta(String nombre, String apellido, String correo) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.correo = correo;
        }

        //getters and Setters

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public String getCorreo() {
            return correo;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Apellido: " + apellido + ", Correo: " + correo;
        }
    }

}
