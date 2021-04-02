package com.ws.ws.model.offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ws.ws.helper.*;

public class ListeOffre 
{
    public Offre offre;
    public DetailsOffre[] forfait;

//********************************************************//

    public ListeOffre(){}
    public ListeOffre(Offre offre, DetailsOffre[] forfait)
    {
        this.offre = offre;
        this.forfait = forfait;
    }

//********************************************************//

    public ListeOffre getOffre(Connection connection, int id, String name) throws Exception
    {
        int is = 0;
        if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
        Offre offr = new Offre().getOffre(connection , id, name);
        DetailsOffre[] det = new DetailsOffre().getOffre(connection, offr);

        return new ListeOffre( offr , det );
    }

//********************************************************//

    public int getTotalOffre(Connection connection) throws Exception
    {
        int is = 0;
        int ret = 0;
        PreparedStatement pstmt  = null;
        ResultSet resultSet = null;
        try 
        {
            if(connection == null) { is = 0 ; connection = new MyConnection().getConnection(); }
            String sql = "select count(idOffre) from offre";
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            resultSet.next(); 
            ret = resultSet.getInt("count") ;
                                    
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
            if(connection!=null && is == 1)
            {
                connection.close();
            }
        }
        return ret;
    }

//********************************************************//

    public ListeOffre[] getOffre(Connection connection) throws Exception
    {
        int is = 0;
        if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
        
        ArrayList<ListeOffre> ret = new ArrayList<>();
        int total = getTotalOffre(connection);
        for(int i = 1; i <= total; i++)
        {
            Offre offr = new Offre().getOffre(connection , i, "");
            DetailsOffre[] det = new DetailsOffre().getOffre(connection , offr);
            ret.add(new ListeOffre  ( offre , det ) );
        }

        return ret.toArray(new ListeOffre[0]);
    }

//********************************************************//

    public void insertListe(Connection connection , ListeOffre liste) throws Exception
    {
        int is = 0;
        try
        {
            Offre offre = liste.offre;
            DetailsOffre[] detail = liste.forfait;
            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            connection.setAutoCommit(false);
            offre.insert(connection, offre);
            for(int i = 0; i < detail.length; i++)
            {
                new DetailsOffre().insert(connection, detail[i]);
            }
            connection.commit();
        }
        catch(Exception e)
        {
            connection.rollback();
            throw new Exception("misy olana eto : "+e.getMessage());
        }
        finally
        {
            if(connection != null && is == 1)
            {
                connection.close();
            }
        }
    }

//********************************************************//   
    public void updatetListe(Connection connection , ListeOffre liste) throws Exception
    {
        int is = 0;
        try
        {
            Offre offre = liste.offre;
            DetailsOffre[] detail = liste.forfait;
            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            connection.setAutoCommit(false);
            offre.update(connection, offre);
            for(int i = 0; i < detail.length; i++)
            {
                new DetailsOffre().update(connection, detail[i]);
            }
            connection.commit();
        }
        catch(Exception e)
        {
            connection.rollback();
            throw new Exception("misy olana eto : "+e.getMessage());
        }
        finally
        {
            if(connection != null && is == 1)
            {
                connection.close();
            }
        }
    }
}
