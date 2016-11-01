package co.com.coomeva.sofibmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAprobacionView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.ConsultaSolicitudAdapter;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ConsultaSolicitudAprobacionFragment extends Fragment{

    private ConsultaSolicitudAdapter consultaSolicitudAdapter;
    private ListView listViewConsultaSolicitudAdapter;
    private List<ConsultaSolicitudDTO> consultaSolicitudList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consulta_solicitud_aprobacion, container, false);

        listViewConsultaSolicitudAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        consultaSolicitudList = OpcionesSecundariasFragment.lstSolicitudAprobacion;
        consultaSolicitudAdapter = new ConsultaSolicitudAdapter(view.getContext(), consultaSolicitudList);
        listViewConsultaSolicitudAdapter.setAdapter(consultaSolicitudAdapter);


        listViewConsultaSolicitudAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                try {

                    ConsultaSolicitudAprobacionView.solicitudAprobacionSeleccionada =  consultaSolicitudList.get(i);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleSolicitudAprobacionFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_consulta_solicitud_aprobacion, fragment, "DetalleSolicitudAprobacionFragment").addToBackStack("DetalleSolicitudAprobacionFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}
