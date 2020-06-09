package com.example.serverQuiz.controllers;

import com.example.serverQuiz.DAO.UserDAO;
import com.example.serverQuiz.models.serverModels.server.RegisterType;
import com.example.serverQuiz.models.serverModels.mongo.User;
import com.google.common.hash.Hashing;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utils.Cripto;

import java.nio.charset.StandardCharsets;

@RestController
public class RegisterController {
    @PostMapping("/auth/register")
    public RegisterType registerController(@RequestBody RegisterType registerType){
        try{
            System.out.println(registerType.getUsername());
        User user = UserDAO.find(registerType.getUsername());
        if(user!=null){
            registerType.setLoggin(false);
            registerType.setMessage("Alredy known");}
        else {
            user = new User();
            registerType.setLoggin(true);
            String sha = Cripto.sha256(registerType.getPassword());
            user.setPassword(sha);
            user.setUsername(registerType.getUsername());
            user.setAdmin(false);

            UserDAO.create(user.getUsername(),sha);
            registerType.setMessage("Successfull register");
        }
        return registerType;
            }catch (Exception e){
            return error();
        }
    }
    static RegisterType error(){
        RegisterType registerType = new RegisterType();
        registerType.setMessage("Some error ");
        registerType.setLoggin(false);
        return registerType;
    }


}
