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
import co.com.coomeva.sofibmobile.adapters.TabGiroManutencionAdapter;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabNotaCreditoDebitoInformacionFragment extends Fragment{

    private TextView txtNumeroFactura;
    private TextView txtFechaEmision;
    private TextView txtFechaVencimientoPago;
    private TextView txtFechaRecibidoCoomeva;
    private TextView txtProveedor;
    private TextView txtValorTotalFactura;
    private TextView txtValorTotalPagar;

    private TextView txtNumeroNota;
    private TextView txtFechaExpedicion;
    private TextView txtFechaRecibidoCoomevaNota;
    private TextView txtMotivo;
    private TextView txtValorTotalNotaCredito;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_nota_credito_debito_informacion, container, false);

        txtNumeroFactura = (TextView) view.findViewById(R.id.txtNumeroFactura);
        txtFechaEmision = (TextView) view.findViewById(R.id.txtFechaEmision);
        txtFechaVencimientoPago = (TextView) view.findViewById(R.id.txtFechaVencimientoPago);
        txtFechaRecibidoCoomeva = (TextView) view.findViewById(R.id.txtFechaRecibidoCoomeva);
        txtProveedor = (TextView) view.findViewById(R.id.txtProveedor);
        txtValorTotalFactura = (TextView) view.findViewById(R.id.txtValorTotalFactura);
        txtValorTotalPagar = (TextView) view.findViewById(R.id.txtValorTotalPagar);
        txtNumeroNota = (TextView) view.findViewById(R.id.txtNumeroNota);
        txtFechaExpedicion = (TextView) view.findViewById(R.id.txtFechaExpedicion);
        txtFechaRecibidoCoomevaNota = (TextView) view.findViewById(R.id.txtFechaRecibidoCoomevaNota);
        txtMotivo = (TextView) view.findViewById(R.id.txtMotivo);
        txtValorTotalNotaCredito = (TextView) view.findViewById(R.id.txtValorTotalNotaCredito);


        txtNumeroFactura.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getNumeroFactura());
        txtFechaEmision.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getFechaEmisionTexto());
        txtFechaVencimientoPago.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getFechaVencimientoPagoTexto());
        txtFechaRecibidoCoomeva.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getFechaRecibidoCoomevaTexto());
        txtProveedor.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getProveedor());
        txtValorTotalFactura.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getValorTotalFacturaTexto());
        txtValorTotalPagar.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getValorTotalAPagarTexto());
        txtNumeroNota.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getNumeroNota());
        txtFechaExpedicion.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getFechaExpedicionTexto());
        txtFechaRecibidoCoomevaNota.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getFechaRecibidoCoomevaNotaCreditoTexto());
        txtMotivo.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getMotivo());
        txtValorTotalNotaCredito.setText(TabNotaCreditoDebitoFragment.notaCreditoDebitoSeleccionado.getValorTotalNotaCreditoTexto());

        return view;
    }


}
