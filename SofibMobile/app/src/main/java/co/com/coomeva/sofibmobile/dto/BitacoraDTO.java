package co.com.coomeva.sofibmobile.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class BitacoraDTO {

    private String numeroSolicitud;
    private String nombrePaciente;
    private String ciudadInicial;
    private String tipoRegistro;
    private String tipoServicio;
    private String tipoAccion;
    private String estado;
    private String descripcion;
    private String nombreUsuario;
    private Date fechaCreado;
    private String fechaCreadoString;


    public BitacoraDTO() {
    }

    public BitacoraDTO(String numeroSolicitud, String nombrePaciente, String tipoRegistro, String tipoAccion, String estado) {
        this.numeroSolicitud = numeroSolicitud;
        this.nombrePaciente = nombrePaciente;
        this.tipoRegistro = tipoRegistro;
        this.tipoAccion = tipoAccion;
        this.estado = estado;
    }

    public BitacoraDTO(String numeroSolicitud, String nombrePaciente, String ciudadInicial, String tipoRegistro, String tipoServicio, String tipoAccion, String estado, String descripcion, String nombreUsuario, String fechaCreadoString) {
        this.numeroSolicitud = numeroSolicitud;
        this.nombrePaciente = nombrePaciente;
        this.ciudadInicial = ciudadInicial;
        this.tipoRegistro = tipoRegistro;
        this.tipoServicio = tipoServicio;
        this.tipoAccion = tipoAccion;
        this.estado = estado;
        this.descripcion = descripcion;
        this.nombreUsuario = nombreUsuario;
        this.fechaCreadoString = fechaCreadoString;
    }

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getCiudadInicial() {
        return ciudadInicial;
    }

    public void setCiudadInicial(String ciudadInicial) {
        this.ciudadInicial = ciudadInicial;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
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
