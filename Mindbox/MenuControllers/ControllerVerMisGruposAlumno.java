package MenuControllers;

import Cruds.GrupoCrud;
import Menu.Controller;
import Modelo.Alumno;
import Modelo.Grupo;
import Modelo.Materia;

public class ControllerVerMisGruposAlumno implements Controller {
    private Alumno alumno;
    private GrupoCrud grupoCrud;

    public ControllerVerMisGruposAlumno(Alumno alumno, GrupoCrud grupoCrud) {
        this.alumno = alumno;
        this.grupoCrud = grupoCrud;
    }

    @Override
    public void execute() {
        verMisGrupos();
    }

    private void verMisGrupos() {
        int idGrupo = alumno.getGrupo();
        Grupo grupo = grupoCrud.obtenerGrupoPorId(idGrupo);

        if (grupo != null) {
            System.out.println("\nMi Grupo:");
            System.out.println("Materias:");
            for (Materia materia : grupo.getMaterias()) {
                System.out.println("- " + materia.getNombre());
            }
        } else {
            System.out.println("No se encontró el grupo del alumno.");
        }
    }
    }

