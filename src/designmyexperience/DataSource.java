/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designmyexperience;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zayneb
 */
public class DataSource {
    Connection conn = null;
  

  public Connection createConnection()
  {
  
    try
    {
          // db parameters
        String url       = "jdbc:mysql://localhost:3306/MyDesignExperienceDB";
        String user      = "root";
        String password  = "";

        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password);

    }
    catch( Exception e )
    {
      System.out.println("Error Occured " + e.toString());
    }
    return conn;
  }
}
