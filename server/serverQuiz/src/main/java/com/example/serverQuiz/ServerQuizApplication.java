package com.example.serverQuiz;

import com.example.serverQuiz.DAO.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerQuizApplication {

	public static void main(String[] args) {
		Database.connect();
		SpringApplication.run(ServerQuizApplication.class, args);
	}

}
