package graphics.player;

import javax.swing.*;

public class ShowAnswerBox extends JPanel {
    JLabel answer = new JLabel();
    JCheckBox userCheck= new JCheckBox();
    JCheckBox validCheck= new JCheckBox();
    String id;
    public ShowAnswerBox(String id , String ans,boolean userAns,boolean validAns){
        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        answer.setText(ans);
        this.id = id;
        userCheck.setEnabled(userAns);
        validCheck.setEnabled(validAns);
        add(validCheck);
        add(userCheck);
        add(answer);
    }

    public String getId() {
        return id;
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

}

