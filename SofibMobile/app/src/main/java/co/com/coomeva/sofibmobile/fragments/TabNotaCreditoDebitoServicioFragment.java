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
import co.com.coomeva.sofibmobile.adapters.TabNotaCreditoDebitoImpuestoAdapter;
import co.com.coomeva.sofibmobile.adapters.TabNotaCreditoDebitoServicioAdapter;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabNotaCreditoDebitoServicioFragment extends Fragment{

    private TextView txtNumeroOrdenServicio;
    private TextView txtServicio;

    private TabNotaCreditoDebitoServicioAdapter tabNotaCreditoDebitoServicioAdapter;
    private ListView listViewNotaCreditoAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_nota_credito_debito_servicio, container, false);
        listViewNotaCreditoAdapter = (ListView) view.findViewById(R.id.lstServicio);

        txtNumeroOrdenServicio = (TextView) view.findViewById(R.id.txtNumeroOrdenServicio);
        txtServicio = (TextView) view.findViewById(R.id.txtServicio);

        tabNotaCreditoDebitoServicioAdapter = new TabNotaCreditoDebitoServicioAdapter(view.getContext(), TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getLstServicioNotaCreditoDebito());
        listViewNotaCreditoAdapter.setAdapter(tabNotaCreditoDebitoServicioAdapter);
        justifyListViewHeightBasedOnChildren(listViewNotaCreditoAdapter);

        txtNumeroOrdenServicio.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getNumeroOrdenServicio());
        txtServicio.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getServicio());

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
