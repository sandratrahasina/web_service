package com.ws.ws.controller;

import com.ws.ws.model.*;
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
import org.springframework.beans.factory.annotation.Autowired; 

import org.bson.Document;


@RestController
@RequestMapping("/start")
public class OperateurCtrl
{
    @Autowired
    private OperateurCtrl(){
    }
    @GetMapping("/operateur") 
    public Operateur getOperator() throws Exception 
    {
        Operateur azo = new Operateur().getOperateur(null);
        return azo ;
    }
    @GetMapping("/dev")
    public Document getDevelloper() throws Exception
    {
        Document ret = new Mongo().getTest();
        return ret;
    }
    @PostMapping("/add")
    public String postDevelloper(@RequestParam String name, @RequestParam String etu) throws Exception
    {
        try
        {
            new Mongo().insertMessages(name, etu);
        }
        catch(Exception ex)
        {
            throw new Exception("misy olana ehh");
        }
        return "succes";
    }
}
