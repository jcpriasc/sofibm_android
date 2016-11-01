package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 5/10/16.
 */
public class DetalleNotaCreditoDebitoDTO implements Serializable {

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
    private String numeroFactura;
    private String fechaEmisionTexto;
    private String fechaVencimientoPagoTexto;
    private String fechaRecibidoCoomevaTexto;
    private String proveedor;
    private String valorTotalFacturaTexto;
    private String valorTotalAPagarTexto;
    private String numeroNota;
    private String fechaExpedicionTexto;
    private String fechaRecibidoCoomevaNotaCreditoTexto;
    private String motivo;
    private String valorTotalNotaCreditoTexto;
    private String valorTotalServicioTexto;
    private String valorTotalSeguroHoteleroTexto;
    private String valorTotalNotaTexto;
    private String valorIvaTexto;
    private Date fechaEmision;
    private Date fechaVencimientoPago;
    private Date fechaRecibidoCoomeva;
    private Double valorTotalFactura;
    private Double valorTotalAPagar;
    private Date fechaExpedicion;
    private Date fechaRecibidoCoomevaNotaCredito;
    private Double valorTotalNotaCredito;
    private Double valorTotalServicio;
    private Double valorTotalSeguroHotelero;
    private Double valorTotalNota;
    private Double valorIva;
    private String numeroOrdenServicio;
    private String servicio;

    private List<ImpuestoNotaCreditoDebitoDTO> lsImpuestoNotaCreditoDebito;
    private List<ServicioNotaCreditoDebitoDTO> lstServicioNotaCreditoDebito;


    public DetalleNotaCreditoDebitoDTO() {
    }

