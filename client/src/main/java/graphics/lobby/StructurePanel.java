package graphics.lobby;

import graphics.MainFrame;
import graphics.player.GamePanel;

import javax.swing.*;
import java.awt.*;

public class StructurePanel extends JPanel {
    String token;
    MainFrame mainFrame;
    LobbyPanel lobbyPanel ;
    GamePanel gamePanel;
    public StructurePanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        //init();
    }
    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setLobbyPanel(LobbyPanel lobbyPanel) {
        this.lobbyPanel = lobbyPanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }



    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public LobbyPanel getLobbyPanel() {
        return lobbyPanel;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
