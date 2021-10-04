package br.com.erombi.estudomongodb.config

import br.com.erombi.estudomongodb.models.entities.User
import br.com.erombi.estudomongodb.repositories.UserRepository
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.annotation.PostConstruct

@Profile("test")
@Configuration
class TestConfig(
    val repository: UserRepository
) {

    @PostConstruct
    fun init() {
        repository.deleteAll()

        val userEduardo = User("Eduardo Rombi", "eduardo@zup.com")
        val userAlex = User("Alex Almeida", "alex@gmail.com")

        repository.saveAll(listOf(userEduardo, userAlex))
    }

}