package tech.thdev.tacademysampleapp.view.main.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import tech.thdev.tacademysampleapp.view.main.search.SearchFragment;
import tech.thdev.tacademysampleapp.view.main.user.UserFragment;

public class GithubViewPager extends FragmentPagerAdapter {

    private static final int VIEW_TYPE_REPOSITORIES_SEARCH = 0;
    private static final int VIEW_TYPE_USER_SEARCH = 1;

    public GithubViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case VIEW_TYPE_REPOSITORIES_SEARCH:
                return new SearchFragment();
            case VIEW_TYPE_USER_SEARCH:
                return new UserFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
