package Usuarios;

import Usuarios.utils.Rol;
import Libreria.Libreria;
import Usuarios.DatosComun;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Administrador extends Usuario{
    private Double sueldo;
    private String RFC;
    private String INE;

    public Administrador(String nombre, String apellido, String telefono,
                         Double sueldo, String RFC, String INE, String userName, String contraseña) {
        super(nombre, apellido, telefono, Rol.GERENTE, userName, contraseña);
        this.sueldo = sueldo;
        this.RFC = RFC;
        this.INE = INE;
    }
    @Override
    public String toString(){
        return String.format("%s, Sueldo: %.3f, RFC: %s, INE: %s "+
                super.toString(), sueldo, RFC, INE);
    }
    public static void registrarGerente() {
        Scanner leer = new Scanner (System.in);
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.ASISTENTE);
        String nameManager = datosComun.get(0);
        String apellidoManager = datosComun.get(1);
        String telphoneManager = datosComun.get(2);
        String RFCManager = datosComun.get(3);
        String usernameManager = datosComun.get(4);
        String passwordManager = datosComun.get(5);
        System.out.println("Ingresa el sueldo del gerente: ");
        Double salaryManager = leer.nextDouble();
        System.out.println("Ingresa la INE: ");
        String INEManager = leer.nextLine();
        Asistente newManager = new Asistente (nameManager, apellidoManager,
                telphoneManager, salaryManager, RFCManager, INEManager,
                usernameManager, passwordManager);
        if (Libreria.usuarios.containsKey(Rol.GERENTE)) {
            Libreria.usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        //si es el primer cliente a registrar, va a crear la lista.
        Libreria.usuarios.get(Rol.GERENTE).add(newManager);
        Libreria.usuarioVerificar.put(usernameManager, newManager);
        System.out.println("El ID es: " + newManager.getId());
        System.out.println("El gerente " + newManager.getUserName() + "se ha registrado con éxito.");
    }
    public static void mostrarGerentesEnLista(){
        for (Map.Entry<String, Usuario> entry : Libreria.usuarioVerificar.entrySet()) {
            Usuario usuario = entry.getValue();
            if (usuario instanceof Administrador) {
                Administrador mostrarGerente = (Administrador) usuario;
                System.out.println(mostrarGerente.toString());
            }
        }
    }
    public static void eliminarGerente() {
        Scanner leer = new Scanner (System.in);
        System.out.println("Ingresar el nombre de usuario a eliminar:");
        String userToBeRemovedManager = leer.nextLine();
        if (Libreria.isGerente(userToBeRemovedManager)) {
            System.out.println("No puede eliminar su propio usuario.");
        }
        else
        {
            if (Libreria.usuarioVerificar.containsKey(userToBeRemovedManager)) {
                Usuario eliminarUsuario = Libreria.usuarioVerificar.remove(userToBeRemovedManager);
                System.out.println("\n*El gerente ha sido eliminado.*");
            }
        }
    }
}