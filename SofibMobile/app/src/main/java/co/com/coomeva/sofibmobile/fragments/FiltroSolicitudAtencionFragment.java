package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.dto.SpinnerDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class FiltroSolicitudAtencionFragment extends Fragment{

    ImageView imgConsultarSolicitudes;
    Spinner spinnerConvenio;
    Spinner spinnerEstado;
    Spinner spinnerCiudadInicial;
    Spinner spinnerCiudadActual;
    Spinner spinnerTraslado;

    EditText editTextIdentificacion;
    EditText editTextSolAtencion;
    EditText editTextNombre;

    private static String convenio;
    private static String estado;
    private static String ciudadInicial;
    private static String ciudadActual;
    private static String traslado = "NA";
    private static String identificacion;
    private static String solAtencion;
    private static String nombre;
    public static JSONArray respJSON = null;
    private static List<ConsultaSolicitudDTO> consultaSolicitudList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filtro_solicitud_atencion, container, false);

        editTextIdentificacion =(EditText) view.findViewById(R.id.editTextIdentificacion);
        editTextSolAtencion =(EditText) view.findViewById(R.id.editTextSolAtencion);
        editTextNombre =(EditText) view.findViewById(R.id.editTextNombre);

        imgConsultarSolicitudes = (ImageView) view.findViewById(R.id.search_action);
        spinnerConvenio = (Spinner) view.findViewById(R.id.spinner_convenios);
        spinnerEstado = (Spinner) view.findViewById(R.id.spinner_estados);
        spinnerCiudadInicial = (Spinner) view.findViewById(R.id.spinner_ciudad_inicial);
        spinnerCiudadActual = (Spinner) view.findViewById(R.id.spinner_ciudad_actual);
        spinnerTraslado = (Spinner) view.findViewById(R.id.spinner_traslado);


        List<NameValuePair> lst = new ArrayList<NameValuePair>();
        lst.add(new BasicNameValuePair("",""));

        try{

            final SpinnerDTO resultMapConvenio = llenar_spinner(getActivity().getResources().getString(R.string.complement_convenios), "/SAC/ABCD1234/0", "CON");
            final SpinnerDTO resultMapEstado = llenar_spinner(getActivity().getResources().getString(R.string.complement_estados), "/SAC/ABCD1234", "EST");
            final SpinnerDTO resultMapCiudadInicial = llenar_spinner(getActivity().getResources().getString(R.string.complement_ciudades), "/SAC/ABCD1234", "CIU_INI");
            final SpinnerDTO resultMapCiudadActual = llenar_spinner(getActivity().getResources().getString(R.string.complement_ciudades), "/SAC/ABCD1234", "CIU_ACT");

            if (resultMapConvenio!=null){
                ArrayAdapter<String> adapter =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, resultMapConvenio.getSpinnerArray());
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerConvenio.setAdapter(adapter);
            }

            if (resultMapEstado!=null){
                ArrayAdapter<String> adapter =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, resultMapEstado.getSpinnerArray());
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerEstado.setAdapter(adapter);
            }

            if (resultMapCiudadInicial!=null){
                ArrayAdapter<String> adapterCiudadInicial =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, resultMapCiudadInicial.getSpinnerArray());
                adapterCiudadInicial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerCiudadInicial.setAdapter(adapterCiudadInicial);
            }

            if (resultMapCiudadActual!=null){
                ArrayAdapter<String> adapterCiudadActual =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, resultMapCiudadActual.getSpinnerArray());
                adapterCiudadActual.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerCiudadActual.setAdapter(adapterCiudadActual);
            }



            ArrayAdapter<CharSequence> adapterTraslado = ArrayAdapter.createFromResource(view.getContext(),R.array.traslado_array, android.R.layout.simple_spinner_item);
            adapterTraslado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTraslado.setAdapter(adapterTraslado);


            imgConsultarSolicitudes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {

                        String nameConvenio = spinnerConvenio.getSelectedItem().toString();
                        convenio = resultMapConvenio.getResultMap().get(nameConvenio);

                        String nameEstado = spinnerEstado.getSelectedItem().toString();
                        estado = resultMapEstado.getResultMap().get(nameEstado);

                        String nameCiudadInicial = spinnerCiudadInicial.getSelectedItem().toString();
                        ciudadInicial = resultMapCiudadInicial.getResultMap().get(nameCiudadInicial);

                        String nameCiudadActual = spinnerCiudadActual.getSelectedItem().toString();
                        ciudadActual = resultMapCiudadActual.getResultMap().get(nameCiudadActual);

//                        int traslado = spinnerTraslado.getSelectedItemPosition();

                        identificacion = editTextIdentificacion.getText().toString();

                        if (identificacion.equals("")){
                            identificacion = "0";
                        }

                        solAtencion = editTextSolAtencion.getText().toString();

                        if (solAtencion.equals("")){
                            solAtencion = "0";
                        }

                        nombre = editTextNombre.getText().toString();

                        if (nombre.equals("")){
                            nombre = "0";
                        }

                        String listParams="/SAC/ABCD1234/0";
                        listParams+="/"+solAtencion;
                        listParams+="/"+nombre;
                        listParams+="/"+convenio;
                        listParams+="/"+estado;
                        listParams+="/"+ciudadInicial;
                        listParams+="/"+ciudadActual;
                        listParams+="/"+traslado;

                        ConexionServicioTask task = new ConexionServicioTask(getActivity(), getActivity().getResources().getString(R.string.complement_solicitudes), listParams);

                        synchronized (task) {
                            task.execute().wait();
                        }

                        respJSON = ConexionServicioTask.respJSON;

                        if (respJSON.length()==0){
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }else {
                            String[] solicitudes = new String[respJSON.length()];
                            consultaSolicitudList = new ArrayList<ConsultaSolicitudDTO>();
                            for (int j = 0; j < respJSON.length(); j++) {
                                JSONObject obj = respJSON.getJSONObject(j);

                                ConsultaSolicitudDTO dto = new ConsultaSolicitudDTO();

                                String tempconsSolicitud = obj.getString("consSolicitud");
                                String tempIdentificacion = obj.getString("identificacion");
                                String tempnombre = obj.getString("nombre");
                                String tempcredencial = obj.getString("credencial");
                                String tempconvenio = obj.getString("convenio");
                                String tempciudadInicial = obj.getString("ciudadInicial");
                                String tempciudadActual = obj.getString("ciudadActual");
                                String temptraslado = obj.getString("traslado");
                                String tempfechaProg = obj.getString("fechaProg");
                                String tempestado = obj.getString("estado");
                                String tempfechaCreado = obj.getString("fechaCreado");

                                dto.setNumeroSolicitud(tempconsSolicitud);
                                dto.setIdentificacion(tempIdentificacion);
                                dto.setNombrePaciente(tempnombre);
                                dto.setConvenio(tempconvenio);
                                dto.setCredencialPaciente(tempcredencial);
                                dto.setCiudadInicial(tempciudadInicial);
                                dto.setCiudadActual(tempciudadActual);
                                dto.setTraslado(temptraslado);
                                dto.setEstado(tempestado);
                                dto.setFechaProgramadaRegresoString(tempfechaProg);
                                dto.setFechaCreadoString(tempfechaCreado);
                                dto.setIdentificacion(tempIdentificacion);
                                consultaSolicitudList.add(dto);
                            }

                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            Fragment fragment = new ConsultaSolicitudAtencionFragment();
                            fragment.setArguments(getActivity().getIntent().getExtras());
                            ft.replace(R.id.fragment_container_consulta_solicitud_atencion, fragment, "ConsultaSolicitudAtencionFragment").addToBackStack("ConsultaSolicitudAtencionFragment").commit();


                        }

                    }catch (Exception e){
                        Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
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

                if (tipoSpinner.equals("CON")){
                    resultMap.put(getActivity().getResources().getString(R.string.lbl_seleccionar_convenio), "0");
                    spinnerArray[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_convenio);
                }else if (tipoSpinner.equals("EST")){
                    resultMap.put(getActivity().getResources().getString(R.string.lbl_seleccionar_estado), "0");
                    spinnerArray[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_estado);
                }else if (tipoSpinner.equals("CIU_INI")){
                    resultMap.put(getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad_ini), "0");
                    spinnerArray[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad_ini);
                }else if (tipoSpinner.equals("CIU_ACT")){
                    resultMap.put(getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad_act), "0");
                    spinnerArray[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_ciudad_act);
                }

                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String codigo = obj.getString("codigo");
                    String descripcion = "";
                    if (tipoSpinner.equals("CON")){
                        descripcion = obj.getString("nombre");
                    }else if (tipoSpinner.equals("EST")){
                        descripcion = obj.getString("descripcion");
                    }else if (tipoSpinner.equals("CIU_INI") || tipoSpinner.equals("CIU_ACT")){
                        descripcion = obj.getString("ciudad");
                    }
                    resultMap.put(descripcion, codigo);
                    spinnerArray[j+1] = descripcion;
                }

                spinnerDTOs = new SpinnerDTO(resultMap, spinnerArray);
            }


        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return spinnerDTOs ;
    }


    public static String getConvenio() {
        return convenio;
    }

    public static void setConvenio(String convenio) {
        FiltroSolicitudAtencionFragment.convenio = convenio;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        FiltroSolicitudAtencionFragment.estado = estado;
    }

    public static String getCiudadInicial() {
        return ciudadInicial;
    }

    public static void setCiudadInicial(String ciudadInicial) {
        FiltroSolicitudAtencionFragment.ciudadInicial = ciudadInicial;
    }

    public static String getCiudadActual() {
        return ciudadActual;
    }

    public static void setCiudadActual(String ciudadActual) {
        FiltroSolicitudAtencionFragment.ciudadActual = ciudadActual;
    }

    public static String getTraslado() {
        return traslado;
    }

    public static void setTraslado(String traslado) {
        FiltroSolicitudAtencionFragment.traslado = traslado;
    }

    public static String getIdentificacion() {
        return identificacion;
    }

    public static void setIdentificacion(String identificacion) {
        FiltroSolicitudAtencionFragment.identificacion = identificacion;
    }

    public static String getSolAtencion() {
        return solAtencion;
    }

    public static void setSolAtencion(String solAtencion) {
        FiltroSolicitudAtencionFragment.solAtencion = solAtencion;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        FiltroSolicitudAtencionFragment.nombre = nombre;
    }

    public static List<ConsultaSolicitudDTO> getConsultaSolicitudList() {
        return consultaSolicitudList;
    }

    public static void setConsultaSolicitudList(List<ConsultaSolicitudDTO> consultaSolicitudList) {
        FiltroSolicitudAtencionFragment.consultaSolicitudList = consultaSolicitudList;
    }
}
