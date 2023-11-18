package WebServices.TP1.controller;

import WebServices.TP1.service.TokenService;
import WebServices.TP1.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import WebServices.TP1.model.BearerToken;
import WebServices.TP1.model.Token;
import WebServices.TP1.model.User;

import java.util.List;

@RequestMapping("apiToken")
@RestController
public class TokenController {
    private final String nomToken="myToken";
    
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

   @PostMapping("/login")
    public void login(@RequestBody User user, HttpServletResponse response) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();

        if (username != null && password != null) {
            List<User> users = userService.findByLogin(username, password);
            if (!users.isEmpty()) {
                Token tok= BearerToken.generateToken(users.get(0));
                response.setHeader("Set-Cookie", nomToken+"=" + tok.getToken() + "; Secure; HttpOnly; SameSite=Strict; Path=/");
                tokenService.save(tok);
            }
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletResponse response,HttpServletRequest request) throws Exception {
        Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (nomToken.equals(cookie.getName())) {
                        String token=cookie.getValue();
                        tokenService.updateToken(token);
                        Cookie deleteCookie = new Cookie(nomToken, null);
                        deleteCookie.setMaxAge(0);
                        deleteCookie.setSecure(true);
                        deleteCookie.setHttpOnly(true);
                        deleteCookie.setPath("/");

                        response.addCookie(deleteCookie);
                        break;
                    }
                }
            }
    }

    @GetMapping("/Tokens")
    public List<Token> getAll() throws Exception {
        return tokenService.findAll();
    }
}