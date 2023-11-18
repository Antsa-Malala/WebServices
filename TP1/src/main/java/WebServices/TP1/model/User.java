package WebServices.TP1.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document(collection = "Login")
@Component
public class User {
    String id;
    String username;
    String password;

    public String getId(){
        return this.id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    
    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

    public User(String id,String username,String password) throws Exception
    {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
    }
    public User(String username,String password)
    {
        this.setPassword(password);
        this.setUsername(username);
    }
    
    public User()
    {
        
    }
}