package eu.giovannidefranceso.effectivenotes.adapters;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import eu.giovannidefranceso.effectivenotes.fragments.BoardFragment;

/**
 * Created by jibbo on 26/07/15.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();
    private String[] mTitles;

    public SectionsPagerAdapter(Context ctx, @ArrayRes int titles, FragmentManager fm) {
        super(fm);
        mTitles = ctx.getResources().getStringArray(titles);
    }

    @Override
    public Fragment getItem(int position) {
        return BoardFragment.newInstance(mTitles[position]);
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

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getFragment(int position) {
        return registeredFragments.get(position);
    }


}