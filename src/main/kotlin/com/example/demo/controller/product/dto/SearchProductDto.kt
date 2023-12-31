package com.example.demo.controller.product.dto


class SearchProductDto(
    val productTitle: String?,
    val categoryTitle: String?,
) {

    data class Builder(
        var productTitle: String?=null,
        var categoryTitle: String? = null,
) {

        fun productTitle(productTitle: String?)= apply { this.productTitle = productTitle }
        fun categoryTitle(categoryTitle: String?) = apply { this.categoryTitle = categoryTitle }

        fun build() = SearchProductDto(productTitle, categoryTitle)
    }
}