    public DetalleNotaCreditoDebitoDTO(String numeroFactura, String proveedor, String numeroNota, String motivo, Date fechaEmision, Date fechaVencimientoPago, Date fechaRecibidoCoomeva, Double valorTotalFactura, Double valorTotalAPagar, Date fechaExpedicion, Date fechaRecibidoCoomevaNotaCredito, Double valorTotalServicio, Double valorTotalNotaCredito, Double valorTotalSeguroHotelero, Double valorTotalNota, Double valorIva, List<ImpuestoNotaCreditoDebitoDTO> lsImpuestoNotaCreditoDebito, List<ServicioNotaCreditoDebitoDTO> lstServicioNotaCreditoDebito, String numeroOrdenServicio, String servicio) {
        this.numeroFactura = numeroFactura;
        this.proveedor = proveedor;
        this.numeroNota = numeroNota;
        this.motivo = motivo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimientoPago = fechaVencimientoPago;
        this.fechaRecibidoCoomeva = fechaRecibidoCoomeva;
        this.valorTotalFactura = valorTotalFactura;
        this.valorTotalAPagar = valorTotalAPagar;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaRecibidoCoomevaNotaCredito = fechaRecibidoCoomevaNotaCredito;
        this.valorTotalServicio = valorTotalServicio;
        this.valorTotalNotaCredito = valorTotalNotaCredito;
        this.valorTotalSeguroHotelero = valorTotalSeguroHotelero;
        this.valorTotalNota = valorTotalNota;
        this.valorIva = valorIva;
        this.lsImpuestoNotaCreditoDebito = lsImpuestoNotaCreditoDebito;
        this.lstServicioNotaCreditoDebito = lstServicioNotaCreditoDebito;
        this.numeroOrdenServicio = numeroOrdenServicio;
        this.servicio = servicio;

    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaEmisionTexto() {
        if(fechaEmision != null){
            fechaEmisionTexto = simple.format(fechaEmision);
        }
        return fechaEmisionTexto;
    }

    public void setFechaEmisionTexto(String fechaEmisionTexto) {
        this.fechaEmisionTexto = fechaEmisionTexto;
    }

    public String getFechaVencimientoPagoTexto() {
        if(fechaVencimientoPago != null){
            fechaVencimientoPagoTexto = simple.format(fechaVencimientoPago);
        }
        return fechaVencimientoPagoTexto;
    }

    public void setFechaVencimientoPagoTexto(String fechaVencimientoPagoTexto) {
        this.fechaVencimientoPagoTexto = fechaVencimientoPagoTexto;
    }

    public String getFechaRecibidoCoomevaTexto() {
        if(fechaRecibidoCoomeva != null){
            fechaRecibidoCoomevaTexto = simple.format(fechaRecibidoCoomeva);
        }
        return fechaRecibidoCoomevaTexto;
    }

    public void setFechaRecibidoCoomevaTexto(String fechaRecibidoCoomevaTexto) {
        this.fechaRecibidoCoomevaTexto = fechaRecibidoCoomevaTexto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getValorTotalFacturaTexto() {
        if(valorTotalFactura != null){
            valorTotalFacturaTexto = Utilities.formatearNumeroDoubleAMoneda(valorTotalFactura);
        }
        return valorTotalFacturaTexto;
    }

    public void setValorTotalFacturaTexto(String valorTotalFacturaTexto) {
        this.valorTotalFacturaTexto = valorTotalFacturaTexto;
    }

    public String getValorTotalAPagarTexto() {
        if(valorTotalAPagar != null){
            valorTotalAPagarTexto = Utilities.formatearNumeroDoubleAMoneda(valorTotalAPagar);
        }
        return valorTotalAPagarTexto;
    }

    public void setValorTotalAPagarTexto(String valorTotalAPagarTexto) {
        this.valorTotalAPagarTexto = valorTotalAPagarTexto;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getFechaExpedicionTexto() {
        if(fechaExpedicion != null){
            fechaExpedicionTexto = simple.format(fechaExpedicion);
        }
        return fechaExpedicionTexto;
    }

    public void setFechaExpedicionTexto(String fechaExpedicionTexto) {
        this.fechaExpedicionTexto = fechaExpedicionTexto;
    }

    public String getFechaRecibidoCoomevaNotaCreditoTexto() {
        if(fechaRecibidoCoomevaNotaCredito != null){
            fechaRecibidoCoomevaNotaCreditoTexto = simple.format(fechaRecibidoCoomevaNotaCredito);
        }
        return fechaRecibidoCoomevaNotaCreditoTexto;
    }

    public void setFechaRecibidoCoomevaNotaCreditoTexto(String fechaRecibidoCoomevaNotaCreditoTexto) {
        this.fechaRecibidoCoomevaNotaCreditoTexto = fechaRecibidoCoomevaNotaCreditoTexto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getValorTotalNotaCreditoTexto() {
        if(valorTotalNotaCredito != null){
            valorTotalNotaCreditoTexto = Utilities.formatearNumeroDoubleAMoneda(valorTotalNotaCredito);
        }
        return valorTotalNotaCreditoTexto;
    }

    public void setValorTotalNotaCreditoTexto(String valorTotalNotaCreditoTexto) {
        this.valorTotalNotaCreditoTexto = valorTotalNotaCreditoTexto;
    }

    public String getValorTotalServicioTexto() {
        if(valorTotalServicio != null){
            valorTotalServicioTexto = Utilities.formatearNumeroDoubleAMoneda(valorTotalServicio);
        }
        return valorTotalServicioTexto;
    }

    public void setValorTotalServicioTexto(String valorTotalServicioTexto) {
        this.valorTotalServicioTexto = valorTotalServicioTexto;
    }

    public String getValorTotalSeguroHoteleroTexto() {
        if(valorTotalSeguroHotelero != null){
            valorTotalSeguroHoteleroTexto = Utilities.formatearNumeroDoubleAMoneda(valorTotalSeguroHotelero);
        }
        return valorTotalSeguroHoteleroTexto;
    }

    public void setValorTotalSeguroHoteleroTexto(String valorTotalSeguroHoteleroTexto) {
        this.valorTotalSeguroHoteleroTexto = valorTotalSeguroHoteleroTexto;
    }

    public String getValorTotalNotaTexto() {
        if(valorTotalNota != null){
            valorTotalNotaTexto = Utilities.formatearNumeroDoubleAMoneda(valorTotalNota);
        }
        return valorTotalNotaTexto;
    }

    public void setValorTotalNotaTexto(String valorTotalNotaTexto) {
        this.valorTotalNotaTexto = valorTotalNotaTexto;
    }

    public String getValorIvaTexto() {
        if(valorIva != null){
            valorIvaTexto = Utilities.formatearNumeroDoubleAMoneda(valorIva);
        }
        return valorIvaTexto;
    }

    public void setValorIvaTexto(String valorIvaTexto) {
        this.valorIvaTexto = valorIvaTexto;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimientoPago() {
        return fechaVencimientoPago;
    }

    public void setFechaVencimientoPago(Date fechaVencimientoPago) {
        this.fechaVencimientoPago = fechaVencimientoPago;
    }

    public Date getFechaRecibidoCoomeva() {
        return fechaRecibidoCoomeva;
    }

    public void setFechaRecibidoCoomeva(Date fechaRecibidoCoomeva) {
        this.fechaRecibidoCoomeva = fechaRecibidoCoomeva;
    }

    public Double getValorTotalFactura() {
        return valorTotalFactura;
    }

    public void setValorTotalFactura(Double valorTotalFactura) {
        this.valorTotalFactura = valorTotalFactura;
    }

    public Double getValorTotalAPagar() {
        return valorTotalAPagar;
    }

    public void setValorTotalAPagar(Double valorTotalAPagar) {
        this.valorTotalAPagar = valorTotalAPagar;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Date getFechaRecibidoCoomevaNotaCredito() {
        return fechaRecibidoCoomevaNotaCredito;
    }

    public void setFechaRecibidoCoomevaNotaCredito(Date fechaRecibidoCoomevaNotaCredito) {
        this.fechaRecibidoCoomevaNotaCredito = fechaRecibidoCoomevaNotaCredito;
    }

    public Double getValorTotalServicio() {
        return valorTotalServicio;
    }

    public void setValorTotalServicio(Double valorTotalServicio) {
        this.valorTotalServicio = valorTotalServicio;
    }

    public Double getValorTotalSeguroHotelero() {
        return valorTotalSeguroHotelero;
    }

    public void setValorTotalSeguroHotelero(Double valorTotalSeguroHotelero) {
        this.valorTotalSeguroHotelero = valorTotalSeguroHotelero;
    }

    public Double getValorTotalNota() {
        return valorTotalNota;
    }

    public void setValorTotalNota(Double valorTotalNota) {
        this.valorTotalNota = valorTotalNota;
    }

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }

    public List<ImpuestoNotaCreditoDebitoDTO> getLsImpuestoNotaCreditoDebito() {
        return lsImpuestoNotaCreditoDebito;
    }

    public void setLsImpuestoNotaCreditoDebito(List<ImpuestoNotaCreditoDebitoDTO> lsImpuestoNotaCreditoDebito) {
        this.lsImpuestoNotaCreditoDebito = lsImpuestoNotaCreditoDebito;
    }

    public List<ServicioNotaCreditoDebitoDTO> getLstServicioNotaCreditoDebito() {
        return lstServicioNotaCreditoDebito;
    }

    public void setLstServicioNotaCreditoDebito(List<ServicioNotaCreditoDebitoDTO> lstServicioNotaCreditoDebito) {
        this.lstServicioNotaCreditoDebito = lstServicioNotaCreditoDebito;
    }

    public Double getValorTotalNotaCredito() {
        return valorTotalNotaCredito;
    }

    public void setValorTotalNotaCredito(Double valorTotalNotaCredito) {
        this.valorTotalNotaCredito = valorTotalNotaCredito;
    }

    public String getNumeroOrdenServicio() {
        return numeroOrdenServicio;
    }

    public void setNumeroOrdenServicio(String numeroOrdenServicio) {
        this.numeroOrdenServicio = numeroOrdenServicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}
