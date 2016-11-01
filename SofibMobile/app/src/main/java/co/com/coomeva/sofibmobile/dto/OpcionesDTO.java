package co.com.coomeva.sofibmobile.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class OpcionesDTO {

    private String id;
    private String nombreOpcion;
    private int icono;

    public OpcionesDTO(String id, String nombreOpcion, int icono) {
        this.id = id;
        this.nombreOpcion = nombreOpcion;
        this.icono = icono;
    }

    public String getNombreOpcion() {
        return nombreOpcion;
    }

    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
