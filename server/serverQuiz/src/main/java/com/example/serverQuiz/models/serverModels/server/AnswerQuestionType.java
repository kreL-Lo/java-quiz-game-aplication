package com.example.serverQuiz.models.serverModels.server;

public class AnswerQuestionType {
    int id;
    boolean []answers;
    String token;
    boolean success;
    String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAnswers(boolean[] answers) {
        this.answers = answers;
    }

    public boolean[] getAnswers() {
        return answers;
    }

    public String getToken() {
        return token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
