package MenuControllers;

import Menu.Controller;
import Modelo.Alumno;

public class ControllerVerCalificacionesAlumno implements Controller {
    private final Alumno alumno;

    public ControllerVerCalificacionesAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public void execute() {
        verCalificaciones();
    }

    private void verCalificaciones() {
        // Implementación para ver calificaciones
    }
}
