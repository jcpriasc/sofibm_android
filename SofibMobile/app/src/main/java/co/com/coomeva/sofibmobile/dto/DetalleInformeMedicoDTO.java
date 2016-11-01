package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cesarlopez on 20/10/16.
 */
public class DetalleInformeMedicoDTO implements Serializable {

    private String entidadPrestadora;
    private String evolucionPaciente;
    private String tipoPaciente;
    private String dadoAlta;
    private String fallecido;
    private String fechaHospitalizacion;
    private List<DocumentosMedicosDTO> lstDocumentos;
    private List<DescipcionDTO> lstProcedimientos;
    private List<DescipcionDTO> lstMedicina;

    public DetalleInformeMedicoDTO() {
    }

    public DetalleInformeMedicoDTO(String entidadPrestadora, String evolucionPaciente, String tipoPaciente, String dadoAlta, String fallecido, String fechaHospitalizacion, List<DocumentosMedicosDTO> lstDocumentos, List<DescipcionDTO> lstProcedimientos, List<DescipcionDTO> lstMedicina) {
        this.entidadPrestadora = entidadPrestadora;
        this.evolucionPaciente = evolucionPaciente;
        this.tipoPaciente = tipoPaciente;
        this.dadoAlta = dadoAlta;
        this.fallecido = fallecido;
        this.fechaHospitalizacion = fechaHospitalizacion;
        this.lstDocumentos = lstDocumentos;
        this.lstProcedimientos = lstProcedimientos;
        this.lstMedicina = lstMedicina;
    }


    public String getEntidadPrestadora() {
        return entidadPrestadora;
    }

    public void setEntidadPrestadora(String entidadPrestadora) {
        this.entidadPrestadora = entidadPrestadora;
    }

    public String getEvolucionPaciente() {
        return evolucionPaciente;
    }

    public void setEvolucionPaciente(String evolucionPaciente) {
        this.evolucionPaciente = evolucionPaciente;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public String getDadoAlta() {
        return dadoAlta;
    }

    public void setDadoAlta(String dadoAlta) {
        this.dadoAlta = dadoAlta;
    }

    public String getFallecido() {
        return fallecido;
    }

    public void setFallecido(String fallecido) {
        this.fallecido = fallecido;
    }

    public String getFechaHospitalizacion() {
        return fechaHospitalizacion;
    }

    public void setFechaHospitalizacion(String fechaHospitalizacion) {
        this.fechaHospitalizacion = fechaHospitalizacion;
    }

    public List<DocumentosMedicosDTO> getLstDocumentos() {
        return lstDocumentos;
    }

    public void setLstDocumentos(List<DocumentosMedicosDTO> lstDocumentos) {
        this.lstDocumentos = lstDocumentos;
    }

    public List<DescipcionDTO> getLstProcedimientos() {
        return lstProcedimientos;
    }

    public void setLstProcedimientos(List<DescipcionDTO> lstProcedimientos) {
        this.lstProcedimientos = lstProcedimientos;
    }

    public List<DescipcionDTO> getLstMedicina() {
        return lstMedicina;
    }

    public void setLstMedicina(List<DescipcionDTO> lstMedicina) {
        this.lstMedicina = lstMedicina;
    }
}
