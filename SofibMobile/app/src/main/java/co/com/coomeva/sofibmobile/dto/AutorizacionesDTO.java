package co.com.coomeva.sofibmobile.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/28/16.
 */
public class AutorizacionesDTO {

    private String descripcion;
    private String ciudad;
    private String tipoSolicitud;
    private Date fechaSolicitud;
    private String fechaSolicitudString;
    private String estado;
    private Date fechaAprobacion;
    private String fechaAprobacionString;
    private Date fechaRechazo;
    private String fechaRechazoString;
    private String consDetAutorizacion;

    public AutorizacionesDTO() {
    }

    public AutorizacionesDTO(String descripcion, String ciudad, String tipoSolicitud, String fechaSolicitudString, String estado, String fechaAprobacionString, String fechaRechazoString, String consDetAutorizacion) {
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.tipoSolicitud = tipoSolicitud;
        this.fechaSolicitudString = fechaSolicitudString;
        this.estado = estado;
        this.fechaAprobacionString = fechaAprobacionString;
        this.fechaRechazoString = fechaRechazoString;
        this.consDetAutorizacion = consDetAutorizacion;
    }

    public AutorizacionesDTO(String descripcion) {
        this.descripcion = descripcion;
    }

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaSolicitudString() {
        if (fechaSolicitud != null) {
            fechaSolicitudString = simple.format(fechaSolicitud);
        }
        return fechaSolicitudString;
    }

    public void setFechaSolicitudString(String fechaSolicitudString) {
        this.fechaSolicitudString = fechaSolicitudString;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getFechaAprobacionString() {
        if (fechaAprobacion != null) {
            fechaAprobacionString = simple.format(fechaAprobacion);
        }
        return fechaAprobacionString;
    }

    public void setFechaAprobacionString(String fechaAprobacionString) {
        this.fechaAprobacionString = fechaAprobacionString;
    }

    public Date getFechaRechazo() {
        return fechaRechazo;
    }

    public void setFechaRechazo(Date fechaRechazo) {
        this.fechaRechazo = fechaRechazo;
    }

    public String getFechaRechazoString() {
        if (fechaRechazo != null) {
            fechaRechazoString = simple.format(fechaRechazo);
        }
        return fechaRechazoString;
    }

    public void setFechaRechazoString(String fechaRechazoString) {
        this.fechaRechazoString = fechaRechazoString;
    }

    public String getConsDetAutorizacion() {
        return consDetAutorizacion;
    }

    public void setConsDetAutorizacion(String consDetAutorizacion) {
        this.consDetAutorizacion = consDetAutorizacion;
    }
}
