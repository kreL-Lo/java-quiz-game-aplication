package controllers.clientController;

import controllers.data.QuestionsData;
import controllers.listeners.button.gameListeners.Answer;
import controllers.server.InitGameController;
import graphics.player.AnswerBox;
import graphics.player.DisplayPanel;
import graphics.player.GamePanel;
import graphics.player.QuestionBox;
import models.server.InitGameType;
import models.server.mongo.Question;

import java.util.ArrayList;
import java.util.List;

public class InitGame {
    public static void initGame(GamePanel gamePanel){
        String token = gamePanel.getToken();
        InitGameType initGameType= new InitGameType();
        initGameType.setToken(token);
        initGameType.setTopic(gamePanel.getTopic());
        initGameType= InitGameController.initGame(initGameType);
        System.out.println(initGameType.getMessage()+" "+gamePanel.getToken());
        QuestionsData questionsData = new QuestionsData();
        questionsData.setIndex(0);
        questionsData.setQuestionList(initGameType.getQuestions());
        gamePanel.setQuestionsData(questionsData);
        Question question = questionsData.getQuestionList().get(0);
        DisplayPanel displayPanel =gamePanel.getDisplayPanel();
        displayPanel.add(new QuestionBox(question.getQuestion()));
        int i=0;
        List<AnswerBox> answerBoxList= new ArrayList<>();
        for(String ans: question.getAnswers()){
            ++i;
            AnswerBox ansBox = new AnswerBox(Integer.toString(i),ans);
            answerBoxList.add(ansBox);
            displayPanel.add(ansBox);
        }
        displayPanel.setAnswerBoxes(answerBoxList);
        displayPanel.revalidate();
        displayPanel.repaint();

    }
}
