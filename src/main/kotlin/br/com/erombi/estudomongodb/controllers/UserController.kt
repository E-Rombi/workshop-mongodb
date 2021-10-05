package br.com.erombi.estudomongodb.controllers

import br.com.erombi.estudomongodb.controllers.request.UserRequest
import br.com.erombi.estudomongodb.controllers.response.PostOfUserResponse
import br.com.erombi.estudomongodb.controllers.response.UserResponse
import br.com.erombi.estudomongodb.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(
    val userRepository: UserRepository
) {

    @GetMapping
    fun findAll(): ResponseEntity<List<UserResponse>> {
        val users = userRepository.findAll().map { UserResponse(it.id!!, it.name, it.email) }

        return ResponseEntity.ok(users)
    }

    @GetMapping("/{userId}")
    fun findById(@PathVariable userId: String): ResponseEntity<Any> {
        val possivelUsuario = userRepository.findById(userId)
        if (possivelUsuario.isEmpty) return ResponseEntity.notFound().build()

        val user = possivelUsuario.get()

        return ResponseEntity.ok(UserResponse(user.id!!, user.name, user.email))
    }

    @PostMapping
    fun insert(@RequestBody @Valid userRequest: UserRequest): ResponseEntity<UserResponse> {
        val user = userRequest.toModel()

        userRepository.save(user)

        return ResponseEntity.ok(UserResponse(user))
    }

    @PutMapping("/{userId}")
    fun insert(@RequestBody @Valid userRequest: UserRequest, @PathVariable userId: String): ResponseEntity<UserResponse> {
        val possivelUsuario = userRepository.findById(userId)
        if (possivelUsuario.isEmpty) return ResponseEntity.notFound().build()

        val user = possivelUsuario.get()

        user.updateFields(userRequest)
        userRepository.save(user)

        return ResponseEntity.ok(UserResponse(user))
    }

    @DeleteMapping("/{userId}")
    fun deleteById(@PathVariable userId: String): ResponseEntity<Any> {
        if (!userRepository.existsById(userId)) return ResponseEntity.notFound().build()

        userRepository.deleteById(userId)

        return ResponseEntity.ok().build()
    }

    @GetMapping("/{userId}/posts")
    fun findPostsByUser(@PathVariable userId: String): ResponseEntity<Any> {
        val possivelUsuario = userRepository.findById(userId)
        if (possivelUsuario.isEmpty) return ResponseEntity.notFound().build()

        val user = possivelUsuario.get()
        val respose = user.posts.map { PostOfUserResponse(it.title, it.body, it.author, it.createdAt, it.comments) }
        return ResponseEntity.ok(respose)
    }
}