package controllers.server;

import models.server.AnswerQuestionType;
import models.server.InitGameType;
import models.server.TopicsType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AnswerController {
    public static AnswerQuestionType answerQuestion(AnswerQuestionType answerQuestionType) {
        final String uri = "http://localhost:9000/answerQuestion";
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<AnswerQuestionType> result =restTemplate
                .postForEntity(uri,answerQuestionType, AnswerQuestionType.class);
        answerQuestionType= (result.getBody());
        return answerQuestionType;
    }
}
