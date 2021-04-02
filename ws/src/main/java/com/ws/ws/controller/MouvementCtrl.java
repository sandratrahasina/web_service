package com.ws.ws.controller;

import com.ws.ws.model.mouvement.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
@RequestMapping("/mouvement")
public class MouvementCtrl 
{
    @Autowired
    private MouvementCtrl()
    {}
    @PostMapping("/new_Mvt/depot") 
    public FormatResponse new_depot(@RequestBody Mouvement mvt) throws Exception 
    {
        if(mvt.getType().equals("R")) return new FormatResponse(400,"conflict",new Document("error","conflict between the type of the mouvement"));
        else{
            mvt.setDateValidation(null);
            try{
                new Mouvement().insertMvt(mvt);
                return new FormatResponse(200,"succes",new Document("succes","insert successfully"));
            }
            catch(Exception e){
                return new FormatResponse(400,"error",new Document("error",e.getMessage()));
            }
        }
    }

    @PostMapping("/new_Mvt/retrait") 
    public FormatResponse new_retrait(@RequestBody Mouvement mvt) throws Exception 
    {
        if(mvt.getType().equals("D")) return new FormatResponse(400,"conflict",new Document("error","conflict between the type of the mouvement"));
        else{
            try{
                new Mouvement().insertMvt(mvt);
                return new FormatResponse(200,"succes",new Document("succes","insert successfully"));
            }
            catch(Exception e){
                return new FormatResponse(400,"error",new Document("error",e.getMessage()));
            }
        }
    }

    @GetMapping("/all_mvt") // par personne
    public FormatResponse all_my_mvt(@RequestParam String number)
    {
        return new FormatResponse(400,"error",new Document("error","mbola vao ho amboarina"));
    }

    @GetMapping("/all_nonValider")
    public FormatResponse all_nonValider()
    {
        List<Document> ret = null;
        try
        {
            
            ret = new Mouvement().getNonValide();
        }
        catch(Exception e) 
        { 
            return new FormatResponse(400,"error",new Document("error" , e.getMessage())); 
        }
        return new FormatResponse(200,"succes",ret);
    }

    @PostMapping("/valider")
    public FormatResponse valider(@RequestParam int idMvt, @RequestParam String date)
    {
        List<Document> ret = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = (Date) dateFormat.parse(date);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            new Mouvement().setValidation(idMvt , timestamp);
            ret = new Mouvement().getNonValide();
        } catch(Exception e) 
        {
            return new FormatResponse(400,"error",new Document("error", e.getMessage()));
        }
        return new FormatResponse(200,"succes",ret);
    }
}
