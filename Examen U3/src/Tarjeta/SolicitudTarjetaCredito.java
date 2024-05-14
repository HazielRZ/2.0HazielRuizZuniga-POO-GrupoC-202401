package Tarjeta;

import Roles.Cliente;
import utils.Sucursales;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SolicitudTarjetaCredito {
    static Cliente cliente;
    static ArrayList<SolicitudTarjetaCredito> listaSolicitudes;
    private static Cliente solicitarTarjetaCredito;
    private static TipoTarjeta tipoTarjeta;
    private static int ID_SOLICITUD;
    LocalDateTime fechaDeSolicitud;
    int idSolicitud;
    private Solicitud status;


    public SolicitudTarjetaCredito(Cliente clienteSolicitando, TipoTarjeta tipoTarjeta, Solicitud status, LocalDateTime fechaDeSolicitud) {
        solicitarTarjetaCredito = clienteSolicitando;
        SolicitudTarjetaCredito.tipoTarjeta = tipoTarjeta;
        this.status = status;
        this.fechaDeSolicitud = fechaDeSolicitud;
        this.idSolicitud = ID_SOLICITUD;
        ID_SOLICITUD++;
    }

    public static void mostrarListaSolicitudes() {
        for (SolicitudTarjetaCredito solicitud : Sucursales.listaSolicitudes) {
            System.out.println("\nID de Solicitud: " + solicitud.getIdSolicitud());
            System.out.println("Usuario: " + solicitarTarjetaCredito(cliente, tipoTarjeta).getNombre());
            System.out.println("Tipo de Tarjeta: " + solicitud.getTipoTarjeta());
            System.out.println("Estado: " + solicitud.getStatus());
            System.out.println("Fecha de Solicitud: " + solicitud.getFechaDeSolicitud());
            System.out.println();
        }
    }

    public static Cliente getSolicitarTarjetaCredito() {
        return solicitarTarjetaCredito;
    }

    public static void setSolicitarTarjetaCredito(Cliente solicitarTarjetaCredito) {
        SolicitudTarjetaCredito.solicitarTarjetaCredito = solicitarTarjetaCredito;
    }

    public static Cliente solicitarTarjetaCredito(Cliente cliente, TipoTarjeta tipoTarjeta) {
        SolicitudTarjetaCredito nuevaSolicitud = new SolicitudTarjetaCredito(cliente, tipoTarjeta, Solicitud.PENDIENTE, LocalDateTime.now());
        listaSolicitudes.add(nuevaSolicitud);
        return cliente;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
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

}
