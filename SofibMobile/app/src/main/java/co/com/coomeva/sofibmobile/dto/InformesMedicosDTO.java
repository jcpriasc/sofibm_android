package co.com.coomeva.sofibmobile.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class InformesMedicosDTO {

    private String ciudad;
    private String dadoDeAlta;
    private String fallecio;
    private String estado;
    private String entidadPrestadora;
    private String evolucionDelPaciente;
    private String tipoPaciente;
    private Date fechaFinHospitalizacion;
    private String fechaFinHospitalizacionString;
    private Date fechaCreado;
    private String fechaCreadoString;
    private String consInformeMedico;

    public InformesMedicosDTO() {
    }

    public InformesMedicosDTO(String ciudad, String dadoDeAlta, String fallecio, String fechaCreado, String estado, String consInformeMedico) {
        this.ciudad = ciudad;
        this.dadoDeAlta = dadoDeAlta;
        this.fallecio = fallecio;
        this.fechaCreadoString = fechaCreado;
        this.estado = estado;
        this.consInformeMedico = consInformeMedico;
    }

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    public String getFechaFinHospitalizacionString() {
        if (fechaFinHospitalizacion != null) {
            fechaFinHospitalizacionString = simple.format(fechaFinHospitalizacion);
        }
        return fechaFinHospitalizacionString;
    }

    public void setFechaFinHospitalizacionString(String fechaFinHospitalizacionString) {
        this.fechaFinHospitalizacionString = fechaFinHospitalizacionString;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDadoDeAlta() {
        return dadoDeAlta;
    }

    public void setDadoDeAlta(String dadoDeAlta) {
        this.dadoDeAlta = dadoDeAlta;
    }

    public String getFallecio() {
        return fallecio;
    }

    public void setFallecio(String fallecio) {
        this.fallecio = fallecio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEntidadPrestadora() {
        return entidadPrestadora;
    }

    public void setEntidadPrestadora(String entidadPrestadora) {
        this.entidadPrestadora = entidadPrestadora;
    }

    public String getEvolucionDelPaciente() {
        return evolucionDelPaciente;
    }

    public void setEvolucionDelPaciente(String evolucionDelPaciente) {
        this.evolucionDelPaciente = evolucionDelPaciente;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public Date getFechaFinHospitalizacion() {
        return fechaFinHospitalizacion;
    }

    public void setFechaFinHospitalizacion(Date fechaFinHospitalizacion) {
        this.fechaFinHospitalizacion = fechaFinHospitalizacion;
    }

    public Date getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public String getFechaCreadoString() {
        if (fechaCreado != null) {
            fechaCreadoString = simple.format(fechaCreado);
        }
        return fechaCreadoString;
    }

    public void setFechaCreadoString(String fechaCreadoString) {
        this.fechaCreadoString = fechaCreadoString;
    }

    public String getConsInformeMedico() {
        return consInformeMedico;
    }

    public void setConsInformeMedico(String consInformeMedico) {
        this.consInformeMedico = consInformeMedico;
    }
}
