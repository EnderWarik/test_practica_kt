package com.example.demo.action

import com.example.demo.action.argument.UpdateProductActionArgument
import com.example.demo.model.Product
import com.example.demo.service.product.ProductService
import com.example.demo.service.product.arguments.UpdateProductArgument
import com.example.demo.service.category.CategoryService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import java.util.*

@Component
@RequiredArgsConstructor
 class UpdateProductAction(val productService: ProductService,
                           val categoryService: CategoryService
) {

    fun execute(id: UUID,argument: UpdateProductActionArgument): Product {

        val category = argument.categoryId?.let { categoryService.getExisting(it) }
        return productService.update(
            id,
            UpdateProductArgument.Builder()
                .price(argument.price)
                .title(argument.title)
                .category(category)
                .build()
        )
    }
}