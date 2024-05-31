package MenusEspecificos;

import Modelo.Coordinador;
import Menu.*;

import java.util.ArrayList;

public class MenuCoordinador {
    private Coordinador coordinador;

    public MenuCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void mostrarMenu() {
        Menu menuCoordinador = new Menu();
        // Opciones del menú de profesor
        menuCoordinador.addMenuItem(1, new MenuItem("Ver Información Personal", () -> verInformacionPersonal(coordinador), new ArrayList<>(List.of(Permission.READ))));
        menuCoordinador.addMenuItem(2, new MenuItem("Ver Grupos Asignados", () -> verGruposAsignados(coordinador), new ArrayList<>(List.of(Permission.READ))));
        menuCoordinador.addMenuItem(3, new MenuItem("Registrar Calificaciones", () -> registrarCalificaciones(coordinador), new ArrayList<>(List.of(Permission.WRITE))));
        menuCoordinador.addMenuItem(4, new MenuItem("Modificar Calificaciones", () -> modificarCalificaciones(coordinador), new ArrayList<>(List.of(Permission.WRITE))));

        // Opciones específicas del coordinador
        menuCoordinador.addMenuItem(5, new MenuItem("Ver Información de Alumnos de la Carrera", () -> verAlumnosCarrera(coordinador), new ArrayList<>(List.of(Permission.READ))));
        menuCoordinador.addMenuItem(6, new MenuItem("Dar de Alta Alumno", () -> darAltaAlumno(coordinador), new ArrayList<>(List.of(Permission.WRITE))));
        menuCoordinador.addMenuItem(7, new MenuItem("Dar de Alta Profesor", () -> darAltaProfesor(coordinador), new ArrayList<>(List.of(Permission.WRITE))));
        menuCoordinador.addMenuItem(8, new MenuItem("Avanzar Semestre de un Grupo", () -> avanzarSemestre(coordinador), new ArrayList<>(List.of(Permission.WRITE))));
        // ... (agregar más opciones al menú de coordinador)

        menuCoordinador.display("Menú Coordinador", coordinador.getRol()); // Mostrar el menú
    }

    // ... (implementa los métodos verInformacionPersonal, verGruposAsignados, registrarCalificaciones, modificarCalificaciones, verAlumnosCarrera, darAltaAlumno, darAltaProfesor, avanzarSemestre)
}

