package controllers.data;

import models.server.mongo.Question;

import java.util.List;

public class QuestionsData {
    List<Question> questionList;
    int index;
    double score;
    public void deleteQuestion(int id){
        Question q =null;
        for(Question question :questionList){
            if(question.getId()==id){
                q= question;
            }
        }
        questionList.remove(q);
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    public int nextQuestion() {
        int size = questionList.size();
        int d = index;
        d= d+1;
        System.out.println(d);
            d= d%size;

        System.out.println(d);
        return d;
    }
    public  int previousQuestion(){
        int size = questionList.size();
        int d = --index;
        if(d<0){
            d= size+d;
        }
        return d;
    }
    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
