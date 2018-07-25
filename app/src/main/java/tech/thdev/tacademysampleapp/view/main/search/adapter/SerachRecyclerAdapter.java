package tech.thdev.tacademysampleapp.view.main.search.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import tech.thdev.tacademysampleapp.base.adapter.BaseRecyclerViewAdapter;
import tech.thdev.tacademysampleapp.base.adapter.data.source.AdapterRepository;
import tech.thdev.tacademysampleapp.base.adapter.holder.BaseViewHolder;
import tech.thdev.tacademysampleapp.view.main.search.adapter.viewmodel.SearchAdapterViewModel;

public class SerachRecyclerAdapter extends BaseRecyclerViewAdapter<SearchAdapterViewModel> {

    public SerachRecyclerAdapter(@NonNull SearchAdapterViewModel viewModel) {
        super(new SearchAdapterViewModel(new AdapterRepository()));
    }

    @Override
    protected BaseViewHolder<Object, SearchAdapterViewModel> createViewHolder(int viewType, @NonNull ViewGroup parent) {
        return ;
    }
}
