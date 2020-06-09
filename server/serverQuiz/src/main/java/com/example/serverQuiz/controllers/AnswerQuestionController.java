package com.example.serverQuiz.controllers;

import com.example.serverQuiz.DAO.UserDAO;
import com.example.serverQuiz.controllers.models.UserModelController;
import com.example.serverQuiz.models.serverModels.mongo.Auth;
import com.example.serverQuiz.models.serverModels.mongo.Question;
import com.example.serverQuiz.models.serverModels.mongo.QuestionAnswer;
import com.example.serverQuiz.models.serverModels.mongo.User;
import com.example.serverQuiz.models.serverModels.server.AnswerQuestionType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utils.JWToken;

@RestController
public class AnswerQuestionController {
    //check token
    public static int scorePerQuestion = 10;
    @PostMapping("/answerQuestion")
    public AnswerQuestionType answeQuestion(@RequestBody AnswerQuestionType answerQuestionType){
        try {
            Auth auth = JWToken.decode(answerQuestionType.getToken());
            if (auth == null) {
                return invalidToken();
            }
            User user = UserDAO.find(auth.getUsername());

            Question question = null;
            for (Question que : user.getQuestions()) {
                if (que.getId() == answerQuestionType.getId()) {
                    question = que;
                }
            }
            boolean userAns[] = answerQuestionType.getAnswers();
            QuestionAnswer score = computeScore(userAns, question.getRight());
            double questionScore = scorePerQuestion * (score.getRight() + score.getWrong()) / userAns.length;
            question.setScore(questionScore);
            question.setUserAnswers(userAns);

            UserDAO.update(user);

            answerQuestionType.setMessage("Success");
            answerQuestionType.setSuccess(true);
            return answerQuestionType;
        }
        catch (Exception e){
            return  error();
        }
    }

    public static AnswerQuestionType invalidToken(){
        AnswerQuestionType answerQuestionType = new AnswerQuestionType();
        answerQuestionType.setSuccess(false);
        answerQuestionType.setMessage("Not a valid token");
        return answerQuestionType;
    }


    public static QuestionAnswer computeScore(boolean userAns[], boolean actualAns[]){
        int n = userAns.length;
        QuestionAnswer QA = new QuestionAnswer();
        int right =0;
        int wrong =0;
        for(int i =0 ;i<n;i++){
            if(userAns[i]==actualAns[i])
                ++right;
            else
                ++wrong;
        }
        QA.setRight(right);
        QA.setWrong(wrong);
        return QA;
    }
    public static AnswerQuestionType error(){
        AnswerQuestionType answerQuestionType = new AnswerQuestionType();
        answerQuestionType.setSuccess(false);
        answerQuestionType.setMessage("Error");
        return answerQuestionType;
    }
}
