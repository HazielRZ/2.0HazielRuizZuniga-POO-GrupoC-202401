package MenuControllers;

import Menu.Controller;
import Menu.Permission;
import Modelo.Profesor;

import java.util.ArrayList;

public class ControllerVerInformacionPersonalProfesor implements Controller {
    private final Profesor profesor;

    public ControllerVerInformacionPersonalProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public void execute(ArrayList<Permission> permissions) {
        verInformacionPersonal();
    }

    private void verInformacionPersonal() {
        System.out.println("\nInformación Personal:");
        System.out.println("Nombre: " + profesor.getNombre() + " " + profesor.getApellidos());
        System.out.println("Sueldo: " + profesor.getSueldo());
        // ... (mostrar más información del profesor)
    }
}
