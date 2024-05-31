package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.GestorId;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Materia {

    private int idMateria;
    private String nombre;
    private Carrera carrera;
    private Grupo grupo;
    private Profesor profesor;

    // Constructor
    public Materia(String nombre, Carrera carrera, Grupo grupo, Profesor profesor) {
        GestorId gestorId = GestorId.getInstancia();
        this.idMateria = gestorId.generarIdMateria();
        this.nombre = nombre;
        this.carrera = carrera;
        this.grupo = grupo;
        this.profesor = profesor;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    // Métodos para guardar/cargar materias en JSON
    public static void guardarMaterias(List<Materia> materias, String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(materias);
        Files.write(Paths.get(nombreArchivo), json.getBytes());
    }

    public static List<Materia> cargarMaterias(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        return gson.fromJson(json, new TypeToken<List<Materia>>() {}.getType());
    }

    // Validaciones (puedes agregar más según tus necesidades)
    public boolean validarIdUnico(List<Materia> materias) {
        for (Materia materia : materias) {
            if (materia.getIdMateria() == this.idMateria) {
                return false; // ID duplicado
            }
        }
        return true; // ID único
    }
}
