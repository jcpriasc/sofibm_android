package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 4/10/16.
 */
public class DetalleGiroDTO implements Serializable {
    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    private String beneficiario;
    private Double montoDiarioAcompañante;
    private String montoDiarioAcompañanteTexto ;
    private Date fechaInicio;
    private String fechaInicioTexto;
    private Date fechaFin;
    private String fechaFinTexto;
    private Double subtotalConceptos;
    private String subtotalConceptosTexto;
    private Double totalConceptos;
    private String totalConceptosTexto;
    private List<ManutencionDTO> lstManutencion;
    private List<ConceptosDTO> lstConceptos;
    private List<HistoricoGirosDTO> lstHistoricoGiro;

    public DetalleGiroDTO() {
    }


    public DetalleGiroDTO(String beneficiario, Double montoDiarioAcompañante, Date fechaInicio, Date fechaFin, Double subtotalConceptos, Double totalConceptos, List<ManutencionDTO> lstManutencion, List<ConceptosDTO> lstConceptos, List<HistoricoGirosDTO> lstHistoricoGiro) {
        this.beneficiario = beneficiario;
        this.montoDiarioAcompañante = montoDiarioAcompañante;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.subtotalConceptos = subtotalConceptos;
        this.totalConceptos = totalConceptos;
        this.lstManutencion = lstManutencion;
        this.lstConceptos = lstConceptos;
        this.lstHistoricoGiro = lstHistoricoGiro;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Double getMontoDiarioAcompañante() {
        return montoDiarioAcompañante;
    }

    public void setMontoDiarioAcompañante(Double montoDiarioAcompañante) {
        this.montoDiarioAcompañante = montoDiarioAcompañante;
    }

    public String getMontoDiarioAcompañanteTexto() {

        if(montoDiarioAcompañante != null){
            montoDiarioAcompañanteTexto =  Utilities.formatearNumeroDoubleAMoneda(montoDiarioAcompañante);
        }
        return montoDiarioAcompañanteTexto;
    }

    public void setMontoDiarioAcompañanteTexto(String montoDiarioAcompañanteTexto) {
        this.montoDiarioAcompañanteTexto = montoDiarioAcompañanteTexto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaInicioTexto() {
        if(fechaInicio!=null){
            fechaInicioTexto = simple.format(fechaInicio);
        }
        return fechaInicioTexto;
    }

    public void setFechaInicioTexto(String fechaInicioTexto) {
        this.fechaInicioTexto = fechaInicioTexto;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaFinTexto() {
        if(fechaFin!=null){
            fechaFinTexto = simple.format(fechaFin);
        }
        return fechaFinTexto;
    }

    public void setFechaFinTexto(String fechaFinTexto) {
        this.fechaFinTexto = fechaFinTexto;
    }

    public Double getSubtotalConceptos() {
        return subtotalConceptos;
    }

    public void setSubtotalConceptos(Double subtotalConceptos) {
        this.subtotalConceptos = subtotalConceptos;
    }

    public String getSubtotalConceptosTexto() {
        if(subtotalConceptos != null){
            subtotalConceptosTexto =  Utilities.formatearNumeroDoubleAMoneda(subtotalConceptos);
        }
        return subtotalConceptosTexto;
    }

    public void setSubtotalConceptosTexto(String subtotalConceptosTexto) {
        this.subtotalConceptosTexto = subtotalConceptosTexto;
    }

    public Double getTotalConceptos() {
        return totalConceptos;
    }

    public void setTotalConceptos(Double totalConceptos) {
        this.totalConceptos = totalConceptos;
    }

    public String getTotalConceptosTexto() {
        if(totalConceptos != null){
            totalConceptosTexto =  Utilities.formatearNumeroDoubleAMoneda(totalConceptos);
        }
        return totalConceptosTexto;
    }

    public void setTotalConceptosTexto(String totalConceptosTexto) {
        this.totalConceptosTexto = totalConceptosTexto;
    }

    public List<ManutencionDTO> getLstManutencion() {
        return lstManutencion;
    }

    public void setLstManutencion(List<ManutencionDTO> lstManutencion) {
        this.lstManutencion = lstManutencion;
    }

    public List<ConceptosDTO> getLstConceptos() {
        return lstConceptos;
    }

    public void setLstConceptos(List<ConceptosDTO> lstConceptos) {
        this.lstConceptos = lstConceptos;
    }

    public List<HistoricoGirosDTO> getLstHistoricoGiro() {
        return lstHistoricoGiro;
    }

    public void setLstHistoricoGiro(List<HistoricoGirosDTO> lstHistoricoGiro) {
        this.lstHistoricoGiro = lstHistoricoGiro;
    }
}
