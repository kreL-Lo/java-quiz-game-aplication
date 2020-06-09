package graphics.panels.registerLogin;

import controllers.listeners.button.LoginButtonListener;
import controllers.listeners.button.LoginRegisterButtonListener;
import graphics.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    JTextField messageBox = new JTextField("status");
    JButton registerButton = new JButton("register");
    JButton login = new JButton("LOGIN");
    JTextField userField = new JTextField("user");
    JPasswordField passField = new JPasswordField("pass");
    JPanel context = new JPanel();
    MainFrame mainFrame;
    public LoginPanel(MainFrame mainframe){
        this.mainFrame= mainframe;
        context.setLayout(new GridLayout(3,1));
        initComponents();
        registerButton.addActionListener(new LoginRegisterButtonListener(this,mainFrame));
        login.addActionListener(new LoginButtonListener(this,mainFrame));
        add(userField);
        add(passField);
        add(login);
        add(registerButton);
        add(messageBox);
        setAlignmentX(Component.LEFT_ALIGNMENT );
        setPreferredSize(new Dimension(100, 150));
        setMaximumSize(new Dimension(100, 150));
        setBorder(BorderFactory.createTitledBorder(""));
    }

    void initComponents(){
        userField.setPreferredSize(new Dimension(70,20));
        passField.setPreferredSize(new Dimension(70,20));
        messageBox.setEditable(false);
        messageBox.setPreferredSize(new Dimension(100,20));
    }

    public JTextField getMessageBox() {
        return messageBox;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMessageBox(JTextField messageBox) {
        this.messageBox = messageBox;
    }

    public void setUserField(JTextField userField) {
        this.userField = userField;
    }

    public void setPassField(JPasswordField passField) {
        this.passField = passField;
    }

    public void setContext(JPanel context) {
        this.context = context;
    }

    public JTextField getUserField() {
        return userField;
    }

    public JTextField getPassField() {
        return passField;
    }

    public JPanel getContext() {
        return context;
    }

    public JButton getLogin() {
        return login;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }


    public void setLogin(JButton login) {
        this.login = login;
    }


    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }
}
