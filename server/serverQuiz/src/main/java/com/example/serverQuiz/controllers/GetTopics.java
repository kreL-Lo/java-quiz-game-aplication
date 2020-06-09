package com.example.serverQuiz.controllers;

import com.example.serverQuiz.DAO.QuestionDAO;
import com.example.serverQuiz.models.serverModels.mongo.Question;
import com.example.serverQuiz.models.serverModels.server.TopicsType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class GetTopics {
    @GetMapping("/topics")
    public TopicsType getTopics(){
        TopicsType topicsType = new TopicsType();
        List list = QuestionDAO.findTopics();
        List<String> topics = new ArrayList<>();
        for(Object top : list ){
            topics.add(top.toString());
        }
        topicsType.setTopics(topics);
        return topicsType;
    }
}
