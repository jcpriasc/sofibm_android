package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.AutorizacionesView;
import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.AutoricionesAdapter;
import co.com.coomeva.sofibmobile.adapters.ConsultaSolicitudAtencionAdapter;
import co.com.coomeva.sofibmobile.dto.AutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.dto.DetalleAutorizacionesDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class  AutorizacionesFragment extends Fragment{

    private AutoricionesAdapter autoricionesAdapter;
    private ListView listViewAutorizacionesAdapter;
    private List<AutorizacionesDTO> autorizacionesList;
    public static List<DetalleAutorizacionesDTO> lstDetalleAutorizaciones;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_autorizaciones, container, false);

        listViewAutorizacionesAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        autorizacionesList = new ArrayList<>();
        autorizacionesList.addAll(OpcionesSecundariasFragment.autorizacionesList);

        autoricionesAdapter = new AutoricionesAdapter(view.getContext(), autorizacionesList);
        listViewAutorizacionesAdapter.setAdapter(autoricionesAdapter);
        listViewAutorizacionesAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                try {

                    if(AutorizacionesView.autorizacionSeleccionada == null){
                        AutorizacionesView.autorizacionSeleccionada = new AutorizacionesDTO();
                    }

                    AutorizacionesView.autorizacionSeleccionada = autorizacionesList.get(i);

                    lstDetalleAutorizaciones = new ArrayList<DetalleAutorizacionesDTO>();


                    String params = getActivity().getResources().getString(R.string.address_service_token) +AutorizacionesView.autorizacionSeleccionada.getConsDetAutorizacion();
                    consultarDetalleAutorizaciones(getActivity().getResources().getString(R.string.complement_detalle_autorizaciones), params);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleAutorizacionFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_autorizaciones, fragment, "DetalleAutorizacionFragment").addToBackStack("DetalleAutorizacionFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

    private  boolean consultarDetalleAutorizaciones(String serviceName, String listParams)throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioTask task = new ConexionServicioTask(getActivity(), serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            JSONArray respJSONSpinner = ConexionServicioTask.respJSON;

            String[] result = new String[respJSONSpinner.length()];

            if (result!=null && result.length>0){
                autorizacionesList = new ArrayList<>();
                respuesta = true;
                for (int j = 0; j < respJSONSpinner.length(); j++) {
                    JSONObject obj = respJSONSpinner.getJSONObject(j);

                    String descripcion =(obj.getString("descripcion") != null && !obj.getString("descripcion").equals("null")) ? obj.getString("descripcion"):"";
                    String justificacion = (obj.getString("justificacion") != null && !obj.getString("justificacion").equals("null")) ? obj.getString("justificacion"):"";
                    String estado = (obj.getString("estado") != null && !obj.getString("estado").equals("null")) ? obj.getString("estado"):"";

                    if(estado != null && estado.equals("true")){
                        estado = getActivity().getResources().getString(R.string.lbl_aprobado);
                    }else if(estado != null && estado.equals("false")){
                        estado = getActivity().getResources().getString(R.string.lbl_pendiente);
                    }

                    DetalleAutorizacionesDTO dto = new DetalleAutorizacionesDTO(descripcion, justificacion, estado);

                    lstDetalleAutorizaciones.add(dto);

                }
            }

        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }

}
