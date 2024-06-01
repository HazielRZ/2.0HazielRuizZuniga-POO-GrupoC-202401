package MenusEspecificos;

import MenuControllers.*;
import Modelo.Profesor;
import Menu.*;

import java.util.ArrayList;
import java.util.List;

public class MenuProfesor {
    private final Profesor profesor;

    public MenuProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void mostrarMenu() {
        Menu menuProfesor = new Menu();
        menuProfesor.addMenuItem(1, new MenuItem("Ver Información Personal", new ControllerVerInformacionPersonalProfesor(profesor), new ArrayList<>(List.of(Permission.READ))));
        menuProfesor.addMenuItem(2, new MenuItem("Ver Grupos Asignados", new ControllerVerGruposAsignadosProfesor(profesor), new ArrayList<>(List.of(Permission.READ))));
        menuProfesor.addMenuItem(3, new MenuItem("Registrar Calificaciones", new ControllerRegistrarCalificacionesProfesor(profesor), new ArrayList<>(List.of(Permission.WRITE))));
        menuProfesor.addMenuItem(4, new MenuItem("Modificar Calificaciones", new ControllerModificarCalificacionesProfesor(profesor), new ArrayList<>(List.of(Permission.WRITE))));
        // ... (agregar más opciones al menú de profesor)
        menuProfesor.addMenuItem(0, new MenuItem("Salir", new SalirController(), new ArrayList<>(List.of(Permission.READ))));
        int opcion;
        do {
            menuProfesor.display("Menú Profesor"); // Mostrar el menú
            opcion = AskData.inputInteger("Opción: ", new IntegerValidator() {
                @Override
                public boolean integerValidator(int value) {
                    return menuProfesor.getMenuItems().containsKey(value); // Validar si la opción existe en el menú
                }
            });
            if (opcion != 0) {
                menuProfesor.getMenuItems().get(opcion).getController().execute(null);
            }
        } while (opcion != 0); // Repetir hasta que el usuario elija salir
    }
}