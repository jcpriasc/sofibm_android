package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 27/09/16.
 */
public class NotaCreditoDebitoDTO implements Serializable{

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
    private String numeroNota;
    private String numeroFactura;
    private Date fechaExpedicion;
    private String fechaExpedicionTexto;
    private Date fechaAprobacion;
    private String fechaAprobacionTexto;
    private String ciudad;
    private String proveedor;
    private String motivo;
    private String estado;
    private String tipoNota;
    private Double valorTotalNotaCredito;
    private String valorTotalNotaCreditoTexto;
    private String consNota;

    public NotaCreditoDebitoDTO() {
    }

    public NotaCreditoDebitoDTO(String numeroNota, String numeroFactura, Date fechaExpedicion, Date fechaAprobacion) {
        this.numeroNota = numeroNota;
        this.numeroFactura = numeroFactura;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaAprobacion = fechaAprobacion;
    }

    public NotaCreditoDebitoDTO(String numeroNota, String numeroFactura, String fechaExpedicionTexto, String fechaAprobacionTexto, String ciudad, String estado, String proveedor, String motivo, String tipoNota, String valorTotalNotaCreditoTexto, String consNota) {
        this.numeroNota = numeroNota;
        this.numeroFactura = numeroFactura;
        this.fechaExpedicionTexto = fechaExpedicionTexto;
        this.fechaAprobacionTexto = fechaAprobacionTexto;
        this.ciudad = ciudad;
        this.estado = estado;
        this.proveedor = proveedor;
        this.motivo = motivo;
        this.tipoNota = tipoNota;
        this.valorTotalNotaCreditoTexto = valorTotalNotaCreditoTexto;
        this.consNota = consNota;
    }

    public SimpleDateFormat getSimple() {
        return simple;
    }

    public void setSimple(SimpleDateFormat simple) {
        this.simple = simple;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getFechaExpedicionTexto() {
        if (fechaExpedicion != null) {
            fechaExpedicionTexto = simple.format(fechaExpedicion);
        }
        return fechaExpedicionTexto;
    }

    public void setFechaExpedicionTexto(String fechaExpedicionTexto) {
        this.fechaExpedicionTexto = fechaExpedicionTexto;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getFechaAprobacionTexto() {
        if (fechaAprobacion != null) {
            fechaAprobacionTexto = simple.format(fechaAprobacion);
        }
        return fechaAprobacionTexto;
    }

    public void setFechaAprobacionTexto(String fechaAprobacionTexto) {
        this.fechaAprobacionTexto = fechaAprobacionTexto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public Double getValorTotalNotaCredito() {
        return valorTotalNotaCredito;
    }

    public void setValorTotalNotaCredito(Double valorTotalNotaCredito) {
        this.valorTotalNotaCredito = valorTotalNotaCredito;
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

    public String getConsNota() {
        return consNota;
    }

    public void setConsNota(String consNota) {
        this.consNota = consNota;
    }
}
