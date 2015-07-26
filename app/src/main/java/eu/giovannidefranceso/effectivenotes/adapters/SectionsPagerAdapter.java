package eu.giovannidefranceso.effectivenotes.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

import eu.giovannidefranceso.effectivenotes.R;

/**
 * Created by jibbo on 26/07/15.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //TODO
        return new Fragment();
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        //TODO
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //TODO
        return ""+position;
    }
}