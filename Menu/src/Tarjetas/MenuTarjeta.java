package Tarjetas;

import java.util.Scanner;

public class MenuTarjeta {


    // Método para el menú de operaciones como cliente
    public static <Cliente> void menuOperacionesCliente(Scanner scanner, SistemaTarjetas sistemaTarjetas) {

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
                SistemaTarjetas.verTarjetasDebitoCliente(opcion);
                break;
            case 2:
                // Aquí llamarías al método para ver las tarjetas de crédito del cliente
                SistemaTarjetas.verTarjetasCreditoCliente(opcion);
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
    public static void menuOperacionesConTarjetas(Scanner scanner, SistemaTarjetas sistemaTarjetas) {
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