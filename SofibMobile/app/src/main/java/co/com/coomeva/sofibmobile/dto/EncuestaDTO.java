package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 27/09/16.
 */
public class EncuestaDTO implements Serializable{

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
    private String pregunta;
    private String respuesta;
    private String observacion;


    public EncuestaDTO() {
    }

    public EncuestaDTO(String pregunta, String respuesta, String observacion) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.observacion = observacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
