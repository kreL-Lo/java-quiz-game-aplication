package com.example.serverQuiz.models.serverModels.mongo;

public class Auth {
    String username;
    String password;
    public Auth(String username,String password){
        this.username = username;
        this.password= password ;

    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
