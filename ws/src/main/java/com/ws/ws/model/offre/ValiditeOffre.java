package com.ws.ws.model.offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ws.ws.helper.*;

public class ValiditeOffre 
{
    //idoffre | h_debut | h_fin
    int idOffre;
    int h_debut;
    int h_fin;

//********************************************************//

    public void setIdOffre(int x) { this.idOffre = x; }
    public void setH_debut(int x) { this.h_debut = x; }
    public void setH_fin(int x) { this.h_fin = x; }

    public int getIdOffre() { return this.idOffre; }
    public int getH_debut() { return this.h_debut; }
    public int getH_fin() { return this.h_fin; }

//********************************************************//

    public ValiditeOffre(){}
    public ValiditeOffre(int id, int h_d, int h_f)
    {
        this.idOffre = id;
        this.h_debut = h_d;
        this.h_fin = h_f;
    }

//********************************************************//

    public void insert(Connection connection , ValiditeOffre offre) throws Exception
    {
        PreparedStatement pstmt  = null;
        String sql = "INSERT INTO validiteoffre VALUES(?,?,?,?)";
        try
        {
            if(connection == null) { connection = new MyConnection().getConnection(); }
            pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, offre.getIdOffre());
                pstmt.setInt(2, offre.getH_debut());
                pstmt.setInt(3, offre.getH_fin());
            pstmt.executeUpdate();
        } 
        catch (Exception ex) 
        {
            throw ex;
        }
        finally
        {
            if(pstmt!=null)
            {
                pstmt.close();
            }
        }
    } 

//********************************************************//

    public void delete(Connection connection , ValiditeOffre offre) throws Exception
    {
        PreparedStatement pstmt  = null;
        String sql = "delete from validiteoffre where idOffre = ?";

        try
        {

            if(connection == null) { connection = new MyConnection().getConnection(); }
            pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, offre.getIdOffre());
            pstmt.executeUpdate();
        } 
        catch (Exception ex) 
        {
            throw ex;
        }
        finally
        {
            if(pstmt!=null)
            {
                pstmt.close();
            }
        }
    }

//********************************************************//

    public void update(Connection connection , ValiditeOffre offre) throws Exception
    {
        PreparedStatement pstmt  = null;
        String sql = "INSERT INTO validiteoffre VALUES(?,?,?)";

        try
        {
            if(connection == null) { connection = new MyConnection().getConnection(); }
            pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, offre.getIdOffre());
                pstmt.setInt(2, offre.getH_debut());
                pstmt.setInt(3, offre.getH_fin());
            pstmt.executeUpdate();
        } 
        catch (Exception ex) 
        {
            throw ex;
        }
        finally
        {
            if(pstmt!=null)
            {
                pstmt.close();
            }
        }
    }

//********************************************************//

    public int getLast() throws Exception
    {
        int ret = 0;
        Connection connection = null;
        PreparedStatement pstmt  = null;
        ResultSet resultSet = null;
        try 
        {
            String sql = "select max(idOffre) from offre";
            connection = new MyConnection().getConnection();
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();

            while(resultSet.next())
            {
                ret = resultSet.getInt(1);
            }

            return ret;
        }
        catch (Exception ex) 
        {
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
            if(connection!=null)
            {
                connection.close();
            }
        }
    }

//********************************************************//

public ValiditeOffre[] getOffreValidite(Connection connection , int idOffre) throws Exception
{
    String secondPart = "";
    if(idOffre != -1)  { secondPart = secondPart+" where idoffre = "+idOffre; }
    
    ArrayList<ValiditeOffre> offre = new ArrayList<>();
    PreparedStatement pstmt  = null;
    ResultSet resultSet = null;
    try 
    {
        if(connection == null) { connection = new MyConnection().getConnection(); }
        String sql = "select * from validiteoffre" + secondPart;
        pstmt = connection.prepareStatement(sql);
        resultSet = pstmt.executeQuery();
        while(resultSet.next())
        {
            offre.add( new ValiditeOffre( resultSet.getInt("idoffre") , 
                                        resultSet.getInt("h_debut") , 
                                        resultSet.getInt("h_fin")
                    ));
        }
    } 
    catch (Exception ex) 
    {
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
    return offre.toArray(new ValiditeOffre[0]);
}

}
