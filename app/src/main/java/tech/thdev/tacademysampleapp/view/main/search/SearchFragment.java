package tech.thdev.tacademysampleapp.view.main.search;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Group;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function0;
import tech.thdev.tacademysampleapp.R;
import tech.thdev.tacademysampleapp.data.source.repositories.SearchRepository;
import tech.thdev.tacademysampleapp.network.GithubAPI;
import tech.thdev.tacademysampleapp.util.LifecycleExtensionsUtilKt;
import tech.thdev.tacademysampleapp.view.main.search.adapter.SearchRecyclerAdapter;
import tech.thdev.tacademysampleapp.view.main.search.viewmodel.SearchViewModel;
import tech.thdev.tacademysampleapp.view.main.viewmodel.UserSearchViewModel;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;
    private UserSearchViewModel userSearchViewModel;
    private SearchRecyclerAdapter searchRecyclerAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.group_progress)
    Group groupProgress;

    @BindView(R.id.tv_message)
    TextView tvMessage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_default, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        searchRecyclerAdapter = new SearchRecyclerAdapter();

        searchViewModel = LifecycleExtensionsUtilKt.inject(SearchViewModel.class, this, "", new Function0<SearchViewModel>() {
            @Override
            public SearchViewModel invoke() {
                return new SearchViewModel(SearchRepository.getInstance(GithubAPI.getInstance().getGithubService()),
                        searchRecyclerAdapter.getViewModel());
            }
        });

        userSearchViewModel = LifecycleExtensionsUtilKt.inject(UserSearchViewModel.class, this, "", new Function0<UserSearchViewModel>() {
            @Override
            public UserSearchViewModel invoke() {
                return new UserSearchViewModel();
            }
        });

        initView();
        initViewModel();
    }

    private void initView() {
        recyclerView.setAdapter(searchRecyclerAdapter);
        setHasOptionsMenu(true);

        groupProgress.setVisibility(View.GONE);

        tvMessage.setVisibility(View.VISIBLE);
        tvMessage.setText(R.string.message_search_github_repository);
    }

    private void initViewModel() {
        searchViewModel.getDisposables().add(userSearchViewModel.getSearchQuerySubject()
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        searchViewModel.search(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
        searchViewModel.getDisposables().add(searchViewModel.showEmptyViewSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Toast.makeText(getContext(), R.string.message_empty_view, Toast.LENGTH_SHORT).show();
                        tvMessage.setVisibility(View.VISIBLE);
                        tvMessage.setText(R.string.message_empty_view);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));

        searchViewModel.getDisposables().add(searchViewModel.showDetailPageViewSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String url) throws Exception {
                        showChromeTabs(url);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));

        searchViewModel.getDisposables().add(searchViewModel.updateProgressSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) { // show progress
                            groupProgress.setVisibility(View.VISIBLE);
                        } else {
                            groupProgress.setVisibility(View.GONE);
                        }
                    }
                }));
    }

    private void showChromeTabs(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
        builder.setStartAnimations(requireContext(), 0, 0);
        builder.setExitAnimations(requireContext(), 0, 0);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(requireContext(), Uri.parse(url));
    }
}
