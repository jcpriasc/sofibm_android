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
import co.com.coomeva.sofibmobile.fragments.TabServicioNoAsistencialDocumentacionServicioFragment;
import co.com.coomeva.sofibmobile.fragments.TabServicioNoAsistencialServicioAdicionadoFragment;
import co.com.coomeva.sofibmobile.fragments.TabServicioProveedorServicioNoAsistencialFragment;

public class PagerGiroAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerGiroAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabGiroManutencionFragment manutencionFragment = new TabGiroManutencionFragment();
                return manutencionFragment;
            case 1:
                TabGiroConceptosFragment conceptosFragment = new TabGiroConceptosFragment();
                return conceptosFragment;
            case 2:
                TabGiroHistoricoFragment historicoFragment = new TabGiroHistoricoFragment();
                return historicoFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
