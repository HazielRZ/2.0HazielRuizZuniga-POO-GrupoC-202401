package MenuControllers;

import Menu.Controller;
import Modelo.Alumno;

public class ControllerVerHistorialAcademicoAlumno implements Controller {
    private final Alumno alumno;

    public ControllerVerHistorialAcademicoAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public void execute() {
        verHistorialAcademico();
    }

    private void verHistorialAcademico() {
        // Implementación para ver historial académico
    }
}
