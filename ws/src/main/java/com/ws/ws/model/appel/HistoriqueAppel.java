package com.ws.ws.model.appel;

import com.ws.ws.helper.Mongo;
import java.util.ArrayList;
import java.util.Date;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class HistoriqueAppel {
    String idCompte;
    String idDestinataire; //id du numero appele
    int duree;
    Date dateAppel;
    
    public HistoriqueAppel(){}
    
    public HistoriqueAppel(String idDestinataire, String duree, String dateAppel){
        this.setNumDestinataire(idDestinataire);
        this.setDuree(duree);
        this.setDateAppel(dateAppel);
    }
    
    public void setDuree(String duree){
        this.duree = new Integer(duree).intValue() ;
    }
    
    public void setDateAppel(String dateAppel){
        this.dateAppel = new Date (dateAppel);
    }
    
    public void setNumDestinataire(String idDestinataire){
        this.idDestinataire = idDestinataire;
    }
    
    public int getDuree(){
        return this.duree;
    }
    
    public Date getDateAppel(){
        return this.dateAppel;
    }
    
    public String getIdDestination(){
        return this.idDestinataire;
    }
 
} 

