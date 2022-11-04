/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class connect {
     String user="";
    String password="";
    String url="";
    Connection conn=null;
    Statement  stmt=null;
    public connect() 
    {  user="root";
          password="";
          url="jdbc:mysql://localhost:3306/java";
    }
    public connect(String url,String user, String password)
    {
     this.url=url;this.user=user;this.password=password;
    }
    public Statement taoketnoi() throws SQLException
    {

  Connection  conn=DriverManager.getConnection(url, user, password);
  Statement  stmt=conn.createStatement();
   //conn.close();
         return (Statement) stmt;
    }
    

   
    
}
