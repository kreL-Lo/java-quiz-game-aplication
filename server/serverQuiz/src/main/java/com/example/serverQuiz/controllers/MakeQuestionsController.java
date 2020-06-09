package com.example.serverQuiz.controllers;

import com.auth0.jwt.JWT;
import com.example.serverQuiz.DAO.QuestionDAO;
import com.example.serverQuiz.DAO.UserDAO;
import com.example.serverQuiz.models.serverModels.mongo.Auth;
import com.example.serverQuiz.models.serverModels.mongo.Question;
import com.example.serverQuiz.models.serverModels.mongo.User;
import com.example.serverQuiz.models.serverModels.server.MakeQuestionType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.ScalarEvent;
import utils.CheckAdmin;
import utils.JWToken;

import java.awt.desktop.QuitEvent;
import java.util.UUID;
@RestController
public class MakeQuestionsController {
    @PostMapping("/create/question")
    public MakeQuestionType makeQuestionsController(MakeQuestionType makeQuestionType){
        String token = makeQuestionType.getToken();
        Auth auth = JWToken.decode(token);
        if(auth==null)
            return noToken();

        try{
            User u = UserDAO.find(auth.getUsername());
            if(CheckAdmin.checkAdmin(auth)==false)
                return  noAdmin();

            Question question = QuestionDAO.find(makeQuestionType.getQuestion());
            if(question!=null){
                makeQuestionType.setSuccess(false);
                return makeQuestionType;
            }
            makeQuestionType.setSuccess(true);
            question = new Question();
            MakeQuestionType mkt = makeQuestionType;
            int id = (int) UUID.randomUUID().getMostSignificantBits();
            question.setId(id);
            question.setAnswers(mkt.getAnswers());
            question.setRight(mkt.getRight());
            question.setQuestion(mkt.getQuestion());
            question.setTopic(mkt.getTopic());
            QuestionDAO.create(id);
            QuestionDAO.update(question);
            mkt.setMessage("Success making questions");
            mkt.setSuccess(true);
            return mkt;}
        catch (Exception e){
            return  error(makeQuestionType);
        }
    }


    public static MakeQuestionType noToken(){
        MakeQuestionType makeQuestionType = new MakeQuestionType();
        makeQuestionType.setSuccess(false);
        makeQuestionType.setMessage("Bad login");
        return makeQuestionType;
    }

    public static MakeQuestionType noAdmin(){
        MakeQuestionType makeQuestionType = new MakeQuestionType();
        makeQuestionType.setSuccess(false);
        makeQuestionType.setMessage("Not an admin");
        return makeQuestionType;
    }
    static MakeQuestionType error(MakeQuestionType mkt){
        mkt.setSuccess(false);
        mkt.setMessage("Some Error");
        return  mkt;
    }
}
