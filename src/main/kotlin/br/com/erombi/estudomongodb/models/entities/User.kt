package br.com.erombi.estudomongodb.models.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class User(
    val name: String,
    val email: String
) {

    @Id
    var id: String? = null

    @DBRef(lazy = true)
    val posts: List<Post> = listOf()
}