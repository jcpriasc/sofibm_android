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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.ServicioAsistencialAdapter;
import co.com.coomeva.sofibmobile.adapters.ServicioNoAsistencialAdapter;
import co.com.coomeva.sofibmobile.dto.ServicioAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNoAsistencialDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ServicioAsistencialFragment extends Fragment{

    private ServicioAsistencialAdapter servicioAsistencialAdapter;
    private ListView listViewServicioAsistencialAdapter;
    private List<ServicioAsistencialDTO> lstServicioAsistencialDTO = new ArrayList<ServicioAsistencialDTO>();
    public static ServicioAsistencialDTO servicio = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_servicio_asistencial, container, false);

        listViewServicioAsistencialAdapter = (ListView) view.findViewById(R.id.lstServicioAsistencial);


        lstServicioAsistencialDTO = OpcionesSecundariasFragment.lstServiciosAsistenciales;

        servicioAsistencialAdapter = new ServicioAsistencialAdapter(view.getContext(), lstServicioAsistencialDTO);
        listViewServicioAsistencialAdapter.setAdapter(servicioAsistencialAdapter);


        listViewServicioAsistencialAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {


                try {

                    if(servicio == null){
                        servicio = new ServicioAsistencialDTO();
                    }

                    servicio = lstServicioAsistencialDTO.get(i);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleServiciosAsistencialesFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_servicio_asistencial, fragment, "DetalleServiciosAsistencialesFragment").addToBackStack("DetalleServiciosAsistencialesFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}
