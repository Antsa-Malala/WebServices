package WebServices.TP1.controller;

import WebServices.TP1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import WebServices.TP1.model.Token;
import WebServices.TP1.model.User;
import java.util.List;
import java.util.Map;

@RequestMapping("apiVehicle")
@RestController
public class TokenController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/token")
    public Token generateToken(@RequestParam String nom_utilisateur,@RequestParam String pass) throws Exception
    {
        return new Token().generateToken(nom_utilisateur, pass);
    }

    @PostMapping("/login")
    public Token login(@RequestBody Map<String, String> loginData) throws Exception {
        String username = loginData.get("username");
        String password = loginData.get("password");

        if (username != null && password != null) {
            List<User> users = userRepository.findByLogin(username, password);
            System.out.println(users.size());
            if (!users.isEmpty()) {
                return new Token().generateToken(username, password);
            }
        }
        return null;
    }

}