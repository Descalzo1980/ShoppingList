package com.example.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository){

    fun getShopItem(shopItemId: Int):ShopItem{ // принимает один id возвращает shop item
        return shopListRepository.getShopItem(shopItemId)
    }
}