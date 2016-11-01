package co.com.coomeva.sofibmobile.adapters;

/**
 * Created by cesarlopez on 30/09/16.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import co.com.coomeva.sofibmobile.fragments.DetalleTabUtilizacionesFragment;
import co.com.coomeva.sofibmobile.fragments.EncuestaFragment;
import co.com.coomeva.sofibmobile.fragments.GiroFragment;
import co.com.coomeva.sofibmobile.fragments.TabAdministracionesFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                DetalleTabUtilizacionesFragment detalleTabUtilizacionesFragment = new DetalleTabUtilizacionesFragment();
                return detalleTabUtilizacionesFragment;
            case 1:
                TabAdministracionesFragment tabAdministracionesFragment = new TabAdministracionesFragment();
                return tabAdministracionesFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
