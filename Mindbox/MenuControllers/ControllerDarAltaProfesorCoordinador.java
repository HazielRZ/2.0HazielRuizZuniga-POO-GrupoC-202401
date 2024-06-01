package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Coordinador;

import java.util.ArrayList;

public class ControllerDarAltaProfesorCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerDarAltaProfesorCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        darAltaProfesor();
    }

    private void darAltaProfesor() {
        // Implementación para dar de alta a un profesor
    }
}
