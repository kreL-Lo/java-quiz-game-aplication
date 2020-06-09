package graphics.lobby;


import graphics.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LobbyPanel extends JPanel {
    MainFrame mainFrame;
    public LobbyPanel(MainFrame mainFrame){
        setLayout(new BorderLayout());
        this.mainFrame = mainFrame;
    }

}
