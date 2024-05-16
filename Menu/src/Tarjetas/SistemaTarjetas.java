package Tarjetas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class SistemaTarjetas {
    private static Map<Integer, List<SolicitudTarjeta>> solicitudesPendientes;
    private static Map<Integer, TarjetaDebito> tarjetasDebitoCliente; // Mapa de tarjetas de débito por cliente
    private static Map<Integer, ArrayList<TarjetaCredito>> tarjetasCreditoCliente; // Mapa de listas de tarjetas de crédito por
    public static SistemaTarjetas sistemaTarjetas = new SistemaTarjetas();                                                                       // cliente

    public SistemaTarjetas() {
        tarjetasDebitoCliente = new HashMap<>();
        tarjetasCreditoCliente = new HashMap<>();
        solicitudesPendientes = new HashMap<>();
    }

    // Métodos para manejar tarjetas de débito
    public void agregarTarjetaDebito(int idCliente, TarjetaDebito tarjeta) {
        tarjetasDebitoCliente.put(idCliente, tarjeta);
        TarjetaDebito agregarTarjetaDebito = new TarjetaDebito(null, null, idCliente, null, null, null);
        agregarTarjetaDebito.crearTarjetaDebito();
    }

    // llamamos al metodo borrar tarjeta para poder eliminarlas
    public void eliminarTarjetaDebito(int idCliente, String numeroTarjeta) {
        TarjetaDebito.borrarTarjeta(numeroTarjeta);
    }

    // Métodos para manejar tarjetas de crédito
    public void agregarTarjetaCredito(int idCliente, TarjetaCredito tarjeta) {
        TarjetaCredito crearTarjetaCredito = new TarjetaCredito(null, null, idCliente, null, null, null);
        crearTarjetaCredito.crearTarjetaCredito();
    }

    // metodo para eliminar tarjetas de credito
    public void eliminarTarjetaCredito(int idCliente, String numeroTarjeta) {
        TarjetaCredito.borrarTarjeta(numeroTarjeta);
    }
    // lo oculté ya que en el metodo de generar tajeta includes el generador de número
    // de tarjeta

    /*
     * public void generarNumeroTarjeta(int idCliente) {
     * HashMap numerosTarjeta = new HashMap<>();
     * AtomicInteger contador = (AtomicInteger)
     * numerosTarjeta.computeIfAbsent(idCliente, k -> new AtomicInteger(1));
     * int num = contador.getAndIncrement();
     * 
     * }
     */
    public static void realizarAbono() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ingrese la cantidad que desea abonar: ");
        double abono = scanner.nextDouble();
        System.out.println("usted ah abonado  " + abono + ". Agradecemos mucho su abono");
        scanner.close();
    }

    public static void realizarGasto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ingrese el monto que gastara: ");
        double gasto = scanner.nextDouble();
        System.out.println("el gasto que ah realizado ah sido de " + gasto);
        scanner.close();
    }

    public void crearSolicitud(int idCliente, double saldoDebito, TipoTarjeta tipoTarjeta) {
        if (!solicitudesPendientes.containsKey(idCliente)) {
            solicitudesPendientes.put(idCliente, new ArrayList<>());
        }
        SolicitudTarjeta solicitud = new SolicitudTarjeta(idCliente, saldoDebito, tipoTarjeta);
        solicitudesPendientes.get(idCliente).add(solicitud);
    }

    // Método para obtener las solicitudes pendientes de un cliente
    public static List<SolicitudTarjeta> getSolicitudesPendientes(int idCliente) {
        return solicitudesPendientes.getOrDefault(idCliente, new ArrayList<>());
    }

    // Método para autorizar una solicitud de tarjeta de crédito
    public static void autorizarSolicitud(int idCliente, int indiceSolicitud) {
        List<SolicitudTarjeta> solicitudes = solicitudesPendientes.get(idCliente);
        if (solicitudes != null && indiceSolicitud >= 0 && indiceSolicitud < solicitudes.size()) {
            SolicitudTarjeta solicitud = solicitudes.get(indiceSolicitud);
            solicitud.aprobar();
            // Aquí iría la lógica para generar la tarjeta y asociarla al cliente
            TarjetaCredito asociarTarjeta = new TarjetaCredito(null, null, indiceSolicitud, null, null, null);
            asociarTarjeta.crearTarjetaCredito();
        }
    }

    // Método para rechazar una solicitud de tarjeta de crédito
    public void rechazarSolicitud(int idCliente, int indiceSolicitud) {
        List<SolicitudTarjeta> solicitudes = solicitudesPendientes.get(idCliente);
        if (solicitudes != null && indiceSolicitud >= 0 && indiceSolicitud < solicitudes.size()) {
            SolicitudTarjeta solicitud = solicitudes.get(indiceSolicitud);
            solicitud.rechazar();
        }
    }

    public static void verTarjetasDebitoCliente(int idCliente) {
        // Verifica si el cliente tiene tarjetas de débito
        if (tarjetasDebitoCliente.containsKey(idCliente)) {
            TarjetaDebito tarjetaDebito = tarjetasDebitoCliente.get(idCliente);
            System.out.println("Tarjeta de Débito del Cliente " + idCliente + ":");
            System.out.println("Número de Tarjeta: " + tarjetaDebito.getNumeroTarjeta());
        } else {
            System.out.println("El cliente " + idCliente + " no tiene tarjetas de débito.");
        }
    }

    public static void verTarjetasCreditoCliente(int idCliente) {
        // Verificar si el cliente tiene tarjetas de crédito
        if (tarjetasCreditoCliente.containsKey(idCliente)) {
            ArrayList<TarjetaCredito> tarjetasCredito = tarjetasCreditoCliente.get(idCliente);
            System.out.println("Tarjetas de Crédito del Cliente " + idCliente + ":");
            for (TarjetaCredito tarjeta : tarjetasCredito) {
                System.out.println("Número de Tarjeta: " + tarjeta.getNumeroTarjeta());
            }
        } else {
            System.out.println("El cliente " + idCliente + " no tiene tarjetas de crédito.");
        }
    }
    public static <Cliente> void menuOperacionesCliente(Scanner scanner, Cliente cliente) {

        System.out.println("Operaciones como cliente:");
        System.out.println("1. Ver tarjetas de débito");
        System.out.println("2. Ver tarjetas de crédito");
        System.out.println("3. Realizar abono");
        System.out.println("4. Realizar gasto");
        System.out.println("5. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                // Aquí llamarías al método para ver las tarjetas de débito del cliente
                verTarjetasDebitoCliente(opcion);
                break;
            case 2:
                // Aquí llamarías al método para ver las tarjetas de crédito del cliente
                verTarjetasCreditoCliente(opcion);
                break;
            case 3:
                // Aquí llamarías al método para realizar un abono
                SistemaTarjetas.realizarAbono();
                break;
            case 4:
                // Aquí llamarías al método para realizar un gasto
                SistemaTarjetas.realizarGasto();
                break;
            case 5:
                return;
            default:
                System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
        }
    }

    // Método para el menú de operaciones con tarjetas (personal autorizado)
    private static void menuOperacionesConTarjetas(Scanner scanner, SistemaTarjetas sistemaTarjetas) {
        System.out.println("Operaciones con tarjetas (personal autorizado):");
        System.out.println("1. Registrar tarjeta de débito");
        System.out.println("2. Registrar tarjeta de crédito");
        System.out.println("3. Ver solicitudes pendientes");
        System.out.println("4. Autorizar solicitud");
        System.out.println("5. Rechazar solicitud");
        System.out.println("6. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea pendiente

        switch (opcion) {
            case 1:
                // Aquí llamarías al método para registrar una tarjeta de débito
                TarjetaDebito tarjetaDebito = new TarjetaDebito(null, null, 0, null, null, null);
                tarjetaDebito.crearTarjetaDebito();
                break;
            case 2:
                // Aquí llamarías al método para registrar una tarjeta de crédito
                TarjetaCredito tarjetaCredito = new TarjetaCredito(null, null, opcion, null, null, null);
                tarjetaCredito.crearTarjetaCredito();
                break;
            case 3:
                // Aquí llamarías al método para ver las solicitudes pendientes
                SistemaTarjetas.getSolicitudesPendientes(opcion);
                break;
            case 4:
                // Aquí llamarías al método para autorizar una solicitud

                break;
            case 5:
                // Aquí llamarías al método para rechazar una solicitud
                break;
            case 6:
                return;
            default:
                System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
        }
    }

}
