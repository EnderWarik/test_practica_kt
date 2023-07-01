package com.example.demo.model
import lombok.*
import java.util.*
import javax.persistence.*


@Entity
@AllArgsConstructor
@NoArgsConstructor
data class Category(
    @Id  @GeneratedValue var id: UUID?,
    var title: String?
)
{

    data class Builder(
        var id: UUID?=null,
        var title: String? = null
    )
    {

        fun id(id: UUID?)= apply { this.id = id }
        fun title(title: String?) = apply { this.title = title }

        fun build() = Category(id, title)
    }




}