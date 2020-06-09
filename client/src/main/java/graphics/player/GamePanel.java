package graphics.player;

import controllers.data.QuestionsData;
import graphics.MainFrame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    String topic;

    QuestionsData questionsData;
    BottomPanel bottomPanel ;
    ScoreBottomPanel scoreBottomPanel;
    MainFrame mainFrame;
    String token;
    DisplayPanel displayPanel;

    public GamePanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        bottomPanel = new BottomPanel(this);
        displayPanel = new DisplayPanel();
        setPreferredSize(new Dimension(600,600));
        add(bottomPanel,BorderLayout.PAGE_END);
        add(displayPanel,BorderLayout.CENTER);
    }
    public BottomPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(BottomPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }

    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    public void setDisplayPanel(DisplayPanel displayPanel) {
        this.displayPanel = displayPanel;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setQuestionsData(QuestionsData questionsData) {
        this.questionsData = questionsData;
    }

    public QuestionsData getQuestionsData() {
        return questionsData;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setScoreBottomPanel(ScoreBottomPanel scoreBottomPanel) {
        this.scoreBottomPanel = scoreBottomPanel;
    }

    public ScoreBottomPanel getScoreBottomPanel() {
        return scoreBottomPanel;
    }
}
