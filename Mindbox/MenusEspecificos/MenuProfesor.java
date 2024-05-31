package MenusEspecificos;

import Modelo.Profesor;
import Menu.*;

import java.util.ArrayList;

public class MenuProfesor {
    private Profesor profesor;

    public MenuProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void mostrarMenu() {
        Menu menuProfesor = new Menu();
        menuProfesor.addMenuItem(1, new MenuItem("Ver Información Personal", () -> verInformacionPersonal(profesor), new ArrayList<>(List.of(Permission.READ))));
        menuProfesor.addMenuItem(2, new MenuItem("Ver Grupos Asignados", () -> verGruposAsignados(profesor), new ArrayList<>(List.of(Permission.READ))));
        menuProfesor.addMenuItem(3, new MenuItem("Registrar Calificaciones", () -> registrarCalificaciones(profesor), new ArrayList<>(List.of(Permission.WRITE))));
        menuProfesor.addMenuItem(4, new MenuItem("Modificar Calificaciones", () -> modificarCalificaciones(profesor), new ArrayList<>(List.of(Permission.WRITE))));
        // ... (agregar más opciones al menú de profesor)

        menuProfesor.display("Menú Profesor", profesor.getRol()); // Mostrar el menú
    }

    // ... (implementa los métodos verInformacionPersonal, verGruposAsignados, registrarCalificaciones, modificarCalificaciones)

}
