package Tarjeta;

import java.util.Random;

public class TarjetaDebito {
    private String numeroTarjeta;
    private String clabeInterbancaria;

    private static final Random random = new Random();

    public TarjetaDebito() {
        generarTarjetaDebito();
    }

    private void generarTarjetaDebito() {
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
    }

    // Getters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getClabeInterbancaria() {
        return clabeInterbancaria;
    }
}
