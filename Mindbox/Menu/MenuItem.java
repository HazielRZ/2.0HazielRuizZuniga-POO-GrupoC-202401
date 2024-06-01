package Menu;

import java.util.ArrayList;
import java.lang.Runnable;

public class MenuItem {
    private String text;
    private Controller controller;
    private static ArrayList<Permission> permission; // Cambiamos a ArrayList<Permission>

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public MenuItem(String text, Controller controller) {
        this.text = text;
        this.controller = controller;
    }

    public MenuItem(String text, Controller controller, ArrayList<Permission> permissions) {
        this.text = text;
        this.controller = controller;
        permission = permissions;
    }

    public static ArrayList<Permission> getPermission() {
        return permission;
    }

    public void setPermission(ArrayList<Permission> permission) {
        MenuItem.permission = permission;
    }




}