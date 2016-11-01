package co.com.coomeva.sofibmobile.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAprobacionView;
import co.com.coomeva.sofibmobile.OpcionesView;
import co.com.coomeva.sofibmobile.R;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleSolicitudAprobacionFragment extends Fragment{

    private TextView txtNombrePaciente;
    private TextView txtEstado;
    private TextView txtFechaSolicitud;
    private TextView txtDescripcion;
    private TextView txtTipoAutorizacion;
    private TextView txtTipoEntidad;
    private TextView txtSolicitante;
    private TextView txtAutoriza;
    private TextView txtFechaAutorizacion;
    private TextView txtServicio;
    private TextView txtProveedor;
    private TextView txtPrestador;
    private TextView txtJustificacion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_solicitud_aprobacion, container, false);

        //Se enlaza los componentes Android al fragment
        txtNombrePaciente = (TextView) view.findViewById(R.id.txtNombrePaciente);
        txtEstado = (TextView) view.findViewById(R.id.txtEstado);
        txtFechaSolicitud = (TextView) view.findViewById(R.id.txtFechaSolicitud);
        txtDescripcion = (TextView) view.findViewById(R.id.txtDescripcion);
        txtTipoAutorizacion = (TextView) view.findViewById(R.id.txtTipoAutorizacion);
        txtTipoEntidad = (TextView) view.findViewById(R.id.txtTipoEntidad);
        txtSolicitante = (TextView) view.findViewById(R.id.txtSolicitante);
        txtAutoriza = (TextView) view.findViewById(R.id.txtAutoriza);
        txtFechaAutorizacion = (TextView) view.findViewById(R.id.txtFechaAutorizacion);
        txtServicio = (TextView) view.findViewById(R.id.txtServicio);
        txtProveedor = (TextView) view.findViewById(R.id.txtProveedor);
        txtPrestador = (TextView) view.findViewById(R.id.txtPrestador);
        txtJustificacion = (TextView) view.findViewById(R.id.txtJustificacion);


        //Se colocan los datos de la solicitud estatica del View a los componentes para mostrar su informacion
        txtNombrePaciente.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getNombrePaciente());
        txtEstado.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getEstado());
        txtFechaSolicitud.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getFechaSolicitudString());


//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getDescripcion() == null
//                || ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getDescripcion().trim().equals("")){
//            txtDescripcion.setText(R.string.lbl_no_aplica);
//        }else{
//            txtDescripcion.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getDescripcion().trim());
//        }
//
//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getTipoAutorizacion() == null
//                || ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getTipoAutorizacion().trim().equals("")){
//            txtTipoAutorizacion.setText(R.string.lbl_no_aplica);
//        }else{
//            txtTipoAutorizacion.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getTipoAutorizacion().trim());
//        }
//
//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getTipoEntidad() == null
//                || ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getTipoEntidad().trim().equals("")){
//            txtTipoEntidad.setText(R.string.lbl_no_aplica);
//        }else{
//            txtTipoEntidad.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getTipoEntidad().trim());
//        }
//
//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getSolicitante() == null
//                || ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getSolicitante().trim().equals("")){
//            txtSolicitante.setText(R.string.lbl_no_aplica);
//        }else{
//            txtSolicitante.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getSolicitante().trim());
//        }
//
//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getAutoriza() == null
//                || ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getAutoriza().trim().equals("")){
//            txtAutoriza.setText(R.string.lbl_no_aplica);
//        }else{
//            txtAutoriza.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getAutoriza().trim());
//        }
//
//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getFechaAutorizacion() == null){
//            txtFechaAutorizacion.setText(R.string.lbl_no_aplica);
//        }else{
//            txtFechaAutorizacion.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getFechaAutorizacionTexto().trim());
//        }
//
//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getServicio() == null
//                || ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getServicio().trim().equals("")){
//            txtServicio.setText(R.string.lbl_no_aplica);
//        }else{
//            txtServicio.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getServicio().trim());
//        }
//
//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getProveedor() == null
//                || ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getProveedor().trim().equals("")){
//            txtProveedor.setText(R.string.lbl_no_aplica);
//        }else{
//            txtProveedor.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getProveedor().trim());
//        }
//
//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getPrestador() == null
//                || ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getPrestador().trim().equals("")){
//            txtPrestador.setText(R.string.lbl_no_aplica);
//        }else{
//            txtPrestador.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getPrestador().trim());
//        }
//
//        if(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getJustificacion() == null
//                || ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getJustificacion().trim().equals("")){
//            txtJustificacion.setText(R.string.lbl_no_aplica);
//        }else{
//            txtJustificacion.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getJustificacion().trim());
//        }

        return view;
    }
}
