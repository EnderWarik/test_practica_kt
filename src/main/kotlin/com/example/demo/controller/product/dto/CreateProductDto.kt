package com.example.demo.controller.product.dto

import java.util.*


class CreateProductDto(
    val title: String?,
    val price: Long?,
    val categoryId: UUID?,
    val cardId: UUID?
) {

    data class Builder(
        var title: String? = null,
        var price: Long?= null,
        var categoryId: UUID?,
        var cardId: UUID?) {

        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun categoryId(categoryId: UUID?) = apply { this.categoryId = categoryId }
        fun cardId(cardId: UUID?) = apply { this.cardId = cardId }
        fun build() = CreateProductDto(title, price,categoryId,cardId)
    }
}