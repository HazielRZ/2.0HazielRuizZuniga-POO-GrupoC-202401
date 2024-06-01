package MenusEspecificos;

import Menu.*;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {

        public void mostrarMenu() {
            Menu menuPrincipal = new Menu();
            menuPrincipal.addMenuItem(1, new MenuItem("Iniciar Sesión", new ControllerInicioSesion()));
            menuPrincipal.addMenuItem(0, new MenuItem("Salir", new SalirController()));

            int opcion;
            do {
                menuPrincipal.display("\nMenú Principal"); // Sin verificación de permisos
                opcion = AskData.inputInteger("Opción: ");
            } while (opcion != 0);
        }
    }




