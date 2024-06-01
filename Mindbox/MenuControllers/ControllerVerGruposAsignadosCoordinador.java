package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Coordinador;

import java.util.ArrayList;

public class ControllerVerGruposAsignadosCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerVerGruposAsignadosCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        verGruposAsignados();
    }

    private void verGruposAsignados() {
        // Implementación para ver grupos asignados
    }
}
