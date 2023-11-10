package WebServices.TP1.model;

import java.util.Date;

import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Token {
    private String token;
    private Date date_expiration;

    public String getToken()
    {
        return this.token;
    }
    public void setToken(String token)
    {
        this.token=token;
    } 

    public Date getDate_expiration()
    {
        return this.date_expiration;
    }
    public void setDate_expiration(Date date_expiration)
    {
        this.date_expiration=date_expiration;
    }
    
     public void setDate_expiration(String date_expiration) {
        java.sql.Date daty=java.sql.Date.valueOf(date_expiration);
        this.setDate_expiration(daty);
    }

    public Token(String token,Date date_expiration2)
    {
        this.setToken(token);
        this.setDate_expiration(date_expiration2);
    }
    public Token(String token,String date_expiration)
    {
        this.setToken(token);
        this.setDate_expiration(date_expiration);
    }

    public Token generateToken(String nom_utilisateur,String pass) throws Exception
    {
        Date daty = new Date();

        SimpleDateFormat format = new SimpleDateFormat("dyDHsdYDm");
        String formate = format.format(daty);
        String base=formate+nom_utilisateur+pass;
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = sha256.digest(base.getBytes());

            StringBuilder tok = new StringBuilder();
            for (byte b : hashBytes) {
                tok.append(String.format("%02x", b));
            }

            String token = tok.toString();
            Timestamp expirationTime = new Timestamp(System.currentTimeMillis() + 3600000);
            Date date_expiration = new Date(expirationTime.getTime());

            return new Token(token,date_expiration);
        } catch (Exception e) {
            throw e;
        }
    }

    public Token(){

    }
}