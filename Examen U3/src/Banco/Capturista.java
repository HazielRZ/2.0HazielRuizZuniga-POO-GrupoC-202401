package Banco;

import utils.Sucursales;

import java.util.ArrayList;
import java.util.Scanner;

public class Capturista extends Usuario {

    public Capturista(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, double salario, Roles Roles, Sucursales Sucursales, String sexo, String userName, String password) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, salario, Roles, Sucursales, sexo, userName, password);
    }


    public static void registerCapturista(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);

        System.out.println("\n***Registro de capturista***");

        // Solicitar los datos al usuario
        System.out.print("Nombre: ");
        String nameCapturista = leer.nextLine().toUpperCase();

        System.out.print("Apellido Paterno: ");
        String fatherLastNameCapturista = leer.nextLine().toUpperCase();

        System.out.print("Apellido Materno: ");
        String motherLastNameCapturista = leer.nextLine().toUpperCase();

        System.out.print("Fecha de Nacimiento: ");
        String fechaDeNacimiento = leer.nextLine().toUpperCase();

        System.out.print("Ciudad: ");
        String cityCapturista = leer.nextLine().toUpperCase();

        System.out.print("Estado: ");
        String estadoCapturista = leer.nextLine().toUpperCase();

        String CURPCapturista = Usuario.generarCurp(nameCapturista, fatherLastNameCapturista, motherLastNameCapturista, fechaDeNacimiento, estadoCapturista);
        String RFCCapturista = Usuario.generateRFC(nameCapturista, fatherLastNameCapturista, motherLastNameCapturista, fechaDeNacimiento);

        System.out.print("Dirección: ");
        String direccionCapturista = leer.nextLine().toUpperCase();

        System.out.print("Salario: ");
        double salaryCapturista = leer.nextDouble();

        leer.nextLine(); // Consumir la nueva línea pendiente

        System.out.print("Banco.Usuario: ");
        String usuarioCapturista = leer.nextLine();

        System.out.print("Contraseña: ");
        String passwordCapturista = leer.nextLine();

        if (CURPCapturista != null) {
            RFCList.add(RFCCapturista);
            Usuario.validarRFC(RFCCapturista);
            Capturista newCapturista = new Capturista(nameCapturista, fatherLastNameCapturista, motherLastNameCapturista,
                    fechaDeNacimiento, cityCapturista, estadoCapturista, CURPCapturista, direccionCapturista, RFCCapturista, salaryCapturista, Banco.Roles.CAPTURISTA, usuarioActual.getSucursales(), "N/A", usuarioCapturista, passwordCapturista);

            if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
                if (!Sistema.usuariosMadero.containsKey(Banco.Roles.CAPTURISTA)) {
                    Sistema.usuariosMadero.put(Banco.Roles.CAPTURISTA, new ArrayList<>());
                }
                Sistema.usuariosMadero.get(Banco.Roles.CAPTURISTA).add(newCapturista);
                System.out.println("* Banco.Capturista registrado con éxito. Su RFC es: " + RFCCapturista + " y su CURP es: " + CURPCapturista);

            } else {
                if (!Sistema.usuariosAcueducto.containsKey(Banco.Roles.CAPTURISTA)) {
                    Sistema.usuariosAcueducto.put(Banco.Roles.CAPTURISTA, new ArrayList<>());
                }
                Sistema.usuariosAcueducto.get(Banco.Roles.CAPTURISTA).add(newCapturista);
                System.out.println("* Banco.Capturista registrado con éxito. Su RFC es: " + RFCCapturista + " y su CURP es: " + CURPCapturista);
            }
        } else {
            System.out.println("* Inténtelo de nuevo.");
        }
    }

    public static void modificarCapturista(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n***Modificación de capturista***");
        System.out.println("Ingrese el RFC del capturista a modificar: ");
        String modificarRFC = leer.nextLine().toUpperCase();

        boolean encontrado = false;

        if (usuario.getSucursales().equals(Sucursales.MADERO)) {
            encontrado = modificarCapturistaEnSucursales(Sistema.usuariosMadero.get(Banco.Roles.CAPTURISTA), modificarRFC);
        } else if (usuario.getSucursales().equals(Sucursales.ACUEDUCTO)) {
            encontrado = modificarCapturistaEnSucursales(Sistema.usuariosAcueducto.get(Banco.Roles.CAPTURISTA), modificarRFC);
        }

        if (!encontrado) {
            System.out.println("* Banco.Capturista no encontrado.");

        }
    }

    private static boolean modificarCapturistaEnSucursales(ArrayList<Usuario> usuarios, String modificarRFC) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getRFC().equals(modificarRFC)) {
                encontrado = true;
                Capturista capturista = (Capturista) usuario;
                modificarDatos(capturista, modificarRFC);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatos(Capturista capturista, String modificarRFC) {
        Scanner leer = new Scanner(System.in);
        int opcionModificar;

        do {
            opcionModificar = getOpcionModificar(leer);
            switch (opcionModificar) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String newName = leer.nextLine().toUpperCase();
                    capturista.setNombre(newName);
                    capturista.setRFC(Usuario.generateRFC(newName, capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento()));
                    capturista.setCurp(Usuario.generarCurp(newName, capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento(), capturista.getEstado()));
                    break;

                case 2:
                    System.out.print("Ingrese el nuevo apellido Paterno: ");
                    String newFatherLastName = leer.nextLine().toUpperCase();
                    capturista.setApellidoPaterno(newFatherLastName);
                    capturista.setRFC(Usuario.generateRFC(capturista.getNombre(), newFatherLastName, capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento()));
                    capturista.setCurp(Usuario.generarCurp(capturista.getNombre(), newFatherLastName, capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento(), capturista.getEstado()));
                    break;

                case 3:
                    System.out.println("Ingrese el nuevo apellido Materno");
                    String newMotherLastName = leer.nextLine().toUpperCase();
                    capturista.setApellidoMaterno(newMotherLastName);
                    capturista.setRFC(Usuario.generateRFC(capturista.getNombre(), capturista.getApellidoPaterno(), newMotherLastName, capturista.getFechaDeNacimiento()));
                    capturista.setCurp(Usuario.generarCurp(capturista.getNombre(), capturista.getApellidoPaterno(), newMotherLastName, capturista.getFechaDeNacimiento(), capturista.getEstado()));
                    break;

                case 4:
                    System.out.println("Ingrese la nueva Fecha de Nacimiento: ");
                    String newFechaDeNacimiento = leer.nextLine().toUpperCase();
                    capturista.setFechaDeNacimiento(newFechaDeNacimiento);
                    capturista.setRFC(Usuario.generateRFC(capturista.getNombre(), capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), newFechaDeNacimiento));
                    capturista.setCurp(Usuario.generarCurp(capturista.getNombre(), capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), newFechaDeNacimiento, capturista.getEstado()));
                    break;

                case 5:
                    System.out.println("Ingrese la ciudad: ");
                    String newCity = leer.nextLine().toUpperCase();
                    capturista.setCiudad(newCity);
                    break;

                case 6:
                    System.out.println("Ingrese el estado: ");
                    String newEstado = leer.nextLine().toUpperCase();
                    capturista.setEstado(newEstado);
                    capturista.setCurp(Usuario.generarCurp(capturista.getNombre(), capturista.getApellidoPaterno(), capturista.getApellidoMaterno(), capturista.getFechaDeNacimiento(), newEstado));
                    break;

                case 7:
                    System.out.println("Ingrese el domicilio: ");
                    String newDomicilio = leer.nextLine().toUpperCase();
                    capturista.setDireccion(newDomicilio);
                    break;

                case 8:
                    System.out.println("Ingrese el salario: ");
                    double newSalary = leer.nextDouble();
                    capturista.setSalario(newSalary);
                    break;

                case 9:
                    System.out.println("Ingrese el nuevo nombre de usuario: ");
                    String newUserName = leer.nextLine();
                    capturista.setUserName(newUserName);
                    break;

                case 10:
                    System.out.println("Ingrese la nueva contraseña: ");
                    String newPassword = leer.nextLine();
                    capturista.setPassword(newPassword);
                    break;

                case 11:
                    return;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcionModificar != 11);
    }

    static int getOpcionModificar(Scanner leer) {
        int opcionModificar;
        Modificar();
        System.out.println("11. Salir.");

        opcionModificar = leer.nextInt();
        leer.nextLine();
        return opcionModificar;
    }

    static void Modificar() {
        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Nombre.");
        System.out.println("2. Apellido paterno.");
        System.out.println("3. Apellido materno.");
        System.out.println("4. Fecha de Nacimiento.");
        System.out.println("5. Ciudad.");
        System.out.println("6. Estado.");
        System.out.println("7. Domicilio.");
        System.out.println("8. Salario.");
        System.out.println("9. Banco.Usuario.");
        System.out.println("10. Contraseña.");
    }


    @Override
    public String toString() {
        return String.format("%s \nSalario: %.4f \nFecha de registro: %s", super.toString(), salario, super.fechaRegistro);
    }



    public static void eliminarCapturista(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n****Eliminación de capturista****");
        System.out.println("\nIngrese el RFC del capturista a eliminar:");
        String buscarRFC = leer.nextLine().toUpperCase();

        if (usuarioActual.getSucursales().equals(Sucursales.ACUEDUCTO)) {
            ArrayList<Usuario> capturistaAcueducto = Sistema.usuariosAcueducto.get(Banco.Roles.CAPTURISTA);
            for (Usuario capturista : capturistaAcueducto) {
                if (capturista.getRFC().equals(buscarRFC)) {
                    capturistaAcueducto.remove(capturista);
                    System.out.println("\n* Banco.Capturista eliminado");
                    return;
                }
            }
        } else if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
            ArrayList<Usuario> capturistaMadero = Sistema.usuariosMadero.get(Banco.Roles.CAPTURISTA);
            for (Usuario capturista : capturistaMadero) {
                if (capturista.getRFC().equals(buscarRFC)) {
                    capturistaMadero.remove(capturista);
                    System.out.println("\n* Banco.Capturista eliminado");
                    return;
                }
            }
        }
        System.out.println("* Banco.Usuario no encontrado.");
    }


    public static void mostrarCapturista(Usuario usuarioActual) {
        System.out.println("\n**Lista de Capturistas**");
        try {
            if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
                for (Usuario usuario : Sistema.usuariosMadero.get(Banco.Roles.CAPTURISTA)) {
                    if (usuario.getRoles() == Banco.Roles.CAPTURISTA) {
                        Capturista capturista = (Capturista) usuario;
                        System.out.println(capturista);
                    }
                }
            }
            if (usuarioActual.getSucursales().equals(Sucursales.ACUEDUCTO)) {
                for (Usuario usuario : Sistema.usuariosAcueducto.get(Banco.Roles.CAPTURISTA)) {
                    if (usuario.getRoles() == Banco.Roles.CAPTURISTA) {
                        Capturista capturista = (Capturista) usuario;
                        System.out.println(capturista);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\n* Lista vacía");
        }
    }
}
