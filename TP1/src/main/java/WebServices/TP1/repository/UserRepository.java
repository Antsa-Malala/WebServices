package WebServices.TP1.repository;

import WebServices.TP1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String>  {
    @Query("{ 'username' : ?0, 'password' : ?1 }")
    List<User> findByLogin(String username,String password);
}