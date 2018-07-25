package tech.thdev.tacademysampleapp.view.main.search.adapter.holder;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import tech.thdev.tacademysampleapp.R;
import tech.thdev.tacademysampleapp.base.adapter.holder.BaseViewHolder;
import tech.thdev.tacademysampleapp.data.RepositoriesItem;
import tech.thdev.tacademysampleapp.databinding.ItemRepositoryViewBinding;
import tech.thdev.tacademysampleapp.view.main.search.adapter.holder.viewmodel.SearchHolderViewModel;
import tech.thdev.tacademysampleapp.view.main.search.adapter.viewmodel.SearchAdapterViewModel;

public class SearchViewHolder extends BaseViewHolder<RepositoriesItem, SearchAdapterViewModel> implements SearchAdapterViewModel.OnClickListener {

    private ItemRepositoryViewBinding binding;

    public SearchViewHolder(@NotNull ViewGroup parent) {
        this(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_repository_view, parent, false));
    }

    public SearchViewHolder(@NotNull ItemRepositoryViewBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    @Override
    public void onClick() {
        getViewModel().getOnClickItem().invoke(getAdapterPosition());
    }

    @Override
    public void onInitViewModel(@NotNull SearchAdapterViewModel $receiver) {
    }

    @Override
    public void onBindViewHolder(@Nullable RepositoriesItem repositoriesItem) {
        binding.setViewModel(new SearchHolderViewModel(repositoriesItem, this));
    }
}
