package Libreria;
import Usuarios.Administrador;
import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.util.*;

public class Libreria {
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap <Rol, ArrayList<Usuario>>();
    public static final HashMap<String, Usuario> usuarioVerificar = new HashMap <String, Usuario>();
    public static final HashMap<String, Libro> listaLibros = new HashMap <String, Libro>();
    public Libreria() {
        usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        Asistente newAsistente = new Asistente("Haziel", "Ruiz", "4423408",
                2500.00, "dfsfsd", "fdggdf", "HZR", "sdffsd");
        usuarios.get(Rol.ASISTENTE).add(newAsistente);
        usuarioVerificar.put("HZR", newAsistente);
        Cliente newCliente = new Cliente("CHIPI", "CHAPA", "4432087308",
                "CHIPI", "CAPICHI093");
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        usuarios.get(Rol.CLIENTE).add(newCliente);
        usuarioVerificar.put("CHIPI", newCliente);
    }
    Scanner leer = new Scanner (System.in);

    public Usuario verificarInicioDeSesion(String userName, String contrasena) {
        if (usuarioVerificar.containsKey(userName)) {
            Usuario usuarioAVerificar = usuarioVerificar.get(userName);
            if (usuarioAVerificar.getContraseña().equals(contrasena)) {//Verifica la contraseña
                return usuarioAVerificar;
            }
        }
        return null;
    }

    public static String validarTelefonoCliente() {
        Scanner leer = new Scanner (System.in);
        //Scope. Espacio dentro de unas llaves.
        String telephone = "" ;
        boolean telephoneValidation = true;
        do {
            System.out.println("Ingresa el teléfono del cliente: ");
            telephone = leer.nextLine();
            telephoneValidation = false;
            for ( Usuario buscarTelefono : usuarioVerificar.values()) {
                if (buscarTelefono.getTelefono().equals(telephone)) {
                    telephoneValidation = true;
                    break;
                }
            }
            if (telephoneValidation) {
                System.out.println("El teléfono ya ha sido registrado. Inténtelo de nuevo.");
            }
        } while (telephoneValidation);
        return telephone;
    }
    public static String validateUser() {
        Scanner leer = new Scanner (System.in);
        String userName = "" ;
        boolean userValidation = true;
        do {
            System.out.println("Ingresa el nombre de la cuenta: ");
            userName = leer.nextLine();
            userValidation = false;
            for ( Usuario buscarNombreCliente : usuarioVerificar.values()) {
                if (buscarNombreCliente.getUserName().equals(userName)) {
                    userValidation = true;
                    break;
                }
            }
            if (userValidation) {
                System.out.println("El usuario ya ha sido registrado. Inténtelo de nuevo.");
            }
        } while (userValidation);
        return userName;
    }
    public boolean validateUserToBeRemoved(String userName) {
        for ( Usuario buscarNombre : usuarioVerificar.values()) {
            if (buscarNombre.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isGerente(String userManager) {
        for (Usuario findUserManager : usuarios.get(Rol.GERENTE)) {
            if (findUserManager.getUserName() == userManager) {
                return true;
            }
        }
        return false;
    }
    public static void registrarCliente() {
        Cliente.registrarCliente();
    }
    public void verCliente() {
        Cliente.mostrarInformacionCliente();
    }
    public void eliminarCliente() {
        Cliente.eliminarCliente();
    }
    public void verListaClientes() {
        Cliente.mostrarClientesEnLista();
    }
    public void modificarCliente() {
    }
    public void registrarAsistente() {
        Asistente.registrarAsistente();
    }
    public void eliminarAsistente() {
        Cliente.eliminarCliente();
    }
    public void verListaAsistentes() {
        Cliente.mostrarClientesEnLista();
    }
    public void modificarAsistente() {
    }
    public void registrarGerente() {
        Administrador.registrarGerente();
    }
    public void eliminarGerente() {
        Administrador.eliminarGerente();
    }
    public void verListaGerentes() {
        Administrador.mostrarGerentesEnLista();
    }
    public void modificarGerente() {
    }

    public void registrarLibro() {
        System.out.println("Ingresa el título: ");
        String tittle = leer.nextLine();
        System.out.println("Ingresa la fecha de lanzamiento: ");
        String fechaLanzamiento = leer.nextLine();
        System.out.println("Ingresa el nombre del autor: ");
        String authorName = leer.nextLine();
        Libro newLibro = new Libro (tittle, fechaLanzamiento, authorName);
        System.out.println("Código de barras: " + newLibro.getLibroID());
        listaLibros.add(newLibro);
    }
    public void mostrarLibros(){
        for (Libro buscarLibro : listaLibros){
            System.out.println(buscarLibro.mostrarLibros());
        }
    }
}