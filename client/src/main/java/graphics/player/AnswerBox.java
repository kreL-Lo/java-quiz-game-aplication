package graphics.player;

import javax.swing.*;
import java.awt.*;

public class AnswerBox extends JPanel {
    JLabel answer = new JLabel();
    JCheckBox checkBox= new JCheckBox();
    String id;
    public AnswerBox(String id , String ans){
        answer.setText(ans);
        this.id = id;
        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        add(checkBox);
        add(answer);
    }

    public String getId() {
        return id;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public JLabel getAnswer() {
        return answer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAnswer(JLabel answer) {
        this.answer = answer;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
