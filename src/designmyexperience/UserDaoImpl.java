/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;

import daodemo.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


/**
 *
 * @author proza
 */
public class UserDaoImpl implements UserDao {
    
    public void addUser(User user)
    {
        Connection dbConnection = null;
        Statement statement=null;

        String username = user.getUsername();
        String password = user.getPassword();
        String userType = user.getUserType().name();
        String name = user.getName();
        String firstname = user.getFirstname();
        String email = user.getEmail();
        String phoneNumber = user.getPhoneNumber();
        
        String sql = "INSERT INTO Users (username, password, user_type, name, firstname, email, phoneNumber) VALUES ('"
        + username + "','" + password + "','" + userType + "','" + name + "','" + firstname + "','" + email + "','" + phoneNumber + "')";
 
        try{
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(sql);

            System.out.println("Record is inserted into Users table for User : " + user.getName());

        }
        catch( SQLException e ){

            e.printStackTrace();
        }
        finally{

            if( statement != null ){
                try {
                  statement.close();
                }
                catch( SQLException e ){
                  e.printStackTrace();
                }
            }

            if( dbConnection != null ){
                try{
                  dbConnection.close();
                }
                catch( SQLException e ){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public User getUser(String username, String password)
    {
        User currentUser = new User();
        Connection dbConnection = null;
        Statement statement=null;
        
        String sql = "SELECT * FROM Users WHERE username = '"+username+"' AND password ='" +password+"'";
        try{
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();

            ResultSet rs=statement.executeQuery(sql); 
            
            if(rs.next()){
    
                int userId = rs.getInt("user_id");  
                String userTypeStr = rs.getString("user_type").toUpperCase();
                UserType userType = UserType.valueOf(userTypeStr);
                String name = rs.getString("name");
                String firstname = rs.getString("firstname");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                
                currentUser = new User(userId, userType, username, password, name, firstname, email, phoneNumber);
                System.out.println("created");
            }else{
                System.out.println("No user found.");
                currentUser = null;
            }
            
        }
        catch( SQLException e ){

            e.printStackTrace();
        }
        finally{

            if( statement != null ){
                try {
                  statement.close();
                }
                catch( SQLException e ){
                  e.printStackTrace();
                }
            }

            if( dbConnection != null ){
                try{
                  dbConnection.close();
                }
                catch( SQLException e ){
                    e.printStackTrace();
                }
            }
            return currentUser;
        }
    }
    
}
