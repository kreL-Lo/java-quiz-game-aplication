package models.server.mongo;

import java.util.List;

public class User {
    List<Question> questions;
    String username;
    String password;
    boolean admin;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public boolean isAdmin(){
        return admin;
    }
}
