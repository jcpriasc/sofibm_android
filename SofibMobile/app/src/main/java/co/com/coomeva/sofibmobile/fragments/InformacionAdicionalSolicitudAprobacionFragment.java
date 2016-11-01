package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAprobacionView;
import co.com.coomeva.sofibmobile.R;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class InformacionAdicionalSolicitudAprobacionFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_solicitud_aprobacion, container, false);

        return view;
    }
}
