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
import java.util.List;

import co.com.coomeva.sofibmobile.AutorizacionesView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.AutoricionesAdapter;
import co.com.coomeva.sofibmobile.adapters.ProcedimientosAdicionalesAdapter;
import co.com.coomeva.sofibmobile.dto.AutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.ProcedimientosAdicionalesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ProcedimientosAdicionalesFragment extends Fragment{

    private ProcedimientosAdicionalesAdapter procedimientosAdicionalesAdapter;
    private ListView listViewProcedimientosAdicionalesAdapter;
    private List<ProcedimientosAdicionalesDTO> procedimientosAdicionalesList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_procedimientos_adicionales, container, false);

        listViewProcedimientosAdicionalesAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        procedimientosAdicionalesList = new ArrayList<>();
        procedimientosAdicionalesList.addAll(OpcionesSecundariasFragment.lstProcedimientosAdicionales);

        procedimientosAdicionalesAdapter = new ProcedimientosAdicionalesAdapter(view.getContext(), procedimientosAdicionalesList);
        listViewProcedimientosAdicionalesAdapter.setAdapter(procedimientosAdicionalesAdapter);

        return view;
    }
}
