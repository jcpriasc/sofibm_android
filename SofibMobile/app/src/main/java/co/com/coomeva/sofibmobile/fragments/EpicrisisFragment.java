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
import co.com.coomeva.sofibmobile.adapters.DocumentosMedicosAdapter;
import co.com.coomeva.sofibmobile.adapters.EpicrisisAdapter;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class EpicrisisFragment extends Fragment{

    private EpicrisisAdapter documentosMedicosAdapter;
    private ListView listViewEpicrisisAdapter;
    private List<DocumentosMedicosDTO> documentosMedicosList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_epicrisis, container, false);

        listViewEpicrisisAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        documentosMedicosList = new ArrayList<>();
        documentosMedicosList.addAll(OpcionesSecundariasFragment.lstEpicrisis);

        documentosMedicosAdapter = new EpicrisisAdapter(view.getContext(), documentosMedicosList);
        listViewEpicrisisAdapter.setAdapter(documentosMedicosAdapter);

        return view;
    }
}
