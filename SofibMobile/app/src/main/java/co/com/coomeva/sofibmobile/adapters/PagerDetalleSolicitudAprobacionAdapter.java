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
import co.com.coomeva.sofibmobile.fragments.TabSolicitudAprobacionDatosPacienteFragment;
import co.com.coomeva.sofibmobile.fragments.TabSolicitudAprobacionInformacionGeneralFragment;
import co.com.coomeva.sofibmobile.fragments.TabSolicitudAprobacionTipoAprobacionFragment;

public class PagerDetalleSolicitudAprobacionAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerDetalleSolicitudAprobacionAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabSolicitudAprobacionInformacionGeneralFragment informacionGeneralFragment = new TabSolicitudAprobacionInformacionGeneralFragment();
                return informacionGeneralFragment;
            case 1:
                TabSolicitudAprobacionDatosPacienteFragment datosPacienteFragment = new TabSolicitudAprobacionDatosPacienteFragment();
                return datosPacienteFragment;
            case 2:
                TabSolicitudAprobacionTipoAprobacionFragment solicitudAprobacionTipoAprobacionFragment = new TabSolicitudAprobacionTipoAprobacionFragment();
                return solicitudAprobacionTipoAprobacionFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
