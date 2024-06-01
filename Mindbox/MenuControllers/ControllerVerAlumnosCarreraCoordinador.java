package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Coordinador;

import java.util.ArrayList;

public class ControllerVerAlumnosCarreraCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerVerAlumnosCarreraCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        verAlumnosCarrera();
    }

    private void verAlumnosCarrera() {
        // Implementación para ver información de alumnos de la carrera
    }
}
