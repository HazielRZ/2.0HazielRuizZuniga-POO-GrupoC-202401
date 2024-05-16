package Tarjetas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TarjetaDebito extends Tarjeta {
        private static List<String> tarjetasRegistradas = new ArrayList<>();

    StringBuilder numeroTarjeta = new StringBuilder();
    StringBuilder clabeInterbancaria = new StringBuilder();

    Random random = new Random();
    private Date fechaCreacion;
    private Date fechaUsoDate;
    private String fechaVencimiento;

    

    public TarjetaDebito(String numero, Date fechaCreacion, double saldo, String CVV, String fechaVencimiento,
            String clabeInterbancaria) {
        super(numero, fechaCreacion, saldo, CVV, fechaVencimiento, clabeInterbancaria);
        this.numeroTarjeta = numeroTarjeta;
        this.fechaUsoDate = fechaUsoDate;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaCreacion = fechaCreacion;
    }

/* */    public void crearTarjetaDebito() {
        // Agregar el primer dígito (debe ser 4 para que sea Visa)
        numeroTarjeta.append("4");

        // Agregar los siguientes 15 dígitos aleatorios
        for (int i = 0; i < 15; i++) {
            int digito = random.nextInt(10); 
            numeroTarjeta.append(digito);
        }
        System.out.println("tu numero de tarjeta es: " + numeroTarjeta);
        System.out.println("la fecha de creacion ah sido: " + fechaCreacion);
        // Agregar los siguientes 18 dígitos aleatorios para una clabeinterbancaria
        for (int i = 0; i < 19; i++) {
            int digito = random.nextInt(10); 
            clabeInterbancaria.append(digito);
        }
        System.out.println("tu clabe interbancaria es: "+ clabeInterbancaria);
        // guardar la tarjeta registrada.
        tarjetasRegistradas.add(numeroTarjeta.toString());

        System.out.println("su tarjeta de debito ah sido creada con exito.");
        }

        public void movientoTarjeta(){
System.out.println("cada que use su tarjeta para realizar movimientos, seran registrados con la fecha en la que se realizo.");
System.out.println("su fecha de utlimo moviendo ah sido: "+ fechaUsoDate);
        }
        //metodo para borrar tarjetas
        public static void borrarTarjeta(String numeroTarjeta) {
            if (tarjetasRegistradas.contains(numeroTarjeta)) {
                tarjetasRegistradas.remove(numeroTarjeta);
                System.out.println("Tarjeta " + numeroTarjeta + " borrada exitosamente.");
            } else {
                System.out.println("La tarjeta " + numeroTarjeta + " no está registrada.");
            }
        }

        public StringBuilder getNumeroTarjeta() {
        return this.numeroTarjeta;
    }

    public void setNumeroTarjeta(StringBuilder numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public StringBuilder getClabeInterbancaria() {
        return this.clabeInterbancaria;
    }

    public void setClabeInterbancaria(StringBuilder clabeInterbancaria) {
        this.clabeInterbancaria = clabeInterbancaria;
    }

    public Random getRandom() {
        return this.random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaUsoDate() {
        return this.fechaUsoDate;
    }

    public void setFechaUsoDate(Date fechaUsoDate) {
        this.fechaUsoDate = fechaUsoDate;
    }

    public String getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}