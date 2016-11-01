package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.DescripcionAdapter;
import co.com.coomeva.sofibmobile.dto.DescipcionDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class MedicinaFragment extends Fragment{

    private DescripcionAdapter descripcionAdapter;
    private ListView listViewDescripcionAdapter;
    private  List<DescipcionDTO> descripcionList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicina, container, false);

        listViewDescripcionAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        descripcionList = InformesMedicosFragment.detalleInformeMedicoSeleccionado.getLstMedicina();

        descripcionAdapter = new DescripcionAdapter(view.getContext(), descripcionList);
        listViewDescripcionAdapter.setAdapter(descripcionAdapter);

        return view;
    }
}
