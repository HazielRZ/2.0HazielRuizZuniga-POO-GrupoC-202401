package Cruds;

import Modelo.Carrera;
import Modelo.Coordinador;

import Modelo.Materia;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import utils.GestorEntidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoordinadorCrud {
    private List<Coordinador> coordinadores;
    private Scanner sc;
    private static final String FILE_NAME = "coordinadores.json";
    private GestorEntidades gestorEntidades;

    public CoordinadorCrud() {
        this.gestorEntidades = GestorEntidades.getInstancia();
        this.coordinadores = cargarCoordinadores(FILE_NAME);
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
    private Carrera obtenerCarrerasPorIds(List<Integer> carrerasIds, List<Carrera> todasLasCarreras) {
        for (Integer id : carrerasIds) {
            for (Carrera carrera : todasLasCarreras) {
                if (Carrera.getIdCarrera() == id) {
                    return carrera;
                }
            }
        }
        return null;
    }




    public void crearCoordinador() {
        System.out.println("Ingrese nombre del coordinador: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellido del coordinador: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese fecha de nacimiento del coordinador (YYYY-MM-DD): ");
        String fechaNacimiento = sc.nextLine();
        System.out.println("Ingrese sexo del coordinador (H/M): ");
        String sexo = sc.nextLine();
        System.out.println("Ingrese ciudad : ");
        String ciudad = sc.nextLine();
        System.out.println("Ingrese estado : ");
        String estado = sc.nextLine();
        System.out.println("Ingrese dirección : ");
        String direccion = sc.nextLine();
        System.out.println("Ingrese fecha de registro  (YYYY-MM-DD): ");
        String fechaRegistro = sc.nextLine();

        System.out.println("Ingrese sueldo: ");
        double sueldo = sc.nextDouble();
        System.out.println("Ingrese nombre de usuario : ");
        String nombreUsuario = sc.nextLine();
        System.out.println("Ingrese contraseña : ");
        String contrasena = sc.nextLine();
        sc.nextLine(); // Consumir el salto de línea pendiente

        // Obtener IDs de las materias que imparte el profesor
        List<Integer> materiasIds = obtenerIdsMaterias();
        List<Materia> materiasSeleccionadas = null;
        try {
            materiasSeleccionadas = obtenerMateriasPorIds(materiasIds, Materia.cargarMaterias("materias.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Obtener IDs de las carreras
        List<Integer> carrerasIds = obtenerIdsCarreras();
        Carrera carreras = null;
        try {
            carreras = obtenerCarrerasPorIds(carrerasIds, Carrera.cargarCarreras("carreras.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.nextLine(); // Consumir el salto de línea pendiente

        Coordinador coordinador = new Coordinador(nombre, apellido, fechaNacimiento, sexo, ciudad, estado, direccion, fechaRegistro,  sueldo, carreras, nombreUsuario, contrasena);

        coordinadores.add(coordinador);
        gestorEntidades.agregarCoordinador(coordinador);
        guardarCoordinadores(coordinadores, FILE_NAME);
        System.out.println("Coordinador creado exitosamente.");
    }
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
    private List<Integer> obtenerIdsCarreras() {
        List<Integer> carrerasIds = new ArrayList<>();
        System.out.println("Ingrese ID de la carrera: ");
        String input = sc.nextLine();
        String[] ids = input.split(",");
        for (String id : ids) {
            try {
                int carreraId = Integer.parseInt(id.trim());
                carrerasIds.add(carreraId);
            } catch (NumberFormatException e) {
                System.out.println("ID no válido: " + id.trim());
            }
        }
        return carrerasIds;
    }
    public void eliminarCoordinador(int id) {
        Coordinador coordinador = gestorEntidades.obtenerCoordinadorPorId(id);
        if (coordinador != null) {
            coordinadores.remove(coordinador);
            guardarCoordinadores(coordinadores, FILE_NAME);
            System.out.println("Coordinador eliminado exitosamente.");
        } else {
            System.out.println("Coordinador no encontrado.");
        }
    }

    public void modificarCoordinador(int id) {
        Coordinador coordinador = gestorEntidades.obtenerCoordinadorPorId(id);
        if (coordinador != null) {
            System.out.println("Ingrese nombre del coordinador: ");
            coordinador.setNombre(sc.nextLine());
            System.out.println("Ingrese apellido del coordinador: ");
            coordinador.setApellidos(sc.nextLine());
            System.out.println("Ingrese fecha de nacimiento del coordinador (YYYY-MM-DD): ");
            coordinador.setFechaNacimiento(sc.nextLine());
            System.out.println("Ingrese ciudad del coordinador: ");
            coordinador.setCiudad(sc.nextLine());
            System.out.println("Ingrese estado del coordinador: ");
            coordinador.setEstado(sc.nextLine());
            System.out.println("Ingrese CURP del coordinador: ");
            coordinador.setCurp(sc.nextLine());
            System.out.println("Ingrese IDs de las materias que imparte el empleado (separados por comas): ");
            String idsInput = sc.nextLine();
            List<Integer> materiaIds = new ArrayList<>();
            String[] ids = idsInput.split(",");
            for (String idString : ids) {
                try {
                    int idm = Integer.parseInt(idString.trim());
                    materiaIds.add(idm);
                } catch (NumberFormatException e) {
                    System.out.println("ID no válido: " + idString.trim());
                }
            }

            System.out.println("Ingrese sueldo del coordinador: ");
            coordinador.setSueldo(sc.nextDouble());
            sc.nextLine(); // salto de línea

            guardarCoordinadores(coordinadores, FILE_NAME);
            System.out.println("Coordinador modificado exitosamente.");
        } else {
            System.out.println("Coordinador no encontrado.");
        }
    }

    private static void guardarCoordinadores(List<Coordinador> coordinadores, String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(coordinadores);
            Files.write(Paths.get(nombreArchivo), json.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar coordinadores en JSON: " + e.getMessage());
        }
    }

    private static List<Coordinador> cargarCoordinadores(String nombreArchivo) {
        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
            return gson.fromJson(json, new TypeToken<List<Coordinador>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>(); // Si no existe el archivo o hay error, devolver una lista vacía
        }
    }

}