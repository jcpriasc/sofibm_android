package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 4/10/16.
 */
public class ManutencionDTO implements Serializable {

    private String estado;
    private String edadHasta;
    private String edadDesde;
    private Double montoDiario;
    private String montoDiarioTexto;

    public ManutencionDTO() {
    }

    public ManutencionDTO(String estado, String edadHasta, String edadDesde, String montoDiarioTexto) {
        this.estado = estado;
        this.edadHasta = edadHasta;
        this.edadDesde = edadDesde;
        this.montoDiarioTexto = montoDiarioTexto;
    }



    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEdadHasta() {
        return edadHasta;
    }

    public void setEdadHasta(String edadHasta) {
        this.edadHasta = edadHasta;
    }

    public String getEdadDesde() {
        return edadDesde;
    }

    public void setEdadDesde(String edadDesde) {
        this.edadDesde = edadDesde;
    }

    public Double getMontoDiario() {
        return montoDiario;
    }

    public void setMontoDiario(Double montoDiario) {
        this.montoDiario = montoDiario;
    }

    public String getMontoDiarioTexto() {
        if(montoDiario != null ){
            montoDiarioTexto = Utilities.formatearNumeroDoubleAMoneda(montoDiario);
        }
        return montoDiarioTexto;
    }

    public void setMontoDiarioTexto(String montoDiarioTexto) {
        this.montoDiarioTexto = montoDiarioTexto;
    }
}
