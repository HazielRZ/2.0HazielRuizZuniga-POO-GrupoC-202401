package MenuControllers;

import Menu.Controller;
import Modelo.Coordinador;

public class ControllerDarAltaAlumnoCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerDarAltaAlumnoCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute() {
        darAltaAlumno();
    }

    private void darAltaAlumno() {
        // Implementación para dar de alta a un alumno
    }
}
