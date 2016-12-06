package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.ConsultaSolicitudAtencionView;
import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.NotaCreditoDebitoAdapter;
import co.com.coomeva.sofibmobile.adapters.UtilizacionesAdapter;
import co.com.coomeva.sofibmobile.dto.AdministracionesDTO;
import co.com.coomeva.sofibmobile.dto.DetalleNotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.DetalleUtilizacionesDTO;
import co.com.coomeva.sofibmobile.dto.ImpuestoNotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.NotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.UtilizacionesDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;
import co.com.coomeva.sofibmobile.utils.Utilities;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class UtilizacionesFragment extends Fragment{

    private UtilizacionesAdapter utilizacionesAdapter;
    private ListView listViewUtilizacionesAdapter;
    private List<UtilizacionesDTO> lstUtilizacionesDTO = new ArrayList<UtilizacionesDTO>();
    public static UtilizacionesDTO utilizacionesSeleccionado = null;
    public static List<AdministracionesDTO> lstAdministraciones = new ArrayList<AdministracionesDTO>();
    public static List<DetalleUtilizacionesDTO> lstDetalleUtilizacionesDTO = new ArrayList<DetalleUtilizacionesDTO>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_utilizaciones, container, false);

        listViewUtilizacionesAdapter = (ListView) view.findViewById(R.id.lstUtilizaciones);

        lstUtilizacionesDTO = OpcionesSecundariasFragment.lstUtilizaciones;

        utilizacionesAdapter = new UtilizacionesAdapter(view.getContext(), lstUtilizacionesDTO);
        listViewUtilizacionesAdapter.setAdapter(utilizacionesAdapter);

        listViewUtilizacionesAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                try {

                    if(utilizacionesSeleccionado == null){
                        utilizacionesSeleccionado = new UtilizacionesDTO();
                    }

                    utilizacionesSeleccionado = lstUtilizacionesDTO.get(i);


                    String params = "/SAC/ABCD1234/"+ ConsultaSolicitudAtencionView.solicitudAtencionSeleccionada.getNumeroSolicitud() +"/"+utilizacionesSeleccionado.getConsConvenio()+"/"+(utilizacionesSeleccionado.getDesdeTexto().replaceAll("/","-"))+"/"+utilizacionesSeleccionado.getHastaTexto().replaceAll("/","-");
                    if (consultarDetalleUtlizaciones(getActivity().getResources().getString(R.string.complement_utilizaciones_detalle), params)){

                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        Fragment fragment = new DetalleUtilizacionesFragment();
                        fragment.setArguments(getActivity().getIntent().getExtras());
                        ft.replace(R.id.fragment_container_utilizaciones, fragment, "DetalleUtilizacionesFragment").addToBackStack("DetalleUtilizacionesFragment").commit();

                    }else {
                        throw new Exception(getActivity().getResources().getString(R.string.lbl_sin_resultados));
                    }



                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

    private boolean consultarDetalleUtlizaciones(String serviceName, String listParams){

        boolean respuesta = false;

        try {

            ConexionServicioListaTask task = new ConexionServicioListaTask(getActivity(), serviceName, listParams);

            synchronized (task) {
                task.execute().wait();
            }

            if (ConexionServicioListaTask.respJSON !=null){
                respuesta = true;
                JSONObject obj = ConexionServicioListaTask.respJSON;

                ///////////////////////////////////////////////////////////////////////////////
                JSONArray jsonArrayUtilizaciones = obj.optJSONArray("utilizaciones");

                lstDetalleUtilizacionesDTO = new ArrayList<DetalleUtilizacionesDTO>();


                for (int x = 0; x < jsonArrayUtilizaciones.length(); x++) {
                    JSONObject utilizaciones = jsonArrayUtilizaciones.getJSONObject(x);

                    String tipoSeguro = (utilizaciones.getString("tipoSeguro") != null && !utilizaciones.getString("tipoSeguro").equals("null")) ? utilizaciones.getString("tipoSeguro"):"";
                    String seguroNumero = (utilizaciones.getString("seguroNumero") != null && !utilizaciones.getString("seguroNumero").equals("null")) ? utilizaciones.getString("seguroNumero"):"";
                    String prestador = (utilizaciones.getString("prestador") != null && !utilizaciones.getString("prestador").equals("null")) ? utilizaciones.getString("prestador"):"";
                    String concepto = (utilizaciones.getString("concepto") != null && !utilizaciones.getString("concepto").equals("null")) ? utilizaciones.getString("concepto"):"";
                    String total = (utilizaciones.getString("total") != null && !utilizaciones.getString("total").equals("null")) ? utilizaciones.getString("total"):"";
                    String totalGlosa = (utilizaciones.getString("totalGlosa") != null && !utilizaciones.getString("totalGlosa").equals("null")) ? utilizaciones.getString("totalGlosa"):"";
                    String fechaCreado = (utilizaciones.getString("fechaCreado") != null && !utilizaciones.getString("fechaCreado").equals("null")) ? utilizaciones.getString("fechaCreado"):"";

                    DetalleUtilizacionesDTO utilizacionesDTO = new DetalleUtilizacionesDTO(tipoSeguro,seguroNumero,prestador,concepto,
                            total,totalGlosa,fechaCreado);
                    lstDetalleUtilizacionesDTO.add(utilizacionesDTO);
                }

                ///////////////////////////////////////////////////////////////////////////////


                JSONArray jsonArrayAdministraciones = obj.optJSONArray("administraciones");
                lstAdministraciones = new ArrayList<AdministracionesDTO>();



                for (int x = 0; x < jsonArrayAdministraciones.length(); x++) {
                    JSONObject administracion = jsonArrayAdministraciones.getJSONObject(x);

                    String total = (administracion.getString("total") != null && !administracion.getString("total").equals("null")) ? administracion.getString("total"):"";
                    String trm = (administracion.getString("trm") != null && !administracion.getString("trm").equals("null")) ? administracion.getString("trm"):"";
                    String subtotal = (administracion.getString("subtotal") != null && !administracion.getString("subtotal").equals("null")) ? administracion.getString("subtotal"):"";
                    String porcentaje = (administracion.getString("porcentaje") != null && !administracion.getString("porcentaje").equals("null")) ? administracion.getString("porcentaje"):"";
                    String valorIva = (administracion.getString("valorIva") != null && !administracion.getString("valorIva").equals("null")) ? administracion.getString("valorIva"):"";
                    String fechaCreado = (administracion.getString("fechaCreado") != null && !administracion.getString("fechaCreado").equals("null")) ? administracion.getString("fechaCreado"):"";

                    AdministracionesDTO administracionesDTO = new AdministracionesDTO(total,trm,subtotal,porcentaje+"%",Utilities.formatearNumeroTexto(valorIva),fechaCreado);

                    lstAdministraciones.add(administracionesDTO);
                }

            }

        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }
}
