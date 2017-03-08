package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.PagerDetalleSolicitudAprobacionAdapter;
import co.com.coomeva.sofibmobile.adapters.PagerFacturaAdapter;
import co.com.coomeva.sofibmobile.dto.DetalleFacturaDTO;
import co.com.coomeva.sofibmobile.dto.DetalleSolicitudAprobacionDTO;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class TabSolicitudAprobacionFragment extends Fragment{

    public static DetalleSolicitudAprobacionDTO detalleSolicitudAprobacionDTO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_solicitud_aprobacion, container, false);

        try {
           // Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
           // ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_informacion_general)));
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_datos_basicos_paciente)));
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_tipo_aprobacion)));

            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.info_general));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.datosbasicos));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.tipo_aprobacion));

            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
            final PagerDetalleSolicitudAprobacionAdapter adapter = new PagerDetalleSolicitudAprobacionAdapter(getFragmentManager(), tabLayout.getTabCount());

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

            detalleSolicitudAprobacionDTO = DetalleSolicitudAprobacionFragment.detalleSolicitudAprobacionSeleccionada;


        }catch (Exception e){
            System.out.print(e.getMessage());
        }

        return view;
    }

}
