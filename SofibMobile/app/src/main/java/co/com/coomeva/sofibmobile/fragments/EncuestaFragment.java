package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.EncuestaAdapter;
import co.com.coomeva.sofibmobile.adapters.UtilizacionesAdapter;
import co.com.coomeva.sofibmobile.dto.EncuestaDTO;
import co.com.coomeva.sofibmobile.dto.UtilizacionesDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class EncuestaFragment extends Fragment{

    private EncuestaAdapter encuestaAdapter;
    private ListView listViewEncuestaAdapter;
    private List<EncuestaDTO> lstEncuestaDTO = new ArrayList<EncuestaDTO>();
    public static EncuestaDTO encuestaSeleccionado = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_encuesta, container, false);

        listViewEncuestaAdapter = (ListView) view.findViewById(R.id.lstEncuesta);

        if(lstEncuestaDTO == null){
            lstEncuestaDTO = new ArrayList<EncuestaDTO>();
        }else{
            lstEncuestaDTO.clear();
        }

        lstEncuestaDTO = OpcionesSecundariasFragment.lstEncuesta;
        encuestaAdapter = new EncuestaAdapter(view.getContext(), lstEncuestaDTO);
        listViewEncuestaAdapter.setAdapter(encuestaAdapter);

        listViewEncuestaAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                try {

                    if(encuestaSeleccionado == null){
                        encuestaSeleccionado = new EncuestaDTO();
                    }
                    encuestaSeleccionado = lstEncuestaDTO.get(i);

//                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                    Fragment fragment = new DetalleNotaCreditoGiroFragment();
//                    fragment.setArguments(getActivity().getIntent().getExtras());
//                    ft.replace(R.id.fragment_container_nota_credito_giro, fragment, "DetalleNotaCreditoGiroFragment").addToBackStack("DetalleNotaCreditoGiroFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}
