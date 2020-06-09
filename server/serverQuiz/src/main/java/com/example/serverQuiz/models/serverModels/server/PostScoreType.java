package com.example.serverQuiz.models.serverModels.server;

import com.example.serverQuiz.models.serverModels.mongo.Question;

import java.util.List;

public class PostScoreType {
    String token;
    List<Question> questionList;
    double score;
    String message;
    boolean success;
    String username;
    String topic;

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getToken() {
        return token;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public double getScore() {
        return score;
    }
}
