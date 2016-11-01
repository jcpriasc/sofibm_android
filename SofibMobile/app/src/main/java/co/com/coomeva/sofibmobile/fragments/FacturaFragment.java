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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.FacturaAdapter;
import co.com.coomeva.sofibmobile.adapters.NotaCreditoGiroAdapter;
import co.com.coomeva.sofibmobile.dto.FacturaDTO;
import co.com.coomeva.sofibmobile.dto.NotaCreditoGiroDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class FacturaFragment extends Fragment{

    private FacturaAdapter facturaAdapter;
    private ListView listViewFacturaAdapter;
    private List<FacturaDTO> lstFacturaDTO = new ArrayList<FacturaDTO>();
    public static FacturaDTO facturaSeleccionado = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_factura, container, false);

        listViewFacturaAdapter = (ListView) view.findViewById(R.id.lstFactura);

        lstFacturaDTO = new ArrayList<>();
        lstFacturaDTO.addAll(OpcionesSecundariasFragment.lstFacturaDTO);

        facturaAdapter = new FacturaAdapter(view.getContext(), lstFacturaDTO);
        listViewFacturaAdapter.setAdapter(facturaAdapter);

        listViewFacturaAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                try {

                    if(facturaSeleccionado == null){
                        facturaSeleccionado = new FacturaDTO();
                    }

                    facturaSeleccionado = lstFacturaDTO.get(i);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleFacturaFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_factura, fragment, "DetalleFacturaFragment").addToBackStack("DetalleFacturaFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
    
}
