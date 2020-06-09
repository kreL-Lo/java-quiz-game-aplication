package controllers.server;

import models.server.RegisterType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RegisterController {
    public static RegisterType registerController(RegisterType registerType){
        final String uri = "http://localhost:9000/auth/register";
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<RegisterType> result =restTemplate
                .postForEntity(uri,registerType, RegisterType.class);

        registerType= (result.getBody());
        return registerType;
    }
}
