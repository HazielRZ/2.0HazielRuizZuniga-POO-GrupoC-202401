package Menu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private HashMap<Integer, MenuItem> menuItems;

    public Menu() {
        menuItems = new HashMap<>();
    }

    public void display(String prompt) {
        System.out.println(prompt);
        for (Map.Entry<Integer, MenuItem> entry : menuItems.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getText());
        }

        int opcion = AskData.inputInteger("Opción: ");

        MenuItem menuItem = menuItems.get(opcion);
        if (menuItem != null) {
            menuItem.getController().execute(); // Ejecutamos el controlador
        } else {
            System.out.println("Opción inválida.");
        }
    }


    public void addMenuItem(int key, MenuItem menuItem) {
        menuItems.put(key, menuItem);
    }

    public HashMap<Integer, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(HashMap<Integer, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
