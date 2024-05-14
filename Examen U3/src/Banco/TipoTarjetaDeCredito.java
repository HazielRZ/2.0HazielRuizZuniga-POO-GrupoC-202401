package Banco;

public enum TipoTarjetaDeCredito {
    SIMPLICITY(0, 60000),
    PLATINUM(60001, 150000),
    GOLD(150001, 400000);

    private final double saldoMaximo;
    private final double saldoMinimo;

    TipoTarjetaDeCredito(double saldoMaximo, double saldoMinimo) {
        this.saldoMaximo = saldoMaximo;
        this.saldoMinimo = saldoMinimo;
    }

    public Double getSaldoMaximo() {
        return saldoMaximo;
    }

    public Double getSaldoMinimo() {
        return saldoMinimo;
    }
}