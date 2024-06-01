package MenuControllers;
import Menu.Controller;
import Menu.Permission;
import Modelo.Profesor;
import java.util.ArrayList;

public class ControllerModificarCalificacionesProfesor implements Controller {
    private final Profesor profesor;

    public ControllerModificarCalificacionesProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        modificarCalificaciones();
    }

    private void modificarCalificaciones() {
        // Implementación para modificar calificaciones
    }
}