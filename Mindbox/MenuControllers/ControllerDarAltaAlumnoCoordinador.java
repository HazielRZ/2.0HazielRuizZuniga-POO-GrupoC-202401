package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Coordinador;

import java.util.ArrayList;

public class ControllerDarAltaAlumnoCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerDarAltaAlumnoCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        darAltaAlumno();
    }

    private void darAltaAlumno() {
        // Implementación para dar de alta a un alumno
    }
}
