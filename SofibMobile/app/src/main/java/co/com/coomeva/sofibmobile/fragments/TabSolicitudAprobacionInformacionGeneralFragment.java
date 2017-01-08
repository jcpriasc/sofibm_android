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

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabSolicitudAprobacionInformacionGeneralFragment extends Fragment{

    private TextView txtNombreConvenio;
    private TextView txtTipoConvenio;
    private TextView txtPais;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_solicitud_aprobacion_informacion_general, container, false);

        txtNombreConvenio = (TextView) view.findViewById(R.id.txtNombreConvenio);
        txtTipoConvenio = (TextView) view.findViewById(R.id.txtTipoConvenio);
        txtPais = (TextView) view.findViewById(R.id.txtPais);

        txtNombreConvenio.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getConvenio());
        txtTipoConvenio.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getTipoConvenio());
        txtPais.setText(TabSolicitudAprobacionFragment.detalleSolicitudAprobacionDTO.getPais());

        return view;
    }

}
