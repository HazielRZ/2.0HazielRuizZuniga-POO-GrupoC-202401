package Cruds;

import Modelo.Materia;
import Modelo.Profesor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfesorCrud {
    private List<Profesor> profesores;

    private Scanner sc;
    private static final String FILE_NAME = "profesores.json";

    public ProfesorCrud() {
        this.profesores = cargarProfesores(FILE_NAME);
        this.sc = new Scanner(System.in);
    }
    private List<Materia> obtenerMateriasPorIds(List<Integer> materiasIds, List<Materia> todasLasMaterias) {
        List<Materia> materiasSeleccionadas = new ArrayList<>();
        for (Integer id : materiasIds) {
            for (Materia materia : todasLasMaterias) {
                if (materia.getIdMateria() == id) {
                    materiasSeleccionadas.add(materia);
                    break;
                }
            }
        }
        return materiasSeleccionadas;
    }
    public void crearProfesor() {
        System.out.println("Ingrese nombre del profesor: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellido del profesor: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese fecha de nacimiento del profesor (YYYY-MM-DD): ");
        String fechaNacimiento = sc.nextLine();
        System.out.println("Ingrese sexo del profesor (H/M): ");
        String sexo = sc.nextLine();
        System.out.println("Ingrese ciudad del profesor: ");
        String ciudad = sc.nextLine();
        System.out.println("Ingrese estado del profesor: ");
        String estado = sc.nextLine();
        System.out.println("Ingrese dirección del profesor: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese fecha de registro del profesor (YYYY-MM-DD): ");
        String fechaRegistro = sc.nextLine();
        System.out.println("Ingrese sueldo del profesor: ");
        double sueldo = sc.nextDouble();
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese nombre de usuario : ");
        String nombreUsuario = sc.nextLine();
        System.out.println("Ingrese contraseña : ");
        String contrasena = sc.nextLine();

        // Obtener IDs de las materias que imparte el profesor
        List<Integer> materiasIds = obtenerIdsMaterias();
        List<Materia> materiasSeleccionadas = null;
        try {
            materiasSeleccionadas = obtenerMateriasPorIds(materiasIds, Materia.cargarMaterias("materias.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Crear instancia de profesor con las materias correspondientes
        Profesor profesor = new Profesor(nombre, apellido, fechaNacimiento, sexo, ciudad, estado, direccion, fechaRegistro,  sueldo, materiasSeleccionadas, nombreUsuario, contrasena);

        // Agregar el profesor a la lista y guardar en archivo
        profesores.add(profesor);
        guardarProfesores(profesores, FILE_NAME);
        System.out.println("Profesor creado exitosamente.");
    }
    //  obtener los ID de las materias que imparte el profesor
    private List<Integer> obtenerIdsMaterias() {
        List<Integer> materiasIds = new ArrayList<>();
        System.out.println("Ingrese IDs de las materias que imparte el profesor (separados por comas): ");
        String input = sc.nextLine();
        String[] ids = input.split(",");
        for (String id : ids) {
            try {
                int materiaId = Integer.parseInt(id.trim());
                materiasIds.add(materiaId);
            } catch (NumberFormatException e) {
                System.out.println("ID no válido: " + id.trim());
            }
        }
        return materiasIds;
    }

    public void eliminarProfesor(int id) {
        Profesor profesor = obtenerProfesorPorId(id);
        if (profesor != null) {
            profesores.remove(profesor);
            guardarProfesores(profesores, FILE_NAME);
            System.out.println("Profesor eliminado exitosamente.");
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    public void modificarProfesor(int id) {
        Profesor profesor = obtenerProfesorPorId(id);
        if (profesor != null) {
            System.out.println("Ingrese nombre del profesor: ");
            profesor.setNombre(sc.nextLine());
            System.out.println("Ingrese apellido del profesor: ");
            profesor.setApellidos(sc.nextLine());
            System.out.println("Ingrese fecha de nacimiento del profesor (YYYY-MM-DD): ");
            profesor.setFechaNacimiento(sc.nextLine());
            System.out.println("Ingrese ciudad del profesor: ");
            profesor.setCiudad(sc.nextLine());
            System.out.println("Ingrese estado del profesor: ");
            profesor.setEstado(sc.nextLine());
            System.out.println("Ingrese CURP del profesor: ");
            profesor.setCurp(sc.nextLine());
            System.out.println("Ingrese materias que imparte el profesor (separadas por comas): ");
            String materiasInput = sc.nextLine();
            List<Materia> materiasImpartidas = new ArrayList<>();
            String[] materias = materiasInput.split(",");


            System.out.println("Ingrese sueldo del profesor: ");
            profesor.setSueldo(sc.nextDouble());
            sc.nextLine(); // Consumir el salto de línea pendiente

            guardarProfesores(profesores, FILE_NAME);
            System.out.println("Profesor modificado exitosamente.");
        } else {
            System.out.println("Profesor no encontrado.");
        }
    }

    private Profesor obtenerProfesorPorId(int id) {
        for (Profesor profesor : profesores) {
            if (profesor.getIdUsuario() == id) {
                return profesor;
            }
        }
        return null;
    }

    private static void guardarProfesores(List<Profesor> profesores, String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(profesores);
            Files.write(Paths.get(nombreArchivo), json.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar profesores en JSON: " + e.getMessage());
        }
    }

    private static List<Profesor> cargarProfesores(String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
            return gson.fromJson(json, new TypeToken<List<Profesor>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>(); // Si no existe el archivo o hay error, devolver una lista vacía
        }
    }

}