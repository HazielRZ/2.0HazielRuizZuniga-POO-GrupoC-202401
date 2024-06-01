package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Coordinador;

import java.util.ArrayList;

public class ControllerModificarCalificacionesCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerModificarCalificacionesCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        modificarCalificaciones();
    }

    private void modificarCalificaciones() {
        // Implementación para modificar calificaciones
    }
}
