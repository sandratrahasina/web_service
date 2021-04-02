package com.ws.ws.model.offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.ws.ws.helper.*;

public class Offre 
{
    int idOffre;
    String nomOffre;
    double prix;
    double dureeOffre;
    String uniteDuree;
    Timestamp status;
    int priorite;

//********************************************************//

    public int getIdOffre() { return this.idOffre; }
    public String getNomOffre() { return this.nomOffre; }
    public double getPrix() { return this.prix; }
    public double getDureeOffre() { return this.dureeOffre; }
    public String getUniteDuree()  { return this.uniteDuree; }
    public Timestamp getStatus() { return this.status; }
    public int getPriorite() { return this.idOffre; }


    public void setIdOffre(int x) { this.idOffre = x; }
    public void setNomOffre(String x) { this.nomOffre = x; }
    public void setPrix(double x) { this.prix = x; }
    public void setDureeOffre(double x) {this.dureeOffre = x; }
    public void setUniteDuree(String x)  { this.uniteDuree = x; }
    public void setStatusl(Timestamp x) { this.status = x; }
    public void setPriorite(int x) { this.priorite = x; }


//********************************************************//

    public Offre(){}

    public Offre(int idOffre)
    {
        this.setIdOffre(idOffre);
    }

    public Offre(int idOffre , String nom , double prix , double duree , String unit_D , Timestamp status , int propriete)
    {
        this.setIdOffre(idOffre);
        this.setNomOffre(nom);
        this.setPrix(prix);
        this.setDureeOffre(duree);
        this.setUniteDuree(unit_D);
        this.setStatusl(status);
        this.setPriorite(priorite);
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

    public Offre[] getOffre(Connection connection)throws Exception
    {
        int is = 0;
        ArrayList<Offre> offres = new ArrayList<>();
        PreparedStatement pstmt  = null;
        ResultSet resultSet = null;
        try 
        {
            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            String sql = "select * from offre";
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while(resultSet.next())
            {
                offres.add( new Offre(  
                                        resultSet.getInt("idoffre") , 
                                        resultSet.getString("nomoffre") , 
                                        resultSet.getDouble("prixoffre") ,  
                                        resultSet.getDouble("dureeoffre") ,  
                                        resultSet.getString("uniteduree") ,
                                        resultSet.getTimestamp("status") ,
                                        resultSet.getInt("priorite")
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

        return offres.toArray(new Offre[0]);
    }
//********************************************************//
    public Offre getOffre(Connection connection , int idOffre , String nameOffre) throws Exception
    {
        int is = 0;
        String secondPart = "";
        if(idOffre > -1) 
        {
            secondPart = secondPart+" where idOffre = "+idOffre;
        }

        // if(nameOffre != null || nameOffre.isBlank())
        // {
        //     if(secondPart == "") secondPart = secondPart+" where nomOffre = '"+nameOffre+"'";
        //     else secondPart = secondPart+" and nomOffre = '"+nameOffre+"'";
        // }

        Offre offre = null;
        PreparedStatement pstmt  = null;
        ResultSet resultSet = null;
        try 
        {
            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            String sql = "select * from offre" + secondPart;
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            if(resultSet.next()) 
            {
                offre =  new Offre(     resultSet.getInt("idoffre") , 
                                    resultSet.getString("nomoffre") , 
                                    resultSet.getDouble("prixoffre") ,  
                                    resultSet.getDouble("dureeoffre") ,  
                                    resultSet.getString("uniteduree") ,
                                    resultSet.getTimestamp("status") ,
                                    resultSet.getInt("priorite")
                               );
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
        return offre;
    }
//********************************************************//

    public void insert(Connection connection) throws Exception
    {
        int is = 0;
        PreparedStatement pstmt  = null;
        String sql = "INSERT INTO offre VALUES(?,?,?,?,?,?,?)";

        try
        {

            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, this.getIdOffre());
                pstmt.setString(2, this.getNomOffre());
                pstmt.setDouble(3, this.getPrix());
                pstmt.setDouble(4, this.getDureeOffre());
                pstmt.setString(5, this.getUniteDuree());
                pstmt.setTimestamp(6, this.getStatus());
                pstmt.setInt(7, this.getPriorite());
            pstmt.executeUpdate();
            connection.commit();
        } 
        catch (Exception ex) 
        {
            connection.rollback();
            throw new Exception("misy olana oo, "+ex.getMessage());
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

    public void delete(Connection connection , Offre offre) throws Exception
    {
        int is = 0;
        PreparedStatement pstmt  = null;
        String sql = "delete from offre where nomOffre = ?";

        try
        {
            if(connection == null) { is = 1; connection = new MyConnection().getConnection(); }
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, offre.getNomOffre());
            pstmt.executeUpdate();
            connection.commit();
        } 
        catch (Exception ex) 
        {
            connection.rollback();
            throw new Exception("misy olana oo"+ex.getMessage());
        }
        finally
        {
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

    public void update(Connection connection , Offre offre) throws Exception
    {
        int is = 0;
        PreparedStatement pstmt  = null;
        String sql = "UPDATE offre SET nomOffre = ? , prixOffre = ? , dureeOffre = ? , uniteDuree = ? , status = ? , priorite = ? WHERE idOffre = ?";

        try
        {
            if(connection == null) { is = 1;    connection = new MyConnection().getConnection(); }
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, offre.getNomOffre());
                pstmt.setDouble(2, offre.getPrix());
                pstmt.setDouble(3, offre.getDureeOffre());
                pstmt.setString(4, offre.getUniteDuree());
                pstmt.setTimestamp(5, offre.getStatus());
                pstmt.setInt(6, offre.getPriorite());
                pstmt.setInt(7, offre.getIdOffre());
            pstmt.executeUpdate();
            connection.commit();
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
}
