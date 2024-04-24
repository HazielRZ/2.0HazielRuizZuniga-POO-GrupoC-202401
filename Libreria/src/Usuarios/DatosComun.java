package Usuarios;

import Usuarios.utils.Rol;
import Libreria.Libreria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatosComun {
    public static ArrayList<String> obtenerDatosComun(Rol rol){
        Scanner leer = new Scanner (System.in);
        String rolUser = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente" ;

        System.out.println("Ingresa el nombre: ");
        String name = leer.nextLine();
        System.out.println("Ingresa el apellido: ");
        String surname = leer.nextLine();
        String telphone = Libreria.validarTelefonoCliente();
        System.out.println("Ingresa el RFC: ");
        String RFC = leer.nextLine();
        String username = Libreria.validateUser();
        System.out.println("Ingresa la contraseña: ");
        String password = leer.nextLine();

        return new ArrayList<>(Arrays.asList(name, surname, telphone, RFC, username, password));
    }
}