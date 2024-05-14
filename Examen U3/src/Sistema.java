import utils.Sucursales;

import java.util.*;

import static SolicitudTarjetaCredito.mostrarListaSolicitudes;

public class Sistema {
    Scanner leer = new Scanner(System.in);
    public static HashMap<Sucursales, Gerente> listaGerentes = new HashMap<Sucursales, Gerente>();
    public static HashMap<Roles, ArrayList<Usuario>> usuariosMadero = new HashMap<Roles, ArrayList<Usuario>>();
    public static HashMap<Roles, ArrayList<Usuario>> usuariosAcueducto = new HashMap<Roles, ArrayList<Usuario>>();
    public static ArrayList <Tarjeta> listaTarjetas = new ArrayList<>();
    public static ArrayList <SolicitudTarjetaCredito> listaSolicitudes = new ArrayList<>();

    Gerente gerenteMadero = new Gerente("Gerente1", "1", "", "1", "1", "2000-30-01", "Morelia", "Michoacan", "Mujer", "Obrera", "", 10000.90, Roles.GERENTE, Sucursales.MADERO, "mujer");
    Gerente gerenteAcueducto = new Gerente("Gerente2", "1", "", "1", "1", "2003-22-10", "Morelia", "", "Hombre", "Av. Morelos", "", 5000.90, Roles.GERENTE, Sucursales.ACUEDUCTO, "hombre");

    public Sistema() {
        if (!listaGerentes.containsKey(Sucursales.ACUEDUCTO)) {
            usuariosAcueducto.put(Roles.GERENTE, new ArrayList<Usuario>());
            usuariosAcueducto.get(Roles.GERENTE).add(gerenteAcueducto);
            listaGerentes.put(Sucursales.ACUEDUCTO, gerenteAcueducto);
        }
        if (!listaGerentes.containsKey(Sucursales.MADERO)) {
            listaGerentes.put(Sucursales.MADERO, gerenteMadero);
            usuariosMadero.put(Roles.GERENTE, new ArrayList<Usuario>());
            usuariosMadero.get(Roles.GERENTE).add(gerenteMadero);

        }

    }

    public static Usuario verificarInicioSesion(Sucursales Sucursales, String nombreUsuario, String contrasena) {
        HashMap<Roles, ArrayList<Usuario>> usuariosPorSucursales = Sucursales.equals(Sucursales.ACUEDUCTO) ? usuariosAcueducto : usuariosMadero;
        Collection<ArrayList<Usuario>> usuarios = usuariosPorSucursales.values();

        if (usuarios != null) {
            for (ArrayList<Usuario> users : usuarios) {
                for(Usuario user: users)
                    if (user.getUserName().equals(nombreUsuario) && user.getPassword().equals(contrasena)) {
                        return user;
                    }
            }
        }
        System.out.println("Datos incorrectos.");
        return null;
    }

    // Métodos de registro
    public static void registrarCliente(Usuario usuarioActual) {
        Cliente.registerClient(usuarioActual);
    }

    public static void registrarEjecutivo(Usuario usuarioActual) {
        EjecutivoCuenta.registerEjecutivo(usuarioActual);
    }

    public static void registrarCapturista(Usuario usuarioActual) {
        Capturista.registerCapturista(usuarioActual);
    }

    public static void registrarInversionista(Usuario usuarioActual) {
        Inversionista.registarInversionista(usuarioActual);
    }

    // Métodos de visualización
    public static void mostrarClientes(Usuario usuarioActual) {
        Cliente.mostrarCliente(usuarioActual);
    }

    public static void mostrarCapturista(Usuario usuarioActual) {
        Capturista.mostrarCapturista(usuarioActual);
    }

    public static void mostrarEjecutivos(Usuario usuarioActual) {
        EjecutivoCuenta.mostrarEjecutivo(usuarioActual);
    }

    public static void mostrarInversionista(Usuario usuarioActual) {
        Inversionista.mostrarInversionista(usuarioActual);
    }

    // Métodos de modificación
    public static void modificarCliente(Usuario usuarioActual) {
        Cliente.modificarCliente(usuarioActual);
    }

    public static void modificarCapturista(Usuario usuarioActual) {
        Capturista.modificarCapturista(usuarioActual);
    }

    public static void modificarInversionista(Usuario usuarioActual) {
        Inversionista.modificarInversionista(usuarioActual);
    }

    public static void modificarEjecutivo(Usuario usuarioActual) {
        EjecutivoCuenta.modificarEjecutivo(usuarioActual);
    }

    // Métodos de eliminación
    public static void eliminarCliente(Usuario usuarioActual) {
        Cliente.eliminarCliente(usuarioActual);
    }

    public static void eliminarEjecutivo(Usuario usuarioActual) {
        EjecutivoCuenta.eliminarEjecutivo(usuarioActual);
    }

    public static void eliminarCapturista(Usuario usuarioActual) {
        Capturista.eliminarCapturista(usuarioActual);
    }

    public static void eliminarInversionista(Usuario usuarioActual) {
        Inversionista.eliminarInversionista(usuarioActual);
    }

    // Métodos relacionados con las tarjetas
    public static void solicitarTarjetaCredito(Usuario usuarioActual){
        Cliente userSolicita = (Cliente) usuarioActual;
        userSolicita.solicitarTarjeta(usuarioActual);
    }

    public static void autorizarSolicitud(Usuario usuarioActual){
        Usuario.aceptarSolicitud(usuarioActual);
    }

    public static void mostrarSolicitudes(){
        mostrarListaSolicitudes();
    }

    public static void realizarCompra(){
        Tarjeta.comprar();
    }

    public static void realizarAbono(){
        Tarjeta.abonar();
    }

    // Métodos relacionados con las inversiones
    public static void mostrarInversiones(Usuario usuarioActual, Sucursales Sucursales) {
        Inversionista.mostrarInversiones(Sucursales);
    }
}
