package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 30/09/16.
 */
public class AdministracionesDTO implements Serializable {

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    private Double totalAdministraciones;
    private String totalAdministracionesTexto;
    private Double trm;
    private String trmTexto;
    private Double subTotal;
    private String subTotalTexto;
    private Double porcentajeIva;
    private String porcentajeIvaTexto;
    private Double valorIva;
    private String valorIvaTexto;
    private Date fechaCreadoAdministraciones;
    private String fechaCreadoAdministracionesTexto;

    public AdministracionesDTO() {
    }

    public AdministracionesDTO(Double totalAdministraciones, Double trm, Double subTotal, Double porcentajeIva, Double valorIva, Date fechaCreadoAdministraciones) {
        this.totalAdministraciones = totalAdministraciones;
        this.trm = trm;
        this.subTotal = subTotal;
        this.porcentajeIva = porcentajeIva;
        this.valorIva = valorIva;
        this.fechaCreadoAdministraciones = fechaCreadoAdministraciones;
    }

    public AdministracionesDTO(String totalAdministracionesTexto, String trmTexto, String subTotalTexto, String porcentajeIvaTexto, String valorIvaTexto, String fechaCreadoAdministracionesTexto) {
        this.totalAdministracionesTexto = totalAdministracionesTexto;
        this.trmTexto = trmTexto;
        this.subTotalTexto = subTotalTexto;
        this.porcentajeIvaTexto = porcentajeIvaTexto;
        this.valorIvaTexto = valorIvaTexto;
        this.fechaCreadoAdministracionesTexto = fechaCreadoAdministracionesTexto;
    }

    public Double getTotalAdministraciones() {
        return totalAdministraciones;
    }

    public void setTotalAdministraciones(Double totalAdministraciones) {
        this.totalAdministraciones = totalAdministraciones;
    }

    public String getTotalAdministracionesTexto() {
        if(totalAdministraciones != null){
            totalAdministracionesTexto = Utilities.formatearNumeroDoubleAMoneda(totalAdministraciones);
        }
        return totalAdministracionesTexto;
    }

    public void setTotalAdministracionesTexto(String totalAdministracionesTexto) {
        this.totalAdministracionesTexto = totalAdministracionesTexto;
    }

    public Double getTrm() {
        return trm;
    }

    public void setTrm(Double trm) {
        this.trm = trm;
    }

    public String getTrmTexto() {
        if(trm != null){
            trmTexto = Utilities.formatearNumeroDoubleAMoneda(trm);
        }
        return trmTexto;
    }

    public void setTrmTexto(String trmTexto) {
        this.trmTexto = trmTexto;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public String getSubTotalTexto() {
        if(subTotal != null){
            subTotalTexto = Utilities.formatearNumeroDoubleAMoneda(subTotal);
        }
        return subTotalTexto;
    }

    public void setSubTotalTexto(String subTotalTexto) {
        this.subTotalTexto = subTotalTexto;
    }

    public Double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(Double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public String getPorcentajeIvaTexto() {
        if(porcentajeIva != null){
            porcentajeIvaTexto = porcentajeIva+"%";
        }
        return porcentajeIvaTexto;
    }

    public void setPorcentajeIvaTexto(String porcentajeIvaTexto) {
        this.porcentajeIvaTexto = porcentajeIvaTexto;
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

    public Date getFechaCreadoAdministraciones() {
        return fechaCreadoAdministraciones;
    }

    public void setFechaCreadoAdministraciones(Date fechaCreadoAdministraciones) {
        this.fechaCreadoAdministraciones = fechaCreadoAdministraciones;
    }

    public String getFechaCreadoAdministracionesTexto() {
        if (fechaCreadoAdministraciones != null) {
            fechaCreadoAdministracionesTexto = simple.format(fechaCreadoAdministraciones);
        }
        return fechaCreadoAdministracionesTexto;
    }

    public void setFechaCreadoAdministracionesTexto(String fechaCreadoAdministracionesTexto) {
        this.fechaCreadoAdministracionesTexto = fechaCreadoAdministracionesTexto;
    }
}
