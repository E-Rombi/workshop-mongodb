package br.com.erombi.estudomongodb.controllers

import br.com.erombi.estudomongodb.controllers.response.PostOfUserResponse
import br.com.erombi.estudomongodb.repositories.PostRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/posts")
class PostController(
    val postRepository: PostRepository
) {

    @GetMapping("/titleSearch")
    fun findByTitle(@RequestParam value: String): ResponseEntity<List<PostOfUserResponse>> {
        val posts = postRepository.findByTitleContainingIgnoreCase(value).map { PostOfUserResponse(it.title, it.body, it.author, it.createdAt, it.comments) }

        return ResponseEntity.ok(posts)
    }

    @GetMapping("/fullSearch")
    fun fullSearch(@RequestParam value: String, start: Instant, end: Instant): ResponseEntity<List<PostOfUserResponse>> {
        // * OBS - fullSearch não estava compilando, tenho reuniao dps vejo
        val posts = postRepository.findByTitleContainingIgnoreCase(value)
            .map { PostOfUserResponse(it.title, it.body, it.author, it.createdAt, it.comments) }

        return ResponseEntity.ok(posts)
    }

}