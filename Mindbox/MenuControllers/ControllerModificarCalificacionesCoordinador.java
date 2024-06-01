package MenuControllers;

import Menu.Controller;
import Modelo.Coordinador;

public class ControllerModificarCalificacionesCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerModificarCalificacionesCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute() {
        modificarCalificaciones();
    }

    private void modificarCalificaciones() {
        // Implementación para modificar calificaciones
    }
}
