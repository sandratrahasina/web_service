package com.ws.ws.controller;

import com.ws.ws.model.Statistique.*;
import com.ws.ws.model.compte.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.ws.ws.helper.*;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired; 

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/statistique")
public class StatistiqueCtrl 
{
    // public Statistique getStat(String collectionTarget, String date , String attribut)
    // {
    //     MongoDatabase database = Mongo.getConnectionMongo();
    //     MongoCollection<Document> collection = database.getCollection("achatOffre");
    //     DocumentFragment filter = new Document("date", "count:{$sum:1}");z
        
    // }

    @Autowired
    private StatistiqueCtrl(){
    }
    @GetMapping("/stat") 
    //public FormatResponse getA_Clients(@RequestParam String col , @RequestParam String key , @RequestParam Object value ) throws Exception 
    public FormatResponse getA_Clients()
    {
        try
        {
            MongoCollection<Document> collection = Mongo.getConnectionMongo().getCollection("achatOffre");
            ArrayList<Document> doc = new Statistique().getStatistique(collection , "", "");
            return new FormatResponse(200,"succes", doc);
        } 
        catch(Exception e)
        {
            return new FormatResponse(400,"succes", "misy erreur ato : "+e.getMessage());
        }
        
    }
}
