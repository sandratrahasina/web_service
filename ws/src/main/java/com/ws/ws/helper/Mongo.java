package com.ws.ws.helper;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.expression.spel.ast.Operator;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Mongo 
{
    public Mongo(){}

    public static MongoDatabase getConnectionMongo() {
        String url = "mongodb://localhost:27017";
        MongoClient mongo = MongoClients.create(url);
        MongoDatabase database = mongo.getDatabase("CloudProject");
        return database;
}

    // public static MongoDatabase getConnectionMongo() 
    // {
    //     String url = "mongodb+srv://rakoto:09042020@cluster0.arrrf.mongodb.net/telephonie_mobile?retryWrites=true&w=majority";
    //     MongoClient mongoClient = MongoClients.create( url );
    //     MongoDatabase database = mongoClient.getDatabase("telephonie_mobile");
    //     return database;
    // }

    public Document getTest()
    {
        MongoDatabase database = getConnectionMongo();
        MongoCollection<Document> collection = database.getCollection("developers");
        Document filter = new Document("name","Onintsoa");
        FindIterable<Document> iterDoc = collection.find(filter);
        MongoCursor<Document> cursor = iterDoc.cursor();

        Document doc = new Document();
        while(cursor.hasNext())
        {
            doc = cursor.next();
        }
        return doc;
    }

    public void insertMessages(String name,String etu) throws ParseException 
    {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        MongoDatabase database = getConnectionMongo();
        MongoCollection<Document> collection = database.getCollection("developers");
        Document document = new Document();
        document.put("name",name);
        document.put("etu",etu);
        collection.insertOne(document);
    }

}


