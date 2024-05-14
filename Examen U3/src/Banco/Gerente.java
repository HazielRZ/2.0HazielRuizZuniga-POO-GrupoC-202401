package Banco;

import utils.Sucursales;

import java.util.ArrayList;
import java.util.Scanner;


public class Gerente extends Usuario {

    String userName;
    String contraseña;

    public Gerente(String userName, String contrasena, String nombre, String apellidoMaterno, String apellidoPaterno,
                   String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC,
                   double salario, Roles Roles, utils.Sucursales Sucursales, String sexo) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC,
                salario, Roles, Sucursales, sexo, userName, contrasena);
        this.userName = userName;
        this.contraseña = contrasena;
    }

    public static void generarClaveSeguridad(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);

        if (usuarioActual.getRoles() != Roles.GERENTE) {
            System.out.println("Acceso no autorizado. Debes ser gerente para generar una clave de seguridad");
            return;
        } else {
            System.out.println("\nGenerar llave de seguridad para inversionista");
            System.out.println("Ingrese el RFC del inversionista:");
            String buscarRFC = leer.nextLine();

            if (usuarioActual.getSucursales().equals(Sucursales.ACUEDUCTO)) {
                ArrayList<Usuario> inversionistasAcueducto = Sistema.usuariosAcueducto.get(Banco.Roles.INVERSIONISTA);
                for (Usuario inversionista : inversionistasAcueducto) {
                    if (inversionista.getRFC().equals(buscarRFC)) {
                        System.out.println("\nIngrese la clave de seguridad:");
                        String nuevaClave = leer.nextLine();

                        Inversionista newInversionista = (Inversionista) inversionista;
                        newInversionista.setLlaveSeguridad(nuevaClave);

                        System.out.println("Se ha asignado llave de seguridad");
                        return;
                    }
                }
            } else if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
                ArrayList<Usuario> inversionistasMadero = Sistema.usuariosMadero.get(Roles.INVERSIONISTA);
                for (Usuario inversionista : inversionistasMadero) {
                    if (inversionista.getRFC().equals(buscarRFC)) {
                        System.out.println("\nIngrese la clave de seguridad:");
                        String nuevaClave = leer.nextLine();

                        Inversionista newInversionista = (Inversionista) inversionista;
                        newInversionista.setLlaveSeguridad(nuevaClave);

                        System.out.println("Se ha asignado llave de seguridad");
                        return;
                    }
                }
            }
            System.out.println("\nBanco.Usuario no encontrado.");
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}