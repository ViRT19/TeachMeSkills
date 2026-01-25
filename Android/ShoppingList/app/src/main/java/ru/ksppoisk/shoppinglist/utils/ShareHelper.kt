package ru.ksppoisk.shoppinglist.utils

import android.content.Intent
import androidx.compose.ui.res.stringResource
import ru.ksppoisk.shoppinglist.entities.ShopListItem

object ShareHelper {
    fun shareShopList(shopList: List<ShopListItem>, listName: String): Intent {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plane"
        intent.apply {
            putExtra(Intent.EXTRA_TEXT, makeShareText(shopList, listName))
        }
        return intent
    }

    private fun makeShareText(shopList: List<ShopListItem>, listName: String): String {
        val sBuilder = StringBuilder()
        sBuilder.append("––«$listName»––")
        sBuilder.append("\n")
        var counter = 0
        var sInfo: String
        var checkIt: String
        shopList.forEach {
            if (it.itemInfo.isNotEmpty()) sInfo = "(${it.itemInfo}) " else sInfo = ""
            if (it.itemChecked) {
                checkIt = PURCHASED
                sBuilder.append("[${++counter}]. ${it.name} $sInfo")
            } else {
                checkIt = NEED_TO_BUY
                sBuilder.append(" ${++counter}. ${it.name} $sInfo")
            }
            sBuilder.append("$checkIt\n")
        }
        return sBuilder.toString()
    }

    const val PURCHASED = " ... [X]"
    const val NEED_TO_BUY = ""
}