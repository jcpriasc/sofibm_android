package co.com.coomeva.sofibmobile.adapters;

/**
 * Created by cesarlopez on 30/09/16.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import co.com.coomeva.sofibmobile.fragments.InformesMedicosGeneralFragment;
import co.com.coomeva.sofibmobile.fragments.MedicinaFragment;
import co.com.coomeva.sofibmobile.fragments.ProcedimientosFragment;
import co.com.coomeva.sofibmobile.fragments.TabFacturaGlosaFragment;
import co.com.coomeva.sofibmobile.fragments.TabFacturaImpuestoFragment;
import co.com.coomeva.sofibmobile.fragments.TabFacturaInformacionFragment;

public class PagerInformesMedicosAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerInformesMedicosAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                InformesMedicosGeneralFragment informesMedicosGeneralFragment = new InformesMedicosGeneralFragment();
                return informesMedicosGeneralFragment;
            case 1:
                ProcedimientosFragment procedimientosFragment = new ProcedimientosFragment();
                return procedimientosFragment;
            case 2:
                MedicinaFragment medicinaFragment = new MedicinaFragment();
                return medicinaFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
