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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.DetalleUtilizacionesAdapter;
import co.com.coomeva.sofibmobile.adapters.TabGiroManutencionAdapter;
import co.com.coomeva.sofibmobile.dto.DetalleUtilizacionesDTO;
import co.com.coomeva.sofibmobile.dto.ManutencionDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabGiroManutencionFragment extends Fragment{

    private TextView txtBeneficiario;
    private TextView txtMontoDiario;

    private TabGiroManutencionAdapter tabGiroManutencionAdapter;
    private ListView listViewManutencionAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_giro_manutencion, container, false);
        listViewManutencionAdapter = (ListView) view.findViewById(R.id.lstManutencion);
        txtMontoDiario = (TextView) view.findViewById(R.id.txtMontoDiario);

        tabGiroManutencionAdapter = new TabGiroManutencionAdapter(view.getContext(), TabGiroFragment.giroSeleccionado.getLstManutencion());
        listViewManutencionAdapter.setAdapter(tabGiroManutencionAdapter);
        justifyListViewHeightBasedOnChildren(listViewManutencionAdapter);

        txtMontoDiario.setText(TabGiroFragment.giroSeleccionado.getMontoDiarioAcompañanteTexto());

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
