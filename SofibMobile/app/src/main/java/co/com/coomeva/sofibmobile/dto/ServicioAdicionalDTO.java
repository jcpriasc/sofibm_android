package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;

/**
 * Created by cesarlopez on 3/10/16.
 */
public class ServicioAdicionalDTO implements Serializable {

    private String nombre;
    private String descripcion;
    private String proveedor;

    public ServicioAdicionalDTO() {
    }

    public ServicioAdicionalDTO(String nombre, String descripcion, String proveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}
