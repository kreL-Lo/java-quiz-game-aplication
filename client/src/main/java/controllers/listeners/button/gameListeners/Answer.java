package controllers.listeners.button.gameListeners;

import controllers.data.QuestionsData;
import controllers.server.AnswerController;
import controllers.server.PostScoreController;
import graphics.player.*;
import models.server.AnswerQuestionType;
import models.server.PostScoreType;
import models.server.mongo.Question;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Answer implements ActionListener {
    GamePanel gamePanel ;
    public Answer(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        action();
    }

    void action(){
        DisplayPanel displayPanel = gamePanel.getDisplayPanel();
        QuestionsData questionsData = gamePanel.getQuestionsData();
        int index = questionsData.getIndex();
        int id = questionsData.getQuestionList().get(index).getId();
        AnswerQuestionType answerQuestionType = new AnswerQuestionType();
        answerQuestionType.setId(id);
        answerQuestionType.setToken(gamePanel.getToken());
        List<AnswerBox> answerBoxes = displayPanel.getAnswerBoxes();
        boolean [] answers   = new boolean[answerBoxes.size()];
        int i=0;
        for(AnswerBox ansBox : answerBoxes){
            answers[i]=  ansBox.getCheckBox().isSelected();
            ++i;
        }
        answerQuestionType.setAnswers(answers);
        answerQuestionType = AnswerController.answerQuestion(answerQuestionType);
        if(answerQuestionType.isSuccess()){
            questionsData.deleteQuestion(id);
            if(questionsData.getQuestionList().size()==0){
                PostScoreType postScoreType = new PostScoreType();
                postScoreType.setToken(gamePanel.getToken());
               postScoreType =  PostScoreController.postScore(postScoreType);
               System.out.println(postScoreType.getMessage());
               if (postScoreType.isSuccess()){
                   QuestionsData questionsData1 = new QuestionsData();
                   questionsData1.setScore(postScoreType.getScore());
                   questionsData1.setIndex(0);
                   questionsData1.setQuestionList(postScoreType.getQuestionList());
                   gamePanel.setQuestionsData(questionsData1);
                   Question question = questionsData1.getQuestionList().get(0);
                   gamePanel.remove(displayPanel);
                   displayPanel =  new DisplayPanel();
                   gamePanel.add(displayPanel);
                   displayPanel.add(new QuestionBox(question.getQuestion()));
                   i=0;
                   List<AnswerBox> answerBoxList= new ArrayList<>();
                   for(String ans: question.getAnswers()){

                       ShowAnswerBox showAnswerBox = new ShowAnswerBox(
                               Integer.toString(i),
                               ans,
                               question.getUserAnswers()[i],
                               question.getRight()[i]
                       );
                       displayPanel.add(showAnswerBox);
                       ++i;

                   }
                   displayPanel.add( new ScoreBox(Double.toString(question.getScore()),gamePanel));
                   gamePanel.setDisplayPanel(displayPanel);
                   gamePanel.remove(gamePanel.getBottomPanel());

                   ScoreBottomPanel scoreBottomPanel = new ScoreBottomPanel(gamePanel);
                   gamePanel.add(scoreBottomPanel, BorderLayout.PAGE_END);
                   gamePanel.setScoreBottomPanel(scoreBottomPanel);
                   gamePanel.revalidate();
                   gamePanel.repaint();
               }
            }else{
                index = questionsData.nextQuestion();
                questionsData.setIndex(index);
                Question question = questionsData.getQuestionList().get(index);
                questionsData.setIndex(index);
                gamePanel.remove(displayPanel);
                displayPanel =  new DisplayPanel();
                gamePanel.add(displayPanel);
                displayPanel.add(new QuestionBox(question.getQuestion()));
                i=0;
                List<AnswerBox> answerBoxList= new ArrayList<>();
                for(String ans: question.getAnswers()){
                    ++i;
                    AnswerBox ansBox = new AnswerBox(Integer.toString(i),ans);
                    answerBoxList.add(ansBox);
                    displayPanel.add(ansBox);
                }
                displayPanel.setAnswerBoxes(answerBoxList);
                gamePanel.setDisplayPanel(displayPanel);
                gamePanel.validate();
                gamePanel.repaint();
            }
        }
    }
}
