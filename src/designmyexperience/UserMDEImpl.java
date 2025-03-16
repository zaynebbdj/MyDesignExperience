/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;


/**
 *
 * @author proza
 */
public class UserMDEImpl implements UserMDE {
    
    public void addUser(User user)
    {
        Connection dbConnection = null;
        Statement statement=null;
        PreparedStatement preparedStatement = null;

        String username = user.getUsername();
        String password = user.getPassword();
        String userType = user.getUserType().name();
        String name = user.getName();
        String firstname = user.getFirstname();
        String email = user.getEmail();
        String phoneNumber = user.getPhoneNumber();
        String imagePath = user.getImagePath();
        
        System.out.println(imagePath);
        String sql = "INSERT INTO Users (username, password, user_type, name, firstname, email, phoneNumber, photo_path) " + 
                "VALUES (?,?,?,?,?,?,?, ?)";
        

        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();

            // Create prepared statement
            preparedStatement = dbConnection.prepareStatement(sql);
            
            // Set parameters in the prepared statement
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, userType);
            preparedStatement.setString(4, name);  
            preparedStatement.setString(5, firstname);  
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, phoneNumber);
            preparedStatement.setString(8, imagePath);

            // Execute the update (insert)
            preparedStatement.executeUpdate();
            
            System.out.println("Record is inserted into activity table for name : " + user.getName());
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
                String imagePath = rs.getString("photo");
                
                currentUser = new User(userId, userType, username, password, name, firstname, email, phoneNumber, imagePath);
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
