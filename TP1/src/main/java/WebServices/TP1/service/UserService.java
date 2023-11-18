package WebServices.TP1.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import WebServices.TP1.model.User;
import WebServices.TP1.repository.UserRepository;
@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;

    public List<User> findByLogin(String username,String password){
        return userrepository.findByLogin(username, password);
    }
    
    public List<User> findByUserName(String username){
        return  userrepository.findByUserName(username);        
    }
}
