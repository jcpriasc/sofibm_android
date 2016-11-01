package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 27/09/16.
 */
public class NotaCreditoGiroDTO implements Serializable{

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
    private String consecutivoNotaCredito;
    private String ciudad;
    private String idGiroAsociado;
    private String tipoBeneficiario;
    private String nombreBeneficiario;
    private String estado;
    private String tipoGiro;
    private Double valorNota;
    private String valorNotaTexto;
    private Date fechaRegistro;
    private String fechaRegistroTexto;
    private Date fechaLiquidacion;
    private String fechaLiquidacionTexto;

    public NotaCreditoGiroDTO() {
    }

    public NotaCreditoGiroDTO(String consecutivoNotaCredito, String idGiroAsociado, String nombreBeneficiario, String tipoGiro) {
        this.consecutivoNotaCredito = consecutivoNotaCredito;
        this.idGiroAsociado = idGiroAsociado;
        this.nombreBeneficiario = nombreBeneficiario;
        this.tipoGiro = tipoGiro;
    }

    public NotaCreditoGiroDTO(String consecutivoNotaCredito, String ciudad, String idGiroAsociado, String tipoBeneficiario, String nombreBeneficiario, String estado, String tipoGiro, String valorNotaTexto, String fechaRegistroTexto, String fechaLiquidacionTexto) {
        this.consecutivoNotaCredito = consecutivoNotaCredito;
        this.ciudad = ciudad;
        this.idGiroAsociado = idGiroAsociado;
        this.tipoBeneficiario = tipoBeneficiario;
        this.nombreBeneficiario = nombreBeneficiario;
        this.estado = estado;
        this.tipoGiro = tipoGiro;
        this.valorNotaTexto = valorNotaTexto;
        this.fechaRegistroTexto = fechaRegistroTexto;
        this.fechaLiquidacionTexto = fechaLiquidacionTexto;
    }



    public SimpleDateFormat getSimple() {
        return simple;
    }

    public void setSimple(SimpleDateFormat simple) {
        this.simple = simple;
    }

    public String getConsecutivoNotaCredito() {
        return consecutivoNotaCredito;
    }

    public void setConsecutivoNotaCredito(String consecutivoNotaCredito) {
        this.consecutivoNotaCredito = consecutivoNotaCredito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getIdGiroAsociado() {
        return idGiroAsociado;
    }

    public void setIdGiroAsociado(String idGiroAsociado) {
        this.idGiroAsociado = idGiroAsociado;
    }

    public String getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    public void setTipoBeneficiario(String tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoGiro() {
        return tipoGiro;
    }

    public void setTipoGiro(String tipoGiro) {
        this.tipoGiro = tipoGiro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaRegistroTexto() {
        if (fechaRegistro != null) {
            fechaRegistroTexto = simple.format(fechaRegistro);
        }
        return fechaRegistroTexto;
    }

    public void setFechaRegistroTexto(String fechaRegistroTexto) {
        this.fechaRegistroTexto = fechaRegistroTexto;
    }

    public Date getFechaLiquidacion() {
        return fechaLiquidacion;
    }

    public void setFechaLiquidacion(Date fechaLiquidacion) {
        this.fechaLiquidacion = fechaLiquidacion;
    }

    public String getFechaLiquidacionTexto() {
        if (fechaLiquidacion != null) {
            fechaLiquidacionTexto = simple.format(fechaLiquidacion);
        }
        return fechaLiquidacionTexto;
    }

    public void setFechaLiquidacionTexto(String fechaLiquidacionTexto) {
        this.fechaLiquidacionTexto = fechaLiquidacionTexto;
    }

    public Double getValorNota() {
        return valorNota;
    }

    public void setValorNota(Double valorNota) {
        this.valorNota = valorNota;
    }

    public String getValorNotaTexto() {
        if(valorNota != null){
            valorNotaTexto = Utilities.formatearNumeroDoubleAMoneda(valorNota);
        }
        return valorNotaTexto;
    }

    public void setValorNotaTexto(String valorNotaTexto) {
        this.valorNotaTexto = valorNotaTexto;
    }
}
