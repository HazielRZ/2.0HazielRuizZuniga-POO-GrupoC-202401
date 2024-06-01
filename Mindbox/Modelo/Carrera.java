package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.GestorId;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrera {

    private static int idCarrera;
    private String nombre;
    private int cantidadGrupos;
    private int cantidadAlumnos;
    private int cantidadMaterias;

    private Coordinador coordinador;

    // Constructor
    public Carrera(String nombre, Coordinador coordinador) {
        GestorId gestorId = GestorId.getInstancia();
        this.idCarrera = gestorId.generarIdCarrera();
        this.nombre = nombre;
        this.cantidadGrupos = 0;
        this.cantidadAlumnos = 0;
        this.cantidadMaterias = 0;

        this.coordinador = coordinador;
    }

    public static int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadGrupos() {
        return cantidadGrupos;
    }

    public void setCantidadGrupos(int cantidadGrupos) {
        this.cantidadGrupos = cantidadGrupos;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }



    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    // Métodos para guardar/cargar carreras en JSON
    public static void guardarCarreras(List<Carrera> carreras, String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(carreras);
        Files.write(Paths.get(nombreArchivo), json.getBytes());
    }

    public static List<Carrera> cargarCarreras(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        return gson.fromJson(json, new TypeToken<List<Carrera>>() {}.getType());
    }

    // Validaciones (puedes agregar más según tus necesidades)
    public boolean validarIdUnico(List<Carrera> carreras) {
        for (Carrera carrera : carreras) {
            if (carrera.getIdCarrera() == this.idCarrera) {
                return false; // ID duplicado
            }
        }
        return true; // ID único
    }

    private static final Map<String, String> ABREVIATURAS = new HashMap<>();

    static {
        ABREVIATURAS.put("Ingeniería en Sistemas Computacionales", "ISC");
        ABREVIATURAS.put("Ingeniería en Materiales", "IMAT");
        ABREVIATURAS.put("Ingeniería Electrónica", "ELC");
    }

    public String getAbreviatura() {
        return ABREVIATURAS.get(this.nombre);
    }
}
