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
import co.com.coomeva.sofibmobile.adapters.TabGiroConceptosAdapter;
import co.com.coomeva.sofibmobile.adapters.TabGiroManutencionAdapter;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabGiroConceptosFragment extends Fragment{

    private TextView txtBeneficiario;
    private TextView txtFechaInicio;
    private TextView txtFechaFin;
    private TextView txtSubtotalConcepto;
    private TextView txtTotalConcepto;

    private TabGiroConceptosAdapter tabGiroConceptosAdapter;
    private ListView listViewConceptosAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_giro_conceptos, container, false);
        listViewConceptosAdapter = (ListView) view.findViewById(R.id.lstConceptos);
        txtBeneficiario = (TextView) view.findViewById(R.id.txtBeneficiario);
        txtFechaInicio = (TextView) view.findViewById(R.id.txtFechaInicio);
        txtFechaFin = (TextView) view.findViewById(R.id.txtFechaFin);
        txtSubtotalConcepto = (TextView) view.findViewById(R.id.txtSubtotalConcepto);
        txtTotalConcepto = (TextView) view.findViewById(R.id.txtTotalConcepto);

        tabGiroConceptosAdapter = new TabGiroConceptosAdapter(view.getContext(), TabGiroFragment.giroSeleccionado.getLstConceptos());
        listViewConceptosAdapter.setAdapter(tabGiroConceptosAdapter);
        justifyListViewHeightBasedOnChildren(listViewConceptosAdapter);

        txtBeneficiario.setText(TabGiroFragment.giroSeleccionado.getBeneficiario());
        txtFechaInicio.setText(TabGiroFragment.giroSeleccionado.getFechaInicioTexto());
        txtFechaFin.setText(TabGiroFragment.giroSeleccionado.getFechaFinTexto());
        txtSubtotalConcepto.setText(TabGiroFragment.giroSeleccionado.getSubtotalConceptosTexto());
        txtTotalConcepto.setText(TabGiroFragment.giroSeleccionado.getTotalConceptosTexto());

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
