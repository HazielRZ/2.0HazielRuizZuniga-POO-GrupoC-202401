package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Alumno;

import java.util.ArrayList;

public class ControllerVerHistorialAcademicoAlumno implements Controller {
    private final Alumno alumno;

    public ControllerVerHistorialAcademicoAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        verHistorialAcademico();
    }

    private void verHistorialAcademico() {
        // Implementación para ver historial académico
    }
}
