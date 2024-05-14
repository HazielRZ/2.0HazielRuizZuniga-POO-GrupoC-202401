package Roles;

import Tarjeta.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {
    private TarjetaDebito tarjetaDebito = new TarjetaDebito();
    private ArrayList<Tarjeta> listaTarjetaCredito;
    private ArrayList<SolicitudTarjetaCredito> listaSolicitudes;

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, Roles rol, Sucursales Sucursales, String sexo, String userName, String password) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, Roles, Sucursales, sexo, userName, password);
        this.tarjetaDebito = TarjetaDebito.crearTarjeta();
        this.listaTarjetaCredito = new ArrayList<>();
        this.listaSolicitudes = new ArrayList<>();
    }

    public static void registerClient(Usuario usuarioActual) {
        System.out.println("\n***Registro de cliente***");
        ArrayList<String> datosComun = Usuario.registerUser(Roles.CLIENTE);
        String nameClient = datosComun.get(0);
        String fatherLastNameClient = datosComun.get(1);
        String motherLastNameClient = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityClient = datosComun.get(4);
        String estadoCliente = datosComun.get(5);
        String CURPClient = datosComun.get(6);
        String direccionClient = datosComun.get(7);
        String sexoClient = datosComun.get(8);
        String usuarioClient = datosComun.get(9);
        String passwordClient = datosComun.get(10);
        String RFCClient = Usuario.generateRFC(nameClient, fatherLastNameClient, motherLastNameClient, fechaDeNacimiento);

        if (RFCClient != null) {
            RFCList.add(RFCClient);
            Usuario.validarRFC(RFCClient);
            Cliente newCliente = new Cliente(nameClient, fatherLastNameClient, motherLastNameClient,
                    fechaDeNacimiento, cityClient, estadoCliente, CURPClient, direccionClient, RFCClient, Roles.CLIENTE, usuarioActual.getSucursales(), sexoClient, usuarioClient, passwordClient);

            if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
                if (!SistemaBancario.usuariosMadero.containsKey(Roles.CLIENTE)) {
                    SistemaBancario.usuariosMadero.put(Roles.CLIENTE, new ArrayList<>());
                }
                SistemaBancario.usuariosMadero.get(Roles.CLIENTE).add(newCliente);
                System.out.println("\nCliente registrado con éxito. Su rfc es:" + RFCClient + " su CURP es: " + CURPClient);
                System.out.print("Su tarjeta de debito es: "+ newCliente.verTarjeta());

            } else {
                if (!SistemaBancario.usuariosAcueducto.containsKey(Roles.CLIENTE)) {
                    SistemaBancario.usuariosAcueducto.put(Roles.CLIENTE, new ArrayList<>());
                }
                SistemaBancario.usuariosAcueducto.get(Roles.CLIENTE).add(newCliente);
                System.out.println("\nCliente registrado con éxito. Su rfc es:" + RFCClient + " su CURP es: " + CURPClient);

            }
        } else {
            System.out.println("\nInténtelo de nuevo.");
        }
    }

    // Métodos de registro y modificación de cliente...

    public String verTarjeta() {
        return this.tarjetaDebito.toString();
    }

    // Métodos para mostrar información del cliente...

    public void mostrarInfo() {
        System.out.println("**** Su informacion ****");
        System.out.println(toString());
        verTarjetasCredito();
    }

    // Métodos para mostrar listas...

    public static void mostrarCliente(Usuario usuarioActual) {
        System.out.println("\n***Lista de clientes***");
        try {
            if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
                for (Usuario usuario : SistemaBancario.usuariosMadero.get(Roles.CLIENTE)) {
                    if (usuario.getRoles() == Roles.CLIENTE) {
                        Cliente cliente = (Cliente) usuario;
                        System.out.println(cliente.toString());
                    }
                }
            }
            if (usuarioActual.getSucursales().equals(Sucursales.ACUEDUCTO)) {
                for (Usuario usuario : SistemaBancario.usuariosAcueducto.get(Roles.CLIENTE)) {
                    if (usuario.getRoles() == Roles.CLIENTE) {
                        Cliente cliente = (Cliente) usuario;
                        System.out.println(cliente.toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nLista vacía");
        }
    }

    public static void modificarCliente(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n***Modificación de cliente***");
        System.out.println("Ingrese el RFC del cliente a modificar: ");
        String modificarRFC = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getSucursales().equals(Sucursales.MADERO)) {
            encontrado = modificarClienteEnSucursales(SistemaBancario.usuariosMadero.get(Roles.CLIENTE), modificarRFC);
        } else if (usuario.getSucursales().equals(Sucursales.ACUEDUCTO)) {
            encontrado = modificarClienteEnSucursales(SistemaBancario.usuariosAcueducto.get(Roles.CLIENTE), modificarRFC);
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
            return;
        }
    }

    private static boolean modificarClienteEnSucursales(ArrayList<Usuario> usuarios, String modificarRFC) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getRFC().equals(modificarRFC)) {
                encontrado = true;
                Cliente cliente = (Cliente) usuario;
                modificarDatos(cliente, modificarRFC);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatos(Cliente cliente, String modificarRFC) {
        Scanner leer = new Scanner(System.in);
        int opcionModificar;

        do {
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Nombre.");
            System.out.println("2. Apellido paterno.");
            System.out.println("3. Apellido materno.");
            System.out.println("4. Fecha de Nacimiento.");
            System.out.println("5. Ciudad.");
            System.out.println("6. Estado.");
            System.out.println("7. Domicilio.");
            System.out.println("8. Usuario.");
            System.out.println("9. Contraseña.");
            System.out.println("10. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();
            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = leer.nextLine().toUpperCase();
                    cliente.setNombre(newName);
                    cliente.setRFC(Usuario.generateRFC(newName, cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento()));
                    cliente.setCurp(Usuario.generarCurp(newName, cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento(), cliente.getEstado(), cliente.getSexo()));
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo apellido Paterno: ");
                    String newFatherLastName = leer.nextLine().toUpperCase();
                    cliente.setApellidoPaterno(newFatherLastName);
                    cliente.setRFC(Usuario.generateRFC(cliente.getNombre(), newFatherLastName, cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento()));
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), newFatherLastName, cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento(), cliente.getEstado(), cliente.getSexo()));
                    break;

                case 3:
                    System.out.println("Ingrese el nuevo apellido Materno");
                    String newMotherLastName = leer.nextLine().toUpperCase();
                    cliente.setApellidoMaterno(newMotherLastName);
                    cliente.setRFC(Usuario.generateRFC(cliente.getNombre(), cliente.getApellidoPaterno(), newMotherLastName, cliente.getFechaDeNacimiento()));
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), cliente.getApellidoPaterno(), newMotherLastName, cliente.getFechaDeNacimiento(), cliente.getEstado(), cliente.getSexo()));
                    break;

                case 4:
                    System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                    String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                    cliente.setFechaDeNacimiento(newFechaDeNacimiento);
                    cliente.setRFC(Usuario.generateRFC(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), newFechaDeNacimiento));
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), newFechaDeNacimiento, cliente.getEstado(), cliente.getSexo()));
                    break;

                case 5:
                    System.out.println("Ingrese la ciudad: ");
                    String newCity = leer.nextLine().toUpperCase();
                    cliente.setCiudad(newCity);
                    break;

                case 6:
                    System.out.println("Ingrese el estado: ");
                    String newEstado = leer.nextLine().toUpperCase();
                    cliente.setEstado(newEstado);
                    cliente.setCurp(Usuario.generarCurp(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaDeNacimiento(), newEstado, cliente.getSexo()));
                    break;

                case 7:
                    System.out.println("Ingrese el domicilio: ");
                    String newDomicilio = leer.nextLine().toUpperCase();
                    cliente.setDireccion(newDomicilio);
                    break;

                case 8:
                    System.out.println("Ingrese el nuevo nombre de usuario: ");
                    String newUserName = leer.nextLine();
                    cliente.setUserName(newUserName);
                    break;

                case 9:
                    System.out.println("Ingrese la nueva contraseña: ");
                    String newPassword = leer.nextLine();
                    cliente.setPassword(newPassword);
                    break;

                case 10:
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 10);
    }


    public static void eliminarCliente(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n****Eliminación de Cliente****");
        System.out.println("\nIngrese el RFC del cliente a eliminar:");
        String buscarRFC = leer.nextLine();

        if (usuarioActual.getSucursales().equals(Sucursales.ACUEDUCTO)) {
            ArrayList<Usuario> clienteAcueducto = SistemaBancario.usuariosAcueducto.get(Roles.CLIENTE);
            for (Usuario cliente : clienteAcueducto) {
                System.out.println(cliente);
                if (cliente.getRFC().equals(buscarRFC)) {
                    clienteAcueducto.remove(cliente);
                    System.out.println("\nCliente de cuenta eliminado");
                    return;
                }
            }
        } else if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
            ArrayList<Usuario> clienteMadero = SistemaBancario.usuariosMadero.get(Roles.CLIENTE);
            for (Usuario cliente : clienteMadero) {
                if (cliente.getRFC().equals(buscarRFC)) {
                    clienteMadero.remove(cliente);
                    System.out.println("\nCliente eliminado");
                    return;
                }
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    //********************Tarjetas*******************
    public void solicitarTarjeta(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        Cliente clienteSolicitar = (Cliente) usuarioActual;
        if (validarSolicitudesPendientes(clienteSolicitar)) {
            System.out.println("Ingrese el tipo de tarjeta que desea solicitar: ");
            System.out.println("1. Simplicity.  2. Platinium.   3. Gold.");
            int opcionTarjetaSolicitar = leer.nextInt();
            tipoTarjetaDeCredito tipoTarjetaSolicitar = null;
            EstadoSolicitud estado = EstadoSolicitud.PENDIENTE;
            switch (opcionTarjetaSolicitar) {
                case 1:
                    tipoTarjetaSolicitar = tipoTarjetaDeCredito.SIMPLICITY;
                    break;
                case 2:
                    tipoTarjetaSolicitar = tipoTarjetaDeCredito.PLATINUM;
                    break;
                case 3:
                    tipoTarjetaSolicitar = tipoTarjetaDeCredito.GOLD;
                    break;
            }


            if (validarRequisitosParaSolicitud(tipoTarjetaSolicitar, clienteSolicitar)) {
                SolicitudTarjetaCredito nuevaSolicitud = new SolicitudTarjetaCredito(clienteSolicitar, tipoTarjetaSolicitar, estado, LocalDateTime.now());
                listaSolicitudes.add(nuevaSolicitud);
                SistemaBancario.listaSolicitudes.add(nuevaSolicitud);
            } else {
                System.out.println("No cuentas con el saldo requerido para este tipo de tarjeta.");
            }
        } else {
            System.out.println("Tienes solicitudes pendientes.");
        }
    }


    public boolean validarSolicitudesPendientes(Cliente clienteActual) {
        for (SolicitudTarjetaCredito solicitudBuscar : listaSolicitudes) {
            if (solicitudBuscar.getClienteSolicitando() == clienteActual && solicitudBuscar.getStatus().equals(EstadoSolicitud.PENDIENTE)) {
                return false;
            }
        }
        return true;
    }

    public  TarjetaDebito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public static boolean validarRequisitosParaSolicitud(tipoTarjetaDeCredito tipoTarjetaASolicitar, Cliente cliente) {
        if (cliente.getTarjetaDebito().getSaldo() >= tipoTarjetaASolicitar.getSaldoMinimo()){
            return true;
        }
        return false;
    }

    public  void mostrarSolicitudesPropias(){
        System.out.println("\nSOLICITUDES");
        if (listaSolicitudes.isEmpty()) {
            System.out.println("No has realizado ninguna solicitud de tarjetas de crédito.");
        } else {
            for (SolicitudTarjetaCredito buscarSolicitud : listaSolicitudes) {
                System.out.println("\nTipo: " + buscarSolicitud.getTipoTarjeta());
                System.out.println("Id solicitud: " + buscarSolicitud.getIdSolicitud());
                System.out.println("Estado: " + buscarSolicitud.getStatus());
                System.out.println("Fecha: " + buscarSolicitud.getFechaDeSolicitud());
                System.out.println("-----------------------------------");
            }
        }
    }



}

