package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import co.com.coomeva.sofibmobile.BitacoraView;
import co.com.coomeva.sofibmobile.R;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleBitacoraFragment extends Fragment{

    private TextView txtNumeroSolicitud;
    private TextView txtNombrePaciente;
    private TextView txtTipoRegistro;
    private TextView txtTipoAccion;
    private TextView txtEstadoBitacora;
    private TextView textCiudad;
    private TextView textServicio;
    private TextView textNombreUsuario;
    private TextView textFecha;
    private TextView textDescripcion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_bitacora, container, false);

        //Se enlaza los componentes Android al fragment
        txtNumeroSolicitud = (TextView) view.findViewById(R.id.txtNumeroSolicitud);
        txtNombrePaciente = (TextView) view.findViewById(R.id.txtNombrePaciente);
        txtTipoRegistro = (TextView) view.findViewById(R.id.txtTipoRegistro);
        txtTipoAccion = (TextView) view.findViewById(R.id.txtTipoAccion);
        txtEstadoBitacora = (TextView) view.findViewById(R.id.txtEstado);
        textCiudad = (TextView) view.findViewById(R.id.textCiudad);
        textServicio = (TextView) view.findViewById(R.id.textServicio);
        textNombreUsuario = (TextView) view.findViewById(R.id.textNombreUsuario);
        textFecha = (TextView) view.findViewById(R.id.textFecha);
        textDescripcion = (TextView) view.findViewById(R.id.textDescripcion);

        try {

        //Se colocan los datos del giro estatica del View a los componentes para mostrar su informacio
            txtNumeroSolicitud.setText(getResources().getString(R.string.lbl_numero_solicitud) + ": "+ BitacoraView.bitacoraDTO.getNumeroSolicitud());
            txtNombrePaciente.setText(getResources().getString(R.string.lbl_nombre_paciente) + ": "+BitacoraView.bitacoraDTO.getNombrePaciente());
            txtTipoRegistro.setText(getResources().getString(R.string.lbl_tipo_registro) + ": "+BitacoraView.bitacoraDTO.getTipoRegistro());
            txtTipoAccion.setText(getResources().getString(R.string.lbl_tipo_accion) + ": "+BitacoraView.bitacoraDTO.getTipoAccion());
            txtEstadoBitacora.setText(getResources().getString(R.string.lbl_estado) + ": "+BitacoraView.bitacoraDTO.getEstado());
            textCiudad.setText(BitacoraView.bitacoraDTO.getCiudadInicial());
            textServicio.setText(BitacoraView.bitacoraDTO.getTipoServicio());
            textNombreUsuario.setText(BitacoraView.bitacoraDTO.getNombreUsuario());
            textFecha.setText(BitacoraView.bitacoraDTO.getFechaCreadoString());
            textDescripcion.setText(BitacoraView.bitacoraDTO.getDescripcion());

        }catch (Exception e) {
            Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }



        return view;
    }
}
