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
import co.com.coomeva.sofibmobile.adapters.NotaCreditoDebitoAdapter;
import co.com.coomeva.sofibmobile.dto.FacturaDTO;
import co.com.coomeva.sofibmobile.dto.NotaCreditoDebitoDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class NotaCreditoDebitoFragment extends Fragment{

    private NotaCreditoDebitoAdapter notaCreditoDebitoAdapter;
    private ListView listViewNotaCreditoAdapter;
    private List<NotaCreditoDebitoDTO> lstNotaCreditoDebitoDTO = new ArrayList<NotaCreditoDebitoDTO>();
    public static NotaCreditoDebitoDTO notaCreditoDebitoSeleccionado = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nota_credito_debito, container, false);

        listViewNotaCreditoAdapter = (ListView) view.findViewById(R.id.lstNotaCreditoDebito);
        lstNotaCreditoDebitoDTO = OpcionesSecundariasFragment.lstNotaCreditoDebito;

        notaCreditoDebitoAdapter = new NotaCreditoDebitoAdapter(view.getContext(), lstNotaCreditoDebitoDTO);
        listViewNotaCreditoAdapter.setAdapter(notaCreditoDebitoAdapter);

        listViewNotaCreditoAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                try {

                    if(notaCreditoDebitoSeleccionado == null){
                        notaCreditoDebitoSeleccionado = new NotaCreditoDebitoDTO();
                    }

                    notaCreditoDebitoSeleccionado = lstNotaCreditoDebitoDTO.get(i);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleNotaCreditoDebitoFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_nota_credito_debito, fragment, "DetalleNotaCreditoDebitoFragment").addToBackStack("DetalleNotaCreditoDebitoFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}
