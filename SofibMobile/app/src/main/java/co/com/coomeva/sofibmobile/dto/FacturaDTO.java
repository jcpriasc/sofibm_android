package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 27/09/16.
 */
public class FacturaDTO implements Serializable{

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
    private String numeroFactura;
    private Date fechaExpedicion;
    private String fechaExpedicionTexto;
    private String estado;
    private Double valorTotalFactura;
    private String valorTotalFacturaTexto;
    private String ciudad;
    private Date fechaRadicacion;
    private String fechaRadicacionTexto;
    private Date fechaAprobacionRechazo;
    private String fechaAprobacionRechazoTexto;
    private Date fechaAnulacion;
    private String fechaAnulacionTexto;
    private Double valorIva;
    private String valorIvaTexto;
    private Double valorTotalPagar;
    private String valorTotalPagarTexto;
    private String prestadorProveedor;
    private String tipoServicio;
    private String consFactura;

    public FacturaDTO() {
    }

    public FacturaDTO(String numeroFactura, Date fechaExpedicion, String estado, Double valorTotalFactura) {
        this.numeroFactura = numeroFactura;
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.valorTotalFactura = valorTotalFactura;
    }

    public FacturaDTO(String numeroFactura, String fechaExpedicionTexto, String estado, String valorTotalFacturaTexto, String ciudad, String fechaRadicacionTexto, String fechaAprobacionRechazoTexto, String fechaAnulacionTexto, String valorIvaTexto, String valorTotalPagarTexto, String prestadorProveedor, String tipoServicio, String consFactura) {
        this.numeroFactura = numeroFactura;
        this.fechaExpedicionTexto = fechaExpedicionTexto;
        this.estado = estado;
        this.valorTotalFacturaTexto = valorTotalFacturaTexto;
        this.ciudad = ciudad;
        this.fechaRadicacionTexto = fechaRadicacionTexto;
        this.fechaAprobacionRechazoTexto = fechaAprobacionRechazoTexto;
        this.fechaAnulacionTexto = fechaAnulacionTexto;
        this.valorIvaTexto = valorIvaTexto;
        this.valorTotalPagarTexto = valorTotalPagarTexto;
        this.prestadorProveedor = prestadorProveedor;
        this.tipoServicio = tipoServicio;
        this.consFactura = consFactura;
    }

    public SimpleDateFormat getSimple() {
        return simple;
    }

    public void setSimple(SimpleDateFormat simple) {
        this.simple = simple;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getValorTotalFactura() {
        return valorTotalFactura;
    }

    public void setValorTotalFactura(Double valorTotalFactura) {
        this.valorTotalFactura = valorTotalFactura;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaRadicacion() {
        return fechaRadicacion;
    }

    public void setFechaRadicacion(Date fechaRadicacion) {
        this.fechaRadicacion = fechaRadicacion;
    }

    public String getFechaRadicacionTexto() {

        if (fechaRadicacion != null) {
            fechaRadicacionTexto = simple.format(fechaRadicacion);
        }
        return fechaRadicacionTexto;
    }

    public void setFechaRadicacionTexto(String fechaRadicacionTexto) {
        this.fechaRadicacionTexto = fechaRadicacionTexto;
    }

    public Date getFechaAprobacionRechazo() {
        return fechaAprobacionRechazo;
    }

    public void setFechaAprobacionRechazo(Date fechaAprobacionRechazo) {
        this.fechaAprobacionRechazo = fechaAprobacionRechazo;
    }

    public String getFechaAprobacionRechazoTexto() {

        if (fechaAprobacionRechazo != null) {
            fechaAprobacionRechazoTexto = simple.format(fechaAprobacionRechazo);
        }
        return fechaAprobacionRechazoTexto;
    }

    public void setFechaAprobacionRechazoTexto(String fechaAprobacionRechazoTexto) {
        this.fechaAprobacionRechazoTexto = fechaAprobacionRechazoTexto;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getFechaAnulacionTexto() {
        if (fechaAnulacion != null) {
            fechaAnulacionTexto = simple.format(fechaAnulacion);
        }
        return fechaAnulacionTexto;
    }

    public void setFechaAnulacionTexto(String fechaAnulacionTexto) {
        this.fechaAnulacionTexto = fechaAnulacionTexto;
    }

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
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

    public Double getValorTotalPagar() {
        return valorTotalPagar;
    }

    public void setValorTotalPagar(Double valorTotalPagar) {
        this.valorTotalPagar = valorTotalPagar;
    }

    public String getValorTotalPagarTexto() {
        if(valorTotalPagar != null){
            valorTotalPagarTexto = Utilities.formatearNumeroDoubleAMoneda(valorTotalPagar);
        }
        return valorTotalPagarTexto;
    }

    public void setValorTotalPagarTexto(String valorTotalPagarTexto) {
        this.valorTotalPagarTexto = valorTotalPagarTexto;
    }

    public String getPrestadorProveedor() {
        return prestadorProveedor;
    }

    public void setPrestadorProveedor(String prestadorProveedor) {
        this.prestadorProveedor = prestadorProveedor;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getConsFactura() {
        return consFactura;
    }

    public void setConsFactura(String consFactura) {
        this.consFactura = consFactura;
    }
}
