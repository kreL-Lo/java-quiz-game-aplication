package controllers.listeners.button;

import controllers.clientController.InitGame;
import graphics.MainFrame;
import graphics.lobby.LobbyPanel;
import graphics.lobby.StructurePanel;
import graphics.player.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopicsButtonListener implements ActionListener {
    MainFrame mainFrame ;
    LobbyPanel lobbyPanel;
    String topic;
    public TopicsButtonListener(MainFrame mainFrame,LobbyPanel lobbyPanel,String topic){
        this.mainFrame =mainFrame;
        this.lobbyPanel = lobbyPanel;
        this.topic =topic;
    }

    void initGamePanel(StructurePanel structurePanel){
        GamePanel gamePanel = mainFrame.getStructurePanel().getGamePanel();

        gamePanel = new GamePanel(mainFrame);
        gamePanel.setToken(structurePanel.getToken());
        gamePanel.setTopic(topic);
        InitGame.initGame(gamePanel);
        structurePanel.setGamePanel(gamePanel);
        structurePanel.add(gamePanel);
        structurePanel.revalidate();
        structurePanel.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        StructurePanel structurePanel = mainFrame.getStructurePanel();
        structurePanel.remove(lobbyPanel);
        initGamePanel(structurePanel);

    }
}
