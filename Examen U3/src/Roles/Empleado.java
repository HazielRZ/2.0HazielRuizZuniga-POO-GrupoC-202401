package Roles;
import utils.IDManager;

public class Empleado {
    protected int id;
    private String nombre;
    private String apellido;

    private String añoNacimiento;
    private String ciudad;
    private String estado;
    private String direccion;
    private String sucursal;
    private double salario;
    private String RFC;
    private final Roles rol;
    private String contraseña;



    public Empleado(int id,Roles rol,String nombre, String apellido, String añoNacimiento, String ciudad, String estado,
                    String direccion, String sucursal, double salario, String RFC, String contraseña) {
        this.id = IDManager.generarIDEmpleado();
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.añoNacimiento = añoNacimiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.salario = salario;
        this.RFC = RFC;
        this.contraseña = contraseña;
    }

    public Roles getRole() {
        return rol;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(String añoNacimiento) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



}
