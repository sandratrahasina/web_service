package com.ws.ws.controller;

import com.ws.ws.model.compte.*;
import com.ws.ws.model.appel.*;

import java.sql.Timestamp;
import java.util.List;

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
@RequestMapping("/compte")

public class CompteCtrl {
    @Autowired
    private CompteCtrl(){
    }
    @GetMapping("/all_Comptes") 
    public FormatResponse getA_Clients() throws Exception 
    {
        return new FormatResponse(200,"succes",new Compte().getClient(""));
    }
    @GetMapping("/all_Compte") 
    public FormatResponse getA_Client(@RequestParam String number) throws Exception 
    {
        List<Document> ret = null;
        try
        { 
            ret = new Compte().getClient(number) ; 
        }
        catch(Exception e) 
        { 
            ret.add(new Document("error", e.getMessage())); 
        }
        return new FormatResponse(200,"succes",ret);
    }
    @PostMapping("/new_Compte")
    public FormatResponse new_Compte(@RequestParam String name ,@RequestParam String number, @RequestParam String mdp, @RequestParam String date, @RequestParam double solde) throws Exception
    {
        int idC = Service.getNext("compte", "idCompte");
        Compte compte = new Compte(idC, name, number,  mdp,  Timestamp.valueOf(date),  solde);
        try 
        { 
            new Compte().insert(compte); 
        }
        catch(Exception e) 
        { 
            return new FormatResponse(400,"error",new Document("error" , e.getMessage())); 
        }
        return new FormatResponse(200,"succes",new Document("succes", compte.getNumber()+" has been created"));
    }

    @PostMapping("/depot")
    public FormatResponse depot(@RequestParam String solde ,@RequestParam String idCompte) throws Exception
    {
        try 
        { 
            // Service.getNext("mouvement", "idMouvement");
            new Compte().faireDepot(solde, idCompte); 
        }
        catch(Exception e) 
        { 
            return new FormatResponse(400,"error",new Document("error" , e.getMessage())); 
        }
        return new FormatResponse(200,"succes",new Document("succes", "depot n°" + Service.getNext("mouvement", "idMouvement") + " has been created"));
    }

    @GetMapping("/historique_appel") 
    public FormatResponse getHistoriqueAppel(@RequestParam String idCompte) throws Exception 
    {
        return new FormatResponse(200,"succes",new Compte().getHistoriqueAppel(idCompte));
    }
    

    @PostMapping("/acheterOffre")
    public FormatResponse acheterOffre(@RequestParam int idOffre ,@RequestParam int idCompte ) throws Exception
    {
        try 
        { 
            new Compte().acheterUnOffre(idOffre, idCompte); 
        }
        catch(Exception e) 
        { 
            return new FormatResponse(401,"error",new Document("error" , e.getMessage())); 
        }
        return new FormatResponse(200,"succes",new Document("succes", idCompte + " has been created"));
    }

}
