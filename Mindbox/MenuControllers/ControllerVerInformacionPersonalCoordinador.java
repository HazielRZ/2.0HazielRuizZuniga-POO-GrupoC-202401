package MenuControllers;

import Menu.Controller;
import Modelo.Coordinador;

public class ControllerVerInformacionPersonalCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerVerInformacionPersonalCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute() {
        verInformacionPersonal();
    }

    private void verInformacionPersonal() {
        System.out.println("\nInformación Personal:");
        System.out.println("Nombre: " + coordinador.getNombre() + " " + coordinador.getApellidos());
        System.out.println("Número de Empleado: " + coordinador.getIdUsuario());
        // ... (mostrar más información del coordinador)
    }
}

