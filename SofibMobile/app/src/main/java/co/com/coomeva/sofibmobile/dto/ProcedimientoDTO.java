package co.com.coomeva.sofibmobile.dto;

/**
 * Created by cesarlopez on 7/01/17.
 */

public class ProcedimientoDTO {

    private  String nombreProcedimiento;
    private String prestadorProcedimiento;

    public ProcedimientoDTO(String nombreProcedimiento, String prestadorProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
        this.prestadorProcedimiento = prestadorProcedimiento;
    }

    public String getNombreProcedimiento() {
        return nombreProcedimiento;
    }

    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

    public String getPrestadorProcedimiento() {
        return prestadorProcedimiento;
    }

    public void setPrestadorProcedimiento(String prestadorProcedimiento) {
        this.prestadorProcedimiento = prestadorProcedimiento;
    }
}
