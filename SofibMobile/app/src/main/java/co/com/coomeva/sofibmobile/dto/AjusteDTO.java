package co.com.coomeva.sofibmobile.dto;

/**
 * Created by JuanCamilo on 9/28/16.
 */
public class AjusteDTO {

    private String nombre;
    private int imagen;

    public AjusteDTO() {
    }

    public AjusteDTO(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
