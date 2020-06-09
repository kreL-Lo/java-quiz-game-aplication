package graphics.player;

import controllers.listeners.button.gameListeners.Answer;
import controllers.listeners.button.gameListeners.Next;
import controllers.listeners.button.gameListeners.Previous;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    GamePanel gamePanel;
    JButton answer= new JButton("Answer");
    JButton previous = new JButton("Previous");
    JButton next = new JButton("Next");
    public BottomPanel(GamePanel gamePanel){
        this.gamePanel= gamePanel;
        setLayout(new GridLayout(0,3));
        answer.addActionListener(new Answer(gamePanel));
        previous.addActionListener(new Previous(gamePanel));
        next.addActionListener(new Next(gamePanel));
        add(previous);
        add(answer);
        add(next);
    }
}
