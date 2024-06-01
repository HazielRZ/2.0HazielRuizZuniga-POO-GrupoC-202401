package MenusEspecificos;

import MenuControllers.*;
import Modelo.Coordinador;
import Menu.*;

import java.util.ArrayList;
import java.util.List;

public class MenuCoordinador {
    private final Coordinador coordinador;

    public MenuCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void mostrarMenu() {
        Menu menuCoordinador = new Menu();
        menuCoordinador.addMenuItem(1, new MenuItem("Ver Información Personal", new ControllerVerInformacionPersonalCoordinador(coordinador), new ArrayList<>(List.of(Permission.READ))));
        menuCoordinador.addMenuItem(2, new MenuItem("Ver Grupos Asignados", new ControllerVerGruposAsignadosCoordinador(coordinador), new ArrayList<>(List.of(Permission.READ))));
        menuCoordinador.addMenuItem(3, new MenuItem("Registrar Calificaciones", new ControllerRegistrarCalificacionesCoordinador(coordinador), new ArrayList<>(List.of(Permission.WRITE))));
        menuCoordinador.addMenuItem(4, new MenuItem("Modificar Calificaciones", new ControllerModificarCalificacionesCoordinador(coordinador), new ArrayList<>(List.of(Permission.WRITE))));
        menuCoordinador.addMenuItem(5, new MenuItem("Ver Información de Alumnos de la Carrera", new ControllerVerAlumnosCarreraCoordinador(coordinador), new ArrayList<>(List.of(Permission.READ))));
        menuCoordinador.addMenuItem(6, new MenuItem("Dar de Alta Alumno", new ControllerDarAltaAlumnoCoordinador(coordinador), new ArrayList<>(List.of(Permission.WRITE))));
        menuCoordinador.addMenuItem(7, new MenuItem("Dar de Alta Profesor", new ControllerDarAltaProfesorCoordinador(coordinador), new ArrayList<>(List.of(Permission.WRITE))));
        menuCoordinador.addMenuItem(8, new MenuItem("Avanzar Semestre de un Grupo", new ControllerAvanzarSemestreCoordinador(coordinador), new ArrayList<>(List.of(Permission.WRITE))));
        menuCoordinador.addMenuItem(0, new MenuItem("Salir", new SalirController(), new ArrayList<>(List.of(Permission.READ))));

        int opcion;
        do {
            menuCoordinador.display("\nMenú Coordinador");
            opcion = AskData.inputInteger("Opción: ", new IntegerValidator() {
                @Override
                public boolean integerValidator(int value) {
                    return menuCoordinador.getMenuItems().containsKey(value); // Validar si la opción existe en el menú
                }
            }); // Validación de opciones
            if (opcion != 0) {
                menuCoordinador.getMenuItems().get(opcion).getController().execute();
            }
        } while (opcion != 0); // Repetir hasta que el usuario elija salir
    }
}