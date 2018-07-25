package tech.thdev.tacademysampleapp.view.main.search.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import tech.thdev.tacademysampleapp.base.adapter.BaseRecyclerViewAdapter;
import tech.thdev.tacademysampleapp.base.adapter.data.source.AdapterRepository;
import tech.thdev.tacademysampleapp.base.adapter.holder.AndroidViewHolder;
import tech.thdev.tacademysampleapp.base.adapter.holder.BaseViewHolder;
import tech.thdev.tacademysampleapp.base.adapter.viewmodel.BaseAdapterViewModel;
import tech.thdev.tacademysampleapp.view.main.search.adapter.holder.SearchViewHolder;
import tech.thdev.tacademysampleapp.view.main.search.adapter.viewmodel.SearchAdapterViewModel;

public class SearchRecyclerAdapter extends BaseRecyclerViewAdapter<SearchAdapterViewModel> {

    public SearchRecyclerAdapter() {
        super(new SearchAdapterViewModel(new AdapterRepository()));
    }

    @Override
    protected AndroidViewHolder createViewHolder(int viewType, @NonNull ViewGroup parent) {
        return new SearchViewHolder(parent);
    }
}
