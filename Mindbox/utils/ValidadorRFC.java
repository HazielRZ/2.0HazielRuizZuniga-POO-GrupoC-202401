package utils;


import Modelo.Empleado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ValidadorRFC {

    private static final Map<String, String> CLAVES_ENTIDADES = new HashMap<>();
    private static final String HOMOCLAVE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    static {
        CLAVES_ENTIDADES.put("AGUASCALIENTES", "AS");
        CLAVES_ENTIDADES.put("BAJA CALIFORNIA", "BC");
        CLAVES_ENTIDADES.put("BAJA CALIFORNIA SUR", "BS");
        CLAVES_ENTIDADES.put("CAMPECHE", "CC");
        CLAVES_ENTIDADES.put("COAHUILA", "CL");
        CLAVES_ENTIDADES.put("COLIMA", "CM");
        CLAVES_ENTIDADES.put("CHIAPAS", "CS");
        CLAVES_ENTIDADES.put("CHIHUAHUA", "CH");
        CLAVES_ENTIDADES.put("CIUDAD DE MÉXICO", "DF");
        CLAVES_ENTIDADES.put("DURANGO", "DG");
        CLAVES_ENTIDADES.put("GUANAJUATO", "GT");
        CLAVES_ENTIDADES.put("GUERRERO", "GR");
        CLAVES_ENTIDADES.put("HIDALGO", "HG");
        CLAVES_ENTIDADES.put("JALISCO", "JC");
        CLAVES_ENTIDADES.put("MÉXICO", "MC");
        CLAVES_ENTIDADES.put("MICHOACÁN", "MN");
        CLAVES_ENTIDADES.put("MORELOS", "MS");
        CLAVES_ENTIDADES.put("NAYARIT", "NT");
        CLAVES_ENTIDADES.put("NUEVO LEÓN", "NL");
        CLAVES_ENTIDADES.put("OAXACA", "OC");
        CLAVES_ENTIDADES.put("PUEBLA", "PL");
        CLAVES_ENTIDADES.put("QUERÉTARO", "QT");
        CLAVES_ENTIDADES.put("QUINTANA ROO", "QR");
        CLAVES_ENTIDADES.put("SAN LUIS POTOSÍ", "SP");
        CLAVES_ENTIDADES.put("SINALOA", "SL");
        CLAVES_ENTIDADES.put("SONORA", "SR");
        CLAVES_ENTIDADES.put("TABASCO", "TC");
        CLAVES_ENTIDADES.put("TAMAULIPAS", "TS");
        CLAVES_ENTIDADES.put("TLAXCALA", "TL");
        CLAVES_ENTIDADES.put("VERACRUZ", "VZ");
        CLAVES_ENTIDADES.put("YUCATÁN", "YN");
        CLAVES_ENTIDADES.put("ZACATECAS", "ZS");
        CLAVES_ENTIDADES.put("NACIDO EXTRANJERO", "NE");
        // ... (Agregar las claves de las entidades federativas, igual que en ValidadorCURP)
    }

    public static String generarRFC(Empleado empleado) {
        String nombre = limpiarNombre(empleado.getNombre());
        String apellidoPaterno = limpiarNombre(empleado.getApellidos().split(" ")[0]);
        String apellidoMaterno = empleado.getApellidos().split(" ").length > 1 ? limpiarNombre(empleado.getApellidos().split(" ")[1]) : "";
        String fechaNacimiento = empleado.getFechaNacimiento();


        String rfcBase = apellidoPaterno.substring(0, 2) + apellidoMaterno.charAt(0) + nombre.charAt(0) + fechaNacimiento;

        String homoclave = generarHomoclaveRFC(rfcBase);
        return rfcBase + homoclave;
    }

    public static boolean validarRFC(String rfc) {
        if (rfc == null || rfc.length() != 12 && rfc.length() != 13) {
            return false;
        }

        String rfcPattern = "^[A-Z&Ñ]{3,4}\\d{6}[A-Z0-9]{3}$";
        return rfc.matches(rfcPattern);

        // Verificar dígito verificador (lógica más compleja que requiere tabla del SAT)
        // ... (implementar la lógica de verificación del dígito verificador)
// Temporalmente, asume que el RFC es válido
    }

    private static String generarHomoclaveRFC(String rfcBase) {

        //  generar una homoclave aleatoria de 3 caracteres
        Random random = new Random();
        StringBuilder homoclave = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            homoclave.append(HOMOCLAVE_CHARS.charAt(random.nextInt(HOMOCLAVE_CHARS.length())));
        }
        return homoclave.toString();
    }

    private static String limpiarNombre(String nombre) {
        nombre = nombre.toUpperCase().trim();
        nombre = nombre.replaceAll("[^A-ZÑ]", "");
        return nombre;
    }

}
