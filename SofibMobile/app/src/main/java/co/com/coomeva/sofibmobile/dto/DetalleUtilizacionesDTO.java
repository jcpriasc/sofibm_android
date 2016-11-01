package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 30/09/16.
 */
public class DetalleUtilizacionesDTO implements Serializable {

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    private String tipoSeguro;
    private String numeroSeguro;
    private String prestadorProveedor;
    private String concepto;
    private Double totalUtilizaciones;
    private String totalUtilizacionesTexto;
    private Double totalGlosa;
    private String totalGlosaTexto;
    private Date fechaCreado;
    private String fechaCreadoTexto;

    public DetalleUtilizacionesDTO() {
    }

    public DetalleUtilizacionesDTO(String tipoSeguro, String numeroSeguro, String prestadorProveedor, String concepto, Double totalUtilizaciones, Double totalGlosa, Date fechaCreado) {
        this.tipoSeguro = tipoSeguro;
        this.numeroSeguro = numeroSeguro;
        this.prestadorProveedor = prestadorProveedor;
        this.concepto = concepto;
        this.totalUtilizaciones = totalUtilizaciones;
        this.totalGlosa = totalGlosa;
        this.fechaCreado = fechaCreado;
    }


    public DetalleUtilizacionesDTO(String tipoSeguro, String numeroSeguro, String prestadorProveedor, String concepto, String totalUtilizacionesTexto, String totalGlosaTexto, String fechaCreadoTexto) {
        this.tipoSeguro = tipoSeguro;
        this.numeroSeguro = numeroSeguro;
        this.prestadorProveedor = prestadorProveedor;
        this.concepto = concepto;
        this.totalUtilizacionesTexto = totalUtilizacionesTexto;
        this.totalGlosaTexto = totalGlosaTexto;
        this.fechaCreadoTexto = fechaCreadoTexto;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(String numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public String getPrestadorProveedor() {
        return prestadorProveedor;
    }

    public void setPrestadorProveedor(String prestadorProveedor) {
        this.prestadorProveedor = prestadorProveedor;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getTotalUtilizaciones() {
        return totalUtilizaciones;
    }

    public void setTotalUtilizaciones(Double totalUtilizaciones) {
        this.totalUtilizaciones = totalUtilizaciones;
    }

    public String getTotalUtilizacionesTexto() {
        if(totalUtilizaciones != null){
            totalUtilizacionesTexto = Utilities.formatearNumeroDoubleAMoneda(totalUtilizaciones);
        }
        return totalUtilizacionesTexto;
    }

    public void setTotalUtilizacionesTexto(String totalUtilizacionesTexto) {
        this.totalUtilizacionesTexto = totalUtilizacionesTexto;
    }

    public Double getTotalGlosa() {
        return totalGlosa;
    }

    public void setTotalGlosa(Double totalGlosa) {
        this.totalGlosa = totalGlosa;
    }

    public String getTotalGlosaTexto() {
        if(totalGlosa != null){
            totalGlosaTexto = Utilities.formatearNumeroDoubleAMoneda(totalGlosa);
        }
        return totalGlosaTexto;
    }

    public void setTotalGlosaTexto(String totalGlosaTexto) {
        this.totalGlosaTexto = totalGlosaTexto;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public String getFechaCreadoTexto() {
        if (fechaCreado != null) {
            fechaCreadoTexto = simple.format(fechaCreado);
        }
        return fechaCreadoTexto;
    }

    public void setFechaCreadoTexto(String fechaCreadoTexto) {
        this.fechaCreadoTexto = fechaCreadoTexto;
    }
}
