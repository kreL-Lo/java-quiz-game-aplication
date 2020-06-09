package controllers.server;

import models.server.LoginType;
import models.server.RegisterType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LoginController {
    public static LoginType registerController(LoginType loginType) {


        final String uri = "http://localhost:9000/auth/login";
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<LoginType> result =restTemplate
                .postForEntity(uri,loginType, LoginType.class);

        loginType= (result.getBody());


        return loginType;
    }
}
