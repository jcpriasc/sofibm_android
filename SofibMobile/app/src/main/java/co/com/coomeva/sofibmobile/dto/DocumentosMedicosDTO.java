package co.com.coomeva.sofibmobile.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/28/16.
 */
public class DocumentosMedicosDTO {

    private String nombre;
    private String tipoDocumento;
    private byte[] imagen;

    public DocumentosMedicosDTO() {
    }

    public DocumentosMedicosDTO(String nombre, String tipoDocumento, byte[] imagen) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
