package co.com.coomeva.sofibmobile.dto;

/**
 * Created by JuanCamilo on 9/30/16.
 */
public class ListExpDetalleDTO {

    private int icon;
    private String text;

    public ListExpDetalleDTO(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
