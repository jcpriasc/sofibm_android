package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.TabGiroManutencionAdapter;
import co.com.coomeva.sofibmobile.adapters.TabNotaCreditoDebitoImpuestoAdapter;
import co.com.coomeva.sofibmobile.dto.HistoricoGirosDTO;
import co.com.coomeva.sofibmobile.dto.ImpuestoNotaCreditoDebitoDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabNotaCreditoDebitoImpuestoFragment extends Fragment{

    private TextView txtTotalServicio;
    private TextView txtTotalSeguroHotelero;
    private TextView txtTotalNota;
    private TextView txtValorIva;
    private TextView txtValorTotalPagar;

    private TabNotaCreditoDebitoImpuestoAdapter tabNotaCreditoDebitoImpuestoAdapter;
    private ListView listViewNotaCreditoAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_nota_credito_debito_impuesto, container, false);
        listViewNotaCreditoAdapter = (ListView) view.findViewById(R.id.lstImpuesto);

        txtTotalServicio = (TextView) view.findViewById(R.id.txtTotalServicio);
        txtTotalSeguroHotelero = (TextView) view.findViewById(R.id.txtTotalSeguroHotelero);
        txtTotalNota = (TextView) view.findViewById(R.id.txtTotalNota);
        txtValorIva = (TextView) view.findViewById(R.id.txtValorIva);
        txtValorTotalPagar = (TextView) view.findViewById(R.id.txtValorTotalPagar);

        tabNotaCreditoDebitoImpuestoAdapter = new TabNotaCreditoDebitoImpuestoAdapter(view.getContext(), TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getLsImpuestoNotaCreditoDebito());
        listViewNotaCreditoAdapter.setAdapter(tabNotaCreditoDebitoImpuestoAdapter);
        justifyListViewHeightBasedOnChildren(listViewNotaCreditoAdapter);

        txtTotalServicio.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getValorTotalServicioTexto());
        txtTotalSeguroHotelero.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getValorTotalSeguroHoteleroTexto());
        txtTotalNota.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getValorTotalNotaTexto());
        txtValorIva.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getValorIvaTexto());
        txtValorTotalPagar.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getValorTotalAPagarTexto());

        listViewNotaCreditoAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                try {

                    LayoutInflater inflater = getActivity().getLayoutInflater();

                    View dialoglayout = inflater.inflate(R.layout.dialog_impuesto_nota, null);

                    final TextView txtProveedor = (TextView) dialoglayout.findViewById(R.id.txtProveedor);
                    final TextView txtNumeroOrdenServicio = (TextView) dialoglayout.findViewById(R.id.txtNumeroOrdenServicio);
                    final TextView txtServicio = (TextView) dialoglayout.findViewById(R.id.txtServicio);
                    final TextView txtFechaInicio = (TextView) dialoglayout.findViewById(R.id.txtFechaInicio);
                    final TextView txtFechaFinalizacion = (TextView) dialoglayout.findViewById(R.id.txtFechaFinalizacion);
                    final TextView txtValorServicio = (TextView) dialoglayout.findViewById(R.id.txtValorServicio);
                    final TextView txtSeguroHotelero = (TextView) dialoglayout.findViewById(R.id.txtSeguroHotelero);
                    final TextView txtValorNota = (TextView) dialoglayout.findViewById(R.id.txtValorNota);

                    List<ImpuestoNotaCreditoDebitoDTO> lstNotas = TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getLsImpuestoNotaCreditoDebito();
                    ImpuestoNotaCreditoDebitoDTO nota = lstNotas.get(i);

                    txtProveedor.setText(nota.getProveedor());
                    txtNumeroOrdenServicio.setText(nota.getNumeroOrdenServicio());
                    txtServicio.setText(nota.getServicio());
                    txtFechaInicio.setText(nota.getFechaInicioTexto());
                    txtFechaFinalizacion.setText(nota.getFechaFinalizacionTexto());
                    txtValorServicio.setText(nota.getValorServicioTexto());
                    txtSeguroHotelero.setText(nota.getSeguroHoteleroTexto());
                    txtValorNota.setText(nota.getValorNotaTexto());

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setView(dialoglayout);
                    builder.show();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

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
