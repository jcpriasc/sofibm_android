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
import co.com.coomeva.sofibmobile.adapters.ConsultaSolicitudAdapter;
import co.com.coomeva.sofibmobile.adapters.OpcionesAdapter;
import co.com.coomeva.sofibmobile.dto.ConsultaSolicitudDTO;
import co.com.coomeva.sofibmobile.dto.OpcionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class OpcionesPrincipalesFragment extends Fragment{

    private OpcionesAdapter opcionesAdapter;
    private ListView listViewOpcionesPrincipales;
    public static OpcionesDTO opcionSeleccionada;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opciones_principales, container, false);

        listViewOpcionesPrincipales = (ListView) view.findViewById(R.id.listOpcionesPrincipales);

        final List<OpcionesDTO> opcionesList = new ArrayList<>();

        opcionesList.add(new OpcionesDTO("1", getResources().getString(R.string.lbl_consultar_info_medica), R.mipmap.consultarinfomed));
        opcionesList.add(new OpcionesDTO("2", getResources().getString(R.string.lbl_consultar_info_logistica), R.mipmap.consultarinfo));

        opcionesAdapter = new OpcionesAdapter(view.getContext(), opcionesList);
        listViewOpcionesPrincipales.setAdapter(opcionesAdapter);


        listViewOpcionesPrincipales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                OpcionesPrincipalesFragment.opcionSeleccionada = opcionesList.get(i);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment = new OpcionesSecundariasFragment();
                fragment.setArguments(getActivity().getIntent().getExtras());
                ft.replace(R.id.fragment_container_opciones, fragment, "OpcionesSecundariasFragment").addToBackStack("OpcionesSecundariasFragment").commit();

            }
        });

        return view;
    }
}
