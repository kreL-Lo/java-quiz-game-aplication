package controllers.server;

import models.server.InitGameType;
import models.server.LoginType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class InitGameController {
    public static InitGameType initGame(InitGameType initGameType) {
        final String uri = "http://localhost:9000/initGame";
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<InitGameType> result =restTemplate
                .postForEntity(uri,initGameType, InitGameType.class);

        initGameType= (result.getBody());
        return initGameType;
    }
}
