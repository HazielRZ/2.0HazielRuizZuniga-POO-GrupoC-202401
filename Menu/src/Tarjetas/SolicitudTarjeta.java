    package Tarjetas;

    public class SolicitudTarjeta {
        private int idCliente;
        private double saldoDebito;
        private TipoTarjeta tipoTarjeta;
        private String estado;

        public SolicitudTarjeta(int idCliente, double saldoDebito, TipoTarjeta tipoTarjeta) {
            this.idCliente = idCliente;
            this.saldoDebito = saldoDebito;
            this.tipoTarjeta = tipoTarjeta;
            this.estado = "En proceso";
        }

        // Métodos para cambiar el estado de la solicitud
        public void aprobar() {
            this.estado = "Aprobada";
        }

        public void rechazar() {
            this.estado = "Rechazada";
        }

        // Otros métodos necesarios
    }
