package controllers.listeners.button.scoreBoard;

import controllers.data.QuestionsData;
import graphics.player.*;
import models.server.mongo.Question;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Next implements ActionListener {
    GamePanel gamePanel;
    public Next(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        action();
    }
    void action() {
        QuestionsData questionsData = gamePanel.getQuestionsData();
        int index = questionsData.nextQuestion();
        DisplayPanel displayPanel = gamePanel.getDisplayPanel();
        questionsData.setIndex(index);
        Question question = questionsData.getQuestionList().get(index);
        gamePanel.remove(displayPanel);
        displayPanel =  new DisplayPanel();
        gamePanel.add(displayPanel);
        displayPanel.add(new QuestionBox(question.getQuestion()));
        int i=0;
        for(String ans: question.getAnswers()){

            ShowAnswerBox showAnswerBox = new ShowAnswerBox(
                    Integer.toString(i),
                    ans,
                    question.getUserAnswers()[i],
                    question.getRight()[i]
            );
            ++i;
            displayPanel.add(showAnswerBox);
        }
        displayPanel.add( new ScoreBox(Double.toString(question.getScore()),gamePanel));
        gamePanel.setDisplayPanel(displayPanel);
        gamePanel.validate();
        gamePanel.repaint();
    }
}