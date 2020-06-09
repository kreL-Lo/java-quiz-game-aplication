package models.server.mongo;

import java.util.Date;

public class Question {
    int id;
    String topic;
    String question;
    String []answers;

    Date receivedDate;
    boolean []userAnswers;
    boolean [] right;
    double score;

    public void setUserAnswers(boolean[] userAnswers) {
        this.userAnswers = userAnswers;
    }

    public boolean[] getUserAnswers() {
        return userAnswers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public boolean[] getRight() {
        return right;
    }

    public void setRight(boolean[] right) {
        this.right = right;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }
}
