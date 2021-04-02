package com.ws.ws.model.mouvement;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.ws.ws.helper.Mongo;

import org.bson.Document;
import org.springframework.expression.spel.ast.Operator;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.bson.Document;

public class Mouvement 
{
    int idmouvement;
    int idCompte;
    double argent;
    String type; // D pour depot , R pour retrait
    Timestamp dateValidation;

//********************************************************//

    public void setIdmouvement(int x) { this.idmouvement = x; }
    public void setIdCompte(int x) { this.idCompte = x; }
    public void setArgent(double x) { this.argent = x; }
    public void setType(String x) { this.type = x; }
    public void setDateValidation(Timestamp x) 
    { 
        if(this.type.equals("D")) this.dateValidation = null;
        else this.dateValidation = x; 
    }

    public int getIdmouvement( ) { return this.idmouvement ; }
    public int getIdCompte( ) { return this.idCompte ; }
    public double getArgent( ) { return this.argent ; }
    public String getType( ) { return this.type ; }
    public Timestamp getDateValidation( ) { return this.dateValidation ; }

//********************************************************//

    public Mouvement(){}

    public Mouvement(int idMvt, int idCpt, double arg, String type, Timestamp dv)
    {
        this.setIdmouvement(idMvt);
        this.setIdCompte(idCpt);
        this.setArgent(arg);
        this.setType(type);
        this.setDateValidation(dv);
    }

//********************************************************//
    public void insertMvt(Mouvement x) throws Exception
    {
        try
        {
            MongoDatabase database = Mongo.getConnectionMongo();
            MongoCollection<Document> collection = database.getCollection("mouvement");
            Document document = new Document();
            document.put("idMouvement", x.getIdmouvement());
            document.put("idCompte", x.getIdCompte());
            document.put("argent", x.getArgent());
            document.put("type", x.getType());
            if(x.getType().equals("D")) document.put("dateValidation", null);
            else document.put("dateValidation", x.getDateValidation());
            collection.insertOne(document);
        }
        catch(Exception e)
        {
            throw new Exception("misy olana eto : "+e.getMessage());
        }
        
    }

    public void insertMvt() throws Exception
    {
        try
        {
            MongoDatabase database = Mongo.getConnectionMongo();
            MongoCollection<Document> collection = database.getCollection("mouvement");
            Document document = new Document();
            document.put("idMouvement", this.getIdmouvement());
            document.put("idCompte", this.getIdCompte());
            document.put("argent", this.getArgent());
            document.put("type", this.getType());
            if(this.getType().equals("D")) document.put("dateValidation", null);
            else document.put("dateValidation", this.getDateValidation());
            collection.insertOne(document);
        }
        catch(Exception e)
        {
            throw new Exception("misy olana eto : "+e.getMessage());
        }
        
    }

//********************************************************//

    public List<Document> getNonValide()
    {
        MongoDatabase database = Mongo.getConnectionMongo();
        MongoCollection<Document> collection = database.getCollection("mouvement");
        Document filter = new Document("dateValidation", null); //document.append()
        FindIterable<Document> iterDoc  = collection.find(filter);
        MongoCursor<Document> cursor = iterDoc.cursor();
        List<Document> res = new ArrayList<>();
        while(cursor.hasNext()){
                res.add(cursor.next());
        }
        return res; 
    }

    public void setValidation(int idMvt , Timestamp temps) throws Exception
    {
        try
        {
            MongoDatabase database = Mongo.getConnectionMongo();
            MongoCollection<Document> collection = database.getCollection("mouvement");
            Document filter = new Document("idMouvement", idMvt); //document.append()
            Document setter = new Document("dateValidation", temps);
            collection.updateOne(filter, setter);
        }
        catch(Exception e)
        {
            throw new Exception("misy olana ato : " + e.getMessage());
        }
    }


}
