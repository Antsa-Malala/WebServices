package WebServices.TP1.model;
import org.bson.BsonTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "token")
public class Token {
    private User user;
    private String token;
    private BsonTimestamp date_expiration;
    private BsonTimestamp date_creation;
    private boolean etat;

    public String getToken()
    {
        return this.token;
    }
    public void setToken(String token)
    {
        this.token=token;
    } 
    public User getUser()
    {
        return this.user;
    }
    public void setUser(User use)
    {
        this.user=use;
    }
    public boolean getEtat()
    {
        return this.etat;
    }
    public void setEtat(boolean etat)
    {
        this.etat=etat;
    }
    public void setEtat(String etat)
    {
        boolean eta=Boolean.valueOf(etat);
        this.setEtat(eta);
    }

    public BsonTimestamp getDate_expiration()
    {
        return this.date_expiration;
    }
    public BsonTimestamp getDate_creation()
    {
        return this.date_creation;
    }
    public void setDate_expiration(BsonTimestamp date_expiration)
    {
        this.date_expiration=date_expiration;
    }

    public void setDate_creation(BsonTimestamp date_creation)
    {
        this.date_creation=date_creation;
    }
    


    public Token(User user,String token,BsonTimestamp date_expiration,BsonTimestamp date_creation,boolean etat)
    {
        this.setUser(user);
        this.setToken(token);
        this.setDate_expiration(date_expiration);
        this.setDate_creation(date_creation);
        this.setEtat(etat);
    }
    public Token(String token,BsonTimestamp date_expiration,BsonTimestamp date_creation,boolean etat)
    {
        this.setToken(token);
        this.setDate_expiration(date_expiration);
        this.setDate_creation(date_creation);
        this.setEtat(etat);
    }
    public Token(){

    }
}