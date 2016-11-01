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
import co.com.coomeva.sofibmobile.adapters.TabFacturaInformacionAdapter;
import co.com.coomeva.sofibmobile.adapters.TabGiroManutencionAdapter;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabFacturaInformacionFragment extends Fragment{

    private TextView txtNumeroFactura;
    private TextView txtFechaEmision;
    private TextView txtFechaVencimientoPago;
    private TextView txtFechaRecibidoCoomeva;
    private TextView txtProveedor;
    private TextView txtValorTotalFactura;

    private TabFacturaInformacionAdapter tabFacturaInformacionAdapter;
    private ListView listViewFacturaInformacionAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_factura_informacion, container, false);
        listViewFacturaInformacionAdapter = (ListView) view.findViewById(R.id.lstInformacionFactura);

        txtNumeroFactura = (TextView) view.findViewById(R.id.txtNumeroFactura);
        txtFechaEmision = (TextView) view.findViewById(R.id.txtFechaEmision);
        txtFechaVencimientoPago = (TextView) view.findViewById(R.id.txtFechaVencimientoPago);
        txtFechaRecibidoCoomeva = (TextView) view.findViewById(R.id.txtFechaRecibidoCoomeva);
        txtProveedor = (TextView) view.findViewById(R.id.txtProveedor);
        txtValorTotalFactura = (TextView) view.findViewById(R.id.txtValorTotalFactura);

        tabFacturaInformacionAdapter = new TabFacturaInformacionAdapter(view.getContext(), TabFacturaFragment.facturaSeleccionado.getLstInformacionFactura());
        listViewFacturaInformacionAdapter.setAdapter(tabFacturaInformacionAdapter);
 //       justifyListViewHeightBasedOnChildren(listViewFacturaInformacionAdapter);

        txtNumeroFactura.setText(TabFacturaFragment.facturaSeleccionado.getNumeroFactura());
        txtFechaEmision.setText(TabFacturaFragment.facturaSeleccionado.getFechaEmisionTexto());
        txtFechaVencimientoPago.setText(TabFacturaFragment.facturaSeleccionado.getFechaVencimientoPagoTexto());
        txtFechaRecibidoCoomeva.setText(TabFacturaFragment.facturaSeleccionado.getFechaRecibidoCoomevaTexto());
        txtProveedor.setText(TabFacturaFragment.facturaSeleccionado.getProveedor());
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
