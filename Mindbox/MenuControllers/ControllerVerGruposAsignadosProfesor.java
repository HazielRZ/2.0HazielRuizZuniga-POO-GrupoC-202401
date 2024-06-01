package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Profesor;

import java.util.ArrayList;

public class ControllerVerGruposAsignadosProfesor implements Controller {
    private final Profesor profesor;

    public ControllerVerGruposAsignadosProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        verGruposAsignados();
    }

    private void verGruposAsignados() {
        // Implementación para ver grupos asignados
    }
}
