package co.com.coomeva.sofibmobile.adapters;

/**
 * Created by cesarlopez on 30/09/16.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import co.com.coomeva.sofibmobile.fragments.TabGiroConceptosFragment;
import co.com.coomeva.sofibmobile.fragments.TabGiroHistoricoFragment;
import co.com.coomeva.sofibmobile.fragments.TabGiroManutencionFragment;
import co.com.coomeva.sofibmobile.fragments.TabNotaCreditoDebitoImpuestoFragment;
import co.com.coomeva.sofibmobile.fragments.TabNotaCreditoDebitoInformacionFragment;
import co.com.coomeva.sofibmobile.fragments.TabNotaCreditoDebitoServicioFragment;

public class PagerNotaCreditoDebitoAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerNotaCreditoDebitoAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabNotaCreditoDebitoInformacionFragment notaCreditoDebitoInformacionFragment = new TabNotaCreditoDebitoInformacionFragment();
                return notaCreditoDebitoInformacionFragment;
            case 1:
                TabNotaCreditoDebitoImpuestoFragment impuestoFragment = new TabNotaCreditoDebitoImpuestoFragment();
                return impuestoFragment;
            case 2:
                TabNotaCreditoDebitoServicioFragment servicioFragment = new TabNotaCreditoDebitoServicioFragment();
                return servicioFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
