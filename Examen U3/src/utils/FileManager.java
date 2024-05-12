package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static final String EMPLEADOS_FILE = "empleados.ser";
    public static final String CLIENTES_FILE = "clientes.ser";
    public static final String INVERSIONISTAS_FILE = "inversionistas.ser";

    public static <T> List<T> cargarLista(String nombreArchivo) {
        List<T> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while (true) {
                // leer un objeto del archivo
                T objeto = (T) ois.readObject();
                if (objeto == null) {
                    break; // Salir del bucle cuando lleguemos al final del archivo
                }
                lista.add(objeto);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo '" + nombreArchivo + "' no encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo '" + nombreArchivo + "'.");
            e.printStackTrace();
        }
        return lista;
    }

    public static <T> void guardarLista(List<T> lista, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            for (T objeto : lista) {
                oos.writeObject(objeto);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo '" + nombreArchivo + "'.");
            e.printStackTrace();
        }
    }
}
