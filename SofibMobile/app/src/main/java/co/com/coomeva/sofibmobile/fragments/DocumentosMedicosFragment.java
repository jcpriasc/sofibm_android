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
import co.com.coomeva.sofibmobile.adapters.DocumentosMedicosAdapter;
import co.com.coomeva.sofibmobile.dto.AutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DocumentosMedicosFragment extends Fragment{

    private DocumentosMedicosAdapter documentosMedicosAdapter;
    private ListView listViewDocumentosMedicosAdapter;
    public static List<DocumentosMedicosDTO> documentosMedicosList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_documentos_medicos, container, false);

        listViewDocumentosMedicosAdapter = (ListView) view.findViewById(R.id.listSolicitudes);
        documentosMedicosList = new ArrayList<>();
        documentosMedicosList.addAll(OpcionesSecundariasFragment.documentosMedicosList);

        documentosMedicosAdapter = new DocumentosMedicosAdapter(view.getContext(), documentosMedicosList);
        listViewDocumentosMedicosAdapter.setAdapter(documentosMedicosAdapter);

        return view;
    }

}
