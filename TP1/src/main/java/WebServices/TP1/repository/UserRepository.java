package WebServices.TP1.repository;

import WebServices.TP1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String>  {
    @Query("{ 'username' : ?0, 'password' : ?1 }")
    List<User> findByLogin(String username,String password);
    @Query("{ 'username' : ?0}")
    List<User> findByUserName(String username);
}