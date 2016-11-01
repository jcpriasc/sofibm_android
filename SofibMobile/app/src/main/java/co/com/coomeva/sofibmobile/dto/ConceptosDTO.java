package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 4/10/16.
 */
public class ConceptosDTO implements Serializable {

    private String concepto;
    private String descripcion;
    private String cantidad;
    private Double valor;
    private String valorTexto;
    private String reliquidacion;
    private Double subtotal;
    private String subtotalTexto;
    private Double trm;
    private String trmTexto;
    private Double total;
    private String totalTexto;

    public ConceptosDTO() {
    }

    public ConceptosDTO(String concepto, String descripcion, String cantidad, Double valor, String reliquidacion, Double subtotal, Double trm, Double total) {
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.reliquidacion = reliquidacion;
        this.subtotal = subtotal;
        this.trm = trm;
        this.total = total;
    }


    public ConceptosDTO(String concepto, String descripcion, String cantidad, String valorTexto, String reliquidacion, String subtotalTexto, String trmTexto, String totalTexto) {
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valorTexto = valorTexto;
        this.reliquidacion = reliquidacion;
        this.subtotalTexto = subtotalTexto;
        this.trmTexto = trmTexto;
        this.totalTexto = totalTexto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getValorTexto() {

        if(valor!= null){
            valorTexto = Utilities.formatearNumeroDoubleAMoneda(valor);
        }
        return valorTexto;
    }

    public void setValorTexto(String valorTexto) {
        this.valorTexto = valorTexto;
    }

    public String getReliquidacion() {
        return reliquidacion;
    }

    public void setReliquidacion(String reliquidacion) {
        this.reliquidacion = reliquidacion;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getSubtotalTexto() {
        if(subtotal!= null){
            subtotalTexto = Utilities.formatearNumeroDoubleAMoneda(subtotal);
        }
        return subtotalTexto;
    }

    public void setSubtotalTexto(String subtotalTexto) {
        this.subtotalTexto = subtotalTexto;
    }

    public Double getTrm() {
        return trm;
    }

    public void setTrm(Double trm) {
        this.trm = trm;
    }

    public String getTrmTexto() {
        if(trm!= null){
            trmTexto = Utilities.formatearNumeroDoubleAMoneda(trm);
        }
        return trmTexto;
    }

    public void setTrmTexto(String trmTexto) {
        this.trmTexto = trmTexto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTotalTexto() {
        if(total!= null){
            totalTexto = Utilities.formatearNumeroDoubleAMoneda(total);
        }
        return totalTexto;
    }

    public void setTotalTexto(String totalTexto) {
        this.totalTexto = totalTexto;
    }
}
