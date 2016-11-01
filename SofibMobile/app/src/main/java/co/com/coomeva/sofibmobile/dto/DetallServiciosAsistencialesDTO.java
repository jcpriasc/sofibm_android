package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 30/09/16.
 */
public class DetallServiciosAsistencialesDTO implements Serializable {

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    private String estado;
    private Date fecha;
    private String fechaTexto;

    public DetallServiciosAsistencialesDTO() {
    }

    public DetallServiciosAsistencialesDTO(String estado, Date fecha) {
        this.estado = estado;
        this.fecha = fecha;
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

    public String getFechaTexto() {
        if (fecha != null) {
            fechaTexto = simple.format(fecha);
        }
        return fechaTexto;
    }

    public void setFechaTexto(String fechaTexto) {
        this.fechaTexto = fechaTexto;
    }
}
