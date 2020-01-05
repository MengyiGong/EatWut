package com.example.eatwut.ui.main

import androidx.lifecycle.ViewModel
import com.example.eatwut.bean.FavoriteNamesBean
import com.example.eatwut.bean.favoriteNames

class MainViewModel : ViewModel() {
    fun addFavoriteNames() {
        favoriteNames.add(FavoriteNamesBean(0, "Wut the Pho", 5L))
        favoriteNames.add(FavoriteNamesBean(1, "Coco", 5L))
        favoriteNames.add(FavoriteNamesBean(2, "Chick fil-a", 3L))
        favoriteNames.add(FavoriteNamesBean(3, "Qian", 5L))
        favoriteNames.add(FavoriteNamesBean(4, "国子监", 4L))
        favoriteNames.add(FavoriteNamesBean(5, "小吃街", 2L))
        favoriteNames.add(FavoriteNamesBean(6, "沸腾鱼", 1L))
        favoriteNames.add(FavoriteNamesBean(7, "香锅大王", 3L))
        favoriteNames.add(FavoriteNamesBean(8, "锦绣成都", 4L))
        favoriteNames.add(FavoriteNamesBean(6, "云麓", 4L))
        favoriteNames.add(FavoriteNamesBean(7, "thai", 4L))
        favoriteNames.add(FavoriteNamesBean(8, "Chongqing", 5L))
    }

    private fun getRandomName() = (0..getTotalLevel()).random()

    private fun getTotalLevel(): Int {
        var totalLevel = 0
        favoriteNames.forEach {
            totalLevel += it.level.toInt()
        }
        return totalLevel
    }

    fun getName(): String {
        var helper = getRandomName()
        var i = 0
        do {
            helper -= favoriteNames[i].level.toInt()
            i++
        } while (i < favoriteNames.size && helper > 0)

        return favoriteNames[i - 1].name
    }
}
