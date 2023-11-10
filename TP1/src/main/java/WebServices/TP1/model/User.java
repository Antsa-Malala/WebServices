package WebServices.TP1.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Login")
public class User {
    String id;
    String username;
    String password;
    int user_id;
    Token token;

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
    public int getUser_id()
    {
        return this.user_id;
    }

    public void setUserId(int user_id) throws Exception
    {
        if(user_id>0)
        {
            this.user_id=user_id;
        }
        else{
            throw new Exception("IdUser invalide");
        }
    }

    public Token getToken()
    {
        return this.token;
    }
    public void setToken(Token token)
    {
        this.token=token;
    }

    public User(String id,String username,String password,int user_id) throws Exception
    {
        this.setId(id);
        this.setUserId(user_id);
        this.setUsername(username);
        this.setPassword(password);
    }
    public User(String username,String password,int user_id) throws Exception
    {
        this.setUserId(user_id);
        this.setUsername(username);
        this.setPassword(password);
    }
    public User(String username,String password)
    {
        this.setPassword(password);
        this.setUsername(username);
    }
    
    public User(int user_id,String username,String password,Token token) throws Exception
    {
        this.setUserId(user_id);
        this.setUsername(username);
        this.setPassword(password);
        this.setToken(token);
    }

    public User(int user_id) throws Exception
    {
        this.setUserId(user_id);
    }

    public User()
    {
        
    }
    
}