package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Coordinador;

import java.util.ArrayList;

public class ControllerAvanzarSemestreCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerAvanzarSemestreCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        avanzarSemestre();
    }

    private void avanzarSemestre() {
        // Implementación para avanzar semestre de un grupo
    }
}
