package graphics.player;



import controllers.listeners.button.scoreBoard.Next;
import controllers.listeners.button.scoreBoard.Previous;

import javax.swing.*;
import java.awt.*;

public class ScoreBottomPanel extends JPanel {
    GamePanel gamePanel;
    JButton previous = new JButton("Previous");
    JButton next = new JButton("Next");
    public ScoreBottomPanel(GamePanel gamePanel){
        this.gamePanel= gamePanel;
        setLayout(new GridLayout(0,2));
        previous.addActionListener(new Previous(gamePanel));
        next.addActionListener(new Next(gamePanel));
        add(previous);
        add(next);
    }
}