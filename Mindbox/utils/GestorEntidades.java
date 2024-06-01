package utils;

import Modelo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorEntidades {
    private Map<Integer, Alumno> alumnos;
    private Map<Integer, Profesor> profesores;
    private Map<Integer, Coordinador> coordinadores;
    private Map<Integer, Semestre> semestres;
    private Map<Integer, Carrera> carreras;
    private Map<Integer, Grupo> grupos;

    private static GestorEntidades instancia;

    private GestorEntidades() {
        this.alumnos = new HashMap<>();
        this.profesores = new HashMap<>();
        this.coordinadores = new HashMap<>();
        this.semestres = new HashMap<>();
        this.carreras = new HashMap<>();
        this.grupos = new HashMap<>();
    }

    public static GestorEntidades getInstancia() {
        if (instancia == null) {
            instancia = new GestorEntidades();
        }
        return instancia;
    }

    // Métodos para gestionar alumnos
    public Alumno obtenerAlumnoPorId(int id) {
        return alumnos.get(id);
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.put(alumno.getIdUsuario(), alumno);
    }

    // Métodos para gestionar profesores
    public Profesor obtenerProfesorPorId(int id) {
        return profesores.get(id);
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.put(profesor.getIdUsuario(), profesor);
    }

    // Métodos para gestionar coordinadores
    public Coordinador obtenerCoordinadorPorId(int id) {
        return coordinadores.get(id);
    }

    public void agregarCoordinador(Coordinador coordinador) {
        coordinadores.put(coordinador.getIdUsuario(), coordinador);
    }

    // Métodos para gestionar semestres
    public Semestre obtenerSemestrePorId(int id) {
        return semestres.get(id);
    }

    public void agregarSemestre(Semestre semestre) {
        semestres.put(semestre.getIdSemestre(), semestre);
    }

    // Métodos para gestionar carreras
    public Carrera obtenerCarreraPorId(int id) {
        return carreras.get(id);
    }

    public void agregarCarrera(Carrera carrera) {
        carreras.put(carrera.getIdCarrera(), carrera);
    }

    // Métodos para gestionar grupos
    public Grupo obtenerGrupoPorId(int id) {
        return grupos.get(id);
    }

    public void agregarGrupo(Grupo grupo) {
        grupos.put(grupo.getIdGrupo(), grupo);
    }

    // Métodos adicionales para gestión y relaciones
    public void asignarSemestreAGrupo(int idGrupo, int idSemestre) {
        Grupo grupo = obtenerGrupoPorId(idGrupo);
        Semestre semestre = obtenerSemestrePorId(idSemestre);
        if (grupo != null && semestre != null) {
            grupo.setSemestre(semestre);
        }
    }

    public void asignarCarreraASemestre(int idSemestre, int idCarrera) {
        Semestre semestre = obtenerSemestrePorId(idSemestre);
        Carrera carrera = obtenerCarreraPorId(idCarrera);
        if (semestre != null && carrera != null) {
            semestre.setCarrera(carrera);
        }
    }

    // Métodos para cargar datos desde JSON
    public void cargarDatosDesdeJson() {
        // Implementar lógica para cargar datos desde JSON y rellenar los mapas
    }

    // Métodos para guardar datos en JSON
    public void guardarDatosEnJson() {
        // Implementar lógica para guardar datos en JSON desde los mapas
    }



}