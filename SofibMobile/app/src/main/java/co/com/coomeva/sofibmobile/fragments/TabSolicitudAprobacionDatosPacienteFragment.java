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
import co.com.coomeva.sofibmobile.adapters.TabFacturaImpuestoAdapter;
import co.com.coomeva.sofibmobile.adapters.TabSolicitudAprobacionProcedimientosAdapter;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabSolicitudAprobacionDatosPacienteFragment extends Fragment{

    private TextView txtIdentificacion;
    private TextView txtNombre;
    private TextView txtDiagnostico;
    private TextView txtEstadoPaciente;
    private TextView txtFechaEstimadaRegreso;


    private TabSolicitudAprobacionProcedimientosAdapter tabSolicitudAprobacionFragment;
    private ListView lstProcedimientos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_solicitud_aprobacion_datos_paciente, container, false);
        lstProcedimientos = (ListView) view.findViewById(R.id.lstProcedimientos);

        txtIdentificacion = (TextView) view.findViewById(R.id.txtIdentificacion);
        txtNombre = (TextView) view.findViewById(R.id.txtNombre);
        txtDiagnostico = (TextView) view.findViewById(R.id.txtDiagnostico);
        txtEstadoPaciente = (TextView) view.findViewById(R.id.txtEstadoPaciente);
        txtFechaEstimadaRegreso = (TextView) view.findViewById(R.id.txtFechaEstimadaRegreso);

        tabSolicitudAprobacionFragment = new TabSolicitudAprobacionProcedimientosAdapter(view.getContext(), TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getLstProcedimientos());
        lstProcedimientos.setAdapter(tabSolicitudAprobacionFragment);
        this.justifyListViewHeightBasedOnChildren(lstProcedimientos);

        txtIdentificacion.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getIdentificacion());
        txtNombre.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getNombre());
        txtDiagnostico.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getDiagnostico());
        txtEstadoPaciente.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getEstadoPaciente());
        txtFechaEstimadaRegreso.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getFechaRegreso());

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
