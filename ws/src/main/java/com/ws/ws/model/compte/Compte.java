package com.ws.ws.model.compte;

import com.ws.ws.helper.*;
import com.ws.ws.model.mouvement.Mouvement;
import com.ws.ws.model.offre.AchatOffre;
import com.ws.ws.model.offre.DetailsAchatOffre;
import com.ws.ws.model.offre.DetailsOffre;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.expression.spel.ast.Operator;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Compte 
{
    int idCompte;
    String name;
    String number;
    String mdp;
    Timestamp date_inscription;
    double solde;

//********************************************************//

    public void setIdCompte(int x) { this.idCompte = x; }
    public void setName(String x) { this.name = x; }
    public void setNumber(String x) { this.number = x; }
    public void setMdp(String x) { this.mdp = x; }
    public void setDate_inscription( Timestamp x) { this.date_inscription = x; }
    public void setSolde(double x) { this.solde = x; }

    public int getIdCompte() { return this.idCompte; }
    public String getName() { return this.name; }
    public String getNumber() { return this.number; }
    public String getMdp() { return this.mdp; }
    public Timestamp getDate_inscription() { return this.date_inscription; }
    public double getSolde() { return this.solde; }

//********************************************************//

    public Compte(){}
    public Compte(int idC, String name, String number, String mdp, Timestamp date, double solde)
    {
        this.setIdCompte(idC);
        this.setName(name);
        this.setNumber(number);
        this.setMdp(mdp);
        this.setDate_inscription(date);
        this.setSolde(solde);
    }

//********************************************************//

    public void insert(Compte cpt)
    {
        MongoDatabase database = Mongo.getConnectionMongo();
        MongoCollection<Document> collection = database.getCollection("compte");
        Document document = new Document();
        document.put("idCompte",cpt.getIdCompte());
        document.put("nom",cpt.getName());
        document.put("numero",cpt.getNumber());
        document.put("mdp",cpt.getMdp());
        document.put("dateCreation",cpt.getDate_inscription());
        document.put("solde", cpt.getSolde());
        collection.insertOne(document);
    }

//********************************************************//

    public List<Document> getClient(String number) throws ParseException 
    {
        MongoDatabase database = Mongo.getConnectionMongo();
        MongoCollection<Document> collection = database.getCollection("compte");
        Document filter = new Document("number",number); //document.append()
        FindIterable<Document> iterDoc = null;
        if(number != "" )  iterDoc = collection.find(filter);
        else  iterDoc = collection.find();
        MongoCursor<Document> cursor = iterDoc.cursor();
        List<Document> res = new ArrayList<>();
        while(cursor.hasNext()){
                res.add(cursor.next());
        }
        return res;
    }

//********************************************************//

    public Document getClient(int idC) throws ParseException 
    {
        MongoDatabase database = Mongo.getConnectionMongo();
        MongoCollection<Document> collection = database.getCollection("compte");
        Document filter = new Document("idCompte",idC); //document.append()
        FindIterable<Document> iterDoc = null;
        iterDoc = collection.find(filter);
        MongoCursor<Document> cursor = iterDoc.cursor();
        Document res = cursor.next();
        return res;
    }
    //********************************************************//
    public void faireDepot(String solde, String idCompte)throws Exception{
        try
        {
            //MongoDatabase database = Mongo.getConnectionMongo();
            // MongoCollection<Document> collection = database.getCollection("compte");
            // Document filter = new Document("idCompe",  idCompte); //document.append()
            // Document setter = new Document("$inc", new Document("solde", new Double(solde).doubleValue() ));
            // collection.updateOne(filter, setter);
            int idMvt = Service.getNext("mouvement", "idMouvement") + 1;
            Mouvement m = new Mouvement(new Integer(idMvt).intValue(), new Integer(idCompte).intValue(), new Double(solde).doubleValue(), "D", null);
            m.insertMvt();
        }
        catch(Exception e)
        {
            throw new Exception("misy olana ato : " + e.getMessage());
        }
    }
//********************************************************//
    public ArrayList<Document>  getHistoriqueAppel(String id)throws Exception{
        ArrayList<Document> lh = new ArrayList<Document>();
        try{
            MongoDatabase database = Mongo.getConnectionMongo();
            MongoCollection<Document> collection = database.getCollection("historiqueAppel");
            Document filter = new Document("idCompte", new Integer(id).intValue());
            FindIterable<Document> iterDoc = collection.find(filter);
            MongoCursor<Document> cursor = iterDoc.cursor();
                while(cursor.hasNext())
                    lh.add (cursor.next());
        }catch(Exception e){
            throw new Exception (e.getMessage());
        }
        finally{}
        return lh;
    }
//********************************************************//
    public void acheterUnOffre(int idOffre, int idcompte) throws Exception
    {
        MongoDatabase database = Mongo.getConnectionMongo();
        //new AchatOffre(idOffre, idcompte).inserer(database);
        try {
            Connection connection = new MyConnection().getConnection();
            new AchatOffre(idOffre, idcompte).inserer(database);
            DetailsOffre[] ld = new DetailsOffre().getOffre(connection, idOffre);
            connection.close();
            for (int i =0;i<ld.length;i++)
                new DetailsAchatOffre( ld[i].getType(),ld[i].getValeur(), ld[i].getUnite()).inserer(database);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
