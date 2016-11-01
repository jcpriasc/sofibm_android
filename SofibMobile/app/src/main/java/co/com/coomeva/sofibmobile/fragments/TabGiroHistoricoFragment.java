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
import co.com.coomeva.sofibmobile.adapters.TabGiroConceptosAdapter;
import co.com.coomeva.sofibmobile.adapters.TabGiroHistoricoAdapter;
import co.com.coomeva.sofibmobile.dto.HistoricoGirosDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabGiroHistoricoFragment extends Fragment{

    private TabGiroHistoricoAdapter tabGiroHistoricoAdapter;
    private ListView listViewHistoricoAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_giro_historico, container, false);
        listViewHistoricoAdapter = (ListView) view.findViewById(R.id.lstHistorico);

        tabGiroHistoricoAdapter = new TabGiroHistoricoAdapter(view.getContext(), TabGiroFragment.giroSeleccionado.getLstHistoricoGiro());
        listViewHistoricoAdapter.setAdapter(tabGiroHistoricoAdapter);
        justifyListViewHeightBasedOnChildren(listViewHistoricoAdapter);


        listViewHistoricoAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                try {

                    LayoutInflater inflater = getActivity().getLayoutInflater();

                    View dialoglayout = inflater.inflate(R.layout.dialog_giro, null);

                    final TextView txtId = (TextView) dialoglayout.findViewById(R.id.txtId);
                    final TextView txtCiudad = (TextView) dialoglayout.findViewById(R.id.txtCiudad);
                    final TextView txtConvenio = (TextView) dialoglayout.findViewById(R.id.txtConvenio);
                    final TextView txtEstado = (TextView) dialoglayout.findViewById(R.id.txtEstado);
                    final TextView txtTipoGiro = (TextView) dialoglayout.findViewById(R.id.txtTipoGiro);
                    final TextView txtTipoBeneficiario = (TextView) dialoglayout.findViewById(R.id.txtTipoBeneficiario);
                    final TextView txtBeneficiario = (TextView) dialoglayout.findViewById(R.id.txtBeneficiario);
                    final TextView txtFechaInicio = (TextView) dialoglayout.findViewById(R.id.txtFechaInicio);
                    final TextView txtFechaFin = (TextView) dialoglayout.findViewById(R.id.txtFechaFin);
                    final TextView txtValorMonedaExtrajera = (TextView) dialoglayout.findViewById(R.id.txtValorMonedaExtrajera);
                    final TextView txtMonedaLocal = (TextView) dialoglayout.findViewById(R.id.txtMonedaLocal);
                    final TextView txtRegistraDevolucion = (TextView) dialoglayout.findViewById(R.id.txtRegistraDevolucion);
                    final TextView txtValorDevolucion = (TextView) dialoglayout.findViewById(R.id.txtValorDevolucion);
                    final TextView txtLegalizado = (TextView) dialoglayout.findViewById(R.id.txtLegalizado);
                    final TextView txtValorLegalizado = (TextView) dialoglayout.findViewById(R.id.txtValorLegalizado);

                    List<HistoricoGirosDTO> lstsHistorico = TabGiroFragment.giroSeleccionado.getLstHistoricoGiro();
                    HistoricoGirosDTO historico = lstsHistorico.get(i);

                    txtId.setText(historico.getId());
                    txtCiudad.setText(historico.getCiudad());
                    txtConvenio.setText(historico.getConvenio());
                    txtEstado.setText(historico.getEstado());
                    txtTipoGiro.setText(historico.getTipoGiro());
                    txtTipoBeneficiario.setText(historico.getTipoBeneficiario());
                    txtBeneficiario.setText(historico.getBeneficiario());
                    txtFechaInicio.setText(historico.getFechaInicioTexto());
                    txtFechaFin.setText(historico.getFechaFinTexto());
                    txtValorMonedaExtrajera.setText(historico.getValorMonedaExtranjeroTexto());
                    txtMonedaLocal.setText(historico.getValorMonedaLocalTexto());
                    txtRegistraDevolucion.setText(historico.getRegistraDevolucion());
                    txtValorDevolucion.setText(historico.getValorDevolucionTexto());
                    txtLegalizado.setText(historico.getLegalizado());
                    txtValorLegalizado.setText(historico.getValorLegalizadoTexto());

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
