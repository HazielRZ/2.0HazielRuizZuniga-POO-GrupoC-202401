package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Profesor;

import java.util.ArrayList;

public class ControllerRegistrarCalificacionesProfesor implements Controller {
    private final Profesor profesor;

    public ControllerRegistrarCalificacionesProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        registrarCalificaciones();
    }

    private void registrarCalificaciones() {
        // Implementación para registrar calificaciones
    }
}
