package br.com.erombi.estudomongodb.models.entities

import br.com.erombi.estudomongodb.models.embedded.Author
import br.com.erombi.estudomongodb.models.embedded.Comment
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "posts")
class Post(
    val title: String,
    val body: String,
    val author: Author,
) {
    @Id
    var id: String? = null

    var createdAt: Instant = Instant.now()
    var comments: MutableList<Comment> = mutableListOf()

    fun adicionarComentarios(comments: List<Comment>) {
        this.comments.addAll(comments)
    }
}