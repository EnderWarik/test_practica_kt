package com.example.demo.controller

import com.example.demo.action.CreateProductAction
import com.example.demo.action.UpdateProductAction
import com.example.demo.action.argument.CreateProductActionArgument
import com.example.demo.action.argument.UpdateProductActionArgument
import com.example.demo.controller.dto.CreateProductDto
import com.example.demo.controller.dto.ProductDto
import com.example.demo.controller.dto.UpdateProductDto
import com.example.demo.service.implementation.ProductService
import com.example.demo.service.argument.UpdateProductArgument
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors


@RestController
@RequiredArgsConstructor
@RequestMapping("product")
class ProductController(
    private val productService: ProductService,
    private val createProductAction: CreateProductAction,
    private val updateProductAction: UpdateProductAction
) {
    @GetMapping("list")
    fun list(): List<ProductDto> {
        return productService.list().stream()
            .map { product ->
                ProductDto.Builder()
                    .id(product.id)
                    .title(product.title)
                    .price(product.price)
                    .category(product.category)
                    .build()
            }
            .collect(Collectors.toList())
    }

    @PostMapping("create")
    fun create(@RequestBody dto: CreateProductDto): ProductDto? {
        val product = createProductAction.execute(CreateProductActionArgument
            .Builder()
            .title(dto.title)
            .price(dto.price)
            .categoryId(dto.categoryId)
            .build())

        return ProductDto.Builder()
            .id(product.id)
            .title(product.title)
            .price(product.price)
            .category(product.category)
            .build()
    }

    @PutMapping("update/{id}")
    fun update(@PathVariable id: UUID?, @RequestBody dto: UpdateProductDto?): ProductDto? {
        val updateProduct = updateProductAction.execute(id,UpdateProductActionArgument
            .Builder()
            .title(dto?.title)
            .price(dto?.price)
            .categoryId(dto?.categoryId)
            .build())

        return ProductDto.Builder()
            .id(updateProduct.id)
            .title(updateProduct.title)
            .price(updateProduct.price)
            .category(updateProduct.category)
            .build()
    }

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: UUID?): HttpStatus {
        productService.delete(id)
        return HttpStatus.OK
    }
}