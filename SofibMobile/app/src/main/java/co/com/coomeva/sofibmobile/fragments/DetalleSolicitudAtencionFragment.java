package co.com.coomeva.sofibmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.OpcionesView;
import co.com.coomeva.sofibmobile.R;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleSolicitudAtencionFragment extends Fragment{

    private TextView txtSolicitudAtencion;
    private TextView txtIdentificacion;
    private TextView txtNombre;
    private TextView txtCredencialPaciente;
    private TextView txtConvenio;
    private TextView txtCiudadInicial;
    private TextView txtCiudadActual;
    private TextView txtTraslado;
    private TextView txtFechaProgramadaRegreso;
    private TextView txtEstado;
    private TextView txtFechaCreado;
    private FloatingActionButton btnDetalle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_solicitud_atencion, container, false);

        //Se enlaza los componentes Android al fragment
        txtSolicitudAtencion = (TextView) view.findViewById(R.id.txtSolicitudAtencion);
        txtIdentificacion = (TextView) view.findViewById(R.id.txtIdentificacion);
        txtNombre = (TextView) view.findViewById(R.id.txtNombre);

        txtCredencialPaciente = (TextView) view.findViewById(R.id.txtCredencialPaciente);
        txtConvenio = (TextView) view.findViewById(R.id.txtConvenio);
        txtCiudadInicial = (TextView) view.findViewById(R.id.txtCiudadInicial);
        txtCiudadActual = (TextView) view.findViewById(R.id.txtCiudadActual);
        txtTraslado = (TextView) view.findViewById(R.id.txtTraslado);
        txtFechaProgramadaRegreso = (TextView) view.findViewById(R.id.txtFechaProgramadaRegreso);
        txtEstado = (TextView) view.findViewById(R.id.txtEstado);
        txtFechaCreado = (TextView) view.findViewById(R.id.txtFechaCreado);
        btnDetalle = (FloatingActionButton) view.findViewById(R.id.btnDetalle);


        //Se colocan los datos de la solicitud estatica del View a los componentes para mostrar su informacion
        txtSolicitudAtencion.setText(getResources().getString(R.string.lbl_solicitud_atencion) + ": "+ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getNumeroSolicitud());
        txtEstado.setText(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getEstado());
        txtNombre.setText(getResources().getString(R.string.lbl_nombre) + ": "+ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getNombrePaciente());
        txtIdentificacion.setText(getResources().getString(R.string.lbl_id) + ": "+ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getIdentificacion());

        if(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getCredencialPaciente() == null
                || ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getCredencialPaciente().trim().equals("")){
            txtCredencialPaciente.setText(R.string.lbl_no_aplica);
        }else{
            txtCredencialPaciente.setText(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getCredencialPaciente().trim());
        }

        if(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getConvenio() == null
                || ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getConvenio().trim().equals("")){
            txtConvenio.setText(R.string.lbl_no_aplica);
        }else{
            txtConvenio.setText(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getConvenio().trim());
        }

        if(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getCiudadInicial() == null
                || ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getCiudadInicial().trim().equals("")){
            txtCiudadInicial.setText(R.string.lbl_no_aplica);
        }else{
            txtCiudadInicial.setText(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getCiudadInicial().trim());
        }

        if(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getCiudadActual() == null
                || ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getCiudadActual().trim().equals("")){
            txtCiudadActual.setText(R.string.lbl_no_aplica);
        }else{
            txtCiudadActual.setText(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getCiudadActual().trim());
        }

        if(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getTraslado() == null
                || ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getTraslado().trim().equals("")){
            txtTraslado.setText(R.string.lbl_no_aplica);
        }else{
            txtTraslado.setText(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getTraslado().trim());
        }

        if(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getFechaProgramadaRegreso() == null){
            txtFechaProgramadaRegreso.setText(R.string.lbl_no_aplica);
        }else{
            txtFechaProgramadaRegreso.setText(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getFechaProgramadaRegresoString().trim());
        }

        if(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getEstado() == null
                || ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getEstado().trim().equals("")){
            txtEstado.setText(R.string.lbl_no_aplica);
        }else{
            txtEstado.setText(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getEstado().trim());
        }

        if(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getFechaCreado() == null){
            txtFechaCreado.setText(R.string.lbl_no_aplica);
        }else{
            txtFechaCreado.setText(ConsultaSolicitudAtencionView.getSolicitudAtencionSeleccionada().getFechaCreadoString().trim());
        }

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intentOpciones = new Intent(view.getContext(), OpcionesView.class);
                    startActivity(intentOpciones);
                }catch (Exception e) {

                }
            }
        });

        return view;
    }
}
