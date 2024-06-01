package MenuControllers;

import Menu.Controller;
import Modelo.Coordinador;

public class ControllerVerGruposAsignadosCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerVerGruposAsignadosCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute() {
        verGruposAsignados();
    }

    private void verGruposAsignados() {
        // Implementación para ver grupos asignados
    }
}
