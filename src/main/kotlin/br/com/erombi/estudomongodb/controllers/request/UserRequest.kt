package br.com.erombi.estudomongodb.controllers.request

import br.com.erombi.estudomongodb.models.entities.User
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserRequest(
    @field:NotBlank val name: String,
    @field:NotBlank @field:Email val email: String,
) {

    fun toModel(): User {
        return User(this.name, this.email)
    }

}
