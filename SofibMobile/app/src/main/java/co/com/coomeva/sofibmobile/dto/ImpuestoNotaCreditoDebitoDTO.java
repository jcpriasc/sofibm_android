package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 5/10/16.
 */
public class ImpuestoNotaCreditoDebitoDTO implements Serializable{

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    private String proveedor;
    private String numeroOrdenServicio;
    private String servicio;
    private String fechaInicioTexto;
    private String valorImpuestoTexto;
    private String aplicaSeguroHotelero;
    private String fechaFinalizacionTexto;
    private String valorServicioTexto;
    private String seguroHoteleroTexto;
    private String valorNotaTexto;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private Double valorServicio;
    private Double valorImpuesto;
    private Double seguroHotelero;
    private Double valorNota;



    public ImpuestoNotaCreditoDebitoDTO() {
    }

    public ImpuestoNotaCreditoDebitoDTO(String proveedor, String numeroOrdenServicio, String servicio, String aplicaSeguroHotelero, Date fechaInicio, Double valorServicio, Date fechaFinalizacion, Double valorImpuesto, Double valorNota, Double seguroHotelero) {
        this.proveedor = proveedor;
        this.numeroOrdenServicio = numeroOrdenServicio;
        this.servicio = servicio;
        this.aplicaSeguroHotelero = aplicaSeguroHotelero;
        this.fechaInicio = fechaInicio;
        this.valorServicio = valorServicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.valorImpuesto = valorImpuesto;
        this.valorNota = valorNota;
        this.seguroHotelero = seguroHotelero;
    }

    public ImpuestoNotaCreditoDebitoDTO(String proveedor, String numeroOrdenServicio, String servicio, String fechaInicioTexto, String valorImpuestoTexto, String aplicaSeguroHotelero, String fechaFinalizacionTexto, String seguroHoteleroTexto, String valorServicioTexto, String valorNotaTexto) {
        this.proveedor = proveedor;
        this.numeroOrdenServicio = numeroOrdenServicio;
        this.servicio = servicio;
        this.fechaInicioTexto = fechaInicioTexto;
        this.valorImpuestoTexto = valorImpuestoTexto;
        this.aplicaSeguroHotelero = aplicaSeguroHotelero;
        this.fechaFinalizacionTexto = fechaFinalizacionTexto;
        this.seguroHoteleroTexto = seguroHoteleroTexto;
        this.valorServicioTexto = valorServicioTexto;
        this.valorNotaTexto = valorNotaTexto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
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

    public String getFechaInicioTexto() {

        if(fechaInicio!= null){
            fechaInicioTexto = simple.format(fechaInicio);
        }
        return fechaInicioTexto;
    }

    public void setFechaInicioTexto(String fechaInicioTexto) {
        this.fechaInicioTexto = fechaInicioTexto;
    }

    public String getValorImpuestoTexto() {
        if(valorImpuesto!= null){
            valorImpuestoTexto = Utilities.formatearNumeroDoubleAMoneda(valorImpuesto);
        }
        return valorImpuestoTexto;
    }

    public void setValorImpuestoTexto(String valorImpuestoTexto) {
        this.valorImpuestoTexto = valorImpuestoTexto;
    }

    public String getAplicaSeguroHotelero() {
        return aplicaSeguroHotelero;
    }

    public void setAplicaSeguroHotelero(String aplicaSeguroHotelero) {
        this.aplicaSeguroHotelero = aplicaSeguroHotelero;
    }

    public String getFechaFinalizacionTexto() {
        if(fechaFinalizacion!= null){
            fechaFinalizacionTexto = simple.format(fechaFinalizacion);
        }
        return fechaFinalizacionTexto;
    }

    public void setFechaFinalizacionTexto(String fechaFinalizacionTexto) {
        this.fechaFinalizacionTexto = fechaFinalizacionTexto;
    }

    public String getValorServicioTexto() {
        if(valorServicio!= null){
            valorServicioTexto = Utilities.formatearNumeroDoubleAMoneda(valorServicio);
        }
        return valorServicioTexto;
    }

    public void setValorServicioTexto(String valorServicioTexto) {
        this.valorServicioTexto = valorServicioTexto;
    }

    public String getSeguroHoteleroTexto() {
        if(seguroHotelero!= null){
            seguroHoteleroTexto = Utilities.formatearNumeroDoubleAMoneda(seguroHotelero);
        }
        return seguroHoteleroTexto;
    }

    public void setSeguroHoteleroTexto(String seguroHoteleroTexto) {
        this.seguroHoteleroTexto = seguroHoteleroTexto;
    }

    public String getValorNotaTexto() {
        if(valorNota!= null){
            valorNotaTexto = Utilities.formatearNumeroDoubleAMoneda(valorNota);
        }
        return valorNotaTexto;
    }

    public void setValorNotaTexto(String valorNotaTexto) {
        this.valorNotaTexto = valorNotaTexto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Double getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(Double valorServicio) {
        this.valorServicio = valorServicio;
    }

    public Double getValorImpuesto() {
        return valorImpuesto;
    }

    public void setValorImpuesto(Double valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
    }

    public Double getSeguroHotelero() {
        return seguroHotelero;
    }

    public void setSeguroHotelero(Double seguroHotelero) {
        this.seguroHotelero = seguroHotelero;
    }

    public Double getValorNota() {
        return valorNota;
    }

    public void setValorNota(Double valorNota) {
        this.valorNota = valorNota;
    }
}
