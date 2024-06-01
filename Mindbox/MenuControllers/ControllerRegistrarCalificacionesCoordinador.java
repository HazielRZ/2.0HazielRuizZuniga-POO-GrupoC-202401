package MenuControllers;

import Menu.Controller;
import Modelo.Coordinador;

public class ControllerRegistrarCalificacionesCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerRegistrarCalificacionesCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute() {
        registrarCalificaciones();
    }

    private void registrarCalificaciones() {
        // Implementación para registrar calificaciones
    }
}
