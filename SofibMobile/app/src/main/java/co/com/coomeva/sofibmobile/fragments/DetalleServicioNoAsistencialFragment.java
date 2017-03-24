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
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAprobacionView;
import co.com.coomeva.sofibmobile.OpcionesView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.ServicioNoAsistencialAdapter;
import co.com.coomeva.sofibmobile.dto.DetalleServicioNoAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.ServicioAdicionalDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNoAsistencialDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleServicioNoAsistencialFragment extends Fragment{

    private TextView txtNumeroSolicitud;
    private TextView txtTipoSolicitud;
    private TextView txtCiudad;
    private TextView txtEstado;
    private TextView txtJustificacionCancelacion;
    private FloatingActionButton btnDetalle;

    public static DetalleServicioNoAsistencialDTO servicioSeleccionado = null;
    List<ServicioAdicionalDTO> lstServiciosAdicionales = new ArrayList<ServicioAdicionalDTO>();


    public static JSONArray respJSON = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_servicio_no_asistencial, container, false);

        //Se enlaza los componentes Android al fragment
        txtNumeroSolicitud = (TextView) view.findViewById(R.id.txtNumeroSolicitud);
        txtTipoSolicitud = (TextView) view.findViewById(R.id.txtTipoSolicitud);
        txtCiudad = (TextView) view.findViewById(R.id.txtCiudad);
        txtEstado = (TextView) view.findViewById(R.id.txtEstado);
        txtJustificacionCancelacion = (TextView) view.findViewById(R.id.txtJustificacionCancelacion);
        btnDetalle = (FloatingActionButton) view.findViewById(R.id.btnDetalle);

        //Se colocan los datos del servicio estatica del View a los componentes para mostrar su informacion
        txtNumeroSolicitud.setText(getResources().getString(R.string.lbl_numero_solicitud) + ": "+ServicioNoAsistencialFragment.servicio.getNumeroSolicitud());
        txtTipoSolicitud.setText(ServicioNoAsistencialFragment.servicio.getTipoSolicitud());
        txtCiudad.setText(ServicioNoAsistencialFragment.servicio.getCiudad());

        if(ServicioNoAsistencialFragment.servicio.getEstado() == null || ServicioNoAsistencialFragment.servicio.getEstado().trim().equals("")){
            txtEstado.setText(R.string.lbl_no_aplica);
        }else{
            txtEstado.setText(ServicioNoAsistencialFragment.servicio.getEstado().trim());
        }

        if(ServicioNoAsistencialFragment.servicio.getJustificacionCancelacion() == null || ServicioNoAsistencialFragment.servicio.getJustificacionCancelacion().trim().equals("")){
            txtJustificacionCancelacion.setText(R.string.lbl_no_aplica);
        }else{
            txtJustificacionCancelacion.setText(ServicioNoAsistencialFragment.servicio.getJustificacionCancelacion().trim());
        }

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    String params = "/SAC/ABCD1234/"+ ServicioNoAsistencialFragment.servicio.getConsservicio();
                    if (consultarServicioNoAsistencial(getActivity().getResources().getString(R.string.complement_serviciosNoAsistenciales_detalle), params)){

                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        Fragment fragment = new DetalleTabServicioNoAsistencialFragment();
                        fragment.setArguments(getActivity().getIntent().getExtras());
                        ft.replace(R.id.fragment_container_servicio_no_asistencial, fragment, "DetalleTabServicioNoAsistencialFragment").addToBackStack("DetalleTabServicioNoAsistencialFragment").commit();

                    }else {
                        throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                    }


                }catch (Exception e) {
                    Toast.makeText(view.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }


    private boolean consultarServicioNoAsistencial(String serviceName, String listParams){

        boolean respuesta = false;

        try {

            ConexionServicioListaTask task = new ConexionServicioListaTask(getActivity(), serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            if (ConexionServicioListaTask.respJSON !=null){
                respuesta = true;
                JSONObject obj = ConexionServicioListaTask.respJSON;
                String proveedor = (obj.getString("proveedor") != null && !obj.getString("proveedor").equals("null")) ? obj.getString("proveedor"):"";
                String servicio = (obj.getString("servicio") != null && !obj.getString("servicio").equals("null")) ? obj.getString("servicio"):"";
                String fecha = (obj.getString("fecha") != null && !obj.getString("fecha").equals("null")) ? obj.getString("fecha" ):"";
                String ubicacion = (obj.getString("ubicacionDestino") != null && !obj.getString("ubicacionDestino").equals("null")) ? obj.getString("ubicacionDestino" ):"";
                String fechaTentativa = (obj.getString("fechaFinTentativa") != null && !obj.getString("fechaFinTentativa").equals("null")) ? obj.getString("fechaFinTentativa" ):"";
                String descripcionYRestricciones = (obj.getString("descripcionYRestricciones") != null && !obj.getString("descripcionYRestricciones").equals("null")) ? obj.getString("descripcionYRestricciones"):"";

                JSONArray json_array = obj.optJSONArray("detalle");
                    lstServiciosAdicionales = new ArrayList<ServicioAdicionalDTO>();


                for (int x = 0; x < json_array.length(); x++) {
                    JSONObject detalle = json_array.getJSONObject(x);

                    String nombre = (detalle.getString("nombre") != null && !detalle.getString("nombre").equals("null")) ? detalle.getString("nombre"):"";
                    String descripcion = (detalle.getString("descripcion") != null && !detalle.getString("descripcion").equals("null")) ? detalle.getString("descripcion"):"";
                    String proveedorDetalle = (detalle.getString("proveedor2") != null && !detalle.getString("proveedor2").equals("null")) ? detalle.getString("proveedor2" ):"";

                    ServicioAdicionalDTO servicioAdicional = new ServicioAdicionalDTO(nombre,descripcion,proveedorDetalle);
                    lstServiciosAdicionales.add(servicioAdicional);
                    //creamos un objeto Fruta y lo insertamos en la lista
                }

                servicioSeleccionado = new DetalleServicioNoAsistencialDTO(proveedor,servicio,fecha,descripcionYRestricciones,lstServiciosAdicionales);
                servicioSeleccionado.setFechaTentativaTexto(fechaTentativa);
                servicioSeleccionado.setUbicacion(ubicacion);

            }

        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }


}
