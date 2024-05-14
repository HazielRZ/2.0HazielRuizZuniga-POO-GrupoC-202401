package Roles;

import utils.Sucursales;

import java.util.ArrayList;

public class EjecutivoCuenta extends Usuario {

    public EjecutivoCuenta(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento,
                           String ciudad, String estado, String curp, String direccion, String RFC, double salario,
                           Roles Roles, Sucursales Sucursales, String sexo, String userName, String password) {
        super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, salario, Roles, Sucursales, sexo, userName, password);
    }

    public static void registerEjecutivo(Usuario usuarioActual) {
        System.out.println("\nRegistro de ejecutivo de ventas");
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = Usuario.registerUser(Roles.EJECUTIVODECUENTA);
        String nameEjecutivo = datosComun.get(0);
        String fatherLastNameEjecutivo = datosComun.get(1);
        String motherLastNameEjecutivo = datosComun.get(2);
        String fechaDeNacimiento = datosComun.get(3);
        String cityEjecutivo = datosComun.get(4);
        String estadoEjecutivo = datosComun.get(5);
        String CURPEjecutivo = datosComun.get(6);
        String direccionEjecutivo = datosComun.get(7);
        String sexoEjecutivo = datosComun.get(8);
        String RFCEjecutivo = datosComun.get(11);
        String usuarioEjecutivo = datosComun.get(9);
        String passwordEjecutivo = datosComun.get(10);

        System.out.print("Salario: ");
        Double salaryEjecutivo = leer.nextDouble();

        if (RFCEjecutivo != null) {
            RFCList.add(RFCEjecutivo);
            Usuario.validarRFC(RFCEjecutivo);
            EjecutivoCuenta newEjecutivoDeCuenta = new EjecutivoCuenta(nameEjecutivo, fatherLastNameEjecutivo, motherLastNameEjecutivo,
                    fechaDeNacimiento, cityEjecutivo, estadoEjecutivo, CURPEjecutivo, direccionEjecutivo, RFCEjecutivo,
                    salaryEjecutivo, Roles.EJECUTIVODECUENTA, usuarioActual.getSucursales(), sexoEjecutivo, usuarioEjecutivo, passwordEjecutivo);
            if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
                if (!SistemaBancario.usuariosMadero.containsKey(Roles.EJECUTIVODECUENTA)) {
                    SistemaBancario.usuariosMadero.put(Roles.EJECUTIVODECUENTA, new ArrayList<>());
                }
                SistemaBancario.usuariosMadero.get(Roles.EJECUTIVODECUENTA).add(newEjecutivoDeCuenta);
                System.out.println("Ejecutivo de venta registrado con éxito. Su RFC es: " + RFCEjecutivo + " su CURP es: " + CURPEjecutivo);
            } else {
                if (!SistemaBancario.usuariosAcueducto.containsKey(Roles.EJECUTIVODECUENTA)) {
                    SistemaBancario.usuariosAcueducto.put(Roles.EJECUTIVODECUENTA, new ArrayList<>());
                }
                SistemaBancario.usuariosAcueducto.get(Roles.EJECUTIVODECUENTA).add(newEjecutivoDeCuenta);
                System.out.println("Ejecutivo de venta registrado con éxito. Su RFC es: " + RFCEjecutivo + " su CURP es: " + CURPEjecutivo);
            }
        } else {
            System.out.println("Inténtelo de nuevo.");
        }
    }

    public static void modificarEjecutivo(Usuario usuario) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nModificación de Ejecutivo de ventas");
        System.out.println("Ingrese el RFC del ejecutivo a modificar: ");
        String modificarRFC = leer.nextLine();

        boolean encontrado = false;

        if (usuario.getSucursales().equals(Sucursales.MADERO)) {
            encontrado = modificarEjecutivoEnSucursales(SistemaBancario.usuariosMadero.get(Roles.EJECUTIVODECUENTA), modificarRFC);
        } else if (usuario.getSucursales().equals(Sucursales.ACUEDUCTO)) {
            encontrado = modificarEjecutivoEnSucursales(SistemaBancario.usuariosAcueducto.get(Roles.EJECUTIVODECUENTA), modificarRFC);
        }

        if (!encontrado) {
            System.out.println("Ejecutivo no encontrado.");
        }
    }

    private static boolean modificarEjecutivoEnSucursales(ArrayList<Usuario> usuarios, String modificarRFC) {
        boolean encontrado = false;

        for (Usuario usuario : usuarios) {
            if (usuario.getRFC().equals(modificarRFC)) {
                encontrado = true;
                EjecutivoCuenta ejecutivo = (EjecutivoCuenta) usuario;
                modificarDatos(ejecutivo, modificarRFC);
                break;
            }
        }

        return encontrado;
    }

    private static void modificarDatos(EjecutivoCuenta ejecutivo, String modificarRFC) {
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
            System.out.println("8. Salario.");
            System.out.println("9. Usuario.");
            System.out.println("10. Contraseña.");
            System.out.println("11. Salir.");

            opcionModificar = leer.nextInt();
            leer.nextLine();
            switch (opcionModificar) {
                // Opciones de modificación aquí...
            }
        } while (opcionModificar != 11);
    }

    public static void eliminarEjecutivo(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("\nEliminación de Ejecutivo de Ventas");
        System.out.println("Ingrese el RFC del ejecutivo a eliminar:");
        String buscarRFC = leer.nextLine();

        if (usuarioActual.getSucursales().equals(Sucursales.ACUEDUCTO)) {
            ArrayList<Usuario> ejecutivoAcueducto = SistemaBancario.usuariosAcueducto.get(Roles.EJECUTIVODECUENTA);
            for (Usuario ejecutivo : ejecutivoAcueducto) {
                if (ejecutivo.getRFC().equals(buscarRFC)) {
                    ejecutivoAcueducto.remove(ejecutivo);
                    System.out.println("\nEjecutivo de cuenta eliminado");
                    return;
                }
            }
        } else if (usuarioActual.getSucursales().equals(utils.Sucursales.MADERO)) {
            ArrayList<Usuario> ejecutivoMadero = SistemaBancario.usuariosMadero.get(Roles.EJECUTIVODECUENTA);
            for (Usuario ejecutivo : ejecutivoMadero) {
                if (ejecutivo.getRFC().equals(buscarRFC)) {
                    ejecutivoMadero.remove(ejecutivo);
                    System.out.println("\nEjecutivo de cuenta eliminado");
                    return;
                }
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    public static void mostrarEjecutivo(Usuario usuarioActual) {
        System.out.println("\nLista de Ejecutivos de Venta");
        try {
            if (usuarioActual.getSucursales().equals(Sucursales.MADERO)) {
                for (Usuario usuario : SistemaBancario.usuariosMadero.get(Roles.EJECUTIVODECUENTA)) {
                    if (usuario.getRoles() == Roles.EJECUTIVODECUENTA) {
                        EjecutivoCuenta ejecutivo = (EjecutivoDeVentas) usuario;
                        System.out.println(ejecutivo.toString());
                    }
                }
            }
            if (usuarioActual.getSucursales().equals(Sucursales.ACUEDUCTO)) {
                for (Usuario usuario : SistemaBancario.usuariosAcueducto.get(Roles.EJECUTIVODECUENTA)) {
                    if (usuario.getRoles() == Roles.EJECUTIVODECUENTA) {
                        EjecutivoDeVentas ejecutivo = (EjecutivoDeVentas) usuario;
                        System.out.println(ejecutivo.toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nLista vacía");
        }
    }

    @Override
    public String toString() {
        return String.format("%s \nSalario: %.4f \nFecha de registro: %s", super.toString(), salario, super.fechaRegistro);
    }
}