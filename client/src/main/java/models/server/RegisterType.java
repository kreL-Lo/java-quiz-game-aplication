package models.server;

public class RegisterType {
    String username;
    String password;
    boolean login;
    String message;

    public String getMessage() {
        return message;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public void setLoggin(boolean login) {
        this.login = login;
    }


    public boolean getLogin(){
        return login;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
