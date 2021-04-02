package com.ws.ws.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ws.ws.helper.*;

public class Operateur 
{
    public Integer idOperateur;
    public String nomOperateur;
    public String prefixeOperateur;

    public Operateur(Integer id , String nom , String prefixe)
    {
        this.setIdOperateur(id);
        this.setNomOperateur(nom);
        this.setPrefixeOperateur(prefixe);
    }

    public Operateur(){}

    public void setIdOperateur(Integer x) { this.idOperateur = x;}
    public void setNomOperateur(String x) { this.nomOperateur = x;}
    public void setPrefixeOperateur(String x) { this.prefixeOperateur = x;}

    public Integer getIdOperateur() { return this.idOperateur;}
    public String getNomOperateur() { return this.nomOperateur;}
    public String getPrefixeOperateur() { return this.prefixeOperateur;}

    
    public Operateur getOperateur(Connection connection)throws Exception
    {
        Operateur op = null;
        PreparedStatement pstmt  = null;
        ResultSet resultSet = null;
        try 
        {
            if(connection == null)
            {
                connection = new MyConnection().getConnection();
            }
            String sql = "select * from operateur";
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            resultSet.next();
            op = new Operateur(resultSet.getInt("idoperateur"),resultSet.getString("nomoperateur"),resultSet.getString("prefixeoperateur"));
        } 
        catch (Exception ex) 
        {
            System.out.println("Message : " + ex.getMessage());
            throw ex;
        }
        finally
        {
            if(resultSet!=null)
            {
                resultSet.close();
            }
            if(pstmt!=null)
            {
                pstmt.close();
            }
        }
        return op;
    }
}

