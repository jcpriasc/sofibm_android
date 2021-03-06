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
public class TabServicioProveedorServicioNoAsistencialFragment extends Fragment{

    private TextView txtProveedor;
    private TextView txtServicio;
    private TextView txtUbicacion;
    private TextView txtFecha;
    private TextView txtFechaTentativa;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_servicio_no_asistencial_servicio_proveedor, container, false);

        txtProveedor = (TextView) view.findViewById(R.id.txtProveedor);
        txtServicio = (TextView) view.findViewById(R.id.txtServicio);
        txtUbicacion = (TextView) view.findViewById(R.id.txtUbicacion);
        txtFecha = (TextView) view.findViewById(R.id.txtFecha);
        txtFechaTentativa = (TextView) view.findViewById(R.id.txtFechaTentativa);

        txtProveedor.setText(DetalleTabServicioNoAsistencialFragment.servicioSeleccionado.getProveedor());
        txtServicio.setText(DetalleTabServicioNoAsistencialFragment.servicioSeleccionado.getServicio());
        txtFecha.setText(DetalleTabServicioNoAsistencialFragment.servicioSeleccionado.getFechaTexto());
        txtUbicacion.setText(DetalleTabServicioNoAsistencialFragment.servicioSeleccionado.getUbicacion());
        txtFechaTentativa.setText(DetalleTabServicioNoAsistencialFragment.servicioSeleccionado.getFechaTentativaTexto());
        return view;
    }
}
