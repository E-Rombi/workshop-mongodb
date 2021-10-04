package br.com.erombi.estudomongodb.models.embedded

import java.time.Instant

class Comment(
    val text: String,
    val createdAt: Instant,
    val author: Author
) {

}