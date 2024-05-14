package Banco;
import utils.Sucursales;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Usuario {
        private String nombre;
        private String apellidoMaterno;
        private String apellidoPaterno;
        private String fechaDeNacimiento;
        private String ciudad;
        private static String estado;
        private String curp;
        private String direccion;
        private String RFC;
        private String sexo;
        private String userName;
        private String password;
        protected double salario;
        protected static Roles Roles;
        protected LocalDate fechaRegistro;
        private Sucursales Sucursales;
        static ArrayList<String> RFCList = new ArrayList<>();

        public Usuario(String nombre, String apellidoMaterno, String apellidoPaterno, String fechaDeNacimiento,
                       String ciudad, String estado, String curp, String direccion, String RFC, double salario,
                       Roles Roles, Sucursales Sucursales, String sexo, String userName, String password) {
            this.nombre = nombre;
            this.apellidoMaterno = apellidoMaterno;
            this.apellidoPaterno = apellidoPaterno;
            this.fechaDeNacimiento = fechaDeNacimiento;
            this.ciudad = ciudad;
            Usuario.estado = estado;
            this.curp = curp;
            this.direccion = direccion;
            this.sexo = sexo;
            this.userName = userName;
            this.password = password;
            this.RFC = RFC;
            this.salario = salario;
            Usuario.Roles = Roles;
            this.Sucursales = Sucursales;
            this.fechaRegistro = LocalDate.now();
        }

        public Usuario(String nombre, String apellidoMaterno, String apellidoPaterno, String fechaDeNacimiento,
                       String ciudad, String estado, String curp, String direccion, String RFC,
                       Roles Roles, Sucursales Sucursales, String sexo, String userName, String password) {
            this.nombre = nombre;
            this.apellidoMaterno = apellidoMaterno;
            this.apellidoPaterno = apellidoPaterno;
            this.fechaDeNacimiento = fechaDeNacimiento;
            this.ciudad = ciudad;
            Usuario.estado = estado;
            this.curp = curp;
            this.direccion = direccion;
            this.sexo = sexo;
            this.userName = userName;
            this.password = password;
            this.RFC = RFC;
            Usuario.Roles = Roles;
            this.Sucursales = Sucursales;
            this.fechaRegistro = LocalDate.now();
        }

        public Usuario(String RFC) {
            this.RFC = RFC;
        }

    protected static String generateRFC(String nameCapturista, String fatherLastNameCapturista, String motherLastNameCapturista, String fechaDeNacimiento) {
        return nameCapturista;
    }

    protected static void validarRFC(String rfcCapturista) {
    }


    @Override
        public String toString() {
            return String.format("""

                            Nombre completo: %s %s %s\s
                            Banco.Roles: %s\s
                            Fecha de nacimiento: %s\s
                            Estado: %s \

                            Ciudad: %s\s
                            Dirección: %s\s
                            Curp: %s\s
                            RFC: %s\s
                            Nombre de usuario: %s\s
                            Contraseña: %s""",
                    nombre, apellidoPaterno, apellidoMaterno, Roles, fechaDeNacimiento, estado, ciudad, direccion, curp,
                    RFC.toUpperCase(), userName, password);
        }



    public Sucursales getSucursales() {
        return Sucursales;
    }

    public Roles getRoles() {
        return Roles;
    }


        public static ArrayList<String> registerUser(Roles userRoles) {
            Scanner leer = new Scanner(System.in);
            System.out.println("\n\tESCRIBIR TODO CON MAYÚSCULAS");
            System.out.print("Ingrese el nombre: ");
            String name = leer.nextLine().toUpperCase();
            System.out.print("Ingrese el apellido paterno: ");
            String fatherLastName = leer.nextLine().toUpperCase();
            System.out.print("Ingrese el apellido materno: ");
            String motherLastName = leer.nextLine().toUpperCase();
            System.out.print("Ingrese la fecha de nacimiento formato AAAA-DD-MM: ");
            String fechaNacimiento = leer.nextLine();
            System.out.print("Ciudad: ");
            String city = leer.nextLine().toUpperCase();
            System.out.print("Estado: ");
            String estado = leer.nextLine().toUpperCase();
            System.out.print("Sexo: ");
            String sexo = leer.nextLine();
            String curp = generarCurp(name, fatherLastName, motherLastName, fechaNacimiento, sexo);
            System.out.print("Domicilio: ");
            String direccion = leer.nextLine();
            System.out.print("Nombre de Banco.Usuario: ");
            String userName = leer.nextLine();
            System.out.print("Contrasena: ");
            String password = leer.nextLine();
            return new ArrayList<>(Arrays.asList(name, fatherLastName, motherLastName, fechaNacimiento, city, estado, curp,
                    direccion, sexo, userName, password));
        }

        protected static String generarCurp(String name, String fatherLastName, String motherLastName,
                                            String fechaDeNacimiento, String sexo) {
            try {
                String nombre = name.substring(0, 1);
                String apellidoPaterno = fatherLastName.substring(0, 2);
                String apellidoMaterno = motherLastName.substring(0, 2);
                String añoNacimiento = fechaDeNacimiento.substring(2, 4);
                String mesNacimiento = fechaDeNacimiento.substring(8, 10);
                String diaNacimiento = fechaDeNacimiento.substring(5, 7);
                String Sexo = sexo.substring(0, 1);

                // Generar CURP
                return apellidoPaterno + apellidoMaterno + nombre + añoNacimiento + mesNacimiento + diaNacimiento +
                        Sexo + estado.substring(0, 2); // Utilizando solo las dos primeras letras del estado
            } catch (Exception e) {
                System.out.println("No fue posible generar su CURP. Ingrese los datos completos");
                return null;
            }
        }





    //+++++++++++++Banco.Solicitud De Tarjetas.+++++++++++
    private static boolean esAutorizado(Usuario usuarioActual){
        if (usuarioActual.getRoles().equals(Banco.Roles.GERENTE) || usuarioActual.getRoles().equals(Banco.Roles.EJECUTIVODECUENTA)){
            return true;
        } else {
            return false;
        }
    }

    public static void aceptarSolicitud(Usuario usuarioActual) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el ID de la solicitud: ");
        int idSolicitud = leer.nextInt();

        for (SolicitudTarjetaCredito buscarSolicitud : Sistema.listaSolicitudes) {
            if (buscarSolicitud.getIdSolicitud() == idSolicitud) {
                System.out.println("1. Aprobar tarjeta ");
                System.out.println("2. Rechazar tarjeta");
                System.out.print("Ingrese la opción: ");
                int opcionStatus = leer.nextInt();

                if (opcionStatus == 1) {
                    buscarSolicitud.setStatus(Solicitud.APROBADA);
                    Credito.crearTarjetaCredito(buscarSolicitud.getTipoTarjeta(), buscarSolicitud.getClienteSolicitante());
                    Sistema.listaSolicitudes.remove(buscarSolicitud);
                    System.out.println("La solicitud ha sido aprobada y la tarjeta de crédito ha sido creada.");
                } else if (opcionStatus == 2) {
                    buscarSolicitud.setStatus(Solicitud.RECHAZADA);
                    Sistema.listaSolicitudes.remove(buscarSolicitud);
                    System.out.println("La solicitud ha sido rechazada.");
                } else {
                    System.out.println("Opción inválida. La solicitud permanece sin cambios.");
                }
                return; // Termina el método después de procesar la solicitud.
            }
        }
        System.out.println("No se encontró ninguna solicitud con el ID especificado.");
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setRoles(Roles Roles) {
        Usuario.Roles = Roles;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setSucursales(Sucursales Sucursales) {
        this.Sucursales = Sucursales;
    }

    public static ArrayList<String> getRFCList() {
        return RFCList;
    }

    public static void setRFCList(ArrayList<String> RFCList) {
        Usuario.RFCList = RFCList;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
