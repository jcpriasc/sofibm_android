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
public class TabFacturaGlosaFragment extends Fragment{

    private TextView txtNumeroFactura;
    private TextView txtFechaEmision;
    private TextView txtFechaVencimientoPago;
    private TextView txtFechaRecibidoCoomeva;
    private TextView txtProveedor;
    private TextView txtValorTotalFactura;
    private TextView txtDescripcion;
    private TextView txtMotivo;
    private TextView txtAplicaGlosa;
    private TextView txtValorGlosa;
    private TextView lblValorGlosa;
    private TextView lblMotivo;
    private TextView lblDescripcion;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_factura_glosa, container, false);

        txtNumeroFactura = (TextView) view.findViewById(R.id.txtNumeroFactura);
        txtFechaEmision = (TextView) view.findViewById(R.id.txtFechaEmision);
        txtFechaVencimientoPago = (TextView) view.findViewById(R.id.txtFechaVencimientoPago);
        txtFechaRecibidoCoomeva = (TextView) view.findViewById(R.id.txtFechaRecibidoCoomeva);
        txtProveedor = (TextView) view.findViewById(R.id.txtProveedor);
        txtValorTotalFactura = (TextView) view.findViewById(R.id.txtValorTotalFactura);
        txtDescripcion = (TextView) view.findViewById(R.id.txtDescripcion);
        txtMotivo = (TextView) view.findViewById(R.id.txtMotivo);
        txtAplicaGlosa = (TextView) view.findViewById(R.id.txtAplicaGlosa);
        txtValorGlosa = (TextView) view.findViewById(R.id.txtValorGlosa);

        lblValorGlosa = (TextView) view.findViewById(R.id.lblValorGlosa);
        lblMotivo = (TextView) view.findViewById(R.id.lblMotivo);
        lblDescripcion = (TextView) view.findViewById(R.id.lblDescripcion);

        if(TabFacturaFragment.facturaSeleccionado.getAplicaGlosa().equals("NO")){
            lblValorGlosa.setVisibility(View.INVISIBLE);
            lblMotivo.setVisibility(View.INVISIBLE);
            lblDescripcion.setVisibility(View.INVISIBLE);
            txtDescripcion.setVisibility(View.INVISIBLE);
            txtMotivo.setVisibility(View.INVISIBLE);
            txtValorGlosa.setVisibility(View.INVISIBLE);
        }

        txtNumeroFactura.setText(TabFacturaFragment.facturaSeleccionado.getNumeroFactura());
        txtFechaEmision.setText(TabFacturaFragment.facturaSeleccionado.getFechaEmisionTexto());
        txtFechaVencimientoPago.setText(TabFacturaFragment.facturaSeleccionado.getFechaVencimientoPagoTexto());
        txtFechaRecibidoCoomeva.setText(TabFacturaFragment.facturaSeleccionado.getFechaRecibidoCoomevaTexto());
        txtProveedor.setText(TabFacturaFragment.facturaSeleccionado.getProveedor());
        txtValorTotalFactura.setText(TabFacturaFragment.facturaSeleccionado.getValorTotalFacturaTexto());

        txtDescripcion.setText(TabFacturaFragment.facturaSeleccionado.getDescripcionGlosa());
        txtMotivo.setText(TabFacturaFragment.facturaSeleccionado.getMotivoGlosa());
        txtAplicaGlosa.setText(TabFacturaFragment.facturaSeleccionado.getAplicaGlosa());
        txtValorGlosa.setText(TabFacturaFragment.facturaSeleccionado.getValorGlosaTexto());

        return view;
    }

}
