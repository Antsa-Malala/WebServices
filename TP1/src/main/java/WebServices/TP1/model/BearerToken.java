package WebServices.TP1.model;

import java.security.MessageDigest;

import org.bson.BsonTimestamp;

public class BearerToken{

    public static Token generateToken(User user) throws Exception
    {
        long currentTimeMillis = System.currentTimeMillis();
        int seconds = (int) (currentTimeMillis / 1000); 
        BsonTimestamp now=new BsonTimestamp(seconds, 0);

        long updatedTimeMillis = (long) now.getTime() * 1000 + 3600000;
        int updatedSeconds = (int) (updatedTimeMillis / 1000); 
        BsonTimestamp expiration = new BsonTimestamp(updatedSeconds, 0);

        String base=now.toString()+user.getUsername()+user.getPassword()+expiration.toString();
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = sha256.digest(base.getBytes());

            StringBuilder tok = new StringBuilder();
            for (byte b : hashBytes) {
                tok.append(String.format("%02x", b));
            }

            String token = tok.toString();
            
            return new Token(user,token,expiration,now,true);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
