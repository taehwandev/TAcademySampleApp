package tech.thdev.tacademysampleapp.view.main.search.adapter.holder;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import tech.thdev.tacademysampleapp.R;
import tech.thdev.tacademysampleapp.base.adapter.holder.BaseViewHolder;
import tech.thdev.tacademysampleapp.view.main.search.adapter.viewmodel.SearchAdapterViewModel;

public class SearchViewHolder extends BaseViewHolder<Object, SearchAdapterViewModel> {

    private final ViewDataBinding binding;

    public SearchViewHolder(@NotNull ViewDataBinding binding, @NotNull ViewGroup parent, @NotNull Context context) {
        super(R.layout.item_repository_view, parent, context);
        this.binding = binding;
    }

    @Override
    public void onInitViewModel(@NotNull SearchAdapterViewModel $receiver) {

    }

    @Override
    public void onBindViewHolder(@Nullable Object o) {

    }
}
