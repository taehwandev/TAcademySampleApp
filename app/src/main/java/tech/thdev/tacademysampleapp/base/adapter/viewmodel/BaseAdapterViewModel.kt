package tech.thdev.tacademysampleapp.base.adapter.viewmodel

import tech.thdev.tacademysampleapp.base.adapter.data.source.AdapterRepositoryInterface

abstract class BaseAdapterViewModel(val adapterRepository: AdapterRepositoryInterface) {

    lateinit var notifyDataSetChanged: () -> Unit

    lateinit var notifyItemChanged: (position: Int) -> Unit
}