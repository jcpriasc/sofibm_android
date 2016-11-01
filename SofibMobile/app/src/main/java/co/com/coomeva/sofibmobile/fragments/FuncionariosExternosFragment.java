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

import co.com.coomeva.sofibmobile.AutorizacionesView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.AutoricionesAdapter;
import co.com.coomeva.sofibmobile.adapters.FuncionariosExternosAdapter;
import co.com.coomeva.sofibmobile.dto.AutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.FuncionariosExternosDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class FuncionariosExternosFragment extends Fragment{

    private FuncionariosExternosAdapter funcionariosExternosAdapter;
    private ListView listViewFuncionariosExternosAdapter;
    private List<FuncionariosExternosDTO> funcionariosExternosList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_funcionarios_externos, container, false);

        listViewFuncionariosExternosAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        funcionariosExternosList = new ArrayList<>();
        funcionariosExternosList.addAll(OpcionesSecundariasFragment.lstFuncionariosExternos);

        funcionariosExternosAdapter = new FuncionariosExternosAdapter(view.getContext(), funcionariosExternosList);
        listViewFuncionariosExternosAdapter.setAdapter(funcionariosExternosAdapter);

        return view;
    }
}
