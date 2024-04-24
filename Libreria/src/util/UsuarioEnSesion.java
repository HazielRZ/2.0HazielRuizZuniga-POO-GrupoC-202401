package util;
import Usuarios.Usuario;

public class UsuarioEnSesion {
    private static UsuarioEnSesion instance;
    private Usuario usuarioActual;

    private UsuarioEnSesion () {}
    public static UsuarioEnSesion obtenerInstancia () {
        if (instance == null) {
            instance = new UsuarioEnSesion();
        }
        return instance;
    }
    public void cerrarSesion() {
        boolean datosCorrectos = true;
        String usuario = null;
        String contrasena = null;
    }
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
    public boolean hayUsuarioEnSesion () {
        return usuarioActual == null;

    }
}