package utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.serverQuiz.models.serverModels.mongo.Auth;

import java.util.List;
import java.util.Map;

public class JWToken {
    static String secret= "SUPER_SECRET_KEY";
    static Algorithm algorithm = Algorithm.HMAC256(secret);
    public static String create(String username,String password){
        try{
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("id",username)
                    .withClaim("pw",password)
                    .sign(algorithm);
            return  token;
        }catch (Exception e){
            return null;
        }
    }
    public static Auth decode(String token){
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            return new Auth(jwt.getClaim("id").asString(),jwt .getClaim("pw").asString());
        } catch (JWTVerificationException exception){
            return null;
        }
    }
}