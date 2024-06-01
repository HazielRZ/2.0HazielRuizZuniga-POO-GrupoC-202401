package MenuControllers;

import Menu.Controller;
import Modelo.Profesor;

public class ControllerRegistrarCalificacionesProfesor implements Controller {
    private final Profesor profesor;

    public ControllerRegistrarCalificacionesProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public void execute() {
        registrarCalificaciones();
    }

    private void registrarCalificaciones() {
        // Implementación para registrar calificaciones
    }
}
