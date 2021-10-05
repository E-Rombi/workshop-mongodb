package br.com.erombi.estudomongodb.repositories

import br.com.erombi.estudomongodb.models.entities.Post
import br.com.erombi.estudomongodb.models.entities.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
interface PostRepository : MongoRepository<Post, String> {

//    @Query("{ $and: [ { 'moment': { $gte: ?1 } }, { 'moment': { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0 , $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
//    fun fullSearch(title: String, start: Instant, end: Instant): List<Post>

    fun findByTitleContainingIgnoreCase(title: String): List<Post>
}