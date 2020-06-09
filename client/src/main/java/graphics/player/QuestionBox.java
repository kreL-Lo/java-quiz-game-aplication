package graphics.player;

import javax.swing.*;
import java.awt.*;

public class QuestionBox extends JPanel {
    JLabel question = new JLabel();
    public QuestionBox(String text){
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        question.setText(text);
        setPreferredSize(new Dimension(20,20));
        question.setPreferredSize(new Dimension(20,20));
        add(question);
    }
}
