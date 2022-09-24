package com.example.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.DeleteShopItemUseCase
import com.example.shoppinglist.domain.EditShopItemUseCase
import com.example.shoppinglist.domain.GetShopListUseCase
import com.example.shoppinglist.domain.ShopItem

class MainViewModel:ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopListUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopListUseCase.editShopItem(newItem)
    }
}

/*
* Здесь ошибка клина. Presentation слой зависит от Domain слоя
* Так как Domain слой это слой где хранится бизнес логика
* То Presentation слой знает всё об этом слое
* Data слой так же знает всё о Domain слое
* Но при этом ViewModel стала зависить от Data слоя. То есть в Presentation слой попал класс из Data слоя
* Data и Presentation не должны знать друг о друге ничего
* Поэтому как в Data слое не должно быть упомининий о Presentation, так и наоборот
* */