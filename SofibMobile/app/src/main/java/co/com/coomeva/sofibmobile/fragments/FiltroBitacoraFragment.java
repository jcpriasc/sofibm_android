package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.LoginView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.BitacoraDTO;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.dto.SpinnerDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class FiltroBitacoraFragment extends Fragment{

    ImageView imgConsultarBitacora;
    Spinner spinnerTipoServicio;
    Spinner spinnerTipoRegistro;
    //Spinner spinnerCiudad;
    //EditText editTextNombrePaciente;

    private static String tipoRegistro;
    private static String tipoServicio;
    private static String ciudad;
    private static String nombrePaciente;
    public static JSONArray respJSON = null;
    private static List<BitacoraDTO> consultaBitacoraList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filtro_bitacora, container, false);

        //editTextNombrePaciente =(EditText) view.findViewById(R.id.editTextNombrePaciente);

        imgConsultarBitacora = (ImageView) view.findViewById(R.id.search_action);
        //spinnerCiudad = (Spinner) view.findViewById(R.id.spinner_ciudad);
        spinnerTipoRegistro = (Spinner) view.findViewById(R.id.spinner__tipo_registro);
        spinnerTipoServicio = (Spinner) view.findViewById(R.id.spinner_tipo_servicio);


        List<NameValuePair> lst = new ArrayList<NameValuePair>();
        lst.add(new BasicNameValuePair("",""));

        try{

            final SpinnerDTO resultMapTipoServicio = llenar_spinner(getActivity().getResources().getString(R.string.complement_servicios), "/SAC/ABCD1234", "SER");
            final SpinnerDTO resultMapTipoRegistro = llenar_spinner(getActivity().getResources().getString(R.string.complement_tipo_registros), "/SAC/ABCD1234", "REG");
            final SpinnerDTO resultMapCiudad = llenar_spinner(getActivity().getResources().getString(R.string.complement_ciudades), "/SAC/ABCD1234", "CIU");

            if (resultMapTipoServicio!=null){
                ArrayAdapter<String> adapter =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, resultMapTipoServicio.getSpinnerArray());
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTipoServicio.setAdapter(adapter);
            }


            if (resultMapTipoRegistro!=null){
                ArrayAdapter<String> adapter =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, resultMapTipoRegistro.getSpinnerArray());
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTipoRegistro.setAdapter(adapter);
            }


            spinnerTipoRegistro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                    String nameTipoRegistro = spinnerTipoRegistro.getSelectedItem().toString();
                    tipoRegistro = resultMapTipoRegistro.getResultMap().get(nameTipoRegistro);

                    nameTipoRegistro =nameTipoRegistro.replaceAll(" ","%20").toUpperCase();
                    final SpinnerDTO resultMapTipoServicio = llenar_spinner(getActivity().getResources().getString(R.string.complement_tipo_servicios), "SAC/ABCD1234/"+tipoRegistro, "SER");

                    if (resultMapTipoServicio!=null){
                        ArrayAdapter<String> adapter =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, resultMapTipoServicio.getSpinnerArray());
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerTipoServicio.setAdapter(adapter);
                    }else{

                        String[] array = new String[1];
                        array[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad_tipo_servicio);
                        ArrayAdapter<String> adapter =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, array);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerTipoServicio.setAdapter(adapter);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }

            });


            /*if (resultMapCiudad!=null){
                ArrayAdapter<String> adapterCiudad =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, resultMapCiudad.getSpinnerArray());
                adapterCiudad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerCiudad.setAdapter(adapterCiudad);
            }*/

            imgConsultarBitacora.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nameTipoServicio = "";
                    try {

                        String nameTipoRegistro = spinnerTipoRegistro.getSelectedItem().toString();
                        tipoRegistro = resultMapTipoRegistro.getResultMap().get(nameTipoRegistro);

                        if(resultMapTipoServicio == null){
                            nameTipoServicio = spinnerTipoServicio.getSelectedItem().toString();
                            tipoServicio = "0";
                        }else {
                             nameTipoServicio = spinnerTipoServicio.getSelectedItem().toString();
                            tipoServicio = resultMapTipoServicio.getResultMap().get(nameTipoServicio);
                        }
                       // String nameCiudad = spinnerCiudad.getSelectedItem().toString();
                       // ciudad = resultMapCiudad.getResultMap().get(nameCiudad);

                       // nombrePaciente = editTextNombrePaciente.getText().toString();

                       // if (nombrePaciente.equals("")){
                       //     nombrePaciente = "0";
                       // }

                        //Se pidio en control de cambio 215 eliminar filtro nombre paciente y ciudad

                        nombrePaciente = "0";
                        ciudad = "0";

                        String listParams="/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud();
                        listParams+="/"+nombrePaciente;
                        listParams+="/"+ciudad;
                        listParams+="/"+tipoRegistro;
                        listParams+="/"+tipoServicio;
                        listParams+="/"+ LoginView.usuarioSesion.usuario;
                        listParams+="/0";
                        listParams+="/0";
                        listParams+="/NA";

                        ConexionServicioTask task = new ConexionServicioTask(getActivity(), getActivity().getResources().getString(R.string.complement_Bitacoras), listParams);

                        synchronized (task) {
                            task.execute().wait();
                        }

                        respJSON = ConexionServicioTask.respJSON;

                        if (respJSON.length()==0){
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }else {

                            consultaBitacoraList = new ArrayList<BitacoraDTO>();
                            for (int j = 0; j < respJSON.length(); j++) {
                                JSONObject obj = respJSON.getJSONObject(j);
                                String consSolicitudAtencion = obj.getString("consSolicitudAtencion");
                                String tipoEntidad = obj.getString("tipoEntidad");
                                String tipoServicio = obj.getString("tipoServicio");
                                String tipoRegistro = obj.getString("tipoRegistro");
                                String tipoAccion = obj.getString("tipoAccion");
                                String fechaAccion = obj.getString("fechaAccion");
                                String usuario = obj.getString("usuario");
                                String descripcion = obj.getString("descripcion");
                                String nombre = obj.getString("nombre");
                                String estado = obj.getString("estado");
                                String cidudadnombre = obj.getString("cidudadnombre");

                                BitacoraDTO dto = new BitacoraDTO(consSolicitudAtencion, nombre, cidudadnombre, tipoRegistro, tipoServicio, tipoAccion, estado, descripcion, usuario, fechaAccion);
                                consultaBitacoraList.add(dto);
                            }

                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            Fragment fragment = new BitacoraFragment();
                            fragment.setArguments(getActivity().getIntent().getExtras());
                            ft.replace(R.id.fragment_container_bitacora, fragment, "BitacoraFragment").addToBackStack("BitacoraFragment").commit();


                        }

                    }catch (Exception e){
                        Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }catch (Exception e){
           // Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return view;
    }


    private SpinnerDTO llenar_spinner(String serviceName, String listParams, String tipoSpinner){

        SpinnerDTO spinnerDTOs = null;

        try {

            ConexionServicioTask task = new ConexionServicioTask(getActivity(), serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                Map<String, String> resultMap = new HashMap<String, String>();
                String[] spinnerArray = new String[result.length+1];

                if (tipoSpinner.equals("SER")){
                    resultMap.put(getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad_tipo_servicio), "0");
                    spinnerArray[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad_tipo_servicio);
                }else if (tipoSpinner.equals("REG")){
                    resultMap.put(getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad_tipo_registro), "0");
                    spinnerArray[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad_tipo_registro);
                }else if (tipoSpinner.equals("CIU")){
                    resultMap.put(getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad), "0");
                    spinnerArray[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad);
                }

                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String codigo = obj.getString("codigo");
                    String descripcion = "";
                    if (tipoSpinner.equals("SER")){
                        descripcion = obj.getString("descripcion");
                    }else if (tipoSpinner.equals("REG")){
                        descripcion = obj.getString("descripcion");
                    }else if (tipoSpinner.equals("CIU")){
                        descripcion = obj.getString("ciudad");
                    }
                    resultMap.put(descripcion, codigo);
                    spinnerArray[j+1] = descripcion;
                }

                spinnerDTOs = new SpinnerDTO(resultMap, spinnerArray);
            }


        }catch (Exception e){
            //Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return spinnerDTOs ;
    }


    public static String getTipoRegistro() {
        return tipoRegistro;
    }

    public static void setTipoRegistro(String tipoRegistro) {
        FiltroBitacoraFragment.tipoRegistro = tipoRegistro;
    }

    public static String getTipoServicio() {
        return tipoServicio;
    }

    public static void setTipoServicio(String tipoServicio) {
        FiltroBitacoraFragment.tipoServicio = tipoServicio;
    }

    public static String getCiudad() {
        return ciudad;
    }

    public static void setCiudad(String ciudad) {
        FiltroBitacoraFragment.ciudad = ciudad;
    }

    public static String getNombrePaciente() {
        return nombrePaciente;
    }

    public static void setNombrePaciente(String nombrePaciente) {
        FiltroBitacoraFragment.nombrePaciente = nombrePaciente;
    }

    public static List<BitacoraDTO> getConsultaBitacoraList() {
        return consultaBitacoraList;
    }

    public static void setConsultaBitacoraList(List<BitacoraDTO> consultaBitacoraList) {
        FiltroBitacoraFragment.consultaBitacoraList = consultaBitacoraList;
    }
}
