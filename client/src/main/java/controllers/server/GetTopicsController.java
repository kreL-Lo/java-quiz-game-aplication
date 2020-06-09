package controllers.server;

import models.server.LoginType;
import models.server.TopicsType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetTopicsController {
    public static TopicsType getTopics() {

        TopicsType topicsType =null;
        final String uri = "http://localhost:9000/topics";
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<TopicsType> result =restTemplate
                .getForEntity(uri,TopicsType.class);

        topicsType= (result.getBody());
        return topicsType;
    }
}
