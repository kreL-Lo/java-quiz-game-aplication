package com.example.serverQuiz.DAO;

import com.example.serverQuiz.models.serverModels.mongo.Question;
import com.example.serverQuiz.models.serverModels.mongo.User;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import javax.xml.crypto.Data;
import java.awt.image.DataBuffer;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    static String collectionName = "Question";
    public static void create(int id){
        BasicDBObject document = new BasicDBObject();
        document.put("id",id);
        Database.createDocument(collectionName,document);
    }
    public static Question find(int id){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("id", id);
        DBObject question1 = Database.findDocument(collectionName,query);
        Question question = gson.fromJson(question1.toString(), Question.class);
        return question;
    }
    public static Question find(String q){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("question", q);
        DBObject question1 = Database.findDocument(collectionName,query);
        Question question = gson.fromJson(question1.toString(), Question.class);
        return question;
    }

    public static List findTopics(){
        return Database.getDistinctList(collectionName,"topic");
    }
    public static  List<Question>  findQuestions(String topic){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("topic", topic);
        List<DBObject> list =  Database.getList(collectionName,query);
        List<Question> question = new ArrayList<>(list.size());
        for(DBObject obj : list){
            Question question1 = gson.fromJson(obj.toString(), Question.class);
            question.add(question1);
        }
        return  question;
    }

    public static  List<Question>  findAnsweredQuestions(String topic,Boolean answered){
        Gson gson = new Gson();
        BasicDBObject query = new BasicDBObject();
        query.put("topic", topic);
        query.put("answered",answered);
        List<DBObject> list =  Database.getList(collectionName,query);
        List<Question> question = new ArrayList<>(list.size());
        for(DBObject obj : list){
            Question question1 = gson.fromJson(obj.toString(), Question.class);
            question.add(question1);
        }
        return  question;
    }


    public static void update(Question question){
        Gson gson = new Gson();
        String json = gson.toJson(question);
        DBObject dbObject = (DBObject) JSON.parse(json);
        BasicDBObject query = new BasicDBObject();
        query.put("id", question.getId());
        Database.updateDocument(collectionName,query,dbObject);
    }
    public static void delete(Question question){
        Gson gson = new Gson();
        String json = gson.toJson(question);
        DBObject dbObject = (DBObject) JSON.parse(json);
        BasicDBObject query = new BasicDBObject();
        query.put("answered", question.isAnswered());
        query.put("id", question.isAnswered());
        Database.delete(collectionName,query);
    }
}
