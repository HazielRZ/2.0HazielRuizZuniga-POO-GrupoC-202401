import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {

         private int id;
         private String nombre;
         private String apellidos;
         private int añoNacimiento;
         private String ciudad;
         private String estado;
         private String rfc;
         private String curp;
         private String direccion;
         private String fechaRegistro;
         private String sucursalRegistro;
         private String contraseña; // Nuevo campo de contraseña

         public Cliente(String nombre, String apellidos, int añoNacimiento, String ciudad, String estado,
                        String direccion, String sucursalRegistro, String contraseña) {
             this.id = IDManager.generarIDCliente(); // Generar ID automáticamente
             this.nombre = nombre;
             this.apellidos = apellidos;
             this.añoNacimiento = añoNacimiento;
             this.ciudad = ciudad;
             this.estado = estado;
             this.direccion = direccion;
             this.sucursalRegistro = sucursalRegistro;
             this.contraseña = contraseña;
             this.rfc = generarRFC();
             this.curp = generarCURP();
             this.fechaRegistro = obtenerFechaActual(); // Método para obtener fecha actual
         }

    // Método para generar RFC
    private String generarRFC() {
        // Implementa lógica para generar el RFC
       return "EJEMPLO";
    }

    // Método para generar CURP
    private String generarCURP() {
        // Implementa  para generar el CURP
        return "CURP123456789"; // Ejemplo de CURP generado automáticamente
    }
     private String obtenerFechaActual() {
         LocalDate fechaActual = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         return fechaActual.format(formatter);
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

     public String getFechaRegistro() {
         return fechaRegistro;
     }

     public void setFechaRegistro(String fechaRegistro) {
         this.fechaRegistro = fechaRegistro;
     }

     public String getSucursalRegistro() {
         return sucursalRegistro;
     }

     public void setSucursalRegistro(String sucursalRegistro) {
         this.sucursalRegistro = sucursalRegistro;
     }

     public String getContraseña() {
         return contraseña;
     }

     public void setContraseña(String contraseña) {
         this.contraseña = contraseña;
     }
 }