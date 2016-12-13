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
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.DetallServiciosAsistencialesAdapter;
import co.com.coomeva.sofibmobile.adapters.DetalleAutoricionesAdapter;
import co.com.coomeva.sofibmobile.dto.DetallServiciosAsistencialesDTO;
import co.com.coomeva.sofibmobile.dto.DetalleAutorizacionesDTO;
import co.com.coomeva.sofibmobile.dto.DetalleServicioAsistencialDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleServiciosAsistencialesFragment extends Fragment{

    private DetallServiciosAsistencialesAdapter detallServiciosAsistencialesAdapter;
    private ListView listViewDetallServiciosAsistencialesAdapter;
    private  List<DetalleServicioAsistencialDTO> detalleServiciosAsistencialesList = new ArrayList<>();

    private TextView textNumeroOrden;
    private TextView textSucursal;
    private TextView textIdPrestador;
    private TextView textNombrePrestador;
    private TextView textTipoServicio;
    private TextView textCodigoProcedimiento;
    private TextView textProcedimientoEspanol;
    private TextView textProcedimientoIngles;
    private TextView textCantidad;
    private TextView textEstado;
    private TextView textFecha;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_servicios_asistenciales, container, false);

        listViewDetallServiciosAsistencialesAdapter = (ListView) view.findViewById(R.id.listSolicitudes);

        textNumeroOrden = (TextView) view.findViewById(R.id.textNumeroOrden);
        textSucursal = (TextView) view.findViewById(R.id.textSucursal);
        textIdPrestador = (TextView) view.findViewById(R.id.textIdPrestador);
        textNombrePrestador = (TextView) view.findViewById(R.id.textNombrePrestador);
        textTipoServicio = (TextView) view.findViewById(R.id.textTipoServicio);
        textCodigoProcedimiento = (TextView) view.findViewById(R.id.textCodigoProcedimiento);
        textProcedimientoEspanol = (TextView) view.findViewById(R.id.textProcedimientoEspanol);
        textProcedimientoIngles = (TextView) view.findViewById(R.id.textProcedimientoIngles);
        textCantidad = (TextView) view.findViewById(R.id.textCantidad);
        textEstado = (TextView) view.findViewById(R.id.textEstado);
        textFecha = (TextView) view.findViewById(R.id.textFecha);

        textNumeroOrden.setText(ServicioAsistencialFragment.servicio.getNumeroOrden());
        textSucursal.setText(ServicioAsistencialFragment.servicio.getSucursal());
        textIdPrestador.setText(ServicioAsistencialFragment.servicio.getIdPrestador());
        textNombrePrestador.setText(ServicioAsistencialFragment.servicio.getNombrePrestador());
        textTipoServicio.setText(ServicioAsistencialFragment.servicio.getTipoServicio());
        textCodigoProcedimiento.setText(ServicioAsistencialFragment.servicio.getCodigoProcedimiento());
        textProcedimientoEspanol.setText(ServicioAsistencialFragment.servicio.getProcedimientoEspanol());
        textProcedimientoIngles.setText(ServicioAsistencialFragment.servicio.getProcedimientoIngles());
        textCantidad.setText(ServicioAsistencialFragment.servicio.getCantidad());
        textEstado.setText(ServicioAsistencialFragment.servicio.getEstado());
        textFecha.setText(ServicioAsistencialFragment.servicio.getFechaString());

        detalleServiciosAsistencialesList = ServicioAsistencialFragment.lstDetalleServicioAsistencialDTO;

        detallServiciosAsistencialesAdapter = new DetallServiciosAsistencialesAdapter(view.getContext(), detalleServiciosAsistencialesList);
        listViewDetallServiciosAsistencialesAdapter.setAdapter(detallServiciosAsistencialesAdapter);
        justifyListViewHeightBasedOnChildren(listViewDetallServiciosAsistencialesAdapter);

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
