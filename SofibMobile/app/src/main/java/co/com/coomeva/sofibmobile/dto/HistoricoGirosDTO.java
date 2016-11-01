package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 27/09/16.
 */
public class HistoricoGirosDTO implements Serializable{

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
    private String id;
    private String ciudad;
    private String estado;
    private String convenio;
    private String tipoGiro;
    private String tipoBeneficiario;
    private String beneficiario;
    private String fechaInicioTexto;
    private Date fechaInicio;
    private String fechaFinTexto;
    private Date fechaFin;
    private String valorMonedaExtranjeroTexto;
    private Double valorMonedaExtranjero;
    private String valorMonedaLocalTexto;
    private Double valorMonedaLocal;
    private String registraDevolucion;
    private String valorDevolucionTexto;
    private Double valorDevolucion;
    private String legalizado;
    private String valorLegalizadoTexto;
    private Double valorLegalizado;

    public HistoricoGirosDTO() {
    }

    public HistoricoGirosDTO(String id, String estado, String ciudad, String convenio, String tipoGiro, String tipoBeneficiario, String beneficiario, Date fechaInicio, Date fechaFin, Double valorMonedaExtranjero, Double valorMonedaLocal, String registraDevolucion, Double valorDevolucion, String legalizado, Double valorLegalizado) {
        this.id = id;
        this.estado = estado;
        this.ciudad = ciudad;
        this.convenio = convenio;
        this.tipoGiro = tipoGiro;
        this.tipoBeneficiario = tipoBeneficiario;
        this.beneficiario = beneficiario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorMonedaExtranjero = valorMonedaExtranjero;
        this.valorMonedaLocal = valorMonedaLocal;
        this.registraDevolucion = registraDevolucion;
        this.valorDevolucion = valorDevolucion;
        this.legalizado = legalizado;
        this.valorLegalizado = valorLegalizado;
    }

    public HistoricoGirosDTO(String id, String ciudad, String estado, String convenio, String tipoGiro, String tipoBeneficiario, String beneficiario, String fechaInicioTexto, String fechaFinTexto, String valorMonedaExtranjeroTexto, String valorMonedaLocalTexto, String registraDevolucion, String valorDevolucionTexto, String legalizado, String valorLegalizadoTexto) {
        this.id = id;
        this.ciudad = ciudad;
        this.estado = estado;
        this.convenio = convenio;
        this.tipoGiro = tipoGiro;
        this.tipoBeneficiario = tipoBeneficiario;
        this.beneficiario = beneficiario;
        this.fechaInicioTexto = fechaInicioTexto;
        this.fechaFinTexto = fechaFinTexto;
        this.valorMonedaExtranjeroTexto = valorMonedaExtranjeroTexto;
        this.valorMonedaLocalTexto = valorMonedaLocalTexto;
        this.registraDevolucion = registraDevolucion;
        this.valorDevolucionTexto = valorDevolucionTexto;
        this.legalizado = legalizado;
        this.valorLegalizadoTexto = valorLegalizadoTexto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public String getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    public void setTipoBeneficiario(String tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getFechaInicioTexto() {
        if (fechaInicio != null) {
            fechaInicioTexto = simple.format(fechaInicio);
        }
        return fechaInicioTexto;
    }

    public void setFechaInicioTexto(String fechaInicioTexto) {
        this.fechaInicioTexto = fechaInicioTexto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinTexto() {
        if (fechaFin != null) {
            fechaFinTexto = simple.format(fechaFin);
        }
        return fechaFinTexto;
    }

    public void setFechaFinTexto(String fechaFinTexto) {
        this.fechaFinTexto = fechaFinTexto;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getValorMonedaExtranjeroTexto() {

        if(valorMonedaExtranjero != null){
            valorMonedaExtranjeroTexto = Utilities.formatearNumeroDoubleAMoneda(valorMonedaExtranjero);
        }
        return valorMonedaExtranjeroTexto;
    }

    public void setValorMonedaExtranjeroTexto(String valorMonedaExtranjeroTexto) {
        this.valorMonedaExtranjeroTexto = valorMonedaExtranjeroTexto;
    }

    public Double getValorMonedaExtranjero() {
        return valorMonedaExtranjero;
    }

    public void setValorMonedaExtranjero(Double valorMonedaExtranjero) {
        this.valorMonedaExtranjero = valorMonedaExtranjero;
    }

    public String getValorMonedaLocalTexto() {
        if(valorMonedaLocal != null){
            valorMonedaLocalTexto = Utilities.formatearNumeroDoubleAMoneda(valorMonedaLocal);
        }
        return valorMonedaLocalTexto;
    }

    public void setValorMonedaLocalTexto(String valorMonedaLocalTexto) {
        this.valorMonedaLocalTexto = valorMonedaLocalTexto;
    }

    public Double getValorMonedaLocal() {
        return valorMonedaLocal;
    }

    public void setValorMonedaLocal(Double valorMonedaLocal) {
        this.valorMonedaLocal = valorMonedaLocal;
    }

    public String getRegistraDevolucion() {
        return registraDevolucion;
    }

    public void setRegistraDevolucion(String registraDevolucion) {
        this.registraDevolucion = registraDevolucion;
    }

    public String getValorDevolucionTexto() {
        if(valorDevolucion != null){
            valorDevolucionTexto = Utilities.formatearNumeroDoubleAMoneda(valorDevolucion);
        }
        return valorDevolucionTexto;
    }

    public void setValorDevolucionTexto(String valorDevolucionTexto) {
        this.valorDevolucionTexto = valorDevolucionTexto;
    }

    public Double getValorDevolucion() {
        return valorDevolucion;
    }

    public void setValorDevolucion(Double valorDevolucion) {
        this.valorDevolucion = valorDevolucion;
    }

    public String getLegalizado() {
        return legalizado;
    }

    public void setLegalizado(String legalizado) {
        this.legalizado = legalizado;
    }

    public String getValorLegalizadoTexto() {
        if (valorLegalizado != null) {
            valorLegalizadoTexto = Utilities.formatearNumeroDoubleAMoneda(valorLegalizado);
        }
        return valorLegalizadoTexto;
    }

    public void setValorLegalizadoTexto(String valorLegalizadoTexto) {
        this.valorLegalizadoTexto = valorLegalizadoTexto;
    }

    public Double getValorLegalizado() {
        return valorLegalizado;
    }

    public void setValorLegalizado(Double valorLegalizado) {
        this.valorLegalizado = valorLegalizado;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
}
