package com.ws.ws.model.offre;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ws.ws.helper.Service;

import org.bson.Document;

public class DetailsAchatOffre {
    String type;
    String idAchatOffre;
    double reste;
    String unite;

    public DetailsAchatOffre(){}

    public DetailsAchatOffre(String id, String type, double reste, String unite){
        this.setIdAchatOffre(id);
        this.setType(type);
        this.setReste(reste);
        this.setUnite(unite);
    }

    public DetailsAchatOffre(String type, double reste, String unite){
        this.setType(type);
        this.setReste(reste);
        this.setUnite(unite);
    }

    public void setType(String type){
        this.type = type;
    }
 
    public void setIdAchatOffre(String idAchat){
        this.idAchatOffre= idAchat ;
    }

    public void setReste(double reste){
        this.reste = reste;
    }
  
    public void setUnite(String unite){
        this.unite = unite;
    }

    public double getReste(){return this.reste;}
    public String getIdAchatOffre(){return this.idAchatOffre;}
    public String getType(){ return this.type;}
    public String getUnite(){return this.unite;}

    public void inserer(MongoDatabase connexion){
        MongoCollection<Document> collection = connexion.getCollection("detailAchatOffre");
        Document achat = new Document();
        int isa = Service.getNext("achatOffre", "idAchatOffre");
        achat.append("idAchatOffre", isa+1);
        achat.append("type", this.getType());
        achat.append("reste", this.getReste());
        achat.append("unite", this.getUnite());
        collection.insertOne(achat);
    }
}
