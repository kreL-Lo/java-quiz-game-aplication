package com.example.serverQuiz.controllers;

import com.example.serverQuiz.DAO.QuestionDAO;
import com.example.serverQuiz.DAO.UserDAO;
import com.example.serverQuiz.models.serverModels.mongo.Auth;
import com.example.serverQuiz.models.serverModels.mongo.Question;
import com.example.serverQuiz.models.serverModels.mongo.User;
import com.example.serverQuiz.models.serverModels.server.PostScoreType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utils.JWToken;

import java.util.List;

@RestController
public class PostScoreController {
    @PostMapping("/postScore")
    public PostScoreType postScore(@RequestBody PostScoreType postScoreType){
        try {
            Auth auth = JWToken.decode(postScoreType.getToken());
            if(auth == null) return failledAuth();
            User user = UserDAO.find(auth.getUsername());
            List<Question> questions = user.getQuestions();
            double sum = computeScore(questions);
            postScoreType.setScore(sum);
            postScoreType.setQuestionList(questions);
            postScoreType.setSuccess(true);
            return postScoreType;
        }
        catch (Exception e){
            System.out.println(e);
            return  error();
        }
    }

    public static PostScoreType error(){
        PostScoreType postScoreType = new PostScoreType();
        postScoreType.setMessage("Erorr");
        postScoreType.setSuccess(false);
        return postScoreType;
    }
    public static PostScoreType failledAuth(){
        PostScoreType postScoreType = new PostScoreType();
        postScoreType.setMessage("Failled Auth");
        postScoreType.setSuccess(false);
        return postScoreType;
    }

    double computeScore(List<Question> questions){
        double sum =0 ;
        for(Question question: questions){
            sum += question.getScore();
        }
        return sum;
    }
}
