package tech.thdev.tacademysampleapp.view.main.search.adapter.viewmodel

import tech.thdev.tacademysampleapp.base.adapter.data.source.AdapterRepositoryInterface
import tech.thdev.tacademysampleapp.base.adapter.viewmodel.BaseAdapterViewModel

class SearchAdapterViewModel(adapterRepository: AdapterRepositoryInterface) : BaseAdapterViewModel(adapterRepository) {

    interface OnClickListener {
        fun onClick()
    }

    lateinit var onClickItem: (adapterPosition: Int) -> Unit
}