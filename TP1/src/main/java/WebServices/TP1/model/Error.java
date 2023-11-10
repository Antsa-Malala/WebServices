package WebServices.TP1.model;

public class Error {
    String message;

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message=message;
    }
    public Error()
    {

    }
    public Error(String message)
    {
        this.setMessage(message);
    }
}
