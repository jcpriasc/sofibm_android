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
import co.com.coomeva.sofibmobile.adapters.GiroAdapter;
import co.com.coomeva.sofibmobile.adapters.NotaCreditoGiroAdapter;
import co.com.coomeva.sofibmobile.dto.GirosDTO;
import co.com.coomeva.sofibmobile.dto.NotaCreditoGiroDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class NotaCreditoGiroFragment extends Fragment{

    private NotaCreditoGiroAdapter notaCreditoGiroAdapter;
    private ListView listViewNotaCreditoGiroAdapter;
    private List<NotaCreditoGiroDTO> lstNotaCreditoGiroDTO = new ArrayList<NotaCreditoGiroDTO>();
    public static NotaCreditoGiroDTO notaCreditoGiroSeleccionado = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nota_credito_giro, container, false);

        listViewNotaCreditoGiroAdapter = (ListView) view.findViewById(R.id.lstNotaCreditoGiro);

        lstNotaCreditoGiroDTO = OpcionesSecundariasFragment.lstNotaCreditoGiro;

        notaCreditoGiroAdapter = new NotaCreditoGiroAdapter(view.getContext(), lstNotaCreditoGiroDTO);
        listViewNotaCreditoGiroAdapter.setAdapter(notaCreditoGiroAdapter);

        listViewNotaCreditoGiroAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                try {

                    notaCreditoGiroSeleccionado = lstNotaCreditoGiroDTO.get(i);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new DetalleNotaCreditoGiroFragment();
                    fragment.setArguments(getActivity().getIntent().getExtras());
                    ft.replace(R.id.fragment_container_nota_credito_giro, fragment, "DetalleNotaCreditoGiroFragment").addToBackStack("DetalleNotaCreditoGiroFragment").commit();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}
