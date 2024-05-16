import java.util.Scanner;

public class Empleado {
    private int id;
    private String nombre;
    private String apellidos;
    private int añoNacimiento;
    private String ciudad;
    private String estado;
    private String rfc;
    private String curp;
    private String direccion;
    private Sucursal sucursalPerteneciente;
    private double salario;
    private String rol;
    private String fechaInicioTrabajo;
    private String contraseña;

    public Empleado(String nombre, String apellidos, int añoNacimiento, String ciudad, String estado,
                    String direccion, Sucursal sucursalPerteneciente, double salario, String rol,
                    String fechaInicioTrabajo, String contraseña) {
        this.id = IDManager.generarIDEmpleado(); // Generar ID automáticamente
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.añoNacimiento = añoNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.rfc = generarRFC();
        this.curp = generarCURP();
        this.direccion = direccion;
        this.sucursalPerteneciente = sucursalPerteneciente;
        this.salario = salario;
        this.rol = rol;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
        this.contraseña = contraseña;
    }

    private String generarCURP() {
        return "";
    }

    private String generarRFC() {
        //puedes copiar el del cliente
        return "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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

    public Sucursal getSucursalPerteneciente() {
        return sucursalPerteneciente;
    }

    public void setSucursalPerteneciente(Sucursal sucursalPerteneciente) {
        this.sucursalPerteneciente = sucursalPerteneciente;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    public void setFechaInicioTrabajo(String fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    private static void registrarNuevoEmpleado(Scanner scanner, GestorEmpleados gestorEmpleados) {
        System.out.println("Ingrese los datos del nuevo empleado:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Año de nacimiento: ");
        int añoNacimiento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Sucursal perteneciente: ");

       Sucursal sucursalPerteneciente = Menu.sucursalActual;

        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Fecha de inicio de trabajo (dd/mm/yyyy): ");
        String fechaInicioTrabajo = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        // Una vez que tengas todos los datos, puedes crear un nuevo objeto Empleado
        // y agregarlo al gestor de empleados
        Empleado nuevoEmpleado = new Empleado(nombre, apellidos, añoNacimiento, ciudad, estado, direccion,
                sucursalPerteneciente, salario, "Rol por defecto", fechaInicioTrabajo,
                contraseña);
        GestorEmpleados.agregarEmpleado(nuevoEmpleado);
    }

// Métodos para generar RFC, CURP y obtener fecha actual
}

