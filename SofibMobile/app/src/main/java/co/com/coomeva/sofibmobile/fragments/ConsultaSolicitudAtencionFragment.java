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

import co.com.coomeva.sofibmobile.ConsultaSolicitudAprobacionView;
import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.ConsultaSolicitudAdapter;
import co.com.coomeva.sofibmobile.adapters.ConsultaSolicitudAtencionAdapter;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ConsultaSolicitudAtencionFragment extends Fragment{

    private ConsultaSolicitudAtencionAdapter consultaSolicitudAtencionAdapter;
    private ListView listViewConsultaSolicitudAtencionAdapter;
    private List<ConsultaSolicitudDTO> consultaSolicitudList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consulta_solicitud_atencion, container, false);
        listViewConsultaSolicitudAtencionAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        consultaSolicitudList=new ArrayList<>();
        consultaSolicitudList.addAll(FiltroSolicitudAtencionFragment.getConsultaSolicitudList());

        consultaSolicitudAtencionAdapter = new ConsultaSolicitudAtencionAdapter(view.getContext(), consultaSolicitudList);
        listViewConsultaSolicitudAtencionAdapter.setAdapter(consultaSolicitudAtencionAdapter);


        listViewConsultaSolicitudAtencionAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                try {

                    if(ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada == null){
                        ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada = new ConsultaSolicitudDTO();
                    }

                    ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada = consultaSolicitudList.get(i);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleSolicitudAtencionFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_consulta_solicitud_atencion, fragment, "DetalleSolicitudAtencionFragment").addToBackStack("DetalleSolicitudAtencionFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}
