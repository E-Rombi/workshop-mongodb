package br.com.erombi.estudomongodb.controllers.response

import br.com.erombi.estudomongodb.models.embedded.Author
import br.com.erombi.estudomongodb.models.embedded.Comment
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

data class PostOfUserResponse(
    val title: String,
    val body: String,
    val author: Author,

    @field:JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "UTC")
    val createdAt: Instant,
    val comments: List<Comment>
)