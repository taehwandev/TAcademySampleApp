package tech.thdev.tacademysampleapp.view.main.user.adapter.viewmodel;

import org.jetbrains.annotations.NotNull;

import tech.thdev.tacademysampleapp.base.adapter.data.source.AdapterRepositoryInterface;
import tech.thdev.tacademysampleapp.base.adapter.viewmodel.BaseAdapterViewModel;

public class UserAdapterViewModel extends BaseAdapterViewModel {

    public static final int VIEW_TYPE_USER = 0;

    public UserAdapterViewModel(@NotNull AdapterRepositoryInterface adapterRepository) {
        super(adapterRepository);
    }
}
