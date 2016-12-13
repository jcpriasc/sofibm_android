package co.com.coomeva.sofibmobile.fragments;

import android.content.Context;
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
import co.com.coomeva.sofibmobile.adapters.ServicioAsistencialAdapter;
import co.com.coomeva.sofibmobile.adapters.ServicioNoAsistencialAdapter;
import co.com.coomeva.sofibmobile.dto.DetalleServicioAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.ServicioAsistencialDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNoAsistencialDTO;
import co.com.coomeva.sofibmobile.task.ConexionServicioListaTask;
import co.com.coomeva.sofibmobile.task.ConexionServicioTask;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class ServicioAsistencialFragment extends Fragment{

    private ServicioAsistencialAdapter servicioAsistencialAdapter;
    private ListView listViewServicioAsistencialAdapter;
    private List<ServicioAsistencialDTO> lstServicioAsistencialDTO = new ArrayList<ServicioAsistencialDTO>();
    public static ServicioAsistencialDTO servicio = null;

    public static List<DetalleServicioAsistencialDTO> lstDetalleServicioAsistencialDTO = new ArrayList<DetalleServicioAsistencialDTO>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_servicio_asistencial, container, false);

        listViewServicioAsistencialAdapter = (ListView) view.findViewById(R.id.lstServicioAsistencial);


        lstServicioAsistencialDTO = OpcionesSecundariasFragment.lstServiciosAsistenciales;

        servicioAsistencialAdapter = new ServicioAsistencialAdapter(view.getContext(), lstServicioAsistencialDTO);
        listViewServicioAsistencialAdapter.setAdapter(servicioAsistencialAdapter);


        listViewServicioAsistencialAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {


                try {

                    if(servicio == null){
                        servicio = new ServicioAsistencialDTO();
                    }

                    servicio = lstServicioAsistencialDTO.get(i);

                    String params = "/SAC/ABCD1234/"+ servicio.getId();
                    consultarDetalleServicioAsistencial(getActivity().getResources().getString(R.string.complement_ServiciosAsistenciales_detalle),params,getActivity());

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleServiciosAsistencialesFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_servicio_asistencial, fragment, "DetalleServiciosAsistencialesFragment").addToBackStack("DetalleServiciosAsistencialesFragment").commit();



                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }


    public static  boolean consultarDetalleServicioAsistencial(String serviceName, String listParams, Context contexto) throws Exception{

        boolean respuesta = false;

        try {

            ConexionServicioListaTask task = new ConexionServicioListaTask(contexto, serviceName, listParams);

           // detalleGiroDTO = new DetalleGiroDTO();

            synchronized (task) {
                task.execute().wait();
            }

            if (ConexionServicioListaTask.respJSON !=null){
                respuesta = true;
                JSONObject obj = ConexionServicioListaTask.respJSON;

                ///////////////////////////////////////////////////////////////////////////////
                JSONArray jsonArrayDetalle = obj.optJSONArray("historico");

                lstDetalleServicioAsistencialDTO = new ArrayList<DetalleServicioAsistencialDTO>();

                for (int x = 0; x < jsonArrayDetalle.length(); x++) {
                    JSONObject manutencion = jsonArrayDetalle.getJSONObject(x);

                    String estado = (manutencion.getString("estado") != null && !manutencion.getString("estado").equals("null")) ? manutencion.getString("estado"):"";
                    String fecha = (manutencion.getString("fecha") != null && !manutencion.getString("fecha").equals("null")) ? manutencion.getString("fecha"):"";
                    DetalleServicioAsistencialDTO detalle = new DetalleServicioAsistencialDTO();
                    detalle.setEstado(estado);
                    detalle.setFecha(fecha);
                    lstDetalleServicioAsistencialDTO.add(detalle);
                }

            }

        }catch (Exception e){
            Toast.makeText(contexto,e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return respuesta ;
    }
}
