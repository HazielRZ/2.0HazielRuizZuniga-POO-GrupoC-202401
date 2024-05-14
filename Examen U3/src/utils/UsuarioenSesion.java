package utils;

import Roles.Usuario;

public class UsuarioenSesion {
    private static UsuarioenSesion instancia;
    private Usuario usuarioActual;

    private UsuarioenSesion(){}

    public static UsuarioenSesion obtenerInstancia(){
        if(instancia == null){
            instancia = new UsuarioenSesion();
        }
        return instancia;
    }

    public Usuario getUsuarioActual(){
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual){
        this.usuarioActual = usuarioActual;
    }

    public boolean hayUsuarioEnSesion(){
        return usuarioActual != null;
    }

    public void cerrarSesion(){
        instancia = null;
        usuarioActual = null;
    }
}