package com.ws.ws.model.mouvement;

import java.sql.Timestamp;

import com.ws.ws.model.compte.*;

import org.bson.Document;
public class MouvementCompte 
{
    Mouvement mvt;
    Compte cpt;

    public Mouvement getMvt() {return this.mvt;}
    public void setMvt(Mouvement x) {this.mvt = x;}

    public Compte getCpt() {return this.cpt;}
    public void setCpt(Compte x) {this.cpt = x;}

    public MouvementCompte(Mouvement x) throws Exception
    {
        Document yz = new Compte().getClient(x.idCompte);
        Compte y = new  Compte(
            (int)yz.getInteger("idCompte"), 
            yz.getString("name"), 
            yz.getString("number"), 
            yz.getString("mdp") ,
            (Timestamp) yz.getDate(" date"), 
            yz.getDouble("solde")
        );
        this.setMvt(x);
        this.setCpt(y);
    }
    
}
