package tech.thdev.tacademysampleapp.data

import com.google.gson.annotations.SerializedName

data class GithubUser(
        @field:SerializedName("login") val login: String,
        @field:SerializedName("id") val id: Int,
        @field:SerializedName("avatar_url") val avatarUrl: String,
        @field:SerializedName("score") val score: Double)