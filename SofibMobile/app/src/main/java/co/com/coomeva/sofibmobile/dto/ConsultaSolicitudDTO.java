package co.com.coomeva.sofibmobile.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ConsultaSolicitudDTO {

    private String nombrePaciente;
    private String estado;
    private Date fechaSolicitud;
    private String fechaSolicitudString;
    private String descripcion;
    private String tipoAutorizacion;
    private String tipoEntidad;
    private String solicitante;
    private String autoriza;
    private Date fechaAutorizacion;
    private String fechaAutorizacionTexto;
    private String servicio;
    private String proveedor;
    private String prestador;
    private String justificacion;
    private String numeroSolicitud;
    private String identificacion;
    private String convenio;
    private String credencialPaciente;
    private String ciudadInicial;
    private String ciudadActual;
    private String traslado;
    private Date fechaProgramadaRegreso;
    private Date fechaCreado;
    private String fechaProgramadaRegresoString;
    private String fechaCreadoString;


    public ConsultaSolicitudDTO() {
    }

    public ConsultaSolicitudDTO(String nombrePaciente, String estado, Date fechaSolicitud) {
        this.nombrePaciente = nombrePaciente;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
    }

    public ConsultaSolicitudDTO(String numeroSolicitud, String identificacion, String nombrePaciente, String convenio) {
        this.numeroSolicitud = numeroSolicitud;
        this.identificacion = identificacion;
        this.nombrePaciente = nombrePaciente;
        this.convenio = convenio;
    }

    public ConsultaSolicitudDTO(String nombrePaciente, String estado, String fechaSolicitudString, String descripcion, String tipoAutorizacion, String tipoEntidad, String solicitante, String autoriza, String fechaAutorizacionTexto, String servicio, String proveedor, String prestador, String justificacion, String numeroSolicitud, String identificacion, String convenio, String credencialPaciente, String ciudadInicial, String ciudadActual, String traslado, String fechaProgramadaRegresoString, String fechaCreadoString) {
        this.nombrePaciente = nombrePaciente;
        this.estado = estado;
        this.fechaSolicitudString = fechaSolicitudString;
        this.descripcion = descripcion;
        this.tipoAutorizacion = tipoAutorizacion;
        this.tipoEntidad = tipoEntidad;
        this.solicitante = solicitante;
        this.autoriza = autoriza;
        this.fechaAutorizacionTexto = fechaAutorizacionTexto;
        this.servicio = servicio;
        this.proveedor = proveedor;
        this.prestador = prestador;
        this.justificacion = justificacion;
        this.numeroSolicitud = numeroSolicitud;
        this.identificacion = identificacion;
        this.convenio = convenio;
        this.credencialPaciente = credencialPaciente;
        this.ciudadInicial = ciudadInicial;
        this.ciudadActual = ciudadActual;
        this.traslado = traslado;
        this.fechaProgramadaRegresoString = fechaProgramadaRegresoString;
        this.fechaCreadoString = fechaCreadoString;
    }

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoAutorizacion() {
        return tipoAutorizacion;
    }

    public void setTipoAutorizacion(String tipoAutorizacion) {
        this.tipoAutorizacion = tipoAutorizacion;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getFechaAutorizacionTexto() {

        if (this.fechaAutorizacion != null) {
            this.fechaAutorizacionTexto = simple.format(this.fechaAutorizacion);
        }
        return this.fechaAutorizacionTexto;
    }

    public void setFechaAutorizacionTexto(String fechaAutorizacionTexto) {
        this.fechaAutorizacionTexto = fechaAutorizacionTexto;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
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

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCredencialPaciente() {
        return credencialPaciente;
    }

    public void setCredencialPaciente(String credencialPaciente) {
        this.credencialPaciente = credencialPaciente;
    }

    public String getCiudadInicial() {
        return ciudadInicial;
    }

    public void setCiudadInicial(String ciudadInicial) {
        this.ciudadInicial = ciudadInicial;
    }

    public String getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(String ciudadActual) {
        this.ciudadActual = ciudadActual;
    }

    public String getTraslado() {
        return traslado;
    }

    public void setTraslado(String traslado) {
        this.traslado = traslado;
    }

    public Date getFechaProgramadaRegreso() {
        return fechaProgramadaRegreso;
    }

    public void setFechaProgramadaRegreso(Date fechaProgramadaRegreso) {
        this.fechaProgramadaRegreso = fechaProgramadaRegreso;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public String getFechaProgramadaRegresoString() {
        if (fechaProgramadaRegreso != null) {
            fechaProgramadaRegresoString = simple.format(fechaProgramadaRegreso);
        }
        return fechaProgramadaRegresoString;
    }

    public void setFechaProgramadaRegresoString(String fechaProgramadaRegresoString) {
        this.fechaProgramadaRegresoString = fechaProgramadaRegresoString;
    }

    public String getFechaCreadoString() {
        if (fechaCreado != null) {
            fechaCreadoString = simple.format(fechaCreado);
        }
        return fechaCreadoString;
    }

    public void setFechaCreadoString(String fechaCreadoString) {
        this.fechaCreadoString = fechaCreadoString;
    }
}
