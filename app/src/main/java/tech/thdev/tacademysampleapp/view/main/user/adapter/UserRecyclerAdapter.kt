package tech.thdev.tacademysampleapp.view.main.user.adapter

import android.view.ViewGroup
import tech.thdev.tacademysampleapp.base.adapter.BaseRecyclerViewAdapter
import tech.thdev.tacademysampleapp.base.adapter.data.source.AdapterRepository
import tech.thdev.tacademysampleapp.base.adapter.holder.BaseViewHolder
import tech.thdev.tacademysampleapp.view.main.user.adapter.holder.LoginViewHolder
import tech.thdev.tacademysampleapp.view.main.user.adapter.viewmodel.UserAdapterViewModel

class UserRecyclerAdapter : BaseRecyclerViewAdapter<UserAdapterViewModel>(UserAdapterViewModel(AdapterRepository())) {

    override fun createViewHolder(viewType: Int, parent: ViewGroup): BaseViewHolder<Any, UserAdapterViewModel> =
            when (viewType) {
                UserAdapterViewModel.VIEW_TYPE_USER -> LoginViewHolder(parent)
                else -> LoginViewHolder(parent)
            }
}