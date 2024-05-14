package Banco;

import utils.Inversion;
import utils.Sucursales;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import static Banco.Menu.inversionista;

public class Inversionista extends Usuario {
    private double fondoInversion;
    private static String llaveSeguridad = null;
    List<Inversion> inversionesPropias;

    public Inversionista(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento,
                         String ciudad, String estado, String direccion, double salario, Roles Roles,
                         utils.Sucursales Sucursales, String sexo, String userName, String password,
                         double fondoInversion, String llaveSeguridad) {
        super(nombre
        );
        this.fondoInversion = fondoInversion;
        Inversionista.llaveSeguridad = llaveSeguridad;
        this.inversionesPropias = new ArrayList<>();
    }

    public String getLlaveSeguridad() {
        return llaveSeguridad;
    }

    public void setLlaveSeguridad(String llaveSeguridad) {
        Inversionista.llaveSeguridad = llaveSeguridad;
    }

    public double getFondoInversion() {
        return fondoInversion;
    }

    public void setFondoInversion(double fondoInversion) {
        this.fondoInversion = fondoInversion;
    }

    public List<Inversion> getInversionesPropias() {
        return inversionesPropias;
    }

    // Método para registrar un nuevo inversionista
    public static void registrarInversionista(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);

        System.out.println("\nHagamos el Registro");
        ArrayList<String> datosComun = Usuario.registerUser(Banco.Roles.INVERSIONISTA);
        String nameInversionista = datosComun.get(0);
        String fatherLastNameInversionista = datosComun.get(1);
        String motherLastNameInversionista = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityInversionista = datosComun.get(4);
        String estadoIinversionista = datosComun.get(5);
        String CURPInversionista = leer.nextLine().toUpperCase(); // Solicitar CURP al usuario
        String direccionInversionista = datosComun.get(6);
        String sexoInversionista = datosComun.get(7);
        String usuarioCInversionista = datosComun.get(8);
        String passwordIinversionista = datosComun.get(9);
        String RFCInversionista = leer.nextLine().toUpperCase(); // Solicitar RFC al usuario

        System.out.print("Salario: ");
        double salary = leer.nextDouble();

        System.out.print("Ingrese el fondo de inversión: ");
        double fondo = leer.nextDouble();

