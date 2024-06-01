package MenuControllers;
import Menu.Controller;
import Modelo.Profesor;

public class ControllerModificarCalificacionesProfesor implements Controller {
    private final Profesor profesor;

    public ControllerModificarCalificacionesProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public void execute() {
        modificarCalificaciones();
    }

    private void modificarCalificaciones() {
        // Implementación para modificar calificaciones
    }
}