package Usuarios;

import Libreria.Libreria;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Cliente extends Usuario {
    private final LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String telefono, String userName, String contraseña) {
        super(nombre, apellido, telefono, Rol.CLIENTE, userName, contraseña);
        this.fechaRegistro = LocalDate.now(); //Trae la fecha actual de la computadora.
    }

    public static void registrarCliente() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.CLIENTE);
        String nameCoustomer = datosComun.get(0);
        String apellidoCoustomer = datosComun.get(1);
        String telphoneCoustomer = datosComun.get(2);
        String usernameCoustomer = datosComun.get(3);
        String passwordCoustomer = datosComun.get(4);

        Cliente newCoustomer = new Cliente(nameCoustomer, apellidoCoustomer,
                telphoneCoustomer, usernameCoustomer, passwordCoustomer);
        if (!Libreria.usuarios.containsKey(Rol.CLIENTE)) {
            Libreria.usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        }
        Libreria.usuarios.get(Rol.CLIENTE).add(newCoustomer);
        Libreria.usuarioVerificar.put(usernameCoustomer, newCoustomer);

        System.out.println("ID: " + newCoustomer.getId());
        System.out.println("El cliente " + newCoustomer.getUserName() + " registrado con éxito. ");
        System.out.println("Bienvenido al mundo de los libros.");
    }

    public static void mostrarInformacionCliente() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre de usuario del cliente: ");
        String showCoustumer = leer.nextLine();
        if (Libreria.usuarioVerificar.containsKey(showCoustumer)) {
            Usuario mostrararUsuario = Libreria.usuarioVerificar.get(showCoustumer);
            System.out.println(mostrararUsuario.toString());
        }
    }

    public static void mostrarClientesEnLista() {
        for (Map.Entry<String, Usuario> entry : Libreria.usuarioVerificar.entrySet()) {
            Usuario usuario = entry.getValue();
            if (usuario instanceof Cliente mostrarCliente) {
                System.out.println(mostrarCliente);
            }
        }
    }

    public static void eliminarCliente() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresar el nombre de usuario a eliminar:");
        String userToBeRemoved = leer.nextLine();
        if (Libreria.usuarioVerificar.containsKey(userToBeRemoved)) {
            Usuario eliminarUsuario = Libreria.usuarioVerificar.remove(userToBeRemoved);
            Libreria.usuarios.remove(eliminarUsuario);
            System.out.println("\n*El cliente ha sido eliminado.*");
            return;
        }
        System.out.println("No fue posible eliminar ese cliente.");
    }

    public String toString() {
        return String.format("%s, Fecha registro: %s", super.toString(), fechaRegistro);
    }

    public String mostrarInfo() {
        return String.format("%s, Fecha registro: %s", super.toString(), fechaRegistro);
    }

}