package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import co.com.coomeva.sofibmobile.R;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleNotaCreditoGiroFragment extends Fragment{

    private TextView txtConsecutivoNotaCredito;
    private TextView txtIdGiroAsociado;
    private TextView txtNombreBeneficiario;
    private TextView txtTipoGiro;
    private TextView txtCiudad;
    private TextView txtTipoBeneficiario;
    private TextView txtEstado;
    private TextView txtValorNota;
    private TextView txtFechaRegistro;
    private TextView txtFechaLiquidacion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_nota_credito_giro, container, false);

        //Se enlaza los componentes Android al fragment
        txtConsecutivoNotaCredito = (TextView) view.findViewById(R.id.txtConsecutivoNotaCredito);
        txtIdGiroAsociado = (TextView) view.findViewById(R.id.txtIdGiroAsociado);
        txtNombreBeneficiario = (TextView) view.findViewById(R.id.txtNombreBeneficiario);
        txtTipoGiro = (TextView) view.findViewById(R.id.txtTipoGiro);
        txtCiudad = (TextView) view.findViewById(R.id.txtCiudad);
        txtTipoBeneficiario = (TextView) view.findViewById(R.id.txtTipoBeneficiario);
        txtEstado = (TextView) view.findViewById(R.id.txtEstado);
        txtValorNota = (TextView) view.findViewById(R.id.txtValorNota);
        txtFechaRegistro = (TextView) view.findViewById(R.id.txtFechaRegistro);
        txtFechaLiquidacion = (TextView) view.findViewById(R.id.txtFechaLiquidacion);

        try {

        //Se colocan los datos del giro estatica del View a los componentes para mostrar su informacio
            txtConsecutivoNotaCredito.setText(getResources().getString(R.string.lbl_consecutivo_nota_credito) + ": "+NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getConsecutivoNotaCredito());
            txtIdGiroAsociado.setText(getResources().getString(R.string.lbl_id_giro_asociado) + ": "+NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getIdGiroAsociado());
            txtNombreBeneficiario.setText(NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getNombreBeneficiario());
            txtTipoGiro.setText(NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getTipoGiro());
            txtCiudad.setText(getResources().getString(R.string.lbl_ciudad) + ": "+NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getCiudad());
            txtTipoBeneficiario.setText(NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getTipoBeneficiario());
            txtEstado.setText(NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getEstado());
            txtValorNota.setText(NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getValorNotaTexto());
            txtFechaRegistro.setText(NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getFechaRegistroTexto());
            txtFechaLiquidacion.setText(NotaCreditoGiroFragment.notaCreditoGiroSeleccionado.getFechaLiquidacionTexto());

        }catch (Exception e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }



        return view;
    }
}
