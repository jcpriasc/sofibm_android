package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.AutorizacionesView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.ConsultaSolicitudAtencionAdapter;
import co.com.coomeva.sofibmobile.adapters.DetalleAutoricionesAdapter;
import co.com.coomeva.sofibmobile.dto.AutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.DetalleAutorizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleAutorizacionFragment extends Fragment{

    private DetalleAutoricionesAdapter detalleAutorizacionAdapter;
    private ListView listViewDetalleAutorizacionAdapter;
    private List<DetalleAutorizacionesDTO> detalleAutorizacionList = new ArrayList<>();
    private TextView txtDescripcion;
    private TextView txtCiudad;
    private TextView txtTipoSolicitud;
    private TextView txtFechaSolicitud;
    private TextView txtEstado;
    private TextView txtFechaAprobacion;
    private TextView txtFechaRechazo;
    private AutorizacionesDTO autorizacionSeleccionado;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_autorizaciones, container, false);

        listViewDetalleAutorizacionAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        txtDescripcion = (TextView) view.findViewById(R.id.txtDescripcion);
        txtCiudad = (TextView) view.findViewById(R.id.txtCiudad);
        txtTipoSolicitud = (TextView) view.findViewById(R.id.txtTipoSolicitud);
        txtFechaSolicitud = (TextView) view.findViewById(R.id.txtFechaSolicitud);
        txtEstado = (TextView) view.findViewById(R.id.txtEstado);
        txtFechaAprobacion = (TextView) view.findViewById(R.id.txtFechaAprobacion);
        txtFechaRechazo = (TextView) view.findViewById(R.id.txtFechaRechazo);

        autorizacionSeleccionado = AutorizacionesView.autorizacionSeleccionada;

        txtDescripcion.setText(autorizacionSeleccionado.getDescripcion());
        txtCiudad.setText(autorizacionSeleccionado.getCiudad());
        txtTipoSolicitud.setText(autorizacionSeleccionado.getTipoSolicitud());
        txtFechaSolicitud.setText(autorizacionSeleccionado.getFechaSolicitudString());
        txtEstado.setText(autorizacionSeleccionado.getEstado());
        txtFechaAprobacion.setText(autorizacionSeleccionado.getFechaAprobacionString());
        txtFechaRechazo.setText(autorizacionSeleccionado.getFechaRechazoString());

        detalleAutorizacionList = AutorizacionesFragment.lstDetalleAutorizaciones;

        detalleAutorizacionAdapter = new DetalleAutoricionesAdapter(view.getContext(), detalleAutorizacionList);
        listViewDetalleAutorizacionAdapter.setAdapter(detalleAutorizacionAdapter);
        justifyListViewHeightBasedOnChildren(listViewDetalleAutorizacionAdapter);

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
