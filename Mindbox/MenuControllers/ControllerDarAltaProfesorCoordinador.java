package MenuControllers;

import Menu.Controller;
import Modelo.Coordinador;

public class ControllerDarAltaProfesorCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerDarAltaProfesorCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute() {
        darAltaProfesor();
    }

    private void darAltaProfesor() {
        // Implementación para dar de alta a un profesor
    }
}
