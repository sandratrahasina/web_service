package com.ws.ws.model.offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ws.ws.helper.*;

public class DetailsOffre 
{
    int idOffre;
    String type;
    double valeur;
    String unite;

    public void setIdOffre(int x) { this.idOffre = x; }
    public void setType(String x) { this.type = x; }
    public void setValeur(double x)  { this.valeur = x; }
    public void setUnite(String x) { this.unite = x; }

    public int getIdOffre() { return this.idOffre; }
    public String  getType() { return this.unite; }
    public double getValeur()  { return this.valeur; }
    public String  getUnite() { return this.unite; }

//********************************************************//

    public DetailsOffre(){}

    public DetailsOffre(int idOffre, String mtype, double valeur, String unite)
    {
        this.setIdOffre(idOffre);
        this.setType(mtype);
        this.setValeur(valeur);
        this.setUnite(unite);
    }

//********************************************************//
    
    public void insert(Connection connection , DetailsOffre offre) throws Exception
    {
        int is = 0;
        PreparedStatement pstmt  = null;
        String sql = "INSERT INTO detailoffre VALUES(?,?,?,?)";

        try
        {

            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, offre.getIdOffre());
                pstmt.setString(2, offre.getType());
                pstmt.setDouble(3, offre.getValeur());
                pstmt.setString(4, offre.getUnite());
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
            if(connection!=null && is == 1)
            {
                connection.close();
            }
        }
    } 

//********************************************************//
    
    public void delete(Connection connection , DetailsOffre offre) throws Exception
    {
        int is = 0;
        PreparedStatement pstmt  = null;
        String sql = "delete from detailoffre where idOffre = ?";
        try
        {
            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
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
            if(connection!=null && is == 1)
            {
                connection.close();
            }
        }
    }

//********************************************************//  

    public void update(Connection connection , DetailsOffre offre) throws Exception
    {
        int is = 0;
        PreparedStatement pstmt  = null;
        String sql = "UPDATE DetailOffre SET type = ? , valeur = ? , unite = ? WHERE idOffre = ?";
        try
        {
            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, offre.getType());
                pstmt.setDouble(2, offre.getValeur());
                pstmt.setString(3, offre.getUnite());
                pstmt.setInt(4, offre.getIdOffre());
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
            if(connection!=null && is == 1)
            {
                connection.close();
            }
        }
    }
    
//********************************************************//

    public DetailsOffre[] getOffre(Connection connection , Offre offre)throws Exception
    {
        int is = 0;
        ArrayList<DetailsOffre> offres = new ArrayList<>();
        PreparedStatement pstmt  = null;
        ResultSet resultSet = null;
        try 
        {
            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            String sql = "select * from offre where idOffre = ?";
            pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, offre.getIdOffre());
            resultSet = pstmt.executeQuery();
            while(resultSet.next())
            {
                offres.add( new DetailsOffre(      
                    resultSet.getInt("idoffre") , 
                    resultSet.getString("type") , 
                    resultSet.getDouble("valeur") ,  
                    resultSet.getString("unite") 
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
            if(connection!=null && is == 1)
            {
                connection.close();
            }
        }

        return offres.toArray(new DetailsOffre[0]);
    }


    public DetailsOffre[] getOffre(Connection connection , int offre)throws Exception
    {
        int is = 0;
        ArrayList<DetailsOffre> offres = new ArrayList<>();
        PreparedStatement pstmt  = null;
        ResultSet resultSet = null;
        try 
        {
            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            String sql = "select * from DetailOffre where idOffre = ?";
            pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, offre);
            resultSet = pstmt.executeQuery();
            while(resultSet.next())
            {
                offres.add( new DetailsOffre(      resultSet.getInt("idoffre") , 
                                                    resultSet.getString("type") , 
                                                    resultSet.getDouble("valeur") ,  
                                                    resultSet.getString("unite") 
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
            if(connection!=null && is == 1)
            {
                connection.close();
            }
        }

        return offres.toArray(new DetailsOffre[0]);
    }

}


