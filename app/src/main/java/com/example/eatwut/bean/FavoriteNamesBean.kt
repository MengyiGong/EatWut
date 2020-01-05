package com.example.eatwut.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteNamesBean (
    var id: Int = 0,
    var name: String = "",
    var level: Long = 5L
): Parcelable

val favoriteNames: MutableList<FavoriteNamesBean> = mutableListOf()