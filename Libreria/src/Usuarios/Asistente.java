package Usuarios;

import Usuarios.utils.Rol;
import Libreria.Libreria;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Asistente extends Usuario {
    private LocalDate fechaInicio;
    private Double sueldo;
    private String RFC;
    private String INE;

    public Asistente(String nombre, String apellido, String telefono,
                     Double sueldo, String RFC, String INE, String userName, String contraseña) {
        super(nombre, apellido, telefono, Rol.ASISTENTE, userName, contraseña);
        this.fechaInicio = fechaInicio;
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }
    @Override
    public String toString(){
        return String.format("%s, Fecha de ingreso: %s, Sueldo: %.3f, RFC: %s, INE: %s "+
                super.toString(), fechaInicio, sueldo, RFC, INE);
    }
    public static void registrarAsistente() {
        Scanner leer = new Scanner (System.in);
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.ASISTENTE);
        String nameAssistan = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telphoneAssistan = datosComun.get(2);

        System.out.println("Ingresa el sueldo del asistente: ");
        Double sueldoAsistente = leer.nextDouble();
        System.out.println("Ingresa el RFC: ");
        String RFCAsistente = datosComun.get(3);
        System.out.println("Ingresa la INE: ");
        String INEAsistente = leer.nextLine();
        String usernameAsistente = datosComun.get(4);
        System.out.println("Ingresa la contraseña: ");
        String passwordAsistente = datosComun.get(5);

        Asistente newAsistente = new Asistente (nameAssistan, apellido,
                telphoneAssistan, sueldoAsistente, RFCAsistente, INEAsistente,
                usernameAsistente, passwordAsistente);
        if (Libreria.usuarios.containsKey(Rol.ASISTENTE)) {
            Libreria.usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        }
        //si es el primer cliente a registrar, va a crear la lista.
        Libreria.usuarios.get(Rol.CLIENTE).add(newAsistente);
        Libreria.usuarioVerificar.put(usernameAsistente, newAsistente);
        System.out.println("ID: " + newAsistente.getId());
        System.out.println("El asistente " + newAsistente.getUserName() + "registrado con éxito.");
    }
    public static void mostrarAsistentesEnLista(){
        for (Map.Entry<String, Usuario> entry : Libreria.usuarioVerificar.entrySet()) {
            Usuario usuario = entry.getValue();
            if (usuario instanceof Asistente) {
                Asistente mostrarAsistente = (Asistente) usuario;
                System.out.println(mostrarAsistente.toString());
            }
        }
    }
    public static void eliminarAsistente() {
        Scanner leer = new Scanner (System.in);
        System.out.println("Ingresar el nombre de usuario a eliminar:");
        String userToBeRemoved = leer.nextLine();
        if (Libreria.usuarioVerificar.containsKey(userToBeRemoved)) {
            Usuario eliminarUsuario = Libreria.usuarioVerificar.remove(userToBeRemoved);
            System.out.println("\n*El asistente ha sido eliminado.*");
        }
        System.out.println("No fue posible eliminar ese asistente.");
    }
}