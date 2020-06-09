package controllers.listeners.button;

import graphics.MainFrame;
import graphics.panels.registerLogin.LoginPanel;
import graphics.panels.registerLogin.RegisterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.LinkOption;

public class LoginRegisterButtonListener implements ActionListener {
    LoginPanel loginPanel ;
    RegisterPanel registerPanel;
    MainFrame mainFrame;
    public LoginRegisterButtonListener(LoginPanel loginPanel , MainFrame mainFrame){
        this.loginPanel = loginPanel;
        this.registerPanel= mainFrame.getRegisterPanel();
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(registerPanel == null){//singleton ish
            registerPanel = new RegisterPanel(mainFrame);
        }
        mainFrame.getMainPanel().remove(loginPanel);
        mainFrame.getMainPanel().add(registerPanel);
        mainFrame.getMainPanel().revalidate();
        mainFrame.getMainPanel().repaint();
    }
}
