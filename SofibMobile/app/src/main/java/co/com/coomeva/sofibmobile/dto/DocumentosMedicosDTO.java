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
    private String id;

    public DocumentosMedicosDTO() {
    }

    public DocumentosMedicosDTO(String nombre, String tipoDocumento, byte[] imagen, String id) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.imagen = imagen;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
