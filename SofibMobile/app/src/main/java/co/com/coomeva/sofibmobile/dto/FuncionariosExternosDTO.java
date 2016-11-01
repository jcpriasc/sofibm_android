package co.com.coomeva.sofibmobile.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by cesarlopez on 30/09/16.
 */
public class FuncionariosExternosDTO implements Serializable {

    private SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");

    private String funcionariosExternosAreaMedica;
    private String medico;
    private String especialidad;
    private Date fechaCita;
    private String fechaCitaTexto;

    public FuncionariosExternosDTO() {
    }

    public FuncionariosExternosDTO(String funcionariosExternosAreaMedica, String medico, String especialidad, String fechaCita) {
        this.funcionariosExternosAreaMedica = funcionariosExternosAreaMedica;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fechaCitaTexto = fechaCita;
    }

    public String getFuncionariosExternosAreaMedica() {
        return funcionariosExternosAreaMedica;
    }

    public void setFuncionariosExternosAreaMedica(String funcionariosExternosAreaMedica) {
        this.funcionariosExternosAreaMedica = funcionariosExternosAreaMedica;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getFechaCitaTexto() {
        if (fechaCita != null) {
            fechaCitaTexto = simple.format(fechaCita);
        }
        return fechaCitaTexto;
    }

    public void setFechaCitaTexto(String fechaCitaTexto) {
        this.fechaCitaTexto = fechaCitaTexto;
    }


}