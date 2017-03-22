package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 5/10/16.
 */
public class InformacionFacturaDTO implements Serializable{

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    private String proveedor;
    private String numeroOrdenServicio;
    private String servicio;
    private String fechaInicioTexto;
    private String fechaFinalizacionTexto;
    private String valorServicioTexto;
    private String seguroHoteleroTexto;
    private String tipoPago;

    private Date fechaInicio;
    private Date fechaFinalizacion;
    private Double valorServicio;
    private Double seguroHotelero;


    public InformacionFacturaDTO() {
    }

    public InformacionFacturaDTO(String proveedor, String numeroOrdenServicio, String servicio, String tipoPago, Date fechaInicio, Date fechaFinalizacion, Double valorServicio, Double seguroHotelero) {
        this.proveedor = proveedor;
        this.numeroOrdenServicio = numeroOrdenServicio;
        this.servicio = servicio;
        this.tipoPago = tipoPago;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.valorServicio = valorServicio;
        this.seguroHotelero = seguroHotelero;
    }

    public InformacionFacturaDTO(String proveedor, String numeroOrdenServicio, String servicio, String fechaInicioTexto, String fechaFinalizacionTexto, String valorServicioTexto, String seguroHoteleroTexto, String tipoPago) {
        this.proveedor = proveedor;
        this.numeroOrdenServicio = numeroOrdenServicio;
        this.servicio = servicio;
        this.fechaInicioTexto = fechaInicioTexto;
        this.fechaFinalizacionTexto = fechaFinalizacionTexto;
        this.valorServicioTexto = valorServicioTexto;
        this.seguroHoteleroTexto = seguroHoteleroTexto;
        this.tipoPago = tipoPago;
    }

    public InformacionFacturaDTO(String proveedor, String numeroOrdenServicio, String servicio, String fechaInicioTexto, String fechaFinalizacionTexto, Double valorServicio, Double seguroHotelero, String tipoPago) {
        this.proveedor = proveedor;
        this.numeroOrdenServicio = numeroOrdenServicio;
        this.servicio = servicio;
        this.fechaInicioTexto = fechaInicioTexto;
        this.fechaFinalizacionTexto = fechaFinalizacionTexto;
        this.valorServicio = valorServicio;
        this.seguroHotelero = seguroHotelero;
        this.tipoPago = tipoPago;
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

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
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

    public Double getSeguroHotelero() {
        return seguroHotelero;
    }

    public void setSeguroHotelero(Double seguroHotelero) {
        this.seguroHotelero = seguroHotelero;
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
}
