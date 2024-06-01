
import Modelo.Carrera;
import Modelo.Coordinador;
import MenusEspecificos.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //  (cargar carreras desde JSON)
        List<Carrera> carreras = new ArrayList<>();

        // Cargar carreras desde JSON si el archivo existe
        if (Files.exists(Paths.get("carreras.json"))) {
            try {
                carreras = Carrera.cargarCarreras("carreras.json");
            } catch (IOException e) {
                System.err.println("Error al cargar carreras desde JSON: " + e.getMessage());
            }
        } else {
            // Crear carreras
            carreras.add(new Carrera("Ingeniería en Sistemas Computacionales", null)); // Coordinador se asignará después
            carreras.add(new Carrera("Ingeniería en Materiales", null));
            carreras.add(new Carrera("Ingeniería Electrónica", null));

            // Guardar carreras en JSON
            try {
                Carrera.guardarCarreras(carreras, "carreras.json");
            } catch (IOException e) {
                System.err.println("Error al guardar carreras en JSON: " + e.getMessage());
            }
        }

        List<Coordinador> coordinadores = new ArrayList<>();

        // Crear coordinadores
        Coordinador coordinadorISC = new Coordinador(
                "José Manuel", "Cuin Jacuinde", "19/05/2012", "M", "Morelia", "MICHOACÁN",
                "Av. Tecnológico 1500", "19/03/1988",50000.0, carreras.get(0) // ISC
        );
        Coordinador coordinadorELC = new Coordinador(
                "Eder", "Rivera Cisneros", "19/05/2012", "M", "Morelia", "MICHOACÁN",
                "Calle Revolución 320", "19/05/2012",48000.0, carreras.get(1) // ELC
        );
        Coordinador coordinadorIMAT = new Coordinador(
                "Juvenal", "Maldonado Pérez", "19/05/2012", "M", "Morelia", "MICHOACÁN",
                "Blvd. García de León 789","19/05/2012", 52000.0, carreras.get(2) // IMAT
        );

        coordinadores.add(coordinadorISC);
        coordinadores.add(coordinadorELC);
        coordinadores.add(coordinadorIMAT);

        // Guardar coordinadores en JSON
        Coordinador.guardarCoordinadores(coordinadores, "coordinadores.json");

        // inicio de sesion
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.mostrarMenu();
    }
}