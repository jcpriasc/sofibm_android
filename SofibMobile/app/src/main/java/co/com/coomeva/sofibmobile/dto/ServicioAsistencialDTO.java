package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ServicioAsistencialDTO implements Serializable {

    private String numeroOrden;
    private String sucursal;
    private String idPrestador;
    private String nombrePrestador;
    private String tipoServicio;
    private String codigoProcedimiento;
    private String procedimientoEspanol;
    private String procedimientoIngles;
    private String cantidad;
    private String estado;
    private Date fecha;
    private String fechaString;
    private String id;

    public ServicioAsistencialDTO() {
    }

    public ServicioAsistencialDTO(String numeroOrden, String idPrestador, String nombrePrestador, String tipoServicio) {
        this.numeroOrden = numeroOrden;
        this.idPrestador = idPrestador;
        this.nombrePrestador = nombrePrestador;
        this.tipoServicio = tipoServicio;
    }


    public ServicioAsistencialDTO(String numeroOrden, String sucursal, String idPrestador, String nombrePrestador, String tipoServicio, String codigoProcedimiento, String procedimientoEspanol, String procedimientoIngles, String cantidad, String estado, String fechaString, String id) {
        this.numeroOrden = numeroOrden;
        this.sucursal = sucursal;
        this.idPrestador = idPrestador;
        this.nombrePrestador = nombrePrestador;
        this.tipoServicio = tipoServicio;
        this.codigoProcedimiento = codigoProcedimiento;
        this.procedimientoEspanol = procedimientoEspanol;
        this.procedimientoIngles = procedimientoIngles;
        this.cantidad = cantidad;
        this.estado = estado;
        this.fechaString = fechaString;
        this.id = id;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(String idPrestador) {
        this.idPrestador = idPrestador;
    }

    public String getNombrePrestador() {
        return nombrePrestador;
    }

    public void setNombrePrestador(String nombrePrestador) {
        this.nombrePrestador = nombrePrestador;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getCodigoProcedimiento() {
        return codigoProcedimiento;
    }

    public void setCodigoProcedimiento(String codigoProcedimiento) {
        this.codigoProcedimiento = codigoProcedimiento;
    }

    public String getProcedimientoEspanol() {
        return procedimientoEspanol;
    }

    public void setProcedimientoEspanol(String procedimientoEspanol) {
        this.procedimientoEspanol = procedimientoEspanol;
    }

    public String getProcedimientoIngles() {
        return procedimientoIngles;
    }

    public void setProcedimientoIngles(String procedimientoIngles) {
        this.procedimientoIngles = procedimientoIngles;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaString() {
        return fechaString;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
