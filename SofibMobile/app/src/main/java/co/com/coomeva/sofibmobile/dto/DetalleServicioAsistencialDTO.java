package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;

/**
 * Created by cesarlopez on 12/12/16.
 */

public class DetalleServicioAsistencialDTO implements Serializable{

    private String estado;
    private String fecha;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
