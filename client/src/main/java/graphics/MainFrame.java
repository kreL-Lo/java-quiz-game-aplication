package graphics;


import graphics.lobby.StructurePanel;
import graphics.panels.registerLogin.LoginPanel;
import graphics.panels.registerLogin.RegisterPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    JPanel mainPanel = new JPanel();
    StructurePanel structurePanel;
    LoginPanel loginPanel ;
    RegisterPanel registerPanel ;
    void init(){

        loginPanel= new LoginPanel(this);
        mainPanel.add(loginPanel);
        add(mainPanel);

    }
    public MainFrame(){
        setSize(700,700);
        init();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setStructurePanel(StructurePanel structurePanel) {
        this.structurePanel = structurePanel;
    }

    public StructurePanel getStructurePanel() {
        return structurePanel;
    }

    public StructurePanel getLobbyPanel() {
        return structurePanel;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public RegisterPanel getRegisterPanel() {
        return registerPanel;
    }



    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
