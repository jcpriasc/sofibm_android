package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.PagerFacturaAdapter;
import co.com.coomeva.sofibmobile.adapters.PagerNotaCreditoDebitoAdapter;
import co.com.coomeva.sofibmobile.dto.DetalleFacturaDTO;
import co.com.coomeva.sofibmobile.dto.DetalleNotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.ImpuestoFacturaDTO;
import co.com.coomeva.sofibmobile.dto.ImpuestoNotaCreditoDebitoDTO;
import co.com.coomeva.sofibmobile.dto.InformacionFacturaDTO;
import co.com.coomeva.sofibmobile.dto.ServicioNotaCreditoDebitoDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabNotaCreditoDebitoFragment extends Fragment{

    public static DetalleNotaCreditoDebitoDTO notaCreditoDebitoSeleccionado;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_nota_credito_debito, container, false);

        try {
           // Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
           // ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_tab_nota_credito)));
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_tab_impuesto)));
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_servicio)));

            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.credito));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.impuesto));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.servicio));

            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
            final PagerNotaCreditoDebitoAdapter adapter = new PagerNotaCreditoDebitoAdapter(getFragmentManager(), tabLayout.getTabCount());

            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            notaCreditoDebitoSeleccionado = DetalleNotaCreditoDebitoFragment. detalleNotaCreditoDebitoDTO ;


        }catch (Exception e){
            System.out.print(e.getMessage());
        }

        return view;
    }

}
