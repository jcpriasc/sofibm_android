package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.AdministracionesAdapter;
import co.com.coomeva.sofibmobile.adapters.DetalleUtilizacionesAdapter;
import co.com.coomeva.sofibmobile.dto.AdministracionesDTO;
import co.com.coomeva.sofibmobile.dto.DetalleUtilizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabAdministracionesFragment extends Fragment{

    private AdministracionesAdapter administracionesAdapter;
    private ListView listViewAdministracionesAdapter;
    private List<AdministracionesDTO> lstAdministraciones = new ArrayList<AdministracionesDTO>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_administraciones, container, false);

        listViewAdministracionesAdapter = (ListView) view.findViewById(R.id.lstAdministraciones);

        lstAdministraciones = UtilizacionesFragment.lstAdministraciones;

        administracionesAdapter = new AdministracionesAdapter(view.getContext(), lstAdministraciones);
        listViewAdministracionesAdapter.setAdapter(administracionesAdapter);


        return view;
    }
}
