package com.example.demo.service.product.arguments

import com.example.demo.model.Category

public class CreateProductArgument (
    var title: String?,
    var price: Long?,
    var category: Category? = null
)
{
    data class Builder(
        var title: String? = null,
        var price: Long? = null,
        var category: Category? = null
    )
    {

        fun title(title: String?) = apply { this.title = title }
        fun price(price: Long?) = apply { this.price = price }
        fun category(category: Category?) = apply { this.category = category }
        fun build() = CreateProductArgument(title, price, category)
    }
}