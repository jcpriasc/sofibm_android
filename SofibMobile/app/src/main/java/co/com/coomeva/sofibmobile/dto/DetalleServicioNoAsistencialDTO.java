package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cesarlopez on 3/10/16.
 */
public class DetalleServicioNoAsistencialDTO implements Serializable {

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
    private String proveedor;
    private String servicio;
    private Date fecha;
    private String fechaTexto;
    private String descripcionRestriccion;
    private List<ServicioAdicionalDTO> lstServiciosAdicionales;

    public DetalleServicioNoAsistencialDTO() {
    }

    public DetalleServicioNoAsistencialDTO(String proveedor, String servicio,String fechaTexto, String descripcionRestriccion, List<ServicioAdicionalDTO> lstServiciosAdicionales) {
        this.proveedor = proveedor;
        this.servicio = servicio;
        this.fechaTexto = fechaTexto;
        this.descripcionRestriccion = descripcionRestriccion;
        this.lstServiciosAdicionales = lstServiciosAdicionales;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaTexto() {
        if(fecha!=null){
            fechaTexto = simple.format(fecha);
        }
        return fechaTexto;
    }

    public void setFechaTexto(String fechaTexto) {
        this.fechaTexto = fechaTexto;
    }

    public String getDescripcionRestriccion() {
        return descripcionRestriccion;
    }

    public void setDescripcionRestriccion(String descripcionRestriccion) {
        this.descripcionRestriccion = descripcionRestriccion;
    }

    public List<ServicioAdicionalDTO> getLstServiciosAdicionales() {
        return lstServiciosAdicionales;
    }

    public void setLstServiciosAdicionales(List<ServicioAdicionalDTO> lstServiciosAdicionales) {
        this.lstServiciosAdicionales = lstServiciosAdicionales;
    }
}
