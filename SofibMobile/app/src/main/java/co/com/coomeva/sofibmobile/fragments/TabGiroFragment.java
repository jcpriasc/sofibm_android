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
import co.com.coomeva.sofibmobile.adapters.PagerAdapter;
import co.com.coomeva.sofibmobile.adapters.PagerGiroAdapter;
import co.com.coomeva.sofibmobile.dto.ConceptosDTO;
import co.com.coomeva.sofibmobile.dto.DetalleGiroDTO;
import co.com.coomeva.sofibmobile.dto.HistoricoGirosDTO;
import co.com.coomeva.sofibmobile.dto.ManutencionDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabGiroFragment extends Fragment{

    public static DetalleGiroDTO giroSeleccionado;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_giro, container, false);

        try {
           // Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
           // ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_tab_manutencion)));
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_tab_conceptos)));
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_tab_historico)));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.manu));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.concepto));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.historico));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
            final PagerGiroAdapter adapter = new PagerGiroAdapter(getFragmentManager(), tabLayout.getTabCount());

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

            giroSeleccionado = DetalleGiroFragment.detalleGiroDTO;

        }catch (Exception e){
            System.out.print(e.getMessage());
        }

        return view;
    }

}
