package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.GestorId;
import utils.ValidadorCURP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Alumno extends Usuario {
    private Carrera carrera;
    private Semestre semestre;
    private Grupo grupo;
    private double promedio;
    private String numeroControl;

    // Constructor
    public Alumno(String nombre, String apellidos, String fechaNacimiento, String sexo, String ciudad, String estado,
                  String direccion, String fechaRegistro, Carrera carrera, Semestre semestre, Grupo grupo) {
        super(nombre, apellidos, fechaNacimiento, sexo, ciudad, estado, direccion, fechaRegistro, "Alumno");
        GestorId gestorId = GestorId.getInstancia();
        this.idUsuario = gestorId.generarIdAlumno();
        this.carrera = carrera;
        this.semestre = semestre;
        this.grupo = grupo;
        this.promedio = 0.0;
        this.numeroControl = generarNumeroControl();
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    // Métodos CRUD
    public static void crearAlumno(Alumno alumno, List<Alumno> alumnos) {
        if (alumno.validar(alumnos)) {
            alumnos.add(alumno);
            guardarAlumnos(alumnos, "alumnos.json");
        } else {
            throw new RuntimeException("No se pudo crear el alumno. Verificar validaciones.");
        }
    }

    public static Alumno obtenerAlumnoPorId(int id, List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            if (alumno.getIdUsuario() == id) {
                return alumno;
            }
        }
        return null;
    }

    public static void actualizarAlumno(Alumno alumno, List<Alumno> alumnos) {
        int index = alumnos.indexOf(alumno);
        if (index != -1) {
            alumnos.set(index, alumno);
            guardarAlumnos(alumnos, "alumnos.json");
        } else {
            throw new RuntimeException("No se pudo actualizar el alumno. No encontrado.");
        }
    }

    public static void eliminarAlumno(Alumno alumno, List<Alumno> alumnos) {
        if (alumnos.remove(alumno)) {
            guardarAlumnos(alumnos, "alumnos.json");
        } else {
            throw new RuntimeException("No se pudo eliminar el alumno. No encontrado.");
        }
    }

    // Método para guardar/cargar alumnos en JSON
    public static void guardarAlumnos(List<Alumno> alumnos, String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(alumnos);
            Files.write(Paths.get(nombreArchivo), json.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar alumnos en JSON: " + e.getMessage());
        }
    }

    public static List<Alumno> cargarAlumnos(String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
            return gson.fromJson(json, new TypeToken<List<Alumno>>() {}.getType());
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar alumnos desde JSON: " + e.getMessage());
        }
    }

    // Validaciones
    public boolean validar(List<Alumno> alumnos) {
        return validarNumeroControlUnico(alumnos) && ValidadorCURP.validarCURP(this.curp);
    }

    private boolean validarNumeroControlUnico(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNumeroControl().equals(this.numeroControl)) {
                return false;
            }
        }
        return true;
    }

    // Generación del número de control
    private String generarNumeroControl() {
        String primeraLetra = this.nombre.substring(0, 1).toUpperCase();
        String anio = String.valueOf(LocalDate.now().getYear()).substring(2);
        return "l" + primeraLetra + anio + carrera.getAbreviatura();
    }

    // Otros métodos específicos de Alumno (calcular promedio, etc.)
    // ...
}
