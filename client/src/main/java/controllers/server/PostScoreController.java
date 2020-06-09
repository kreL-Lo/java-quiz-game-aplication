package controllers.server;

import models.server.InitGameType;
import models.server.PostScoreType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostScoreController {
    public static PostScoreType postScore(PostScoreType postScoreType) {
        final String uri = "http://localhost:9000/postScore";
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<PostScoreType> result =restTemplate
                .postForEntity(uri,postScoreType, PostScoreType.class);
        postScoreType= (result.getBody());
        return postScoreType;
    }
}
