package Roles;

public enum Roles {
    GERENTE,
    CAPTURISTA,
    EJECUTIVO_CUENTA,
    INVERSIONISTA;


    public String getRol() {
        return this.name(); // Devuelve el nombre del rol
    }
}