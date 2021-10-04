package br.com.erombi.estudomongodb.repositories

import br.com.erombi.estudomongodb.models.entities.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {

}