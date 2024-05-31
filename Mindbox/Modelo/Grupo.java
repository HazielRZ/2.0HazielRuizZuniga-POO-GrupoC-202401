package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.GestorId;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Grupo {

    private int idGrupo;
    private String tipoGrupo; // "A" o "B"
    private Carrera carrera;
    private List<Alumno> alumnos;
    private List<Materia> materias;
    private Semestre semestre;

    // Constructor
    public Grupo(String tipoGrupo, Carrera carrera, Semestre semestre) {
        GestorId gestorId = GestorId.getInstancia();
        this.idGrupo = gestorId.generarIdGrupo();
        this.tipoGrupo = tipoGrupo;
        this.carrera = carrera;
        this.alumnos = new ArrayList<>();
        this.materias = new ArrayList<>();
        this.semestre = semestre;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    // Métodos para agregar/eliminar alumnos y materias
    public void agregarAlumno(Alumno alumno) {
        if (alumnos.size() < 20) {
            alumnos.add(alumno);
            alumno.setGrupo(this); // Establecer la relación bidireccional
        } else {
            throw new RuntimeException("No se pueden agregar más alumnos al grupo (máximo 20).");
        }
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnos.remove(alumno);
        alumno.setGrupo(null); // Eliminar la relación bidireccional
    }

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public void eliminarMateria(Materia materia) {
        materias.remove(materia);
    }

    // Métodos para guardar/cargar grupos en JSON
    public static void guardarGrupos(List<Grupo> grupos, String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(grupos);
        Files.write(Paths.get(nombreArchivo), json.getBytes());
    }

    public static List<Grupo> cargarGrupos(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        return gson.fromJson(json, new TypeToken<List<Grupo>>() {}.getType());
    }

    // Validaciones (puedes agregar más según tus necesidades)
    public boolean validarNumeroAlumnos() {
        return alumnos.size() >= 3 && alumnos.size() <= 20;
    }

    public boolean validarIdUnico(List<Grupo> grupos) {
        for (Grupo grupo : grupos) {
            if (grupo.getIdGrupo() == this.idGrupo) {
                return false; // ID duplicado
            }
        }
        return true; // ID único
    }
}
