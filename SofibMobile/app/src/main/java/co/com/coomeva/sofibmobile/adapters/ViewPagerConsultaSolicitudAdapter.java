package co.com.coomeva.sofibmobile.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerConsultaSolicitudAdapter extends FragmentStatePagerAdapter {

    private CharSequence titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    private int numeroTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    public ViewPagerConsultaSolicitudAdapter(FragmentManager fm, CharSequence[] titles, int numeroTabs) {
        super(fm);
        this.titles = titles;
        this.numeroTabs = numeroTabs;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
//            ConsultaRotacionesFechaFragment consultaRotacionesFechaFragment = new ConsultaRotacionesFechaFragment();
            return null;
        }
        else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
//            ConsultaRotacionesTarjetaFragment tab2 = new ConsultaRotacionesTarjetaFragment();
            return null;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return numeroTabs;
    }
}