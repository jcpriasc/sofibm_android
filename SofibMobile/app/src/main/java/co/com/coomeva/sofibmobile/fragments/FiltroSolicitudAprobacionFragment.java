package co.com.coomeva.sofibmobile.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAprobacionView;
import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.dto.SpinnerDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class FiltroSolicitudAprobacionFragment extends Fragment {

    ImageView imgConsultarSolicitudes;
    //Spinner spinnerConvenio;
    Spinner spinnerServicio;
    private static String convenio;
    private static String servicio;
    public static String tipoAprobacion;
    public static List<ConsultaSolicitudDTO> lstSolicitudAprobacion = new ArrayList<ConsultaSolicitudDTO>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filtro_solicitud_aprobacion, container, false);

        imgConsultarSolicitudes = (ImageView) view.findViewById(R.id.search_action);
        //spinnerConvenio = (Spinner) view.findViewById(R.id.spinner_convenios);
        spinnerServicio = (Spinner) view.findViewById(R.id.spinner_servicios);


        try {

           // final SpinnerDTO resultMapConvenio = llenar_spinner(getActivity().getResources().getString(R.string.complement_convenios), "/SAC/ABCD1234/0", "CON");
            final SpinnerDTO resultMapServicio = llenar_spinner(getActivity().getResources().getString(R.string.complement_servicios), "/SAC/ABCD1234", "SERV");

//            if (resultMapConvenio != null) {
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, resultMapConvenio.getSpinnerArray());
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinnerConvenio.setAdapter(adapter);
//            }

            if (resultMapServicio != null) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, resultMapServicio.getSpinnerArray());
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerServicio.setAdapter(adapter);
            }

            imgConsultarSolicitudes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {

                        //String nameConvenio = spinnerConvenio.getSelectedItem().toString();
                       // convenio = resultMapConvenio.getResultMap().get(nameConvenio);

                        String nameEstado = spinnerServicio.getSelectedItem().toString();
                        servicio = resultMapServicio.getResultMap().get(nameEstado);


                        String params = "/SAC/ABCD1234/0/" +
                                "0/"+
                                servicio+"/"
                                + ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud() + "/" +tipoAprobacion;
                        if (consultarSolicitudAprobacion(getActivity().getResources().getString(R.string.complement_aprobacion), params, getActivity())) {

                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            Fragment fragment = new ConsultaSolicitudAprobacionFragment();
                            fragment.setArguments(getActivity().getIntent().getExtras());
                            ft.replace(R.id.fragment_container_consulta_solicitud_aprobacion, fragment, "ConsultaSolicitudAprobacionFragment").addToBackStack("ConsultaSolicitudAprobacionFragment").commit();

                        } else {
                            throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                        }
                    }catch (Exception e){
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }


                }
            });

        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return view;
    }


    private SpinnerDTO llenar_spinner(String serviceName, String listParams, String tipoSpinner) {

        SpinnerDTO spinnerDTOs = null;

        try {

            ConexionServicioTask task = new ConexionServicioTask(getActivity(), serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result != null && result.length > 0) {
                Map<String, String> resultMap = new HashMap<String, String>();
                String[] spinnerArray = new String[result.length + 1];

                if (tipoSpinner.equals("CON")) {
                    resultMap.put(getActivity().getResources().getString(R.string.lbl_seleccionar_convenio), "0");
                    spinnerArray[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_convenio);
                } else if (tipoSpinner.equals("SERV")) {
                    resultMap.put(getActivity().getResources().getString(R.string.lbl_seleccionar_servicio), "0");
                    spinnerArray[0] = getActivity().getResources().getString(R.string.lbl_seleccionar_servicio);
                }

                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String codigo = obj.getString("codigo");
                    String descripcion = "";
                    if (tipoSpinner.equals("CON")) {
                        descripcion = obj.getString("nombre");
                    } else if (tipoSpinner.equals("SERV")) {
                        descripcion = obj.getString("nombre");
                    }

                    resultMap.put(descripcion, codigo);
                    spinnerArray[j + 1] = descripcion;
                }

                spinnerDTOs = new SpinnerDTO(resultMap, spinnerArray);
            }


        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return spinnerDTOs;
    }

    public static  boolean consultarSolicitudAprobacion(String serviceName, String listParams, Context contexto) throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(contexto, serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }
            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                lstSolicitudAprobacion = new ArrayList<ConsultaSolicitudDTO>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String solicitudDescripcion = (obj.getString("solicitudDescripcion")!= null && !obj.getString("solicitudDescripcion").equals("null")) ? obj.getString("solicitudDescripcion"):"";
                    String nombrePaciente = (obj.getString("nombrePaciente") != null && !obj.getString("nombrePaciente").equals("null")) ? obj.getString("nombrePaciente"):"";
                    String tipoAutorizacion = (obj.getString("tipoAutorizacion") != null && !obj.getString("tipoAutorizacion").equals("null")) ? obj.getString("tipoAutorizacion"):"";
                    String estado = (obj.getString("estado")!= null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";
                    String tipoEntidad = (obj.getString("tipoEntidad") != null && !obj.getString("tipoEntidad").equals("null")) ? obj.getString("tipoEntidad"):"";
                    String solicitante = (obj.getString("solicitante") != null && !obj.getString("solicitante").equals("null")) ? obj.getString("solicitante"):"";
                    String fechaSolicitud = (obj.getString("fechaSolicitud")!= null && !obj.getString("fechaSolicitud").equals("null")) ? obj.getString("fechaSolicitud"):"";
                    String autoriza = (obj.getString("autoriza") != null && !obj.getString("autoriza").equals("null")) ? obj.getString("autoriza"):"";
                    String fechaAutorizacion = (obj.getString("fechaAutorizacion") != null && !obj.getString("fechaAutorizacion").equals("null")) ? obj.getString("fechaAutorizacion"):"";
                    String servicio = (obj.getString("servicio")!= null && !obj.getString("servicio").equals("null")) ? obj.getString("servicio"):"";
                    String proveedor = (obj.getString("proveedor")!= null && !obj.getString("proveedor").equals("null")) ? obj.getString("proveedor"):"";
                    String prestador = (obj.getString("prestador")!= null && !obj.getString("prestador").equals("null")) ? obj.getString("prestador"):"";
                    String justificacion = (obj.getString("justificacion")!= null && !obj.getString("justificacion").equals("null")) ? obj.getString("justificacion"):"";
                    String idAprobacion = (obj.getString("idAprobacion")!= null && !obj.getString("idAprobacion").equals("null")) ? obj.getString("idAprobacion"):"";



                    ConsultaSolicitudDTO dto = new ConsultaSolicitudDTO(nombrePaciente,estado,fechaSolicitud,solicitudDescripcion,tipoAutorizacion,tipoEntidad,solicitante,autoriza, fechaAutorizacion,servicio,proveedor,
                            prestador, justificacion,"","","","","","","","","",idAprobacion);
                    lstSolicitudAprobacion.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

}