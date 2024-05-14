package Banco;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public abstract class Tarjeta {
    private String numeroDeCuenta;
    private LocalDateTime UltimoMovimiento;
    private int CVV;
    private String clabe;
    private Double saldo;
    private LocalDate fechaDeVencimiento;
    private LocalDate fechaDeCreacion;
    private TipoTarjetaDeCredito type;
    private static final ArrayList<String> cuentasAsignadas = new ArrayList<>();

    public Tarjeta() {
    }

    public Tarjeta(String numeroDeCuenta, int CVV, String clabeInterbancaria, Double saldo, LocalDate fechaDeVencimiento, LocalDate fechaDeCreacion, TipoTarjetaDeCredito type) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.UltimoMovimiento = LocalDateTime.now();
        this.CVV = CVV;
        this.clabe = clabeInterbancaria;
        this.saldo = saldo;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.fechaDeCreacion = fechaDeCreacion;
        this.type = type;
    }

    protected static String generarNumeroCuenta() {
        int longitud = 16;
        StringBuilder numeroCuenta = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            numeroCuenta.append(random.nextInt(10));
        }
        cuentasAsignadas.add(numeroCuenta.toString());
        return numeroCuenta.toString();
    }

    protected static String generarClabe() {
        int longitud = 10;
        StringBuilder numeroClabe = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            numeroClabe.append(random.nextInt(10));
        }
        return numeroClabe.toString();
    }

    protected static int generarCVV() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    protected static LocalDate generarFechaDeVencimiento(LocalDate fechaDeCreacion) {
        return fechaDeCreacion.plusYears(5);
    }

    public static void comprar() {
    }

    public static void abonar() {
    }

    // Getters and Setters
    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public LocalDateTime getUltimoMovimiento() {
        return UltimoMovimiento;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public TipoTarjetaDeCredito getType() {
        return type;
    }

    public void setType(TipoTarjetaDeCredito type) {
        this.type = type;
    }
}