package br.com.erombi.estudomongodb.models.entities

import br.com.erombi.estudomongodb.controllers.request.UserRequest
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
class User(
    name: String,
    email: String
) {
    @Id
    var id: String? = null

    var email = email
        private set

    var name = name
        private set

    @DBRef(lazy = true)
    var posts: MutableList<Post> = mutableListOf()

    fun adicionarPosts(posts: MutableList<Post>) {
        this.posts.addAll(posts)
    }

    fun updateFields(userRequest: UserRequest) {
        this.name = userRequest.name
        this.email = userRequest.email
    }
}