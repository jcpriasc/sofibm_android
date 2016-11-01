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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.SolicitudNoAsistencialView;
import co.com.coomeva.sofibmobile.adapters.ServicioNoAsistencialAdapter;
import co.com.coomeva.sofibmobile.dto.DetalleServicioNoAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.ServicioAdicionalDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNoAsistencialDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ServicioNoAsistencialFragment extends Fragment{

    private ServicioNoAsistencialAdapter servicioNoAsistencialAdapter;
    private ListView listViewServicioNoAsistencialAdapter;
    private List<ServicioNoAsistencialDTO> lstServicioNoAsistencialDTO = new ArrayList<ServicioNoAsistencialDTO>();

    public static ServicioNoAsistencialDTO servicio = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_servicio_no_asistencial, container, false);

        listViewServicioNoAsistencialAdapter = (ListView) view.findViewById(R.id.lstServicioNoAsistencial);

        if(lstServicioNoAsistencialDTO == null){
            lstServicioNoAsistencialDTO = new ArrayList<ServicioNoAsistencialDTO>();
        }

        lstServicioNoAsistencialDTO = OpcionesSecundariasFragment.lstSolicitudNoAsistencial;

        servicioNoAsistencialAdapter = new ServicioNoAsistencialAdapter(view.getContext(), lstServicioNoAsistencialDTO);
        listViewServicioNoAsistencialAdapter.setAdapter(servicioNoAsistencialAdapter);


        listViewServicioNoAsistencialAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {


                try {

                    if(servicio == null){
                        servicio = new ServicioNoAsistencialDTO();
                    }

                    servicio = lstServicioNoAsistencialDTO.get(i);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleServicioNoAsistencialFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_servicio_no_asistencial, fragment, "DetalleServicioNoAsistencialFragment").addToBackStack("DetalleServicioNoAsistencialFragment").commit();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

}
