package com.example.serverQuiz.controllers;

import com.example.serverQuiz.DAO.UserDAO;
import com.example.serverQuiz.models.serverModels.server.LoginType;
import com.example.serverQuiz.models.serverModels.server.RegisterType;
import com.example.serverQuiz.models.serverModels.mongo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utils.Cripto;
import utils.JWToken;
@RestController
public class LoginController {
    @PostMapping("/auth/login")
    public LoginType loginController(@RequestBody LoginType loginType){
        User user = UserDAO.find(loginType.getUsername());
        try {
            if (user == null) {
                loginType.setLoggin(false);
                loginType.setMessage("Not a known user");
            } else {
                String sha = Cripto.sha256(loginType.getPassword());
                if (sha.compareTo(user.getPassword()) != 0) {
                    loginType.setLoggin(false);
                    loginType.setMessage("Invalid password");
                } else {
                    String token = JWToken.create(user.getUsername(), user.getPassword());
                    user.setAdmin(false);
                    loginType.setLoggin(true);
                    loginType.setToken(token);
                    UserDAO.update(user);
                    loginType.setMessage("Successfull Login");
                }
            }
            return loginType;
        }
        catch (Exception e){
            System.out.println(e);
            return error();
        }
    }

    static LoginType error(){
        LoginType loginType = new LoginType();
        loginType.setMessage("Some error");
        loginType.setLoggin(false);
        return loginType;
    }
}
