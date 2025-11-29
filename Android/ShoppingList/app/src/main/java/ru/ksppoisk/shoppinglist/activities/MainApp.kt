package ru.ksppoisk.shoppinglist.activities

import android.app.Application
import ru.ksppoisk.shoppinglist.db.MainDataBase

class MainApp : Application() {
    val database by lazy { MainDataBase.getDataBase(this) }
}