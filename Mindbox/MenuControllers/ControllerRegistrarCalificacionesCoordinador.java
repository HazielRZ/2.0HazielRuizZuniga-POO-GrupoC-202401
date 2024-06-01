package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Coordinador;

import java.util.ArrayList;

public class ControllerRegistrarCalificacionesCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerRegistrarCalificacionesCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        registrarCalificaciones();
    }

    private void registrarCalificaciones() {
        // Implementación para registrar calificaciones
    }
}
