package MenusEspecificos;

import Menu.AskData;
import Menu.IntegerValidator;

import Menu.Menu;
import Menu.MenuItem;
import Menu.Permission;
import Modelo.Alumno;
import Modelo.Grupo;
import Modelo.Materia;

import java.util.ArrayList;
import java.util.List;

public class MenuAlumno {
    private final Alumno alumno;

    public MenuAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void mostrarMenu() {
        Menu menuAlumno = new Menu();
        menuAlumno.addMenuItem(1, new MenuItem("Ver Información Personal", () -> verInformacionPersonal(alumno), new ArrayList<>(List.of(Permission.READ))));
        menuAlumno.addMenuItem(2, new MenuItem("Ver Calificaciones", () -> verCalificaciones(alumno), new ArrayList<>(List.of(Permission.READ))));
        menuAlumno.addMenuItem(3, new MenuItem("Ver Mis Grupos", () -> verMisGrupos(alumno), new ArrayList<>(List.of(Permission.READ))));
        menuAlumno.addMenuItem(4, new MenuItem("Ver Historial Académico", () -> verHistorialAcademico(alumno), new ArrayList<>(List.of(Permission.READ))));
        menuAlumno.addMenuItem(0, new MenuItem("Salir", () -> System.exit(0), new ArrayList<>(List.of(Permission.READ)))); // Opción para salir

        int opcion;
        do {
            menuAlumno.display("\nMenú Alumno", alumno.getRol());
            opcion = AskData.inputInteger("Opción: ", new IntegerValidator() {
                @Override
                public boolean integerValidator(int value) {
                    return false;
                }
            }); // Validación de opciones
        } while (opcion != 0); // Repetir hasta que el usuario elija salir
    }

    // Implementación de las acciones del menú (ejemplo)
    public void verInformacionPersonal(Alumno alumno) {
        System.out.println("\nInformación Personal:");
        System.out.println("Nombre: " + alumno.getNombre() + " " + alumno.getApellidos());
        System.out.println("Número de Control: " + alumno.getNumeroControl());
        // ... (mostrar más información del alumno)
    }
    public void verMisGrupos(Alumno alumno) {
        if (alumno.getGrupo() != null) { // Verificar si el alumno está en un grupo
            Grupo grupo = alumno.getGrupo();
            System.out.println("\nMi Grupo:");

            System.out.println("Materias:");
            for (Materia materia : grupo.getMaterias()) {
                System.out.println("- " + materia.getNombre());
            }
        } else {
            System.out.println("No estás inscrito en ningún grupo.");
        }
    }

    public void verCalificaciones(Alumno alumno) {
        // ... (implementación para ver calificaciones)
    }

    public void verHistorialAcademico(Alumno alumno) {
        // ... (implementación para ver historial académico)
    }
}
