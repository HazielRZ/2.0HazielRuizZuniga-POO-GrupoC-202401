package MenuControllers;

import Menu.Controller;
import Modelo.Profesor;

public class ControllerVerGruposAsignadosProfesor implements Controller {
    private final Profesor profesor;

    public ControllerVerGruposAsignadosProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public void execute() {
        verGruposAsignados();
    }

    private void verGruposAsignados() {
        // Implementación para ver grupos asignados
    }
}
