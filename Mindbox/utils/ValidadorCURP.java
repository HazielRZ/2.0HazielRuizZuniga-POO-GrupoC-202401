package utils;

import Modelo.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ValidadorCURP {

    private static final Map<String, String> CLAVES_ENTIDADES = new HashMap<>();

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
    }

    private static String obtenerSubcadenaSegura(String cadena, int inicio, int fin) {
        if (cadena.length() < fin) {
            fin = cadena.length();
        }
        return cadena.substring(inicio, fin);
    }

    public static String generarCURP(Usuario usuario) {
        String nombre = limpiarNombre(usuario.getNombre());
        String apellido1 = limpiarNombre(usuario.getApellidos().split(" ")[0]);
        String apellido2 = usuario.getApellidos().split(" ").length > 1 ? limpiarNombre(usuario.getApellidos().split(" ")[1]) : "X";
        String fechaNacimiento = usuario.getFechaNacimiento();


        String sexo = usuario.getSexo();
        String entidadNacimiento = CLAVES_ENTIDADES.get(usuario.getEstado().toUpperCase());

        if (entidadNacimiento == null) {
            throw new IllegalArgumentException("Entidad de nacimiento inválida: " + usuario.getEstado());
        }

        String consonantesApellido1 = obtenerConsonantes(apellido1);
        String subcadenaConsonantes = obtenerSubcadenaSegura(consonantesApellido1, 1, 3);

        String primeraVocalInternaApellido1 = obtenerPrimeraVocalInterna(apellido1);
        String[] componentesFecha = fechaNacimiento.split("/");
        int anioNacimiento = Integer.parseInt(componentesFecha[2]); // Extraer año

        String homoclave = generarHomoclave(anioNacimiento);

        return apellido1.charAt(0) + primeraVocalInternaApellido1 + apellido2.charAt(0) +
                nombre.charAt(0) + fechaNacimiento + sexo + entidadNacimiento +
                subcadenaConsonantes + homoclave;
    }

    // ... (otros métodos auxiliares: limpiarNombre, obtenerConsonantes, etc.)
    public static boolean validarCURP(String curp) {
        // 1. Verificar longitud y formato
        if (curp == null || curp.length() != 18 || !curp.matches("[A-Z]{4}\\d{6}[HM][A-Z]{2}[BCDFGHJKLMNPQRSTVWXYZ]{3}\\d{2}")) {
            return false;
        }

        // 2. Verificar dígito verificador
        int suma = 0;
        for (int i = 0; i < 16; i++) {
            char c = curp.charAt(i);
            int valor;
            if (Character.isDigit(c)) {
                valor = c - '0';
            } else {
                valor = c - 'A' + 10;
            }
            suma += valor * (18 - i);
        }
        int digitoVerificador = 10 - (suma % 10);
        if (digitoVerificador == 10) {
            digitoVerificador = 0;
        }
        return digitoVerificador == (curp.charAt(17) - '0');
    }
    private static String limpiarNombre(String nombre) {
        nombre = nombre.toUpperCase().trim();
        nombre = nombre.replaceAll("[^A-ZÑ]", "");
        return nombre;
    }

    private static String obtenerConsonantes(String palabra) {
        return palabra.replaceAll("[AEIOUÑ]", "");
    }

    private static String obtenerPrimeraVocalInterna(String palabra) {
        for (int i = 1; i < palabra.length(); i++) {
            if ("AEIOUÑ".indexOf(palabra.charAt(i)) != -1) {
                return String.valueOf(palabra.charAt(i));
            }
        }
        return "X";
    }

    private static String generarHomoclave(int anioNacimiento) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        Random random = new Random();

        if (anioNacimiento < 2000) {
            return String.valueOf(letras.charAt(random.nextInt(letras.length())) + numeros.charAt(random.nextInt(numeros.length())));
        } else {
            return String.valueOf(anioNacimiento).substring(2, 4) +
                    letras.charAt(random.nextInt(letras.length())) +
                    numeros.charAt(random.nextInt(numeros.length()));
        }
    }
}


