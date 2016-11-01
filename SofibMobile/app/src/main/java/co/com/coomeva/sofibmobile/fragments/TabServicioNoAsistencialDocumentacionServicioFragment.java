package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.com.coomeva.sofibmobile.R;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabServicioNoAsistencialDocumentacionServicioFragment extends Fragment{

    private TextView txtDescripcionRestriccion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_servicio_no_asistencial_documentacion_servicio, container, false);

        txtDescripcionRestriccion = (TextView) view.findViewById(R.id.txtDescripcionRestriccion);

        txtDescripcionRestriccion.setText(DetalleTabServicioNoAsistencialFragment.servicioSeleccionado.getDescripcionRestriccion());
        return view;
    }
}
