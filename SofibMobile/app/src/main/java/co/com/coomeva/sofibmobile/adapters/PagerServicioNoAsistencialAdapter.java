package co.com.coomeva.sofibmobile.adapters;

/**
 * Created by cesarlopez on 30/09/16.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import co.com.coomeva.sofibmobile.fragments.DetalleTabUtilizacionesFragment;
import co.com.coomeva.sofibmobile.fragments.TabAdministracionesFragment;
import co.com.coomeva.sofibmobile.fragments.TabServicioNoAsistencialDocumentacionServicioFragment;
import co.com.coomeva.sofibmobile.fragments.TabServicioNoAsistencialServicioAdicionadoFragment;
import co.com.coomeva.sofibmobile.fragments.TabServicioProveedorServicioNoAsistencialFragment;

public class PagerServicioNoAsistencialAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerServicioNoAsistencialAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabServicioProveedorServicioNoAsistencialFragment proveedorServicioFragment = new TabServicioProveedorServicioNoAsistencialFragment();
                return proveedorServicioFragment;
            case 1:
                TabServicioNoAsistencialDocumentacionServicioFragment documentacionServicioFragment = new TabServicioNoAsistencialDocumentacionServicioFragment();
                return documentacionServicioFragment;
            case 2:
                TabServicioNoAsistencialServicioAdicionadoFragment servicioAdicionadoFragment = new TabServicioNoAsistencialServicioAdicionadoFragment();
                return servicioAdicionadoFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
