package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 5/10/16.
 */
public class ServicioNotaCreditoDebitoDTO implements Serializable{

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    private String numeroOrdenServicio;
    private String tipoImpuesto;
    private String servicio;
    private String porcentajeTexto;
    private String valorImpuestoTexto;
    private String aplicaSeguroHotelero;

    private Double valorImpuesto;
    private Double porcentaje;



    public ServicioNotaCreditoDebitoDTO() {
    }

    public ServicioNotaCreditoDebitoDTO(String numeroOrdenServicio, String tipoImpuesto, String servicio, String aplicaSeguroHotelero, Double valorImpuesto, Double porcentaje) {
        this.numeroOrdenServicio = numeroOrdenServicio;
        this.tipoImpuesto = tipoImpuesto;
        this.servicio = servicio;
        this.aplicaSeguroHotelero = aplicaSeguroHotelero;
        this.valorImpuesto = valorImpuesto;
        this.porcentaje = porcentaje;
    }

    public ServicioNotaCreditoDebitoDTO(String numeroOrdenServicio, String tipoImpuesto, String servicio, String porcentajeTexto, String valorImpuestoTexto, String aplicaSeguroHotelero) {
        this.numeroOrdenServicio = numeroOrdenServicio;
        this.tipoImpuesto = tipoImpuesto;
        this.servicio = servicio;
        this.porcentajeTexto = porcentajeTexto;
        this.valorImpuestoTexto = valorImpuestoTexto;
        this.aplicaSeguroHotelero = aplicaSeguroHotelero;
    }

    public String getNumeroOrdenServicio() {
        return numeroOrdenServicio;
    }

    public void setNumeroOrdenServicio(String numeroOrdenServicio) {
        this.numeroOrdenServicio = numeroOrdenServicio;
    }

    public String getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(String tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getPorcentajeTexto() {
        if(porcentaje != null){
            porcentajeTexto = porcentaje + "%";
        }

        return porcentajeTexto;
    }

    public void setPorcentajeTexto(String porcentajeTexto) {
        this.porcentajeTexto = porcentajeTexto;
    }

    public String getValorImpuestoTexto() {
        if(valorImpuesto != null){
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

    public Double getValorImpuesto() {
        return valorImpuesto;
    }

    public void setValorImpuesto(Double valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
