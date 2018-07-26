package tech.thdev.tacademysampleapp.view.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import kotlin.jvm.functions.Function0;
import tech.thdev.tacademysampleapp.R;
import tech.thdev.tacademysampleapp.util.LifecycleExtensionsUtilKt;
import tech.thdev.tacademysampleapp.view.main.pager.GithubViewPager;
import tech.thdev.tacademysampleapp.view.main.viewmodel.UserSearchViewModel;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private GithubViewPager githubViewPager;

    private UserSearchViewModel userSearchViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        userSearchViewModel = LifecycleExtensionsUtilKt.inject(UserSearchViewModel.class, this, "", new Function0<UserSearchViewModel>() {
            @Override
            public UserSearchViewModel invoke() {
                return new UserSearchViewModel();
            }
        });

        githubViewPager = new GithubViewPager(getSupportFragmentManager());

        viewPager.setAdapter(githubViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_icon_made_by, menu);
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(this.getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userSearchViewModel.updateSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                userSearchViewModel.updateSearch("");
                return false;
            }
        });
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_icon_made_by:
                showChromeTabs();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showChromeTabs() {
        // Use a CustomTabsIntent.Builder to configure CustomTabsIntent.
        // Once ready, call CustomTabsIntent.Builder.build() to create a CustomTabsIntent
        // and launch the desired Url with CustomTabsIntent.launchUrl()
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        // Changes the background color for the omnibox. colorInt is an int
        // that specifies a Color.
        builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));

        builder.setStartAnimations(this, 0, 0);
        builder.setExitAnimations(this, 0, 0);

        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse("https://www.flaticon.com/"));
    }
}
