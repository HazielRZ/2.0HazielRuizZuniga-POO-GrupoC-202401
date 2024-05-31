package Menu;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private HashMap<Integer, MenuItem> menuItems;

    public Menu() {
        menuItems = new HashMap<>();
    }

    public void display(String prompt, String rolUsuario) {
        System.out.println(prompt);
        for (Map.Entry<Integer, MenuItem> entry : menuItems.entrySet()) {
            MenuItem item = entry.getValue();
            // Verificar permisos usando la clase Permission (enum)
            if (MenuItem.getPermission().contains(Permission.valueOf(rolUsuario.toUpperCase()))) {
                System.out.println(entry.getKey() + " - " + item.getText());
            }
        }

        int opcion = AskData.inputInteger("Opción: ", new IntegerValidator() {
            @Override
            public boolean integerValidator(int value) {
                return false;
            }
        }); // Validación con AskData

        MenuItem menuItem = menuItems.get(opcion);
        if (menuItem != null) {
            menuItem.getController(); // No es necesario pasar el rol, ya se verificó antes
        } else {
            System.out.println("Opción inválida.");
        }

    }
    void addMenuItem(int key, MenuItem menuItem) {
        menuItems.put(key, menuItem);
    }

    public HashMap<Integer, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(HashMap<Integer, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
