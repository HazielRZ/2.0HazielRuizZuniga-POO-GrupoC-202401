package Roles;

public enum Roles {
    GERENTE("Menu del Gerente"),
    CAPTURISTA("Menu del Capturista"),
    EJECUTIVO_CUENTA("Menu del Ejecutivo de Cuenta"),
    INVERSIONISTA("Menu del Inversionista");

    private final String menu;

    Roles(String menu) {
        this.menu = menu;
    }

    public static String getMenuForRole(Roles rol) {
        return rol.getMenu();
    }

    public String getMenu() {
        return menu;
    }
}