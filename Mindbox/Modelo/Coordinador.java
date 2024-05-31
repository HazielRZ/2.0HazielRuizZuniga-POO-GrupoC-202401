package Modelo;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.GestorId;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Coordinador extends Empleado {
    private Carrera carrera;

    // Constructor
    public Coordinador(String nombre, String apellidos, String fechaNacimiento, String sexo, String ciudad, String estado,
                       String direccion,String fechaRegistro, double sueldo, Carrera carrera) {
        super(nombre, apellidos, fechaNacimiento, sexo, ciudad, estado, direccion, fechaRegistro, "Coordinador", sueldo);
        GestorId gestorId = GestorId.getInstancia();
        this.idUsuario = gestorId.generarIdProfesor();
        this.carrera = carrera;
    }

    // Getters y Setters

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    // Métodos CRUD
    public static void crearCoordinador(Coordinador coordinador, List<Coordinador> coordinadores) {
        if (coordinador.validar(coordinadores)) { // Validar antes de agregar
            coordinadores.add(coordinador);
            guardarCoordinadores(coordinadores, "coordinadores.json");
        } else {
            throw new RuntimeException("No se pudo crear el coordinador. Verificar validaciones.");
        }
    }


    // ... (métodos obtenerCoordinadorPorId, actualizarCoordinador, eliminarCoordinador similares a Alumno)

    // Método para guardar/cargar coordinadores en JSON
    public static void guardarCoordinadores(List<Coordinador> coordinadores, String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(coordinadores);
            Files.write(Paths.get(nombreArchivo), json.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar coordinadores en JSON: " + e.getMessage());
        }
    }

    public static List<Coordinador> cargarCoordinadores(String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
            return gson.fromJson(json, new TypeToken<List<Coordinador>>() {}.getType());
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar coordinadores desde JSON: " + e.getMessage());
        }
    }

    // Validaciones
    public boolean validar(List<Coordinador> coordinadores) {
        return validarCarreraUnica(coordinadores) ; // Validar
    }

    private boolean validarCarreraUnica(List<Coordinador> coordinadores) {
        for (Coordinador c : coordinadores) {
            if (c.getCarrera().equals(this.carrera)) {
                return false; // Ya existe un coordinador para esta carrera
            }
        }
        return true;
    }

    // Generación del número de control
    private String generarNumeroControl() {
        String primeraLetra = this.nombre.substring(0, 1).toUpperCase();
        String anio = String.valueOf(LocalDate.now().getYear()).substring(2);
        return "C" + primeraLetra + anio + carrera.getAbreviatura();
    }

    // Otros métodos específicos de Coordinador (avanzar semestre, etc.)
    // ...
}