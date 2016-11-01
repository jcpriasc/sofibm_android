package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 5/10/16.
 */
public class DetalleFacturaDTO implements Serializable {

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
    private String numeroFactura;
    private String fechaEmisionTexto;
    private String fechaVencimientoPagoTexto;
    private String fechaRecibidoCoomevaTexto;
    private String proveedor;
    private String valorTotalFacturaTexto;
    private String valorIvaTexto;
    private String valorTotalAPagarTexto;
    private String descripcionGlosa;
    private String motivoGlosa;
    private String aplicaGlosa;
    private String valorGlosaTexto;
    private Date fechaEmision;
    private Date fechaVencimientoPago;
    private Date fechaRecibidoCoomeva;
    private Double valorTotalFactura;
    private Double valorIva;
    private Double  valorTotalAPagar;
    private Double valorGlosa;
    private List<InformacionFacturaDTO> lstInformacionFactura;
    private List<ImpuestoFacturaDTO> lstImpuestoFactura;

    public DetalleFacturaDTO() {
    }

    public DetalleFacturaDTO(String numeroFactura, String proveedor, String descripcionGlosa, String motivoGlosa, String aplicaGlosa, Date fechaEmision, Date fechaVencimientoPago, Date fechaRecibidoCoomeva, Double valorTotalFactura, Double valorIva, Double valorTotalAPagar, Double valorGlosa, List<InformacionFacturaDTO> lstInformacionFactura, List<ImpuestoFacturaDTO> lstImpuestoFactura) {
        this.numeroFactura = numeroFactura;
        this.proveedor = proveedor;
        this.descripcionGlosa = descripcionGlosa;
        this.motivoGlosa = motivoGlosa;
        this.aplicaGlosa = aplicaGlosa;
        this.fechaEmision = fechaEmision;
        this.fechaVencimientoPago = fechaVencimientoPago;
        this.fechaRecibidoCoomeva = fechaRecibidoCoomeva;
        this.valorTotalFactura = valorTotalFactura;
        this.valorIva = valorIva;
        this.valorTotalAPagar = valorTotalAPagar;
        this.valorGlosa = valorGlosa;
        this.lstInformacionFactura = lstInformacionFactura;
        this.lstImpuestoFactura = lstImpuestoFactura;
    }

