package graphics.player;

import controllers.clientController.UpdateTopics;
import graphics.MainFrame;
import graphics.lobby.LobbyPanel;
import graphics.lobby.StructurePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreBox extends JPanel {
    JButton jButton = new JButton("Lobby");
    JLabel txt = new JLabel("Score:");
    JLabel score = new JLabel();
    public ScoreBox(String sum,GamePanel gamePanel){
        setLayout(new GridLayout(0,2));
        score.setText(sum);
        add(txt);
        add(score);
        add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = gamePanel.getMainFrame();
                gamePanel.remove(gamePanel.getDisplayPanel());
                gamePanel.remove(gamePanel.getScoreBottomPanel());
                StructurePanel structure = mainFrame.getStructurePanel();
                structure.remove(gamePanel);
                UpdateTopics.updateTopics(structure,gamePanel.getToken());
            }
        });
        setBorder(BorderFactory.createTitledBorder(""));
        setPreferredSize(new Dimension(50,50));

    }

}
