package com.ws.ws.helper;

import java.util.Arrays;
import com.mongodb.client.*;
import org.bson.Document;

public class Service 
{
    public static int getNext(String collectionName,String field)
    {
        MongoDatabase database = Mongo.getConnectionMongo();
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Object isa  = collection.aggregate(
            Arrays.asList(new Document("$group", new Document("_id", null)
            .append("max", new Document("$max", "$"+field)))))
            .first().get("max");
        if(isa.equals(new Double(0.0)))
        {
            Double x = (Double)isa;
            return x.intValue();
        } 
        if(isa.equals(null)) return 1;
        
        return Integer.parseInt(isa.toString());
    }

    // public static Document getCount(String collectionName,String field)
    // {
    //     MongoDatabase database = Mongo.getConnectionMongo();
    //     MongoCollection<Document> collection = database.getCollection(collectionName);
    //     Document isa  = collection.aggregate(
    //         Arrays.asList(new Document("$group", new Document("_id", null)
    //         .append("max", new Document("$count", "$"+field)))))
    //         .first();
    //     return isa;
    // } 
}
