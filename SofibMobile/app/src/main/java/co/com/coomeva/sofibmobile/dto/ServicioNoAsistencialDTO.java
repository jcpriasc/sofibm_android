package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ServicioNoAsistencialDTO implements Serializable {

    private String numeroSolicitud;
    private String tipoSolicitud;
    private String ciudad;
    private String justificacionCancelacion;
    private String estado;
    private String consservicio;

    public ServicioNoAsistencialDTO(String numeroSolicitud, String tipoSolicitud, String ciudad) {
        this.numeroSolicitud = numeroSolicitud;
        this.tipoSolicitud = tipoSolicitud;
        this.ciudad = ciudad;
    }

    public ServicioNoAsistencialDTO(String numeroSolicitud, String tipoSolicitud, String justificacionCancelacion, String ciudad, String estado, String consservicio) {
        this.numeroSolicitud = numeroSolicitud;
        this.tipoSolicitud = tipoSolicitud;
        this.justificacionCancelacion = justificacionCancelacion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.consservicio = consservicio;
    }

    public ServicioNoAsistencialDTO() {
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getJustificacionCancelacion() {
        return justificacionCancelacion;
    }

    public void setJustificacionCancelacion(String justificacionCancelacion) {
        this.justificacionCancelacion = justificacionCancelacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getConsservicio() {
        return consservicio;
    }

    public void setConsservicio(String consservicio) {
        this.consservicio = consservicio;
    }
}
