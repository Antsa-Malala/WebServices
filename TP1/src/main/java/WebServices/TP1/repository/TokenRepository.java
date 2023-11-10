package WebServices.TP1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import WebServices.TP1.model.Token;

public interface TokenRepository extends MongoRepository<Token, String> {
}