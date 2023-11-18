package WebServices.TP1.controller;

import WebServices.TP1.model.User;
import WebServices.TP1.service.UserService;
import WebServices.TP1.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("apiUser")
@RestController
public class UserController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    TokenService tokenService;

    @GetMapping("/getName/{username}")
    public User getByUsername(@PathVariable String username,HttpServletRequest request) throws Exception {
        if(tokenService.verifieConnection(request))
        {
            List<User> user=userService.findByUserName(username);
            return user.get(0);
        }
        return null;
    }
}   