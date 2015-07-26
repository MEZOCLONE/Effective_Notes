package eu.giovannidefranceso.effectivenotes.adapters;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

import eu.giovannidefranceso.effectivenotes.R;
import eu.giovannidefranceso.effectivenotes.fragments.BoardFragment;

/**
 * Created by jibbo on 26/07/15.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public SectionsPagerAdapter(Context ctx, @ArrayRes int titles, FragmentManager fm) {
        super(fm);
        mTitles = ctx.getResources().getStringArray(titles);
    }

    @Override
    public Fragment getItem(int position) {
        return new BoardFragment();
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        //TODO
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}