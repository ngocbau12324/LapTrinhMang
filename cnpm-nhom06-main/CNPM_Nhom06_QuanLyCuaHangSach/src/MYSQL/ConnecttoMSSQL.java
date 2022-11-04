/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnecttoMSSQL 
{
    Connection conn;
    public Connection getConnectiontoSQL()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnecttoMSSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try 
        {
            //conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/qlda?useUnicode=true&characterEncoding=utf-8","root","");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(ConnecttoMSSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public void close()
    {
        if(conn!=null)
        {
            try {
                if(!conn.isClosed())
                {
                    conn.close();
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ConnecttoMSSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
