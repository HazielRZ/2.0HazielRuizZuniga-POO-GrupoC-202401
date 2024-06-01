package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Alumno;

import java.util.ArrayList;

public class ControllerVerCalificacionesAlumno implements Controller {
    private final Alumno alumno;

    public ControllerVerCalificacionesAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        verCalificaciones();
    }

    private void verCalificaciones() {
        // Implementación para ver calificaciones
    }
}
