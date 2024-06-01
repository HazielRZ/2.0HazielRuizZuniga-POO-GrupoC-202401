package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.GestorEntidades;
import utils.GestorId;
import utils.ValidadorCURP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Alumno extends Usuario {
    private int carrera;
    private int semestre;
    private int grupo;
    private double promedio;
    String numeroControl = generarNumeroControl(carrera);

    // Constructor
    public Alumno(String nombre, String apellidos, String fechaNacimiento, String sexo, String ciudad, String estado,
                  String direccion, String fechaRegistro, int carrera, int semestre, int grupo,
                  String nombreUsuario, String contrasena) {
        super(nombre, apellidos, fechaNacimiento, sexo, ciudad, estado, direccion, fechaRegistro, "Alumno", nombreUsuario, contrasena);
        GestorId gestorId = GestorId.getInstancia();
        this.idUsuario = gestorId.generarIdAlumno();
        this.carrera = carrera;
        this.semestre = semestre;
        this.grupo = grupo;
        this.promedio = 0.0;
        this.numeroControl = generarNumeroControl(carrera);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;

    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo.getIdGrupo();
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
    private String generarNumeroControl(int carreraId) {
        String primeraLetra = this.nombre.substring(0, 1).toUpperCase();
        String anio = String.valueOf(LocalDate.now().getYear()).substring(2);
        // Obtén la abreviatura de la carrera usando su ID
        String abreviaturaCarrera = GestorEntidades.getInstancia().obtenerCarreraPorId(carreraId).getAbreviatura();
        return "l" + primeraLetra + anio + abreviaturaCarrera;
    }

    // Otros métodos específicos de Alumno (calcular promedio, etc.)
    // ...
}
