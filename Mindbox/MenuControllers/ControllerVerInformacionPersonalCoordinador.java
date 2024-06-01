package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Coordinador;
import Modelo.Alumno;
import Modelo.Profesor;
import java.util.ArrayList;

public class ControllerVerInformacionPersonalCoordinador implements Controller {
    private final Coordinador coordinador;

    public ControllerVerInformacionPersonalCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        verInformacionPersonal();
    }

    private void verInformacionPersonal() {
        System.out.println("\nInformación Personal:");
        System.out.println("Nombre: " + coordinador.getNombre() + " " + coordinador.getApellidos());
        System.out.println("Número de Empleado: " + coordinador.getIdUsuario());
        // ... (mostrar más información del coordinador)
    }
}

