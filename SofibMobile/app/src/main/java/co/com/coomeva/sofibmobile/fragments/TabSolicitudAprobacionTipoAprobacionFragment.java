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

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.DocumentosSolicitudAprobacionAdapter;
import co.com.coomeva.sofibmobile.adapters.TabSolicitudAprobacionProcedimientosAdapter;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabSolicitudAprobacionTipoAprobacionFragment extends Fragment{

    private TextView txtEntidad;
    private TextView txtTipo;
    private TextView txtJustificacion;

    private DocumentosSolicitudAprobacionAdapter documentosSolicitudAprobacionAdapter;
    private ListView lstDocumentos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_solicitud_aprobacion_tipo_aprobacion, container, false);
        lstDocumentos = (ListView) view.findViewById(R.id.lstDocumentos);

        txtEntidad = (TextView) view.findViewById(R.id.txtEntidad);
        txtTipo = (TextView) view.findViewById(R.id.txtTipo);
        txtJustificacion = (TextView) view.findViewById(R.id.txtJustificacion);

        documentosSolicitudAprobacionAdapter = new DocumentosSolicitudAprobacionAdapter(view.getContext(), TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getLstDocumentoAprobacion());
        lstDocumentos.setAdapter(documentosSolicitudAprobacionAdapter);
        this.justifyListViewHeightBasedOnChildren(lstDocumentos);

        txtEntidad.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getEntidad());
        txtTipo.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getTipo());
        txtJustificacion.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getJustificacion());

        return view;
    }


    public void justifyListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        int i = 0;
        for ( i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
         System.out.print(i);

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
}
