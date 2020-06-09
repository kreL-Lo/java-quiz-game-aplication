package com.example.serverQuiz.DAO;

import com.example.serverQuiz.models.serverModels.mongo.User;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class UserDAO {
    static String collectionName ="User";
    public static void create(String username,String password){
        BasicDBObject document = new BasicDBObject();
        document.put("username",username);
        document.put("password",password);
        Database.createDocument(collectionName,document);
    }

    public static User find(String username){
        try{
            Gson gson = new Gson();
            BasicDBObject query = new BasicDBObject();
            query.put("username", username);
            DBObject user = Database.findDocument(collectionName,query);
            User user1 = gson.fromJson(user.toString(), User.class);

            return user1;}
        catch (Exception e){
            return null;
        }
    }
    public static void update(User user){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        DBObject dbObject = (DBObject) JSON.parse(json);
        BasicDBObject query = new BasicDBObject();
        query.put("username", user.getUsername());
        Database.updateDocument(collectionName,query,dbObject);
    }
}
