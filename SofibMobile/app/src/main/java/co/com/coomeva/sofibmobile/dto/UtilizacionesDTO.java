package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 27/09/16.
 */
public class UtilizacionesDTO implements Serializable{

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
    private String convenio;
    private Date desde;
    private String desdeTexto;
    private Date hasta;
    private String hastaTexto;
    private String consConvenio;



    public UtilizacionesDTO() {
    }

    public UtilizacionesDTO(String convenio, Date desde, Date hasta) {
        this.convenio = convenio;
        this.desde = desde;
        this.hasta = hasta;
    }

    public UtilizacionesDTO(String convenio, String desdeTexto, String hastaTexto, String consConvenio) {
        this.convenio = convenio;
        this.desdeTexto = desdeTexto;
        this.hastaTexto = hastaTexto;
        this.consConvenio =consConvenio;
    }

    public SimpleDateFormat getSimple() {
        return simple;
    }

    public void setSimple(SimpleDateFormat simple) {
        this.simple = simple;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public String getDesdeTexto() {
        if (desde != null) {
            desdeTexto = simple.format(desde);
        }
        return desdeTexto;
    }

    public void setDesdeTexto(String desdeTexto) {
        this.desdeTexto = desdeTexto;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getHastaTexto() {
        if (hasta != null) {
            hastaTexto = simple.format(hasta);
        }
        return hastaTexto;
    }

    public void setHastaTexto(String hastaTexto) {
        this.hastaTexto = hastaTexto;
    }

    public String getConsConvenio() {
        return consConvenio;
    }

    public void setConsConvenio(String consConvenio) {
        this.consConvenio = consConvenio;
    }
}
