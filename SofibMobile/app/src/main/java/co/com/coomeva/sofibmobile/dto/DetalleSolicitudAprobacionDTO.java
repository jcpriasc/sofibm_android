package co.com.coomeva.sofibmobile.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cesarlopez on 7/01/17.
 */

public class DetalleSolicitudAprobacionDTO {

    private String identificacion;
    private String nombre;
    private String estadoPaciente;
    private String fechaRegreso;
    private String diagnostico;
    private String convenio;
    private String tipoConvenio;
    private String pais;
    private String entidad;
    private String tipo;
    private String justificacion;
    private List<ProcedimientoDTO> lstProcedimientos;
    private List<DocumentosAprobacionDTO> lstDocumentoAprobacion;

    public DetalleSolicitudAprobacionDTO(String identificacion, String nombre, String estadoPaciente, String fechaRegreso, String diagnostico, String convenio, String tipoConvenio, String pais, String entidad, String tipo, String justificacion, List<ProcedimientoDTO> lstProcedimientos, List<DocumentosAprobacionDTO> lstDocumentoAprobacion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.estadoPaciente = estadoPaciente;
        this.fechaRegreso = fechaRegreso;
        this.diagnostico = diagnostico;
        this.convenio = convenio;
        this.tipoConvenio = tipoConvenio;
        this.pais = pais;
        this.entidad = entidad;
        this.tipo = tipo;
        this.justificacion = justificacion;
        this.lstProcedimientos = lstProcedimientos;
        this.lstDocumentoAprobacion = lstDocumentoAprobacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(String estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(String tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public List<ProcedimientoDTO> getLstProcedimientos() {
        return lstProcedimientos;
    }

    public void setLstProcedimientos(List<ProcedimientoDTO> lstProcedimientos) {
        this.lstProcedimientos = lstProcedimientos;
    }

    public List<DocumentosAprobacionDTO> getLstDocumentoAprobacion() {
        return lstDocumentoAprobacion;
    }

    public void setLstDocumentoAprobacion(List<DocumentosAprobacionDTO> lstDocumentoAprobacion) {
        this.lstDocumentoAprobacion = lstDocumentoAprobacion;
    }
}
