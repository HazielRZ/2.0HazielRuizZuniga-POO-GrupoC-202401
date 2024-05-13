package Tarjeta;
import Roles.Cliente;
import Sucursales.Sucursales;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SolicitudTarjetaCredito {
    private Cliente solicitarTarjetaCredito;
    private TipoTarjeta tipoTarjeta;
    private Solicitud status;
    LocalDateTime fechaDeSolicitud;
    int idSolicitud ;
    private static int ID_SOLICITUD;

    static ArrayList<SolicitudTarjetaCredito> listaSolicitudes;


    public SolicitudTarjetaCredito(Cliente clienteSolicitando, TipoTarjeta tipoTarjeta, Solicitud status, LocalDateTime fechaDeSolicitud) {
        this.solicitarTarjetaCredito = clienteSolicitando;
        this.tipoTarjeta = tipoTarjeta;
        this.status = status;
        this.fechaDeSolicitud = fechaDeSolicitud;
        this.idSolicitud = ID_SOLICITUD;
        ID_SOLICITUD++;
    }
    public static void mostrarListaSolicitudes(){
        for (SolicitudTarjetaCredito solicitud : Sucursales.listaSolicitudes) {
            System.out.println("\nID de Solicitud: " + solicitud.getIdSolicitud());
            System.out.println("Usuario: " + solicitud.solicitarTarjetaCredito().getNombre());
            System.out.println("Tipo de Tarjeta: " + solicitud.getTipoTarjeta());
            System.out.println("Estado: " + solicitud.getStatus());
            System.out.println("Fecha de Solicitud: " + solicitud.getFechaDeSolicitud());
            System.out.println();
        }
    }
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setStatus(Solicitud status) {
        this.status = status;
    }

    public Cliente solicitarTarjetaCredito() {
        return solicitarTarjetaCredito;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }
    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
    public Solicitud getStatus() {
        return status;
    }

    public LocalDateTime getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }

}
