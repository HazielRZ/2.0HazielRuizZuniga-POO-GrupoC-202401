package MenuControllers;

import Menu.Controller;
import Modelo.Coordinador;

public class ControllerAvanzarSemestreCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerAvanzarSemestreCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute() {
        avanzarSemestre();
    }

    private void avanzarSemestre() {
        // Implementación para avanzar semestre de un grupo
    }
}
