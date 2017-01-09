package co.com.coomeva.sofibmobile.dto;

/**
 * Created by cesarlopez on 7/01/17.
 */

public class DocumentosAprobacionDTO {

    private String tipoArchivo;
    private String nombreDocumento;
    private String archivoString;
    private String id;

    public DocumentosAprobacionDTO(String tipoArchivo, String nombreDocumento, String archivoString, String id) {
        this.tipoArchivo = tipoArchivo;
        this.nombreDocumento = nombreDocumento;
        this.archivoString = archivoString;
        this.id = id;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getArchivoString() {
        return archivoString;
    }

    public void setArchivoString(String archivoString) {
        this.archivoString = archivoString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
