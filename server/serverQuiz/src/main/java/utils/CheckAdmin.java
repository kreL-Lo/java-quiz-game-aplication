package utils;

import com.auth0.jwt.JWT;
import com.example.serverQuiz.DAO.UserDAO;
import com.example.serverQuiz.models.serverModels.mongo.Auth;
import com.example.serverQuiz.models.serverModels.mongo.User;

public class CheckAdmin {
    public static boolean checkAdmin(Auth auth  ){
        User u = UserDAO.find(auth.getUsername());
        if(u.isAdmin()){
            return true;
        }
        return  false;
    }
}
