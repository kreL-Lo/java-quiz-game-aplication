package com.example.serverQuiz.controllers.models;

import com.example.serverQuiz.models.serverModels.mongo.Question;
import com.example.serverQuiz.models.serverModels.mongo.User;

public class UserModelController {

    public static Question findQuestion(User user ,int id){
        for(Question question : user.getQuestions()){
            if(question.getId()==id){
                return question;
            }

        }
        return null;
    }

}
