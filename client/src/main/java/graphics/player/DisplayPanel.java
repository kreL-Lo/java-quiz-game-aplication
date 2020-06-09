package graphics.player;

import controllers.listeners.button.gameListeners.Answer;
import models.server.mongo.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DisplayPanel extends JPanel {
    List<AnswerBox> answerBoxes;
    JLabel score = new JLabel("score");
    public DisplayPanel(){
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
    }

    public void setAnswerBoxes(List<AnswerBox> answerBoxes) {
        this.answerBoxes = answerBoxes;
    }

    public List<AnswerBox> getAnswerBoxes() {
        return answerBoxes;
    }
}
