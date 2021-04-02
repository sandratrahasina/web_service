package com.ws.ws.model.Statistique;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.ws.ws.helper.Mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import com.mongodb.client.AggregateIterable;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.w3c.dom.DocumentFragment;

public class Statistique 
{
    int[] x;
    int[] y;
    String name;

    public int[] getX() { return this.x; }
    public void setX(int[] xval) { this.x = xval; }

    public int[] getY() { return this.y; }
    public void setY(int[] yval) { this.x = yval; }

    public String getName() { return this.name; }
    public void setName(String x) { this.name = x; }

    public Statistique(String name, int[] xv, int[] yv)
    {
        this.x = xv;
        this.y = yv;
        this.name = name;
    }

    public Statistique(){}

   
    public ArrayList<Document> getStatistique(MongoCollection<Document> collection, String key, Object value)
    {
        ArrayList<Document> lh = new ArrayList<Document>();
        AggregateIterable<Document> iterDoc = null;
        iterDoc = collection.aggregate(Arrays.asList(
            Aggregates.group("$idOffre", Accumulators.sum("sum", 1))
        ) );
        MongoCursor<Document> cursor = iterDoc.cursor();
                while(cursor.hasNext())
                    lh.add (cursor.next());
        return lh;
    }

    
}
