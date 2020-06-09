package com.example.serverQuiz.DAO;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static DB database;
    public static void connect(){
        MongoClientURI uri = new MongoClientURI(
                "mongodb://admin:admin@dungeons-shard-00-00-qmexh.mongodb.net:27017,dungeons-shard-00-01-qmexh.mongodb.net:27017,dungeons-shard-00-02-qmexh.mongodb.net:27017/test?ssl=true&replicaSet=Dungeons-shard-0&authSource=admin&retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        database = mongoClient.getDB("test");

    }

    public static ObjectId createDocument(String collectionName, DBObject document){
        DBCollection collection = database.getCollection(collectionName);
        collection.insert(document);
        ObjectId id = (ObjectId)document.get( "_id" );

        return id;
    }
    public static DBObject findDocument(String collectionName,DBObject query){
        DBCollection collection =  database.getCollection(collectionName);
        return collection.findOne(query);
    }
    public static void updateDocument(String collectionName,DBObject query, DBObject document){
        DBCollection collection =  database.getCollection(collectionName);
        collection.update(query,document);
    }
    public static List<DBObject> getAllDocuments(String collectionName){
        List<DBObject> objects = new ArrayList<>();
        DBCollection collection = database.getCollection(collectionName);
        DBCursor cursor =collection.find();
        while(cursor.hasNext()){
            objects.add(cursor.next());
        }
        return objects;
    }
    public static List getDistinctList(String collectionName,String query){
        List<DBObject> objects = new ArrayList<>();
        DBCollection collection = database.getCollection(collectionName);
        List list = collection.distinct(query);
        return list;
    }
    public static List<DBObject> getList(String collectionName,DBObject querry){
        List<DBObject> objects = new ArrayList<>();
        DBCollection collection = database.getCollection(collectionName);
        DBCursor cursor =collection.find(querry).limit(10);
        while(cursor.hasNext()){
            objects.add(cursor.next());
        }
        return objects;
    }
    public static void delete(String collectionName, DBObject querry){
        DBCollection collection =  database.getCollection(collectionName);
        collection.remove(querry);
    }

}