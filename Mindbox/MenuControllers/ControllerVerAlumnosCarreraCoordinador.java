package MenuControllers;

import Menu.Controller;
import Modelo.Coordinador;

public class ControllerVerAlumnosCarreraCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerVerAlumnosCarreraCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute() {
        verAlumnosCarrera();
    }

    private void verAlumnosCarrera() {
        // Implementación para ver información de alumnos de la carrera
    }
}
