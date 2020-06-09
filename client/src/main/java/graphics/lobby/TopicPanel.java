package graphics.lobby;

import controllers.listeners.button.TopicsButtonListener;
import graphics.MainFrame;

import javax.swing.*;
import java.awt.*;

public class TopicPanel extends JPanel{
    JLabel name = new JLabel();
    JButton enterButton = new JButton("enter");
    MainFrame mainFrame;
    LobbyPanel lobbyPanel;
    public TopicPanel(MainFrame mainFrame,LobbyPanel lobbyPanel,String nume){
        this.mainFrame=mainFrame;
        this.lobbyPanel =lobbyPanel;
        setBorder(BorderFactory.createTitledBorder(""));
        setLayout(new GridLayout(2,1));
        name.setText(nume);
        init();
    }
    void init(){
        add(name);
        add(enterButton);

        enterButton.addActionListener( new TopicsButtonListener(mainFrame,lobbyPanel,name.getText()));
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setName(JLabel name) {
        this.name = name;
    }

}
