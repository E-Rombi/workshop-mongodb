package br.com.erombi.estudomongodb.repositories

import br.com.erombi.estudomongodb.models.entities.Post
import br.com.erombi.estudomongodb.models.entities.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : MongoRepository<Post, String> {

}