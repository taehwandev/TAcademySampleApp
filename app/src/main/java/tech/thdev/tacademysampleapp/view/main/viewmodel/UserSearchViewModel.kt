package tech.thdev.tacademysampleapp.view.main.viewmodel

import io.reactivex.subjects.BehaviorSubject
import tech.thdev.tacademysampleapp.base.viewmodel.BaseLifecycleViewModel

class UserSearchViewModel : BaseLifecycleViewModel() {

    val searchQuerySubject = BehaviorSubject.create<String>()

    fun updateSearch(query: String?) {
        query?.takeIf { it.isNotEmpty() }?.let {
            searchQuerySubject.onNext(it)
        }
    }
}