    public DetalleFacturaDTO(String numeroFactura, String fechaEmisionTexto, String fechaVencimientoPagoTexto, String fechaRecibidoCoomevaTexto, String proveedor, String valorTotalFacturaTexto, String valorIvaTexto, String valorTotalAPagarTexto, String descripcionGlosa, String motivoGlosa, String aplicaGlosa, String valorGlosaTexto, List<InformacionFacturaDTO> lstInformacionFactura, List<ImpuestoFacturaDTO> lstImpuestoFactura) {
        this.numeroFactura = numeroFactura;
        this.fechaEmisionTexto = fechaEmisionTexto;
        this.fechaVencimientoPagoTexto = fechaVencimientoPagoTexto;
        this.fechaRecibidoCoomevaTexto = fechaRecibidoCoomevaTexto;
        this.proveedor = proveedor;
        this.valorTotalFacturaTexto = valorTotalFacturaTexto;
        this.valorIvaTexto = valorIvaTexto;
        this.valorTotalAPagarTexto = valorTotalAPagarTexto;
        this.descripcionGlosa = descripcionGlosa;
        this.motivoGlosa = motivoGlosa;
        this.aplicaGlosa = aplicaGlosa;
        this.valorGlosaTexto = valorGlosaTexto;
        this.lstInformacionFactura = lstInformacionFactura;
        this.lstImpuestoFactura = lstImpuestoFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcionGlosa() {
        return descripcionGlosa;
    }

    public void setDescripcionGlosa(String descripcionGlosa) {
        this.descripcionGlosa = descripcionGlosa;
    }

    public String getMotivoGlosa() {
        return motivoGlosa;
    }

    public void setMotivoGlosa(String motivoGlosa) {
        this.motivoGlosa = motivoGlosa;
    }

    public String getAplicaGlosa() {
        return aplicaGlosa;
    }

    public void setAplicaGlosa(String aplicaGlosa) {
        this.aplicaGlosa = aplicaGlosa;
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

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }

    public Double getValorTotalAPagar() {
        return valorTotalAPagar;
    }

    public void setValorTotalAPagar(Double valorTotalAPagar) {
        this.valorTotalAPagar = valorTotalAPagar;
    }

    public Double getValorGlosa() {
        return valorGlosa;
    }

    public void setValorGlosa(Double valorGlosa) {
        this.valorGlosa = valorGlosa;
    }

    public String getFechaEmisionTexto() {
        if(fechaEmision!= null){
            fechaEmisionTexto = simple.format(fechaEmision);
        }
        return fechaEmisionTexto;
    }

    public void setFechaEmisionTexto(String fechaEmisionTexto) {
        this.fechaEmisionTexto = fechaEmisionTexto;
    }

    public String getFechaVencimientoPagoTexto() {
        if(fechaVencimientoPago!= null){
            fechaVencimientoPagoTexto = simple.format(fechaVencimientoPago);
        }
        return fechaVencimientoPagoTexto;
    }

    public void setFechaVencimientoPagoTexto(String fechaVencimientoPagoTexto) {
        this.fechaVencimientoPagoTexto = fechaVencimientoPagoTexto;
    }

    public String getFechaRecibidoCoomevaTexto() {
        if(fechaRecibidoCoomeva!= null){
            fechaRecibidoCoomevaTexto = simple.format(fechaRecibidoCoomeva);
        }
        return fechaRecibidoCoomevaTexto;
    }

    public void setFechaRecibidoCoomevaTexto(String fechaRecibidoCoomevaTexto) {
        this.fechaRecibidoCoomevaTexto = fechaRecibidoCoomevaTexto;
    }

    public String getValorTotalFacturaTexto() {
        if(valorTotalFactura!= null){
            valorTotalFacturaTexto = Utilities.formatearNumeroDoubleAMoneda(valorTotalFactura);
        }
        return valorTotalFacturaTexto;
    }

    public void setValorTotalFacturaTexto(String valorTotalFacturaTexto) {
        this.valorTotalFacturaTexto = valorTotalFacturaTexto;
    }

    public String getValorIvaTexto() {
        if(valorIva!= null){
            valorIvaTexto = Utilities.formatearNumeroDoubleAMoneda(valorIva);
        }
        return valorIvaTexto;
    }

    public void setValorIvaTexto(String valorIvaTexto) {
        this.valorIvaTexto = valorIvaTexto;
    }

    public String getValorTotalAPagarTexto() {
        if(valorTotalAPagar!= null){
            valorTotalAPagarTexto = Utilities.formatearNumeroDoubleAMoneda(valorTotalAPagar);
        }
        return valorTotalAPagarTexto;
    }

    public void setValorTotalAPagarTexto(String valorTotalAPagarTexto) {
        this.valorTotalAPagarTexto = valorTotalAPagarTexto;
    }

    public String getValorGlosaTexto() {
        if(valorGlosa!= null){
            valorGlosaTexto = Utilities.formatearNumeroDoubleAMoneda(valorGlosa);
        }
        return valorGlosaTexto;
    }

    public void setValorGlosaTexto(String valorGlosaTexto) {
        this.valorGlosaTexto = valorGlosaTexto;
    }

    public List<InformacionFacturaDTO> getLstInformacionFactura() {
        return lstInformacionFactura;
    }

    public void setLstInformacionFactura(List<InformacionFacturaDTO> lstInformacionFactura) {
        this.lstInformacionFactura = lstInformacionFactura;
    }

    public List<ImpuestoFacturaDTO> getLstImpuestoFactura() {
        return lstImpuestoFactura;
    }

    public void setLstImpuestoFactura(List<ImpuestoFacturaDTO> lstImpuestoFactura) {
        this.lstImpuestoFactura = lstImpuestoFactura;
    }
}
