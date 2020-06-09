package controllers.listeners.button.gameListeners;

import controllers.data.QuestionsData;
import graphics.player.AnswerBox;
import graphics.player.DisplayPanel;
import graphics.player.GamePanel;
import graphics.player.QuestionBox;
import models.server.mongo.Question;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Previous implements ActionListener {
    GamePanel gamePanel;
    public Previous(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        action();

    }

    void action() {
        QuestionsData questionsData = gamePanel.getQuestionsData();
        int index = questionsData.previousQuestion();
        DisplayPanel displayPanel = gamePanel.getDisplayPanel();
        questionsData.setIndex(index);
        Question question = questionsData.getQuestionList().get(index);
        gamePanel.remove(displayPanel);
        displayPanel = new DisplayPanel();
        gamePanel.add(displayPanel);
        displayPanel.add(new QuestionBox(question.getQuestion()));
        int i = 0;
        List<AnswerBox> answerBoxList = new ArrayList<>();
        for (String ans : question.getAnswers()) {
            ++i;
            AnswerBox ansBox = new AnswerBox(Integer.toString(i), ans);
            answerBoxList.add(ansBox);
            displayPanel.add(ansBox);
        }
        displayPanel.setAnswerBoxes(answerBoxList);
        gamePanel.setDisplayPanel(displayPanel);
        gamePanel.validate();
        gamePanel.repaint();
    }

}
