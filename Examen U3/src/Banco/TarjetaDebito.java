package Banco;

import java.util.Random;

public class TarjetaDebito {
    private static final Random random = new Random();
    private static String numeroTarjeta;
    private static String clabeInterbancaria;

    public TarjetaDebito() {
        generarTarjetaDebito();
    }

    public static TarjetaDebito generarTarjetaDebito() {
        StringBuilder numerosAleatorios = new StringBuilder();
        // Generar 16 números aleatorios para la tarjeta
        for (int i = 0; i < 16; i++) {
            int numero = random.nextInt(10);
            numerosAleatorios.append(numero);
        }
        numeroTarjeta = numerosAleatorios.toString();

        // Generar 18 números aleatorios para la clabe interbancaria
        numerosAleatorios = new StringBuilder(); // Reiniciar para la nueva generación
        for (int i = 0; i < 18; i++) {
            int inter = random.nextInt(10);
            numerosAleatorios.append(inter);
        }
        clabeInterbancaria = numerosAleatorios.toString();
        return null;
    }

    // Getters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getClabeInterbancaria() {
        return clabeInterbancaria;
    }
}
