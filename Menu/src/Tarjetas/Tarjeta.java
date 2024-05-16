package Tarjetas;

import java.sql.Date;
import java.util.Scanner;

// Clase para representar una tarjeta
 class Tarjeta {
    Scanner scanner  = new Scanner(System.in);
    private String numero;
    private Date fechaCreacion;
    private double saldo;
    private String CVV, fechaVencimiento, clabeInterbancaria;

    public Tarjeta( String numero, Date fechaCreacion, double saldo, String CVV, String fechaVencimiento, String clabeInterbancaria) {
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.saldo = saldo;
        this.CVV = CVV;
        this.fechaVencimiento = fechaVencimiento;
        this.clabeInterbancaria = clabeInterbancaria;
    }


    // Métodos para realizar abonos y gastos
    public void hacerAbono(double cantidad) {
System.out.println("ingrese la cantidad deseada para abonar a su pago: ");
double abono = scanner.nextDouble();  
System.out.println("su abono ah sido de "+ abono);  }

    public void hacerGasto(double cantidad) {
System.out.println("ingrese la cantidad que desea gastar: ");
double gastar = scanner.nextDouble();  
System.out.println("su gasto a sido cargado a su cuenta. asi gastando "+ gastar + "mxn");
  }

   
}
