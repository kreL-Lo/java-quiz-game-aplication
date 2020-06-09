package utils;

import com.example.serverQuiz.DAO.QuestionDAO;
import com.example.serverQuiz.DAO.UserDAO;
import com.example.serverQuiz.models.serverModels.mongo.Question;
import com.example.serverQuiz.models.serverModels.mongo.User;

import java.nio.file.Watchable;

public class DummyInsert {
    public static void makeQuestion (
            String[] answers,
            boolean[] right,
            String question,
            String topic,int i
    ){
        Question q = makeQuestion(question,topic,answers,right);
        QuestionDAO.create(i);
        q.setId(i);
        QuestionDAO.update(q);
    }
    public static void init(){
        String []answers={"Human","Lion","Car"};
        String topic = "Animals";
        boolean []right={true,false ,false};
        String question ="Who is the most op animal?";
        makeQuestion(answers,right,question,topic,3);
        init1();
        init2();
    }

    public static void init1(){
        String []answers={"Human","Lion","Car"};
        String topic = "Animals";
        boolean []right={true,false ,false};
        String question ="Who is the most op animal?";
        makeQuestion(answers,right,question,topic,4);
    }
    public static void init2(){
        String []answers={"Human","Lion","Car"};
        String topic = "Animals";
        boolean []right={false,true ,false};
        String question ="Who king of the jungle?";
        makeQuestion(answers,right,question,topic,5);
    }

    public static Question makeQuestion(String question1,String topic, String [] answers,boolean []right){
        Question question = new Question();
        question.setQuestion(question1);
        question.setRight(right);
        question.setTopic(topic);
        question.setAnswers(answers);
        return question;
    }
}
