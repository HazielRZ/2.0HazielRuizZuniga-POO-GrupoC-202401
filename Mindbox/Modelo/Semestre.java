package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.GestorId;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Semestre {

    private int idSemestre;
    private int numeroSemestre; // 1, 2 o 3
    private Carrera carrera;
    private List<Grupo> grupos;

    // Constructor
    public Semestre(int numeroSemestre, Carrera carrera) {
        GestorId gestorId = GestorId.getInstancia();
        this.idSemestre = gestorId.generarIdSemestre();
        this.numeroSemestre = numeroSemestre;
        this.carrera = carrera;
        this.grupos = new ArrayList<>();
    }

    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    public int getNumeroSemestre() {
        return numeroSemestre;
    }

    public void setNumeroSemestre(int numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    // Método para avanzar de semestre
    public void avanzarSemestre(Grupo grupo) {
        if (numeroSemestre == 3) {
            // Graduar alumnos
            // ... (implementar lógica de graduación)
            return;
        }

        if (!todosAlumnosAprobados(grupo) || !todasCalificacionesRegistradas(grupo)) {
            throw new RuntimeException("No se puede avanzar el semestre. Verificar calificaciones.");
        }

        grupo.setSemestre(new Semestre(numeroSemestre + 1, carrera));
        // Asignar nuevas materias al grupo (implementar lógica de asignación)
        // ...
    }

    // Métodos de validación
    private boolean todosAlumnosAprobados(Grupo grupo) {
        // Verificar si todos los alumnos del grupo aprobaron todas las materias
        // ... (implementar lógica de verificación)
        return true; // Reemplazar con la lógica real
    }

    private boolean todasCalificacionesRegistradas(Grupo grupo) {
        // Verificar si todos los alumnos del grupo tienen calificaciones en todas las materias
        // ... (implementar lógica de verificación)
        return true; // Reemplazar con la lógica real
    }

    // Métodos para guardar/cargar semestres en JSON
    public static void guardarSemestres(List<Semestre> semestres, String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(semestres);
        Files.write(Paths.get(nombreArchivo), json.getBytes());
    }

    public static List<Semestre> cargarSemestres(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        return gson.fromJson(json, new TypeToken<List<Semestre>>() {}.getType());
    }
}