package com.example.serverQuiz.models.serverModels.server;

public class MakeQuestionType {
    int id;
    String topic;
    String question;
    String [] answers;
    boolean [] right;
    boolean success;
    String message;
    String token;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean[] getRight() {
        return right;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setRight(boolean[] right) {
        this.right = right;
    }

    public String getTopic() {
        return topic;
    }

    public String[] getAnswers() {
        return answers;
    }
}
