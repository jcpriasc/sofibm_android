package co.com.coomeva.sofibmobile.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JuanCamilo on 9/28/16.
 */
public class ProcedimientosAdicionalesDTO {


//

    private String nombreProcedimiento;
    private String prestadorProveedor;
    private String ciudad;

    public ProcedimientosAdicionalesDTO() {
    }

    public ProcedimientosAdicionalesDTO(String nombreProcedimiento, String prestadorProveedor, String ciudad) {
        this.nombreProcedimiento = nombreProcedimiento;
        this.prestadorProveedor = prestadorProveedor;
        this.ciudad = ciudad;
    }

    public String getNombreProcedimiento() {
        return nombreProcedimiento;
    }

    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

    public String getPrestadorProveedor() {
        return prestadorProveedor;
    }

    public void setPrestadorProveedor(String prestadorProveedor) {
        this.prestadorProveedor = prestadorProveedor;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