        if (RFCInversionista != null) {
            Inversionista newInversionista = new Inversionista(nameInversionista, fatherLastNameInversionista, motherLastNameInversionista,
                    fechaDeNacimiento, cityInversionista, estadoIinversionista, direccionInversionista, salary, Banco.Roles.INVERSIONISTA,
                    usuarioActual.getSucursales(), sexoInversionista, usuarioCInversionista, passwordIinversionista, fondo, null);

            if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
                if (!Sistema.usuariosMadero.containsKey(Banco.Roles.INVERSIONISTA)) {
                    Sistema.usuariosMadero.put(Banco.Roles.INVERSIONISTA, new ArrayList<>());
                }
                Sistema.usuariosMadero.get(Banco.Roles.INVERSIONISTA).add(newInversionista);
                System.out.println("Banco.Inversionista registrado con éxito.");

            } else {
                if (!Sistema.usuariosAcueducto.containsKey(Banco.Roles.INVERSIONISTA)) {
                    Sistema.usuariosAcueducto.put(Banco.Roles.INVERSIONISTA, new ArrayList<>());
                }
                Sistema.usuariosAcueducto.get(Banco.Roles.INVERSIONISTA).add(newInversionista);
                System.out.println("Banco.Inversionista registrado con éxito.");

            }
        } else {
            System.out.println("Inténtelo de nuevo.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s \nSalario: %.4f \nFondo de inversion: %.4f \nkey: %s \nFecha de registro: %s", super.toString(), salario, fondoInversion, llaveSeguridad, super.fechaRegistro);
    }

    public static void mostrarInversionista(Usuario usuarioActual) {
        System.out.println("Inversores: ");
        try {
            if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
                for (Usuario usuario : Sistema.usuariosMadero.get(Banco.Roles.INVERSIONISTA)) {
                    if (usuario.getRoles() == Banco.Roles.INVERSIONISTA) {
                        Inversionista newInversionista = (Inversionista) usuario;
                        System.out.println(newInversionista);
                    }
                }
            }
            if (usuarioActual.getSucursales().equals(Sucursales.ACUEDUCTO)) {
                for (Usuario usuario : Sistema.usuariosAcueducto.get(Banco.Roles.INVERSIONISTA)) {
                    if (usuario.getRoles() == Banco.Roles.INVERSIONISTA) {
                        Inversionista newInversionista = (Inversionista) usuario;
                        System.out.println(newInversionista);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nLa lista está vacía");
        }
    }

    public static void modificarInversionista(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n***Modificación de inversionista***");
        System.out.println("\nIngrese el RFC del inversionista a modificar: ");
        String modificarRFC = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getSucursales().equals(Sucursales.MADERO)) {
            encontrado = modificarInversionistaEnSucursales(Sistema.usuariosMadero.get(Banco.Roles.INVERSIONISTA), modificarRFC);
        } else if (usuario.getSucursales().equals(Sucursales.ACUEDUCTO)) {
            encontrado = modificarInversionistaEnSucursales(Sistema.usuariosAcueducto.get(Banco.Roles.INVERSIONISTA), modificarRFC);
        }

        if (!encontrado) {
            System.out.println("Banco.Inversionista no encontrado.");
            if (usuario.getSucursales().equals(Sucursales.MADERO)) {
                Menu.menuGerente(Sucursales.MADERO);
            } else if (usuario.getSucursales().equals(Sucursales.ACUEDUCTO)) {
                Menu.menuGerente(Sucursales.ACUEDUCTO);
            }
        }
    }

    private static boolean modificarInversionistaEnSucursales(ArrayList<Usuario> usuarios, String modificarRFC) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getRFC().equals(modificarRFC)) {
                encontrado = true;
                Inversionista inversionista = (Inversionista) usuario;
                modificarDatos(inversionista);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatos(Inversionista inversionista) {
        Scanner leer = new Scanner(System.in);
        int opcionModificar;

        do {
            Capturista.Modificar();
            System.out.println("11. Fondo de inversión.");
            System.out.println("12. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();
            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = leer.nextLine().toUpperCase();
                    inversionista.setNombre(newName);
                    inversionista.setRFC(Usuario.generateRFC(newName, inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento()));
                    inversionista.setCurp(Usuario.generarCurp(newName, inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento(), inversionista.getEstado()));
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo apellido Paterno: ");
                    String newFatherLastName = leer.nextLine().toUpperCase();
                    inversionista.setApellidoPaterno(newFatherLastName);
                    inversionista.setRFC(Usuario.generateRFC(inversionista.getNombre(), newFatherLastName, inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento()));
                    inversionista.setCurp(Usuario.generarCurp(inversionista.getNombre(), newFatherLastName, inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento(), inversionista.getEstado()));
                    break;

                case 3:
                    System.out.println("Ingrese el nuevo apellido Materno");
                    String newMotherLastName = leer.nextLine().toUpperCase();
                    inversionista.setApellidoMaterno(newMotherLastName);
                    inversionista.setRFC(Usuario.generateRFC(inversionista.getNombre(), inversionista.getApellidoPaterno(), newMotherLastName, inversionista.getFechaDeNacimiento()));
                    inversionista.setCurp(Usuario.generarCurp(inversionista.getNombre(), inversionista.getApellidoPaterno(), newMotherLastName, inversionista.getFechaDeNacimiento(), inversionista.getEstado()));
                    break;

                case 4:
                    System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                    String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                    inversionista.setFechaDeNacimiento(newFechaDeNacimiento);
                    inversionista.setRFC(Usuario.generateRFC(inversionista.getNombre(), inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), newFechaDeNacimiento));
                    inversionista.setCurp(Usuario.generarCurp(inversionista.getNombre(), inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), newFechaDeNacimiento, inversionista.getEstado()));
                    break;

                case 5:
                    System.out.println("Ingrese la ciudad: ");
                    String newCity = leer.nextLine().toUpperCase();
                    inversionista.setCiudad(newCity);
                    break;

                case 6:
                    System.out.println("Ingrese el estado: ");
                    String newEstado = leer.nextLine().toUpperCase();
                    inversionista.setEstado(newEstado);
                    inversionista.setCurp(Usuario.generarCurp(inversionista.getNombre(), inversionista.getApellidoPaterno(), inversionista.getApellidoMaterno(), inversionista.getFechaDeNacimiento(), newEstado));
                    break;

                case 7:
                    System.out.println("Ingrese el domicilio: ");
                    String newDomicilio = leer.nextLine().toUpperCase();
                    inversionista.setDireccion(newDomicilio);
                    break;

                case 8:
                    System.out.println("Ingrese el salario: ");
                    double newSalary = leer.nextDouble();
                    inversionista.setSalario(newSalary);
                    break;

                case 9:
                    System.out.println("Ingrese el nuevo nombre de usuario: ");
                    String newUserName = leer.nextLine();
                    inversionista.setUserName(newUserName);
                    break;

                case 10:
                    System.out.println("Ingrese la nueva contraseña: ");
                    String newPassword = leer.nextLine();
                    inversionista.setPassword(newPassword);
                    break;

                case 11:
                    System.out.println("Ingrese su nuevo fondo de inversión: ");
                    double newFondo = leer.nextDouble();
                    inversionista.setFondoInversion(newFondo);
                    break;

                case 12:
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 12);
    }

    public static void eliminarInversionista(Usuario usuarioActual) {
        System.out.println("\n***Eliminación de inversionista***");
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el RFC del inversionista a eliminar:");
        String buscarRFC = leer.nextLine();

        if (usuarioActual.getSucursales().equals(Sucursales.ACUEDUCTO)) {
            ArrayList<Usuario> inversionistasAcueducto = Sistema.usuariosAcueducto.get(Banco.Roles.INVERSIONISTA);
            for (Usuario inversionista : inversionistasAcueducto) {
                if (inversionista.getRFC().equals(buscarRFC)) {
                    inversionistasAcueducto.remove(inversionista);
                    System.out.println("\nBanco.Inversionista eliminado");
                    return;
                }
            }
        } else if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
            ArrayList<Usuario> inversionistasMadero = Sistema.usuariosMadero.get(Banco.Roles.INVERSIONISTA);
            for (Usuario inversionista : inversionistasMadero) {
                if (inversionista.getRFC().equals(buscarRFC)) {
                    inversionistasMadero.remove(inversionista);
                    System.out.println("\nBanco.Inversionista eliminado");
                    return;
                }
            }
        }
        System.out.println("Banco.Usuario no encontrado.");
    }


    public static void realizarInversion() {
        Scanner leer = new Scanner(System.in);
        int opcion;


            do {
                System.out.println("\n***Inversión en Sucursales***");
                System.out.println("\n\tSucursales");
                System.out.println("1) Sucursales Madero");
                System.out.println("2) Sucursales Acueducto");
                System.out.println("3) Salir");

                System.out.print("\nSeleccione la Sucursales en la que desea invertir: ");
                opcion = leer.nextInt();
                leer.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("\nDigite la contraseña de seguridad: ");
                        String claveMadero = leer.nextLine();

                        if (claveMadero.equals(inversionista.getLlaveSeguridad())) {
                            System.out.print("Ingrese la cantidad a invertir en la Sucursales Madero: ");
                            double cantidadMadero = leer.nextDouble();

                            Inversion inversionAcueducto = new Inversion(inversionista.getNombre(), cantidadMadero);
                            inversionista.agregarInversionPropia(inversionAcueducto);

                            Sucursales.MADERO.realizarInversion(cantidadMadero, inversionista.getNombre(), inversionista);

                            System.out.println("Inversión realizada con éxito en la Sucursales Madero.");

                        } else {
                            System.out.println("Clave incorrecta");
                        }
                        break;
                    case 2:
                        System.out.print("\nDigite la contraseña de seguridad: ");
                        String claveAcueducto = leer.nextLine();
                        if (claveAcueducto.equals(inversionista.getLlaveSeguridad())) {
                            System.out.print("Ingrese la cantidad a invertir en la Sucursales Acueducto: ");
                            double cantidadAcueducto = leer.nextDouble();

                            leer.nextLine();

                            Inversion inversionAcueducto = new Inversion(inversionista.getNombre(), cantidadAcueducto);
                            inversionista.agregarInversionPropia(inversionAcueducto);
                            Sucursales.ACUEDUCTO.realizarInversion(cantidadAcueducto, inversionista.getNombre(), inversionista);

                            System.out.println("Inversión realizada con éxito en la Sucursales Acueducto.");

                        } else {
                            System.out.println("Clave incorrecta");
                        }
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            } while (opcion != 3);

        }



    public void agregarInversionPropia(Inversion inversion) {
        inversionesPropias.add(inversion);
    }

    public static void mostrarInversionesPropias(Usuario usuarioActual) {
        Inversionista inversionista = (Inversionista) usuarioActual;
        System.out.println("Tus inversiones:");
        for (Inversion inversion : inversionista.getInversionesPropias()) {
            System.out.println(inversion.toString());
        }
    }

    public static void mostrarInversiones(Sucursales Sucursales) {
        System.out.println("\n***Inversiones realizadas en la Sucursales " + Sucursales.name() + "***");
        mostrarInversionesSucursales(Sucursales);
    }


    private static void mostrarInversionesSucursales(Sucursales Sucursales) {
        List<Inversion> inversiones = Sucursales.getInversiones();

        if (inversiones.isEmpty()) {
            System.out.println("No se han realizado inversiones en esta Sucursales.");
        } else {
            System.out.println("\n***Lista de inversiones***");
            for (Inversion inversion : inversiones) {
                System.out.println("\nFecha: " + inversion.getFecha() + "\nBanco.Inversionista: " + inversion.getNombreInversionista() + "\nCantidad: " + inversion.getCantidad());
            }
        }
    }

    public static void mostrarDatosPersonales(Usuario usuarioActual) {

        Inversionista inversionista = (Inversionista) usuarioActual;
        System.out.println("\nDatos personales:");
        System.out.println("Nombre: " + inversionista.getNombre());
        System.out.println("Apellido paterno: " + inversionista.getApellidoPaterno());
        System.out.println("Apellido materno: " + inversionista.getApellidoMaterno());
        System.out.println("Fecha de nacimiento: " + inversionista.getFechaDeNacimiento());
        System.out.println("Ciudad: " + inversionista.getCiudad());
        System.out.println("Estado: " + inversionista.getEstado());
        System.out.println("CURP: " + inversionista.getCurp());
        System.out.println("RFC: %s" + inversionista.getRFC());
        System.out.println("Fondo de inversión: " + inversionista.getFondoInversion());
        System.out.println("Salario: " + inversionista.getSalario());
        System.out.println("Banco.Usuario: " + inversionista.getUserName());
        System.out.println("Contraseña:" + inversionista.getPassword());
        System.out.println("Llave de seguridad: " + inversionista.getLlaveSeguridad());

    }

}




