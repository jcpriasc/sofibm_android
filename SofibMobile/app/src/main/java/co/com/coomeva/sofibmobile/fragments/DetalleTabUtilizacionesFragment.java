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
import co.com.coomeva.sofibmobile.adapters.DetalleUtilizacionesAdapter;
import co.com.coomeva.sofibmobile.adapters.UtilizacionesAdapter;
import co.com.coomeva.sofibmobile.dto.DetalleUtilizacionesDTO;
import co.com.coomeva.sofibmobile.dto.UtilizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleTabUtilizacionesFragment extends Fragment{

    private DetalleUtilizacionesAdapter detalleTabUtilizacionesFragment;
    private ListView listViewDetalleTabUtilizacionesAdapter;
    private List<DetalleUtilizacionesDTO> lstUtilizacionesDTO = new ArrayList<DetalleUtilizacionesDTO>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_utilizaciones, container, false);

        listViewDetalleTabUtilizacionesAdapter = (ListView) view.findViewById(R.id.lstDetalleUtlizaciones);


        lstUtilizacionesDTO = UtilizacionesFragment.lstDetalleUtilizacionesDTO;
        detalleTabUtilizacionesFragment = new DetalleUtilizacionesAdapter(view.getContext(), lstUtilizacionesDTO);
        listViewDetalleTabUtilizacionesAdapter.setAdapter(detalleTabUtilizacionesFragment);


        return view;
    }
}
