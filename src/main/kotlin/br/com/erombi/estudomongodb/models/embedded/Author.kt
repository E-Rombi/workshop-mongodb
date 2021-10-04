package br.com.erombi.estudomongodb.models.embedded

import br.com.erombi.estudomongodb.models.entities.User

class Author(
    val id:String,
    val name: String,
) {
    constructor(user: User) : this(user.id!!, user.name)
}