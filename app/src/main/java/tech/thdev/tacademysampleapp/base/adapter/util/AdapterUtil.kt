package tech.thdev.tacademysampleapp.base.adapter.util

inline fun <reified T: Any> Any?.cast(): T? = this as? T