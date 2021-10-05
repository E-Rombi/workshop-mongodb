package br.com.erombi.estudomongodb.controllers.response

import br.com.erombi.estudomongodb.models.entities.User

data class UserResponse(
    val id: String,
    val name: String,
    val email: String
) {
    constructor(user: User) : this(user.id!!, user.name, user.email)
}