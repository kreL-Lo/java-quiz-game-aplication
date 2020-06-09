package controllers.listeners.button;

import controllers.server.RegisterController;
import graphics.MainFrame;
import graphics.panels.registerLogin.RegisterPanel;
import models.server.RegisterType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterButtonListener implements ActionListener {
    MainFrame mainFrame;
    RegisterPanel registerPanel;
    public RegisterButtonListener(RegisterPanel registerPanel , MainFrame mainFrame){
        this.registerPanel=registerPanel;
        this.mainFrame=mainFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String user = registerPanel.getUserField().getText();
        String pass = registerPanel.getPassField().getText();
        String  pass1 = registerPanel.getPassField1().getText();
        System.out.println(pass+" "+ pass1);
        if(pass.compareTo(pass1)!=0){
            registerPanel.getMessageBox().setText("no match on pass");
        }
        else{
            RegisterType registerType = new RegisterType();
            registerType.setUsername(user);
            registerType.setPassword(pass);
            registerType = RegisterController.registerController(registerType);
            registerPanel.getMessageBox().setText(registerType.getMessage());
        }

    }
}
