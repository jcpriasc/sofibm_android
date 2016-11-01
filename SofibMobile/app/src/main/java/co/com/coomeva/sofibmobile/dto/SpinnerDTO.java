package co.com.coomeva.sofibmobile.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by JuanCamilo on 9/28/16.
 */
public class SpinnerDTO {

    private Map<String, String> resultMap;
    private String[] spinnerArray;

    public SpinnerDTO() {
    }

    public SpinnerDTO(Map<String, String> resultMap, String[] spinnerArray) {
        this.resultMap = resultMap;
        this.spinnerArray = spinnerArray;
    }

    public String[] getSpinnerArray() {
        return spinnerArray;
    }

    public void setSpinnerArray(String[] spinnerArray) {
        this.spinnerArray = spinnerArray;
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }
}
