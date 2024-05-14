package Tarjeta;

import Roles.Cliente;

import java.time.LocalDate;
import java.util.Random;

public class Credito {
    private final int CVV;
    private final String clabeInterbancaria;
    private final double saldo;
    private final LocalDate fechaDeVencimiento;
    private final LocalDate fechaDeCreacion;
    private final String numeroTarjeta;
    private double creditoMaximo;
    private double creditoMinimo;
    private final TipoTarjeta tipoTarjeta;

    public Credito(String numeroTarjeta, int CVV, String clabeInterbancaria, double saldo,
                   LocalDate fechaDeVencimiento, LocalDate fechaDeCreacion, TipoTarjeta tipoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.CVV = CVV;
        this.clabeInterbancaria = clabeInterbancaria;
        this.saldo = saldo;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.fechaDeCreacion = fechaDeCreacion;
        this.tipoTarjeta = tipoTarjeta;
    }

    public static Credito crearTarjetaCredito(TipoTarjeta tipoTarjeta, Cliente usuario) {
        Random random = new Random();
        String numeroTarjeta = generarNumeroAleatorio(16, random);
        String clabeInterbancaria = generarNumeroAleatorio(18, random);
        int CVV = random.nextInt(1000); // Suponemos que el CVV es un número de tres dígitos aleatorio
        double saldoInicial = 0.0; // Suponemos que el saldo inicial es cero
        LocalDate fechaDeVencimiento = LocalDate.now().plusYears(5); // La fecha de vencimiento es 5 años después de la creación
        LocalDate fechaDeCreacion = LocalDate.now(); // La fecha de creación es la fecha actual

        return new Credito(numeroTarjeta, CVV, clabeInterbancaria, saldoInicial, fechaDeVencimiento, fechaDeCreacion, tipoTarjeta);
    }

    private static String generarNumeroAleatorio(int longitud, Random random) {
        StringBuilder numerosAleatorios = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int numero = random.nextInt(10);
            numerosAleatorios.append(numero);
        }
        return numerosAleatorios.toString();
    }
}
