package graphics.panels.registerLogin;

import controllers.listeners.button.RegisterButtonListener;
import controllers.listeners.button.RegisterLoginButtonListener;
import graphics.MainFrame;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends  JPanel {
    JTextField messageBox = new JTextField("status");
    JButton loginButton = new JButton("Register");
    JButton register = new JButton("login");
    JTextField userField = new JTextField("user");
    JPasswordField passField = new JPasswordField("pass");
    JPasswordField passField1 = new JPasswordField("pass1");
    JPanel context = new JPanel();
    MainFrame mainFrame;
    public RegisterPanel(MainFrame mainFrame){
        this.mainFrame=mainFrame;
        init();
    }
    void init(){
        context.setLayout(new GridLayout(3,1));
        initComponents();
        register.addActionListener(new RegisterLoginButtonListener(
                this,mainFrame
        ));
        loginButton.addActionListener(new RegisterButtonListener(this,mainFrame));
        add(userField);
        add(passField);
        add(passField1);
        add(loginButton);
        add(register);
        add(messageBox);
        setAlignmentX(Component.LEFT_ALIGNMENT );
        setPreferredSize(new Dimension(100, 180));
        setMaximumSize(new Dimension(100, 180));
        setBorder(BorderFactory.createTitledBorder(""));
    }

    void initComponents(){
        userField.setPreferredSize(new Dimension(70,20));
        passField.setPreferredSize(new Dimension(70,20));
        passField1.setPreferredSize(new Dimension(70,20));
        messageBox.setEditable(false);
        messageBox.setPreferredSize(new Dimension(100,20));
    }

    public void setContext(JPanel context) {
        this.context = context;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setPassField1(JPasswordField passField1) {
        this.passField1 = passField1;
    }

    public JTextField getMessageBox() {
        return messageBox;
    }

    public JPasswordField getPassField1() {
        return passField1;
    }

    public void setMessageBox(JTextField messageBox) {
        this.messageBox = messageBox;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public void setPassField(JPasswordField passField) {
        this.passField = passField;
    }

    public void setRegister(JButton register) {
        this.register = register;
    }

    public void setUserField(JTextField userField) {
        this.userField = userField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegister() {
        return register;
    }

    public JPanel getContext() {
        return context;
    }

    public JTextField getPassField() {
        return passField;
    }

    public JTextField getUserField() {
        return userField;
    }
}
