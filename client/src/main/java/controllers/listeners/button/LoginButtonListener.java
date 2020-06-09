package controllers.listeners.button;

import controllers.clientController.UpdateTopics;
import controllers.server.LoginController;
import graphics.MainFrame;
import graphics.lobby.StructurePanel;
import graphics.panels.registerLogin.LoginPanel;
import models.server.LoginType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonListener implements ActionListener {

    LoginPanel loginPanel ;
    StructurePanel structurePanel;
    MainFrame mainFrame;
    public LoginButtonListener(LoginPanel loginPanel, MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.loginPanel= loginPanel;
        this.structurePanel=mainFrame.getStructurePanel();
    }

    void initLobby(LoginType loginType){
        if(structurePanel == null){
            structurePanel = new StructurePanel(mainFrame);
            structurePanel.setToken(loginType.getToken());
            mainFrame.setStructurePanel(structurePanel);
        }
        mainFrame.getMainPanel().remove(loginPanel);
        mainFrame.getMainPanel().add(structurePanel);
        mainFrame.getMainPanel().revalidate();
        mainFrame.getMainPanel().repaint();
        UpdateTopics.updateTopics(structurePanel,structurePanel.getToken());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = loginPanel.getUserField().getText();
        String pass = loginPanel.getPassField().getText();
        System.out.println(user+ " "+pass);
        LoginType loginType = new LoginType();
        loginType.setUsername(user);
        loginType.setPassword(pass);
        loginType =  LoginController.registerController(loginType);
        loginPanel.getMessageBox().setText(loginType.getMessage());
        if(loginType.isLogin()){
            initLobby(loginType);
        }
        //

    }
}
