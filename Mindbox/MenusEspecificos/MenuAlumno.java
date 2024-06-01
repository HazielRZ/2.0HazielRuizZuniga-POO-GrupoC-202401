package MenusEspecificos;

import Cruds.GrupoCrud;
import Menu.AskData;
import Menu.IntegerValidator;

import Menu.Menu;
import Menu.MenuItem;
import Menu.Permission;
import MenuControllers.*;
import Modelo.Alumno;
import Menu.SalirController;

import java.util.ArrayList;
import java.util.List;



    public class MenuAlumno {
        private final Alumno alumno;
        private GrupoCrud grupoCrud;

        public MenuAlumno(Alumno alumno, GrupoCrud grupoCrud) {
            this.alumno = alumno;
            this.grupoCrud = grupoCrud;
        }

        public void mostrarMenu() {
            Menu menuAlumno = new Menu();
            menuAlumno.addMenuItem(1, new MenuItem("Ver Información Personal", new ControllerVerInformacionPersonalAlumno(alumno), new ArrayList<>(List.of(Permission.READ))));
            menuAlumno.addMenuItem(2, new MenuItem("Ver Calificaciones", new ControllerVerCalificacionesAlumno(alumno), new ArrayList<>(List.of(Permission.READ))));
            menuAlumno.addMenuItem(3, new MenuItem("Ver Mis Grupos", new ControllerVerMisGruposAlumno(alumno, grupoCrud), new ArrayList<>(List.of(Permission.READ))));
            menuAlumno.addMenuItem(4, new MenuItem("Ver Historial Académico", new ControllerVerHistorialAcademicoAlumno(alumno), new ArrayList<>(List.of(Permission.READ))));
            menuAlumno.addMenuItem(0, new MenuItem("Salir", new SalirController(), new ArrayList<>(List.of(Permission.READ))));

            int opcion;
            do {
                menuAlumno.display("\nMenú Alumno");
                opcion = AskData.inputInteger("Opción: ", new IntegerValidator() {
                    @Override
                    public boolean integerValidator(int value) {
                        return menuAlumno.getMenuItems().containsKey(value); // Validar si la opción existe en el menú
                    }
                }); // Validación de opciones
                if (opcion != 0) {
                    menuAlumno.getMenuItems().get(opcion).getController().execute(null);
                }
            } while (opcion != 0); // Repetir hasta que el usuario elija salir
        }
    }