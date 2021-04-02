package com.ws.ws.helper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class MyConnection 
{
    private final String url = "jdbc:postgresql://localhost/stm";
    private final String user = "postgres";
    private final String password = "123456";
    Connection connection = null;
    public Connection getConnection()throws Exception
    {
        try
        {
            this.connection=DriverManager.getConnection(url,user,password);
        }
        catch(Exception ex){ throw ex; }
        finally{  }
        return this.connection;
    }
}
