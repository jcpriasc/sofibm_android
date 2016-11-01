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

import co.com.coomeva.sofibmobile.BitacoraView;
import co.com.coomeva.sofibmobile.ConsultaSolicitudAprobacionView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.BitacoraAdapter;
import co.com.coomeva.sofibmobile.adapters.ConsultaSolicitudAdapter;
import co.com.coomeva.sofibmobile.dto.BitacoraDTO;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class BitacoraFragment extends Fragment{

    private BitacoraAdapter bitacoraAdapter;
    private ListView listViewBitacoraAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consulta_bitacora, container, false);

        listViewBitacoraAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        bitacoraAdapter = new BitacoraAdapter(view.getContext(), FiltroBitacoraFragment.getConsultaBitacoraList());
        listViewBitacoraAdapter.setAdapter(bitacoraAdapter);


        listViewBitacoraAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                try {

                    BitacoraView.bitacoraDTO = FiltroBitacoraFragment.getConsultaBitacoraList().get(i);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleBitacoraFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_bitacora, fragment, "DetalleBitacoraFragment").addToBackStack("DetalleBitacoraFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}
