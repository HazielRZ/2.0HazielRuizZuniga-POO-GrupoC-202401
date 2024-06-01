package MenusEspecificos;

import Modelo.Alumno;
import Modelo.Coordinador;
import Modelo.Profesor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Modelo.Usuario;
import Menu.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {
    public void mostrarMenu() {
        Menu menuPrincipal = new Menu();
        menuPrincipal.addMenuItem(1, new MenuItem("Iniciar Sesión", new ControllerInicioSesion(), new ArrayList<>(List.of(Permission.READ))));
        menuPrincipal.addMenuItem(0, new MenuItem("Salir", new SalirController(), new ArrayList<>(List.of(Permission.READ))));

        int opcion;
        do {
            menuPrincipal.display("\nMenú Principal", "todos"); // "todos" indica que cualquiera puede ver este menú
            opcion = AskData.inputInteger("Opción: ", new IntegerValidator() {
                @Override
                public boolean integerValidator(int value) {
                    return false;
                }
            });
        } while (opcion != 0);
    }






}
