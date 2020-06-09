package com.example.serverQuiz.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.DummyInsert;

@RestController
public class DummyInit {
    @GetMapping("/init")
    public String test(){
        DummyInsert.init();
        return "done";
    }

}
