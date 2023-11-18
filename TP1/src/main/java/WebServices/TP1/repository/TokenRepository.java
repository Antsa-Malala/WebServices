package WebServices.TP1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import WebServices.TP1.model.Token;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends MongoRepository<Token, String> {
    @Query("{ 'token' : ?0, 'etat' : ?1 }")
    List<Token> findByToken(String token,boolean etat);
    List<Token> findAll();
}