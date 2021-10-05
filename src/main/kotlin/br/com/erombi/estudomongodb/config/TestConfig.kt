package br.com.erombi.estudomongodb.config

import br.com.erombi.estudomongodb.models.embedded.Author
import br.com.erombi.estudomongodb.models.embedded.Comment
import br.com.erombi.estudomongodb.models.entities.Post
import br.com.erombi.estudomongodb.models.entities.User
import br.com.erombi.estudomongodb.repositories.PostRepository
import br.com.erombi.estudomongodb.repositories.UserRepository
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import javax.annotation.PostConstruct


@Profile("test")
@Configuration
class TestConfig(
    val repository: UserRepository,
    val postRepository: PostRepository
) {

    @PostConstruct
    @Transactional
    fun init() {
        repository.deleteAll()
        postRepository.deleteAll()

        val userEduardo = User("Eduardo Rombi", "eduardo@zup.com")
        val userAlex = User("Alex Almeida", "alex@gmail.com")

        repository.saveAll(listOf(userEduardo, userAlex))

        val postEduardo = Post("Terminando o orange talents !", "Finalmente estou terminando o bootcamp !", Author(userEduardo))

        val c1 = Comment("Boa viagem mano!", Instant.parse("2021-02-13T14:30:01Z"), Author(userEduardo))
        val c2 = Comment("Aproveite", Instant.parse("2021-02-13T15:38:05Z"), Author(userAlex))

        postEduardo.adicionarComentarios(listOf(c1, c2));

        postRepository.saveAll(listOf(postEduardo))

        userAlex.adicionarPosts(mutableListOf(postEduardo))
        userEduardo.adicionarPosts(mutableListOf(postEduardo))

        repository.saveAll(listOf(userEduardo, userAlex))
    }

}