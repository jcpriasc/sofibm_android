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
import co.com.coomeva.sofibmobile.adapters.GiroAdapter;
import co.com.coomeva.sofibmobile.adapters.ServicioNoAsistencialAdapter;
import co.com.coomeva.sofibmobile.dto.GirosDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNoAsistencialDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class GiroFragment extends Fragment{

    private GiroAdapter giroAdapter;
    private ListView listViewGiroAdapter;
    private  List<GirosDTO> lstGiroDTO = new ArrayList<GirosDTO>();
    public static GirosDTO giro = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_giro, container, false);

        listViewGiroAdapter = (ListView) view.findViewById(R.id.lstGiro);

        lstGiroDTO = OpcionesSecundariasFragment.lstGiros;

        giroAdapter = new GiroAdapter(view.getContext(), lstGiroDTO);
        listViewGiroAdapter.setAdapter(giroAdapter);

        listViewGiroAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                try {

                    if(giro == null){
                        giro = new GirosDTO();
                    }

                    giro = lstGiroDTO.get(i);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleGiroFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_giro, fragment, "DetalleGiroFragment").addToBackStack("DetalleGiroFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}
