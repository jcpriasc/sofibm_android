package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.DetalleAutoricionesAdapter;
import co.com.coomeva.sofibmobile.adapters.DocumentosInformesMedicosAdapter;
import co.com.coomeva.sofibmobile.adapters.DocumentosMedicosAdapter;
import co.com.coomeva.sofibmobile.dto.DetalleAutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.DetalleInformeMedicoDTO;
import co.com.coomeva.sofibmobile.dto.DocumentosMedicosDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class InformesMedicosGeneralFragment extends Fragment{

    private DocumentosInformesMedicosAdapter documentosMedicosAdapter;
    private ListView listViewDocumentosMedicosAdapter;
    private List<DocumentosMedicosDTO> documentosMedicosList = new ArrayList<>();
    private TextView textEntidadPrestadora;
    private TextView textEvolucionPaciente;
    private TextView textTipoPaciente;
    private TextView textDadoAlta;
    private TextView textFallecio;
    private TextView textFechaHospitalizacion;

    private DetalleInformeMedicoDTO detalleInformeMedicoSeleccionado;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_informes_medicos_general, container, false);

        listViewDocumentosMedicosAdapter = (ListView) view.findViewById(R.id.listSolicitudes);
        textEntidadPrestadora = (TextView) view.findViewById(R.id.textEntidadPrestadora);
        textEvolucionPaciente = (TextView) view.findViewById(R.id.textEvolucionPaciente);
        textTipoPaciente = (TextView) view.findViewById(R.id.textTipoPaciente);
        textDadoAlta = (TextView) view.findViewById(R.id.textDadoAlta);
        textFallecio = (TextView) view.findViewById(R.id.textFallecio);
        textFechaHospitalizacion = (TextView) view.findViewById(R.id.textFechaHospitalizacion);

        detalleInformeMedicoSeleccionado = InformesMedicosFragment.detalleInformeMedicoSeleccionado;

        if (detalleInformeMedicoSeleccionado.getDadoAlta()==null){
            detalleInformeMedicoSeleccionado.setDadoAlta("");
        }else if (detalleInformeMedicoSeleccionado.getDadoAlta().equals("true")){
            detalleInformeMedicoSeleccionado.setDadoAlta("SI");

        }else if (detalleInformeMedicoSeleccionado.getDadoAlta().equals("false")){
            detalleInformeMedicoSeleccionado.setDadoAlta("NO");
        }

        if (detalleInformeMedicoSeleccionado.getFallecido()==null){
            detalleInformeMedicoSeleccionado.setFallecido("");
        }else if (detalleInformeMedicoSeleccionado.getFallecido().equals("true")){
            detalleInformeMedicoSeleccionado.setFallecido("SI");
        }else if (detalleInformeMedicoSeleccionado.getFallecido().equals("false")){
            detalleInformeMedicoSeleccionado.setFallecido("NO");
        }

        textEntidadPrestadora.setText(detalleInformeMedicoSeleccionado.getEntidadPrestadora());
        textEvolucionPaciente.setText(detalleInformeMedicoSeleccionado.getEvolucionPaciente());
        textTipoPaciente.setText(detalleInformeMedicoSeleccionado.getTipoPaciente());
        textDadoAlta.setText(detalleInformeMedicoSeleccionado.getDadoAlta());
        textFallecio.setText(detalleInformeMedicoSeleccionado.getFallecido());
        textFechaHospitalizacion.setText(detalleInformeMedicoSeleccionado.getFechaHospitalizacion());

        documentosMedicosList = detalleInformeMedicoSeleccionado.getLstDocumentos();

        documentosMedicosAdapter = new DocumentosInformesMedicosAdapter(view.getContext(), documentosMedicosList);
        listViewDocumentosMedicosAdapter.setAdapter(documentosMedicosAdapter);

        justifyListViewHeightBasedOnChildren(listViewDocumentosMedicosAdapter);

        return view;
    }


    public void justifyListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
}
