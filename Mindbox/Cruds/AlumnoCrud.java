package Cruds;

import Modelo.Alumno;
import Modelo.Carrera;
import Modelo.Grupo;
import Modelo.Semestre;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlumnoCrud {
    private List<Alumno> alumnos;
    private Scanner sc;
    private static final String FILE_NAME = "alumnos.json";

    public AlumnoCrud() {
        this.alumnos = cargarAlumnos(FILE_NAME);
        this.sc = new Scanner(System.in);
    }

    public void crearAlumno() {
        System.out.println("Ingrese nombre del alumno: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellido del alumno: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese fecha de nacimiento del alumno (YYYY-MM-DD): ");
        String fechaNacimiento = sc.nextLine();
        System.out.println("Ingrese sexo del alumno (H/M): ");
        String sexo = sc.nextLine();
        System.out.println("Ingrese ciudad del alumno: ");
        String ciudad = sc.nextLine();
        System.out.println("Ingrese estado del alumno: ");
        String estado = sc.nextLine();
        System.out.println("Ingrese direccion del alumno: ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese carrera del alumno: ");
        int carrera = sc.nextInt();
        System.out.println("Ingrese semestre del alumno: ");
        int semestre = sc.nextInt();
        System.out.println("Ingrese grupo del alumno: ");
        int grupo = sc.nextInt();
        System.out.println("Ingrese nombre de usuario del alumno: ");
        String nombreUsuario = sc.nextLine();
        System.out.println("Ingrese contraseña del alumno: ");
        String contrasena = sc.nextLine();


        Alumno alumno = new Alumno(nombre, apellido, fechaNacimiento, sexo, ciudad, estado, direccion, LocalDate.now().toString(), carrera, semestre, grupo, nombreUsuario, contrasena);

        if (alumno.validar(alumnos)) {
            alumnos.add(alumno);
            guardarAlumnos(alumnos, FILE_NAME);
            System.out.println("Alumno creado exitosamente.");
        } else {
            System.out.println("Error al crear el alumno. Verifique los datos ingresados.");
        }
    }

    public void eliminarAlumno(int id) {
        Alumno alumno = obtenerAlumnoPorId(id);
        if (alumno != null) {
            alumnos.remove(alumno);
            guardarAlumnos(alumnos, FILE_NAME);
            System.out.println("Alumno eliminado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    public void modificarAlumno(int id) {
        Alumno alumno = obtenerAlumnoPorId(id);
        if (alumno != null) {
            System.out.println("Ingrese nombre del alumno: ");
            alumno.setNombre(sc.nextLine());
            System.out.println("Ingrese apellido del alumno: ");
            alumno.setApellidos(sc.nextLine());
            System.out.println("Ingrese fecha de nacimiento del alumno (YYYY-MM-DD): ");
            alumno.setFechaNacimiento(sc.nextLine());
            System.out.println("Ingrese ciudad del alumno: ");
            alumno.setCiudad(sc.nextLine());
            System.out.println("Ingrese estado del alumno: ");
            alumno.setEstado(sc.nextLine());
            System.out.println("Ingrese direccion del alumno: ");
            alumno.setDireccion(sc.nextLine());
            System.out.println("Ingrese carrera del alumno: ");
            alumno.setCarrera(sc.nextInt());
            System.out.println("Ingrese semestre del alumno: ");
            alumno.setSemestre(sc.nextInt());


            guardarAlumnos(alumnos, FILE_NAME);
            System.out.println("Alumno modificado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    private Alumno obtenerAlumnoPorId(int id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getIdUsuario() == id) {
                return alumno;
            }
        }
        return null;
    }

    private static void guardarAlumnos(List<Alumno> alumnos, String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(alumnos);
            Files.write(Paths.get(nombreArchivo), json.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar alumnos en JSON: " + e.getMessage());
        }
    }

    private static List<Alumno> cargarAlumnos(String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
            return gson.fromJson(json, new TypeToken<List<Alumno>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>(); // Si no existe el archivo o hay error, devolver una lista vacía
        }
    }
}