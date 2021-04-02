package com.ws.ws.controller;


import com.ws.ws.model.offre.*;

import java.sql.Connection;
import java.sql.Timestamp;

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
@RequestMapping("/offre")
public class OffreCtrl 
{
    @Autowired
    private OffreCtrl(){
    }
    @GetMapping("/all_Offre") 
    public FormatResponse getA_offre() throws Exception 
    {
        return new FormatResponse(1,"ok",new Offre().getOffre(null));
    }

    @GetMapping("/detail_Offre") 
    public FormatResponse getD_offre(@RequestParam int idOffre) throws Exception 
    {
        return new FormatResponse(1,"ok",new DetailsOffre().getOffre(null, idOffre));
    }

    @GetMapping("/validite_Offre") 
    public FormatResponse getV_offre(@RequestParam int idOffre) throws Exception 
    {
        return new FormatResponse(1,"ok",new ValiditeOffre().getOffreValidite(null, idOffre));
    }

    @PostMapping("/add_offre")
    public FormatResponse postDevelloperOffre(@RequestParam  String nom, @RequestParam double prix, @RequestParam double duree, @RequestParam String unit_D, @RequestParam String status, @RequestParam int priorite ) throws Exception
    {
        try
        {
            int idOffre = new Offre().getLast();
            new Offre(idOffre , nom , prix , duree , unit_D , Timestamp.valueOf(status) , priorite ).insert(null);
            return new FormatResponse(200,"succes",new ListeOffre().getOffre(null));
        }
        catch(Exception e)
        {
            return new FormatResponse(400,"error",new Document("error", e.getMessage()));

        }
    }

    @PostMapping("/add_detail")
    public FormatResponse postDevelloperDetail(@RequestParam  String nom, @RequestParam double prix, @RequestParam double duree, @RequestParam String unit_D, @RequestParam String status, @RequestParam int priorite ) throws Exception
    {
        try
        {
            int idOffre = new Offre().getLast();
            new Offre(idOffre , nom , prix , duree , unit_D , Timestamp.valueOf(status) , priorite ).insert(null);
            return new FormatResponse(200,"succes",new ListeOffre().getOffre(null));
        }
        catch(Exception e)
        {
            return new FormatResponse(400,"error",new Document("error", e.getMessage()));

        }
    }

    @PostMapping("/add_validite")
    public FormatResponse postDevelloperValidite(@RequestParam  String nom, @RequestParam double prix, @RequestParam double duree, @RequestParam String unit_D, @RequestParam String status, @RequestParam int priorite ) throws Exception
    {
        try
        {
            int idOffre = new Offre().getLast();
            new Offre(idOffre , nom , prix , duree , unit_D , Timestamp.valueOf(status) , priorite ).insert(null);
            return new FormatResponse(200,"succes",new ListeOffre().getOffre(null));
        }
        catch(Exception e)
        {
            return new FormatResponse(400,"error",new Document("error", e.getMessage()));

        }
    }

    @PostMapping("/update")
    public FormatResponse puttDevelloper(@RequestBody ListeOffre liste) throws Exception
    {
        try
        {
            new ListeOffre().updatetListe(null, liste);
            return new FormatResponse(200,"succes",new ListeOffre().getOffre(null));
        }
        catch(Exception e)
        {
            return new FormatResponse(400,"error",new Document("error", e.getMessage()));
        }
    }
    
}
