package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.DetalleServiciosAdicionadosAdapter;
import co.com.coomeva.sofibmobile.adapters.DetalleUtilizacionesAdapter;
import co.com.coomeva.sofibmobile.dto.DetalleUtilizacionesDTO;
import co.com.coomeva.sofibmobile.dto.ServicioAdicionalDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabServicioNoAsistencialServicioAdicionadoFragment extends Fragment{

    private DetalleServiciosAdicionadosAdapter detalleServiciosAdicionadosAdapter;
    private ListView listViewDetalleTabServiciosAdicionadosAdapter;
    private final List<ServicioAdicionalDTO> lstServicioAdicional = new ArrayList<ServicioAdicionalDTO>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_servicio_no_asistencial_servicios_adicionados, container, false);

        listViewDetalleTabServiciosAdicionadosAdapter = (ListView) view.findViewById(R.id.lstServiciosAdicionados);

        detalleServiciosAdicionadosAdapter = new DetalleServiciosAdicionadosAdapter(view.getContext(), DetalleTabServicioNoAsistencialFragment.servicioSeleccionado.getLstServiciosAdicionales());
        listViewDetalleTabServiciosAdicionadosAdapter.setAdapter(detalleServiciosAdicionadosAdapter);

        return view;
    }
}
