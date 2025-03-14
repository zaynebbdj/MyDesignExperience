/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author proza
 */
public class ActivityMDEImpl implements ActivityMDE {
    
    public void addActivity(Activity activity){
        Connection dbConnection = null;
        Statement statement=null;
        PreparedStatement preparedStatement = null;
        
        // Set the fields of the activity to add
        String name = activity.getName();
        String description = activity.getDescription(); 
        String theme = activity.getThemeStr().toLowerCase();
        int ownerId = activity.getActivityId();
        double fee = activity.getFee();
        String address = activity.getAddress();
        int maxParticipant = activity.getMaxParticipant();
        int duration = activity.getDuration();

        int year = activity.getYear();
        int month = activity.getMonth();
        int day = activity.getDay();
        
        String dateFormatted = String.format("%04d-%02d-%02d", year, month, day);
        
        // sql request
        String sql = "INSERT INTO activity (name, description, theme, activity_date, user_id, fee, address, max_participants, duration) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();

            // Create prepared statement
            preparedStatement = dbConnection.prepareStatement(sql);
            
            // Set parameters in the prepared statement
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, theme);
            preparedStatement.setString(4, dateFormatted);  
            preparedStatement.setInt(5, ownerId);  
            preparedStatement.setDouble(6, fee);
            preparedStatement.setString(7, address);
            preparedStatement.setInt(8, maxParticipant);
            preparedStatement.setInt(9, duration);

            // Execute the update (insert)
            preparedStatement.executeUpdate();
            
            System.out.println("Record is inserted into activity table for name : " + activity.getName());
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
}
