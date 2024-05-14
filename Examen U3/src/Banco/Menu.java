package Banco;

import utils.Sucursales;
import utils.UsuarioenSesion;
import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Banco.Sistema.eliminarEjecutivo;
import static Banco.SolicitudTarjetaCredito.solicitarTarjetaCredito;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    public static HashMap<Sucursales, ArrayList<Cliente>> listaClientes = new HashMap<Sucursales, ArrayList<Cliente>>();
    static TipoTarjeta tipoTarjeta;
    private static Cliente cliente;
    private static Usuario usuario;
    private static Inversionista inversionista;
    Scanner leer = new Scanner(System.in);
    Sistema sistema = new Sistema();

    public static void mostrarMenuCliente() {
        while (true) {
            System.out.println("Banco.Cliente");
            System.out.println("1. Ver tarjetas");
            if (puedeSolicitarTarjeta(cliente)) {
                System.out.println("2. Solicitar tarjeta de débito");
                System.out.println("3. Solicitar tarjeta de crédito");
            }
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    SolicitudTarjetaCredito.mostrarListaSolicitudes();
                    break;
                case 2:
                    System.out.println("No disponible por el momento");
                    break;
                case 3:
                    solicitarTarjetaCredito();
                    break;
                case 0:
                    System.out.println("Saliendo del menú cliente.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static boolean puedeSolicitarTarjeta(Cliente cliente) {

        return true; // Por ahora siempre retorna true
    }

    public static void mostrarMenuEmpleado() {
        Roles Roles = usuario.getRoles();
        String menu = Roles.getMenuForRoles(Roles);
        if (menu != null) {
            System.out.println("Mostrando menú para: " + Roles);
            System.out.println(menu);
        } else {
            System.out.println("Banco.Roles de empleado no reconocido.");
        }
    }

    private static void mostrarMenuGerente(Gerente gerente) {
        while (true) {
            System.out.println("Menú de Banco.Gerente");
            System.out.println("1. Realizar operaciones con clientes");
            System.out.println("2. Realizar operaciones con empleados");
            System.out.println("3. Realizar operaciones con inversionistas");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    mostrarMenuOperacionesClientes();
                    break;
                case 2:
                    // Lógica para realizar operaciones con empleados
                    break;
                case 3:
                    mostrarMenuOperacionesInversionistas();
                    break;
                case 0:
                    System.out.println("Saliendo del menú de Banco.Gerente.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void mostrarMenuOperacionesInversionistas() {
        while (true) {
            System.out.println("Menú de Operaciones con Inversionistas");
            System.out.println("1. Registrar nuevo inversionista");
            System.out.println("2. Modificar datos de inversionista");
            System.out.println("3. Eliminar inversionista");
            System.out.println("4. Ver lista de inversionistas");
            System.out.println("5. Invertir");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarNuevoInversionista();
                    break;
                case 2:
                    modificarDatosInversionista();
                    break;
                case 3:
                    eliminarInversionista();
                    break;
                case 4:
                    // Lógica para mostrar la lista de inversionistas
                    break;
                case 5:
                    invertir();
                    break;
                case 0:
                    System.out.println("Saliendo del menú de Operaciones con Inversionistas.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void mostrarMenuCapturista() {
        while (true) {
            System.out.println("=== Menú para Banco.Capturista ===");
            System.out.println("1. Registrar nuevo ejecutivo de cuenta");
            System.out.println("2. Modificar datos de un ejecutivo de cuenta");
            System.out.println("3. Eliminar ejecutivo de cuenta");
            System.out.println("4. Buscar ejecutivo de cuenta");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarNuevoEjecutivoCuenta();
                    break;
                case 2:
                    modificarDatosEjecutivoCuenta();
                    break;
                case 3:
                    eliminarEjecutivoCuenta();
                    break;
                case 4:
                    buscarEjecutivoCuenta();
                    break;
                case 5:
                    System.out.println("Saliendo del menú para Banco.Capturista.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void buscarEjecutivoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del ejecutivo de cuenta: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del ejecutivo de cuenta: ");
        String apellido = scanner.nextLine();
        EjecutivoCuenta ejecutivo = buscarEjecutivo(nombre, apellido);
        if (ejecutivo != null) {
            System.out.println("Ejecutivo de cuenta encontrado: " + ejecutivo);
        } else {
            System.out.println("No se encontró ningún ejecutivo de cuenta con ese nombre y apellido.");
        }
    }

    private static void eliminarEjecutivoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del ejecutivo de cuenta: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del ejecutivo de cuenta: ");
        String apellido = scanner.nextLine();
        EjecutivoCuenta ejecutivo = buscarEjecutivo(nombre, apellido);
        if (ejecutivo != null) {
            eliminarEjecutivo(ejecutivo);
        } else {
            System.out.println("No se encontró ningún ejecutivo de cuenta con ese nombre y apellido.");
        }
    }

    private static void modificarDatosEjecutivoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del ejecutivo de cuenta que desea modificar: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del ejecutivo de cuenta que desea modificar: ");
        String apellido = scanner.nextLine();
        EjecutivoCuenta ejecutivo = buscarEjecutivo(nombre, apellido);
        if (ejecutivo != null) {
            System.out.print("Ingrese el nuevo nombre del ejecutivo de cuenta: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo apellido del ejecutivo de cuenta: ");
            String nuevoApellido = scanner.nextLine();
            System.out.print("Ingrese el nuevo correo del ejecutivo de cuenta: ");
            String nuevoCorreo = scanner.nextLine();
            EjecutivoCuenta.modificarDatos(ejecutivo, nuevoNombre);
        } else {
            System.out.println("No se encontró ningún ejecutivo de cuenta con ese nombre y apellido.");
        }
    }

    private static void registrarNuevoEjecutivoCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del nuevo ejecutivo de cuenta: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del nuevo ejecutivo de cuenta: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el correo del nuevo ejecutivo de cuenta: ");
        String correo = scanner.nextLine();
        EjecutivoCuenta.registerEjecutivo(usuario);
    }

    private static void mostrarMenuEjecutivoCuenta() {
        while (true) {
            System.out.println("=== Menú para Ejecutivo de Cuenta ===");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Modificar datos de un cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Solicitar tarjeta de crédito para un cliente");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarNuevoCliente();
                    break;
                case 2:
                    modificarDatosCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    UsuarioenSesion.buscarClientePorID(cliente.getId());
                    break;
                case 5:
                    solicitarTarjetaCredito(cliente, tipoTarjeta);
                    break;
                case 6:
                    System.out.println("Saliendo del menú para Ejecutivo de Cuenta.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void mostrarMenuOperacionesClientes() {
        while (true) {
            System.out.println("Menú de Operaciones con Clientes");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Modificar datos de cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Ver tarjetas del cliente");
            System.out.println("5. Solicitar tarjeta de crédito");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    registrarNuevoCliente();
                    break;
                case 2:
                    modificarDatosCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    SolicitudTarjetaCredito.mostrarListaSolicitudes();
                    break;
                case 5:
                    // Lógica para solicitar tarjeta de crédito
                    break;
                case 0:
                    System.out.println("Saliendo del menú de Operaciones con Clientes.");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void registrarNuevoCliente() {
        Cliente cliente = Cliente.registerClient(usuario);

    }

    private static void modificarDatosCliente() {
        System.out.println("Ingrese el ID del cliente que desea modificar:");
        int id = scanner.nextInt();
        Cliente cliente = UsuarioenSesion.buscarClientePorID(id);
        if (cliente != null) {

            modificarDatosCliente();
        } else {
            System.out.println("No se encontró ningún cliente con el ID proporcionado.");

        }
    }

    private static void eliminarCliente() {
        System.out.println("Ingrese el ID del cliente que desea eliminar:");
        int id = scanner.nextInt();
        Cliente clienteAEliminar = UsuarioenSesion.buscarClientePorID(id);
        if (clienteAEliminar != null) {
            UsuarioenSesion.getClientes().remove(clienteAEliminar);
            System.out.println("Banco.Cliente eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con el ID proporcionado.");
        }
    }

    private static void registrarNuevoInversionista() {
        Inversionista.registrarNuevoInversionista();
    }

    private static void modificarDatosInversionista() {
        Inversionista.modificarDatos(inversionista);

    }

    private static void eliminarInversionista() {
        Inversionista.eliminarInversionista(inversionista);
    }

    private static void invertir() {
        Inversionista.realizarInversion();
    }

    private static int leerOpcion() {
        int opcion = -1;
        boolean opcionValida = false;

        while (!opcionValida) {
            try {
                opcion = scanner.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        return opcion;
    }

    public static void iniciarSesion() {
        boolean datosCorrectos = false;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("\n\tBIENVENIDO AL SISTEMA Banco.Sistema ");

            System.out.println("Pulsa enter para iniciar sesion: ");
            leer.nextLine();
            System.out.println("\nSucursales ");
            System.out.println("1.Acueducto.");
            System.out.println("2.Madero.");

            int SucursalesActual = 0;
            try {
                System.out.print("\nSelecciona tu Sucursales: ");
                SucursalesActual = leer.nextInt();
                leer.nextLine();
            } catch (Exception e) {
                System.out.println("\nIngresa un número");
            }
            System.out.print("Ingresa tu usuario: ");
            String usuario = leer.nextLine();
            System.out.print("Ingresa tu contrasena: ");
            String contrasena = leer.nextLine();


            Usuario usuarioActual = null;
            if (SucursalesActual == 1)
                usuarioActual = Sistema.verificarInicioSesion(Sucursales.ACUEDUCTO, usuario, contrasena);
            else if (SucursalesActual == 2) {
                usuarioActual = Sistema.verificarInicioSesion(Sucursales.MADERO, usuario, contrasena);
            }


            if (usuarioActual != null) {
                datosCorrectos = true;

                UsuarioenSesion.obtenerInstancia().setUsuarioActual(usuarioActual);

                seleccionarMenu();

            } else {
                System.out.println("Datos incorrectos, intentalo de nuevo.");
            }
        } while (!datosCorrectos);

    }

    public static void seleccionarMenu() {
        Usuario usuario = UsuarioenSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRoles()) {
            case CLIENTE:
                menuCliente(usuario.getSucursales());
                break;
            case CAPTURISTA:
                menuCapturista(usuario.getSucursales());
                break;
            case INVERSIONISTA:
                menuInversionista(usuario.getSucursales());
                break;
            case EJECUTIVODECUENTA:
                menuEjecutivoCuenta(usuario.getSucursales());
                break;
            case GERENTE:
                menuGerente(usuario.getSucursales());
                break;

            /*" -> funciones landa  */
        }
    }

    public static void menuGerente(Sucursales Sucursales) {
        Usuario usuario = UsuarioenSesion.obtenerInstancia().getUsuarioActual();
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n\nBanco.Gerente");
            System.out.println("1) Registrar cliente.");
            System.out.println("2) Mostrar lista de clientes");
            System.out.println("3) Modificar clientes");
            System.out.println("4) Eliminar clientes");
            System.out.println("5) Registrar capturista.");
            System.out.println("6) Mostrar lista de capturistas");
            System.out.println("7) Modificar capturistas");
            System.out.println("8) Eliminar capturistas");
            System.out.println("9) Registrar ejecutivo de cuenta.");
            System.out.println("10) Mostrar lista de ejecutivos de cuenta");
            System.out.println("11) Modificar ejecutivo de cuenta");
            System.out.println("12) Eliminar ejecutivo de cuenta");
            System.out.println("13) Registrar inversionista");
            System.out.println("14) Mostrar lista de inversionistas");
            System.out.println("15) Modificar inversionista");
            System.out.println("16) Eliminar inversionista");
            System.out.println("17) Ver solicitudes de tarjetas");
            System.out.println("18) Autorizar / rechazar solicitudes de tarjetas.");
            System.out.println("19) Generar llave de seguridad a inversionista");
            System.out.println("20) Consultar movimientos de inversionistas");
            System.out.println("21) Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Sistema.registrarCliente(usuario);
                    break;

                case 2:
                    Sistema.mostrarClientes(usuario);
                    break;

                case 3:
                    Sistema.modificarCliente(usuario);
                    break;

                case 4:
                    Sistema.eliminarCliente(usuario);
                    break;

                case 5:
                    Sistema.registrarCapturista(usuario);
                    break;

                case 6:
                    Sistema.mostrarCapturista(usuario);
                    break;

                case 7:
                    Sistema.modificarCapturista(usuario);
                    break;

                case 8:
                    Sistema.eliminarCapturista(usuario);
                    break;

                case 9:
                    Sistema.registrarEjecutivo(usuario);
                    break;

                case 10:
                    Sistema.mostrarEjecutivos(usuario);
                    break;

                case 11:
                    Sistema.modificarEjecutivo(usuario);
                    break;

                case 12:
                    eliminarEjecutivo(usuario);
                    break;

                case 13:
                    Sistema.registrarInversionista(usuario);
                    break;

                case 14:
                    Sistema.mostrarInversionista(usuario);
                    break;

                case 15:
                    Sistema.modificarInversionista(usuario);
                    break;

                case 16:
                    Sistema.eliminarInversionista(usuario);
                    break;

                case 17:
                    Sistema.mostrarSolicitudes();
                    break;

                case 18:
                    Sistema.autorizarSolicitud(usuario);
                    break;

                case 19:
                    Gerente.generarClaveSeguridad(usuario);
                    break;

                case 20:
                    Sistema.mostrarInversiones(usuario, Sucursales);
                    break;

                case 21:
                    System.out.println("\nCerrando sesión");
                    UsuarioenSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 21);
    }

    public static void menuCapturista(Sucursales Sucursales) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioenSesion.obtenerInstancia().getUsuarioActual();
        int opcion;

        do {
            System.out.println("\n capturista");
            System.out.println("1) Registrar ejecutivo de cuenta.");
            System.out.println("2) Mostrar lista de ejecutivos de cuenta");
            System.out.println("3) Modificar ejecutivo de cuenta");
            System.out.println("4) Eliminar ejecutivo de cuenta");
            System.out.println("5) Cerrar sesión");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    Sistema.registrarInversionista(usuario);
                    break;

                case 2:
                    Sistema.mostrarEjecutivos(usuario);
                    break;

                case 3:
                    Sistema.modificarEjecutivo(usuario);
                    break;

                case 4:
                    eliminarEjecutivo(usuario);
                    break;

                case 5:
                    System.out.println("\nCerrando sesión");
                    UsuarioenSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);
    }

    public static void menuEjecutivoCuenta(Sucursales Sucursales) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioenSesion.obtenerInstancia().getUsuarioActual();
        int opcion;
        do {
            System.out.println("\nBanco.Menu de ejecutivo de cuenta");
            System.out.println("1) Registrar cliente.");
            System.out.println("2) Mostrar lista de clientes");
            System.out.println("3) Modificar clientes");
            System.out.println("4) Eliminar clientes");
            System.out.println("5) Ver solicitudes de tarjetas");
            System.out.println("6) Autorizar / rechazar solicitudes de tarjetas.");
            System.out.println("7) Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Sistema.registrarCliente(usuario);
                    break;

                case 2:
                    Sistema.mostrarClientes(usuario);
                    break;

                case 3:
                    Sistema.modificarCliente(usuario);
                    break;

                case 4:
                    Sistema.eliminarCliente(usuario);
                    break;
                case 5:
                    Sistema.mostrarSolicitudes();
                    break;

                case 6:
                    Sistema.autorizarSolicitud(usuario);
                    break;

                case 7:
                    System.out.println("\nCerrando sesión");
                    UsuarioenSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 7);
    }

    public static void menuCliente(Sucursales Sucursales) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioenSesion.obtenerInstancia().getUsuarioActual();
        Cliente user = (Cliente) usuario;
        int opcion;
        do {
            System.out.println("\n\t***Banco.Menu de cliente****");
            System.out.println("1) Ver información.");
            System.out.println("2) Ver fondos");
            System.out.println("3) Solicitar tarjeta");
            System.out.println("4) Ver solicitudes");
            System.out.println("5) Realizar compra.");
            System.out.println("6) Abonar a tarjeta de crédito.");
            System.out.println("7) Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    user.mostrarInfo();
                    break;

                case 2:
                    user.verFondosTarjetas();
                    break;

                case 3:
                    Sistema.solicitarTarjetaCredito(usuario);
                    break;

                case 4:
                    user.mostrarSolicitudesPropias();
                    break;

                case 5:
                    int compra = 0;
                    System.out.println("1. Comprar con debito");
                    System.out.println("2. Comprar con credito");
                    System.out.print("Como vas a realizar tus compras: ");
                    compra = leer.nextInt();
                    if(compra==1)
                        Tarjeta.comprar();
                    else  {
                        Tarjeta.comprar();
                    }

                    break;

                case 6:
                    int abono = 0;
                    System.out.println("1. Abonar con debito");
                    System.out.println("2. Abonar con credito");
                    System.out.print("Como vas a realizar el abono: ");
                    abono = leer.nextInt();
                    if(abono==1)
                        TarjetaDebito.abonarDebito();

                    else  {
                        Tarjeta.abonar();
                    }
                    break;

                case 7:
                    System.out.println("\nCerrando sesión");
                    UsuarioenSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;


                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 7);
    }

    public static void menuInversionista(Sucursales Sucursales) {
        Scanner leer = new Scanner(System.in);
        Usuario usuario = UsuarioenSesion.obtenerInstancia().getUsuarioActual();
        int opcion;

        do {
            System.out.println("\n\t***Banco.Menu de inversionista****");
            System.out.println("1) Ver información.");
            System.out.println("2) Ver fondos de inversión");
            System.out.println("3) Realizar fondo de inversión");
            System.out.println("4) Cerrar sesión.");

            System.out.println("\nAcción a realizar: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    Inversionista.mostrarDatosPersonales(usuario);
                    break;

                case 2:
                    Inversionista.mostrarInversionesPropias(usuario);
                    break;

                case 3:
                    Inversionista.realizarInversion();
                    break;

                case 4:
                    System.out.println("\nCerrando sesión");
                    UsuarioenSesion.obtenerInstancia().cerrarSesion();
                    iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 4);
    }
}


