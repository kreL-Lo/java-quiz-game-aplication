package controllers.listeners.button;

import graphics.MainFrame;
import graphics.panels.registerLogin.LoginPanel;
import graphics.panels.registerLogin.RegisterPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterLoginButtonListener implements ActionListener {
    LoginPanel loginPanel ;
    RegisterPanel registerPanel;
    MainFrame mainFrame;
    public RegisterLoginButtonListener(RegisterPanel registerPanel , MainFrame mainFrame){
        this.loginPanel = mainFrame.getLoginPanel();
        this.registerPanel= registerPanel;
        this.mainFrame = mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.getMainPanel().remove(registerPanel);
        mainFrame.getMainPanel().add(loginPanel);
        mainFrame.getMainPanel().revalidate();
        mainFrame.getMainPanel().repaint();
    }
}
