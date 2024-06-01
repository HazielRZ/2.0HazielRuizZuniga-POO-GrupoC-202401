package Menu;

import Cruds.GrupoCrud;
import MenusEspecificos.MenuAlumno;
import MenusEspecificos.MenuCoordinador;
import MenusEspecificos.MenuProfesor;
import Modelo.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ControllerInicioSesion implements Controller {

    @Override
    public void execute(ArrayList<Permission> permissions) {
        iniciarSesion();
    }

    public void iniciarSesion() {
        String nombreUsuario = AskData.inputString("Nombre de usuario");
        String contrasena = AskData.inputString("Contraseña");

        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(Paths.get("usuarios.json")));
            List<Usuario> usuarios = gson.fromJson(json, new TypeToken<List<Usuario>>() {}.getType());

            for (Usuario usuario : usuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                    System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario.getNombre() + "!");
                    mostrarMenuSegunRol(usuario,GrupoCrud.grupos); // Pasar el usuario encontrado
                    return;
                }
            }

            System.out.println("Credenciales incorrectas. Por favor, intente de nuevo.");
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios desde JSON: " + e.getMessage());
        }
    }

    public static void mostrarMenuSegunRol(Usuario usuario, List<Grupo> grupos) {
        String rol = usuario.getRol();
        switch (rol) {
            case "Alumno":
                new MenuAlumno((Alumno) usuario, new GrupoCrud(grupos)).mostrarMenu();
                break;
            case "Profesor":
                new MenuProfesor((Profesor) usuario).mostrarMenu();
                break;
            case "Coordinador":
                new MenuCoordinador((Coordinador) usuario).mostrarMenu();
                break;
            default:
                System.out.println("Rol de usuario no válido.");
        }
    }
}