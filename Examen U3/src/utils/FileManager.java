package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {

    public static final String EMPLEADOS_FILE = "empleados.json";
    public static final String CLIENTES_FILE = "clientes.json";
    public static final String INVERSIONISTAS_FILE = "inversionistas.json";

    private static final Gson gson = new GsonBuilder().create();

    public static <T> List<T> cargarLista(String nombreArchivo, Class<T> clase) throws IOException {
        List<T> lista = new ArrayList<>();
        try (Reader reader = new FileReader(nombreArchivo)) {
            T[] array = gson.fromJson(reader, (Class<T[]>) Array.newInstance(clase, 0).getClass());
            if (array != null) {
                for (T objeto : array) {
                    lista.add(objeto);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Archivo '" + nombreArchivo + "' no encontrado.");
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo '" + nombreArchivo + "'.", e);
        }
        return lista;
    }

    public static <T> void guardarLista(List<T> lista, String nombreArchivo) {
        try (Writer writer = new FileWriter(nombreArchivo)) {
            if (!lista.isEmpty()) {
                T[] array = lista.toArray((T[]) Array.newInstance(lista.get(0).getClass(), lista.size()));
                gson.toJson(array, writer);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo '" + nombreArchivo + "'.");
            e.printStackTrace();
        }
    }

    public static boolean existeArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        boolean existe = archivo.exists();
        if (!existe) {
            System.out.println("El archivo '" + nombreArchivo + "' no existe en la ubicación especificada.");
        }
        return existe;
    }
}