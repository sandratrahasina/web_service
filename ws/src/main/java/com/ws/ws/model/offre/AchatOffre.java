package com.ws.ws.model.offre;

import java.util.Date;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ws.ws.helper.*;

import org.bson.Document;

public class AchatOffre 
{
    int idOffre;
    int idCompte;
    Date dateAchat;
    DetailsAchatOffre[] detailsAchat;

    public void setIdOffre(int idOffre){
        this.idOffre = new Integer(idOffre).intValue();
    }
    public void setIdCompte(int idCompte){
        this.idCompte = new Integer(idCompte).intValue();
    }
    public void setDateAchat(String dateAchat){
        this.dateAchat = new Date(dateAchat);
    }
    public AchatOffre(){}
    public AchatOffre(int idOffre, int idClient){
        this.setIdOffre(idOffre);
        this.setIdCompte(idClient);
    }
    public int getIdOffre(){return this.idOffre;}
    public int getIdCompte(){return this.idCompte;}
    public void inserer(MongoDatabase connexion)
    {
        MongoCollection<Document> collection = connexion.getCollection("achatOffre");
        Document achat = new Document();
        int isa = Service.getNext("achatOffre", "idAchatOffre");
        achat.append("idAchatOffre", isa+1 );
        achat.append("idCompte", this.getIdOffre());
        achat.append("idOffre", this.getIdCompte());
        achat.append("dateAchat","new Date()");
        collection.insertOne(achat);
    }
}
