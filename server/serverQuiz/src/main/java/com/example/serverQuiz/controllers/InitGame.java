package com.example.serverQuiz.controllers;

import com.example.serverQuiz.DAO.QuestionDAO;
import com.example.serverQuiz.DAO.UserDAO;
import com.example.serverQuiz.models.serverModels.mongo.Auth;
import com.example.serverQuiz.models.serverModels.mongo.Question;
import com.example.serverQuiz.models.serverModels.mongo.User;
import com.example.serverQuiz.models.serverModels.server.InitGameType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utils.JWToken;

import java.util.List;

@RestController
public class InitGame {
    @PostMapping("/initGame")
    public InitGameType initGame(@RequestBody InitGameType initGameType){
        System.out.println(initGameType.getToken());
        Auth auth = JWToken.decode(initGameType.getToken());
        if(auth == null) return failedAuth(initGameType);
        try {
            User user = UserDAO.find(auth.getUsername());
            List<Question> questions = generateQuestions(initGameType.getTopic());
            user.setQuestions(questions);
            UserDAO.update(user);
            initGameType.setQuestions(questions);
            initGameType.setSuccess(true);
            initGameType.setMessage("Success , Begin Game");
            return initGameType;
        }
        catch (Exception e){
            return  error(initGameType);
        }
    }

    static InitGameType failedAuth(InitGameType initGameType){
        initGameType.setMessage("Failled token");
        initGameType.setSuccess(false);
        return initGameType;
    }
    static InitGameType error(InitGameType initGameType){
        initGameType.setMessage("Some error");
        initGameType.setSuccess(false);
        return initGameType;
    }
    static List<Question> generateQuestions(String topic){
        List<Question> questions = QuestionDAO.findQuestions(topic);

        return  questions;
    }
}
