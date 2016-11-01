package co.com.coomeva.sofibmobile.dto;

import java.util.ArrayList;

/**
 * Created by JuanCamilo on 9/30/16.
 */
public class ListExpDTO {

    private String name;
    private ArrayList<ListExpDetalleDTO> bitacoraDetalleList;

    public ListExpDTO(ArrayList<ListExpDetalleDTO> bitacoraDetalleList, String name) {
        this.bitacoraDetalleList = bitacoraDetalleList;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ListExpDetalleDTO> getBitacoraDetalleList() {
        return bitacoraDetalleList;
    }

    public void setBitacoraDetalleList(ArrayList<ListExpDetalleDTO> bitacoraDetalleList) {
        this.bitacoraDetalleList = bitacoraDetalleList;
    }
}
