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
import co.com.coomeva.sofibmobile.adapters.TabFacturaInformacionAdapter;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabFacturaImpuestoFragment extends Fragment{

    private TextView txtNumeroFactura;
    private TextView txtValorIva;
    private TextView txtValorTotalPagar;
    private TextView txtValorTotalFactura;

    private TabFacturaImpuestoAdapter tabFacturaImpuestoAdapter;
    private ListView listViewFacturaImpuestoAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_factura_impuesto, container, false);
        listViewFacturaImpuestoAdapter = (ListView) view.findViewById(R.id.lstImpuestoFactura);

        txtNumeroFactura = (TextView) view.findViewById(R.id.txtNumeroFactura);
        txtValorIva = (TextView) view.findViewById(R.id.txtValorIva);
        txtValorTotalPagar = (TextView) view.findViewById(R.id.txtValorTotalPagar);
        txtValorTotalFactura = (TextView) view.findViewById(R.id.txtValorTotalFactura);

        tabFacturaImpuestoAdapter = new TabFacturaImpuestoAdapter(view.getContext(), TabFacturaFragment.facturaSeleccionado.getLstImpuestoFactura());
        listViewFacturaImpuestoAdapter.setAdapter(tabFacturaImpuestoAdapter);
//        this.justifyListViewHeightBasedOnChildren(listViewFacturaImpuestoAdapter);

        txtNumeroFactura.setText(TabFacturaFragment.facturaSeleccionado.getNumeroFactura());
        txtValorIva.setText(TabFacturaFragment.facturaSeleccionado.getValorIvaTexto());
        txtValorTotalPagar.setText(TabFacturaFragment.facturaSeleccionado.getValorTotalAPagarTexto());
        txtValorTotalFactura.setText(TabFacturaFragment.facturaSeleccionado.getValorTotalFacturaTexto());

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
