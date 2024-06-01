package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.ValidadorRFC; // Clase para validar y generar RFC

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Profesor extends Empleado {

    // Constructor
    public Profesor(String nombre, String apellidos, String fechaNacimiento, String sexo, String ciudad, String estado,
                    String direccion, String fechaRegistro, double sueldo, List<Materia> materiasSeleccionadas, String nombreUsuario, String contrasena) {
        super(nombre, apellidos, fechaNacimiento, sexo, ciudad, estado, direccion, fechaRegistro, "Profesor", sueldo, nombreUsuario,contrasena);

        this.rfc = ValidadorRFC.generarRFC(this); // Generar RFC para el profesor
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;

    }

    // Métodos CRUD
    public static void crearProfesor(Profesor profesor, List<Profesor> profesores) {
        if (profesor.validar(profesores)) {
            profesores.add(profesor);
            guardarProfesores(profesores, "profesores.json");
        } else {
            throw new RuntimeException("No se pudo crear el profesor. Verificar validaciones.");
        }
    }

    // ... (métodos obtenerProfesorPorId, actualizarProfesor, eliminarProfesor similares a Alumno)

    // Método para guardar/cargar profesores en JSON
    public static void guardarProfesores(List<Profesor> profesores, String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(profesores);
            Files.write(Paths.get(nombreArchivo), json.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar profesores en JSON: " + e.getMessage());
        }
    }

    public static List<Profesor> cargarProfesores(String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
            return gson.fromJson(json, new TypeToken<List<Profesor>>() {}.getType());
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar profesores desde JSON: " + e.getMessage());
        }
    }

    // Validaciones
    public boolean validar(List<Profesor> profesores) {
        return validarRFCUnico(profesores) && ValidadorRFC.validarRFC(this.rfc);
    }

    private boolean validarRFCUnico(List<Profesor> profesores) {
        for (Profesor profesor : profesores) {
            if (profesor.getRfc().equals(this.rfc)) {
                return false;
            }
        }
        return true;
    }

    // Generación del número de control
    private String generarNumeroControl() {
        String primeraLetra = this.nombre.substring(0, 1).toUpperCase();
        String anio = String.valueOf(LocalDate.now().getYear()).substring(2);
        return "M" + primeraLetra + anio;
    }

    // Otros métodos específicos de Profesor
    public void agregarMateria(Materia materia) {
        materiasImpartidas.add(materia);
    }

    public void eliminarMateria(Materia materia) {
        materiasImpartidas.remove(materia);
    }

    @Override
    public void setMateriasImpartidas(List<Materia> materiasImpartidas) {
        super.setMateriasImpartidas(materiasImpartidas);
    }

    @Override
    public List<Materia> getMateriasImpartidas() {
        return super.getMateriasImpartidas();
    }
    // ... (otros métodos para asignar/modificar calificaciones, etc.)
}
