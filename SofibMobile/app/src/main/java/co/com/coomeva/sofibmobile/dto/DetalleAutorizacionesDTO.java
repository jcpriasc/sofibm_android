package co.com.coomeva.sofibmobile.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/28/16.
 */
public class DetalleAutorizacionesDTO {

    private String descripcion;
    private String justificacionCancelado;
    private String estado;

    public DetalleAutorizacionesDTO() {
    }

    public DetalleAutorizacionesDTO(String descripcion, String justificacionCancelado, String estado) {
        this.descripcion = descripcion;
        this.justificacionCancelado = justificacionCancelado;
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getJustificacionCancelado() {
        return justificacionCancelado;
    }

    public void setJustificacionCancelado(String justificacionCancelado) {
        this.justificacionCancelado = justificacionCancelado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
