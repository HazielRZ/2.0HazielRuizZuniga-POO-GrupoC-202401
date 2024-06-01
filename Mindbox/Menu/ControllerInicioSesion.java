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
import java.util.List;

public class ControllerInicioSesion implements Controller {

    @Override
    public void execute() {
        iniciarSesion();
    }

    public void iniciarSesion() {
        String nombreUsuario = AskData.inputString("Nombre de usuario");
        String contrasena = AskData.inputString("Contraseña");

        Usuario usuario = buscarUsuarioEnArchivos(nombreUsuario, contrasena);

        if (usuario != null) {
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario.getNombre() + "!");
            mostrarMenuSegunRol(usuario, GrupoCrud.grupos);
        } else {
            System.out.println("Credenciales incorrectas. Por favor, intente de nuevo.");
        }
    }

    private Usuario buscarUsuarioEnArchivos(String nombreUsuario, String contrasena) {
        Gson gson = new Gson();
        String[] archivosUsuarios = {"alumnos.json", "profesores.json", "coordinadores.json"};

        for (String archivo : archivosUsuarios) {
            try {
                String json = new String(Files.readAllBytes(Paths.get(archivo)));
                List<Usuario> usuarios = gson.fromJson(json, new TypeToken<List<Usuario>>() {}.getType());
                for (Usuario usuario : usuarios) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                        return usuario; // Encontramos al usuario, retornamos la instancia
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al cargar usuarios desde " + archivo + ": " + e.getMessage());
                // Puedes decidir si continuar buscando en otros archivos o no
            }
        }
        return null; // No se encontró el usuario
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