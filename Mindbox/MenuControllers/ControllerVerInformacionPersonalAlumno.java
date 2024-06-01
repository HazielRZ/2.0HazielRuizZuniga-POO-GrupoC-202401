package MenuControllers;

import Menu.Controller;
import Modelo.Alumno;

public class ControllerVerInformacionPersonalAlumno implements Controller {
    private final Alumno alumno;

    public ControllerVerInformacionPersonalAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public void execute() {
        verInformacionPersonal();
    }

    private void verInformacionPersonal() {
        System.out.println("\nInformación Personal:");
        System.out.println("Nombre: " + alumno.getNombre() + " " + alumno.getApellidos());
        System.out.println("Número de Control: " + alumno.getNumeroControl());
        // ... (mostrar más información del alumno)
    }
}

