package co.com.coomeva.sofibmobile.adapters;

/**
 * Created by cesarlopez on 30/09/16.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import co.com.coomeva.sofibmobile.fragments.TabFacturaGlosaFragment;
import co.com.coomeva.sofibmobile.fragments.TabFacturaImpuestoFragment;
import co.com.coomeva.sofibmobile.fragments.TabFacturaInformacionFragment;
import co.com.coomeva.sofibmobile.fragments.TabGiroConceptosFragment;
import co.com.coomeva.sofibmobile.fragments.TabGiroHistoricoFragment;
import co.com.coomeva.sofibmobile.fragments.TabGiroManutencionFragment;

public class PagerFacturaAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerFacturaAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFacturaInformacionFragment facturaInformacionFragment = new TabFacturaInformacionFragment();
                return facturaInformacionFragment;
            case 1:
                TabFacturaGlosaFragment glosaFragment = new TabFacturaGlosaFragment();
                return glosaFragment;
            case 2:
                TabFacturaImpuestoFragment facturaImpuestoFragment = new TabFacturaImpuestoFragment();
                return facturaImpuestoFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
