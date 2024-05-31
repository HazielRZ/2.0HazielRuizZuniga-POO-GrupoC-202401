package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistorialAcademico {
    private Alumno alumno;
    private List<RegistroSemestral> registros;

    public HistorialAcademico(Alumno alumno) {
        this.alumno = alumno;
        this.registros = new ArrayList<>();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setRegistros(List<RegistroSemestral> registros) {
        this.registros = registros;
    }

    public void agregarRegistroSemestral(RegistroSemestral registro) {
        registros.add(registro);
    }

    public List<RegistroSemestral> getRegistros() {
        return registros;
    }

    // Método para guardar/cargar historiales en JSON
    public static void guardarHistoriales(List<HistorialAcademico> historiales, String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(historiales);
        Files.write(Paths.get(nombreArchivo), json.getBytes());
    }

    public static List<HistorialAcademico> cargarHistoriales(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        return gson.fromJson(json, new TypeToken<List<HistorialAcademico>>() {}.getType());
    }

    // Clase interna para representar un registro semestral
    public static class RegistroSemestral {
        private int semestre;
        private List<Materia> materias;
        private Map<Materia, Double> calificaciones;
        private Map<Materia, Profesor> profesores;

        public RegistroSemestral(int semestre, List<Materia> materias) {
            this.semestre = semestre;
            this.materias = materias;
            this.calificaciones = new HashMap<>();
            this.profesores = new HashMap<>();
            for (Materia materia : materias) {
                this.profesores.put(materia, materia.getProfesor()); // Asigna el profesor de la materia
            }
        }

        public int getSemestre() {
            return semestre;
        }

        public void setSemestre(int semestre) {
            this.semestre = semestre;
        }

        public List<Materia> getMaterias() {
            return materias;
        }

        public void setMaterias(List<Materia> materias) {
            this.materias = materias;
        }

        public Map<Materia, Double> getCalificaciones() {
            return calificaciones;
        }

        public void setCalificaciones(Map<Materia, Double> calificaciones) {
            this.calificaciones = calificaciones;
        }

        public Map<Materia, Profesor> getProfesores() {
            return profesores;
        }

        public void setProfesores(Map<Materia, Profesor> profesores) {
            this.profesores = profesores;
        }

        public void agregarCalificacion(Materia materia, double calificacion) {
            calificaciones.put(materia, calificacion);
        }
    }
}