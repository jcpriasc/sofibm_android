package co.com.coomeva.sofibmobile.fragments;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import co.com.coomeva.sofibmobile.R;
import co.com.coomeva.sofibmobile.adapters.PagerAdapter;

/**
 * Created by JuanCamilo on 9/25/16.
 */
public class DetalleUtilizacionesFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_utlizaciones, container, false);

        try {
           // Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
           // ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_tab_utilizaciones)));
//            tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.lbl_tab_administraciones)));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.utilizaciones));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.admin));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
            final PagerAdapter adapter = new PagerAdapter(getFragmentManager(), tabLayout.getTabCount());

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

        }catch (Exception e){
            System.out.print(e.getMessage());
        }

        return view;
    }

}
