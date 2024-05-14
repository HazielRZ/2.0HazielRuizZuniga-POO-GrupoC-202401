package Banco;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SolicitudTarjetaCredito {
    private Cliente clienteSolicitante;
    private static TipoTarjetaDeCredito tipoTarjeta;
    private int idSolicitud;
    private static int ID_SOLICITUD = 1;
    private LocalDateTime fechaDeSolicitud;
    private Solicitud status;
    private static final ArrayList<SolicitudTarjetaCredito> listaSolicitudes = new ArrayList<>();

    public SolicitudTarjetaCredito(Cliente clienteSolicitante, TipoTarjetaDeCredito tipoTarjeta, Solicitud status, LocalDateTime fechaDeSolicitud) {
        this.clienteSolicitante = clienteSolicitante;
        this.tipoTarjeta = tipoTarjeta;
        this.status = status;
        this.fechaDeSolicitud = fechaDeSolicitud;
        this.idSolicitud = ID_SOLICITUD++;
        listaSolicitudes.add(this);
    }
    public static void mostrarListaSolicitudes() {
        for (SolicitudTarjetaCredito solicitud : listaSolicitudes) {
            System.out.println("\nID de Solicitud: " + solicitud.getIdSolicitud());
            System.out.println("Usuario: " + solicitud.getClienteSolicitante().getNombre());
            System.out.println("Tipo de Tarjeta: " + solicitud.getTipoTarjeta());
            System.out.println("Estado: " + solicitud.getStatus());
            System.out.println("Fecha de Solicitud: " + solicitud.getFechaDeSolicitud());
            System.out.println();
        }
    }

    public static Cliente getSolicitarTarjetaCredito() {
        return Cliente.solicitarTarjeta();
    }

    public static void setSolicitarTarjetaCredito(Cliente solicitarTarjetaCredito) {
        Cliente.solicitarTarjeta = solicitarTarjetaCredito;
    }

    public static Cliente solicitarTarjetaCredito(Cliente cliente, TipoTarjeta tipoTarjeta) {
        SolicitudTarjetaCredito nuevaSolicitud = new SolicitudTarjetaCredito(cliente, tipoTarjeta, Solicitud.PENDIENTE, LocalDateTime.now());
        listaSolicitudes.add(nuevaSolicitud);
        return cliente;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public TipoTarjetaDeCredito getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjetaDeCredito tipoTarjeta) {
        SolicitudTarjetaCredito.tipoTarjeta = tipoTarjeta;
    }

    public Solicitud getStatus() {
        return status;
    }

    public void setStatus(Solicitud status) {
        this.status = status;
    }

    public LocalDateTime getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }
    public Cliente getClienteSolicitante() {
        return clienteSolicitante;
    }

}
