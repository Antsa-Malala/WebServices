package WebServices.TP1.model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import WebServices.TP1.service.TokenService;
import java.util.List;

import org.bson.BsonTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Intercepteur implements HandlerInterceptor{

    @Autowired
    TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        List<Token> all=tokenService.findAll();
        for(Token token : all){
            long currentTimeMillis = System.currentTimeMillis();
            int seconds = (int) (currentTimeMillis / 1000); 
            BsonTimestamp now=new BsonTimestamp(seconds, 0);
            if(isBefore(token.getDate_expiration(),now))
            {
                tokenService.updateToken(token.getToken());
            }
        }
        return true;
    }

    private static boolean isBefore(BsonTimestamp timestamp1, BsonTimestamp timestamp2) {
        return timestamp1.getTime() < timestamp2.getTime();
    }
}
