package br.com.erombi.estudomongodb.config

import br.com.erombi.estudomongodb.models.embedded.Author
import br.com.erombi.estudomongodb.models.entities.Post
import br.com.erombi.estudomongodb.models.entities.User
import br.com.erombi.estudomongodb.repositories.PostRepository
import br.com.erombi.estudomongodb.repositories.UserRepository
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.annotation.PostConstruct

@Profile("test")
@Configuration
class TestConfig(
    val repository: UserRepository,
    val postRepository: PostRepository
) {

    @PostConstruct
    fun init() {
        repository.deleteAll()
        postRepository.deleteAll()

        val userEduardo = User("Eduardo Rombi", "eduardo@zup.com")
        val userAlex = User("Alex Almeida", "alex@gmail.com")

        repository.saveAll(listOf(userEduardo, userAlex))

        val postEduardo = Post("Terminando o orange talents !", "Finalmente estou terminando o bootcamp !", Author(userEduardo))

        postRepository.saveAll(listOf(postEduardo))
    }

}