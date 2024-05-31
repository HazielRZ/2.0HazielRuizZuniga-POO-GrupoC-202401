package utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GestorId {

    private int contadorCarreras = 1;
    private int contadorSemestres = 1;
    private int contadorGrupos = 1;
    private int contadorMaterias = 1;
    private int contadorAlumnos = 1;
    private int contadorProfesores = 1;

    // Singleton para asegurar una única instancia del utils.GestorId
    private static GestorId instancia = null;

    private GestorId() {}

    public static GestorId getInstancia() {
        if (instancia == null) {
            instancia = new GestorId();
            try {
                instancia.cargarContadores("contadores.json"); // Intenta cargar los contadores al inicio
            } catch (IOException e) {
                // Si el archivo no existe, se usarán los valores iniciales de los contadores
                System.out.println("No se pudieron cargar los contadores: " + e.getMessage());
            }
        }
        return instancia;
    }

    // Métodos para generar IDs
    public int generarIdCarrera() {
        return contadorCarreras++;
    }

    public int generarIdSemestre() {
        return contadorSemestres++;
    }

    public int generarIdGrupo() {
        return contadorGrupos++;
    }

    public int generarIdMateria() {
        return contadorMaterias++;
    }

    public int generarIdAlumno() {
        return contadorAlumnos++;
    }

    public int generarIdProfesor() {
        return contadorProfesores++;
    }

    // Métodos para guardar/cargar contadores desde/hacia JSON
    public void guardarContadores(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        Files.write(Paths.get(nombreArchivo), json.getBytes());
    }

    public void cargarContadores(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        GestorId datos = gson.fromJson(json, GestorId.class);
        this.contadorCarreras = datos.contadorCarreras;
        this.contadorSemestres = datos.contadorSemestres;
        this.contadorGrupos = datos.contadorGrupos;
        this.contadorMaterias = datos.contadorMaterias;
        this.contadorAlumnos = datos.contadorAlumnos;
        this.contadorProfesores = datos.contadorProfesores;
    }
}