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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAprobacionView;
import co.com.coomeva.sofibmobile.OpcionesView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.dto.DetalleSolicitudAprobacionDTO;
import co.com.coomeva.sofibmobile.dto.DocumentosAprobacionDTO;
import co.com.coomeva.sofibmobile.dto.ProcedimientoDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;

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

    private FloatingActionButton btnDetalle;

    public static DetalleSolicitudAprobacionDTO detalleSolicitudAprobacionSeleccionada;

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
        btnDetalle = (FloatingActionButton) view.findViewById(R.id.btnDetalle);

        //Se colocan los datos de la solicitud estatica del View a los componentes para mostrar su informacion
        txtNombrePaciente.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getNombrePaciente());
        txtEstado.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getEstado());
        txtFechaSolicitud.setText(ConsultaSolicitudAprobacionView.getSolicitudAprobacionSeleccionada().getFechaSolicitudString());

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String params = "SAC/ABCD1234/"+ConsultaSolicitudAprobacionView.solicitudAprobacionSeleccionada.getIdAprobacion();

                    if (consultarDetalleSolicitudAprobacion(getActivity().getResources().getString(R.string.complement_detalle_aprobacion), params)){

                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        Fragment fragment = new TabSolicitudAprobacionFragment();
                        fragment.setArguments(getActivity().getIntent().getExtras());
                        ft.replace(R.id.fragment_container_consulta_solicitud_aprobacion, fragment, "TabSolicitudAprobacionFragment").addToBackStack("TabSolicitudAprobacionFragment").commit();

                    }

                }catch (Exception e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    private boolean consultarDetalleSolicitudAprobacion(String serviceName, String listParams){

        boolean respuesta = false;

        try {

            ConexionServicioListaTask task = new ConexionServicioListaTask(getActivity(), serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            if (ConexionServicioListaTask.respJSON !=null){
                respuesta = true;
                JSONObject obj = ConexionServicioListaTask.respJSON;

                String identificacion = (obj.getString("identificacion") != null && !obj.getString("identificacion").equals("null")) ? obj.getString("identificacion"):"";
                String nombre = (obj.getString("nombre") != null && !obj.getString("nombre").equals("null")) ? obj.getString("nombre"):"";
                String estadoPaciente = (obj.getString("estadoPaciente") != null && !obj.getString("estadoPaciente").equals("null")) ? obj.getString("estadoPaciente"):"";
                String fechaRegreso = (obj.getString("fechaRegreso") != null && !obj.getString("fechaRegreso").equals("null")) ? obj.getString("fechaRegreso"):"";
                String diagnostico = (obj.getString("diagnostico") != null && !obj.getString("diagnostico").equals("null")) ? obj.getString("diagnostico"):"";
                String convenio = (obj.getString("convenio") != null && !obj.getString("convenio").equals("null")) ? obj.getString("convenio"):"";
                String tipoConvenio = (obj.getString("tipoConvenio") != null && !obj.getString("tipoConvenio").equals("null")) ? obj.getString("tipoConvenio"):"";
                String pais = (obj.getString("pais") != null && !obj.getString("pais").equals("null")) ? obj.getString("pais"):"";
                String entidad = (obj.getString("entidad") != null && !obj.getString("entidad").equals("null")) ? obj.getString("entidad"):"";
                String tipo = (obj.getString("tipo") != null && !obj.getString("tipo").equals("null")) ? obj.getString("tipo"):"";
                String justificacion = (obj.getString("justificacion") != null && !obj.getString("justificacion").equals("null")) ? obj.getString("justificacion"):"";

                List<ProcedimientoDTO> lstProcedimientos = new ArrayList<>();
                List<DocumentosAprobacionDTO> lstDocumentoAprobacion = new ArrayList<>();

                JSONArray jsonArrayDocumentos = obj.optJSONArray("lstDocumentos");

                for (int x = 0; x < jsonArrayDocumentos.length(); x++) {
                    JSONObject documento = jsonArrayDocumentos.getJSONObject(x);

                    String tipoArchivo = (documento.getString("tipoArchivo") != null && !documento.getString("tipoArchivo").equals("null")) ? documento.getString("tipoArchivo"):"";
                    String nombreDocumento = (documento.getString("nombreDocumento") != null && !documento.getString("nombreDocumento").equals("null")) ? documento.getString("nombreDocumento"):"";
                    String archivoString = (documento.getString("archivo") != null && !documento.getString("archivo").equals("null")) ? documento.getString("archivo"):"";
                    String id = (documento.getString("id") != null && !documento.getString("id").equals("null")) ? documento.getString("id"):"";

                    DocumentosAprobacionDTO documentosAprobacionDTO = new DocumentosAprobacionDTO(tipoArchivo, nombreDocumento, archivoString, id);

                    if (lstDocumentoAprobacion==null){
                        lstDocumentoAprobacion = new ArrayList<>();
                    }

                    lstDocumentoAprobacion.add(documentosAprobacionDTO);

                }

                JSONArray jsonArrayProcedimiento = obj.optJSONArray("lstProcedimiento");

                for (int x = 0; x < jsonArrayProcedimiento.length(); x++) {
                    JSONObject procedimiento = jsonArrayProcedimiento.getJSONObject(x);

                    String nombreProcedimiento = (procedimiento.getString("nombre") != null && !procedimiento.getString("nombre").equals("null")) ? procedimiento.getString("nombre"):"";
                    String prestadorProcedimiento = (procedimiento.getString("prestador") != null && !procedimiento.getString("prestador").equals("null")) ? procedimiento.getString("prestador"):"";

                    ProcedimientoDTO procedimientoDTO = new ProcedimientoDTO(nombreProcedimiento, prestadorProcedimiento);

                    if (lstProcedimientos==null){
                        lstProcedimientos = new ArrayList<>();
                    }

                    lstProcedimientos.add(procedimientoDTO);

                }

                detalleSolicitudAprobacionSeleccionada = new DetalleSolicitudAprobacionDTO(identificacion, nombre, estadoPaciente, fechaRegreso, diagnostico, convenio, tipoConvenio, pais, entidad, tipo, justificacion, lstProcedimientos, lstDocumentoAprobacion);

            }

        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }
}
