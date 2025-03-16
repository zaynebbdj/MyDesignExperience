/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author proza
 */
public class BookingMDEImpl implements BookingMDE {
    
    
    public void addBooking(Booking b){
        
        Connection dbConnection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        
        // setting of the booking filed
        int userId = b.getUserId();
        int activityId = b.getActivityId();
        String status = b.getStatus().name();
        
        String sql = "INSERT INTO discount (user_id, activity_id, status) " + 
                "VALUES (?,?,?)";
        
        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();

            // Create prepared statement
            preparedStatement = dbConnection.prepareStatement(sql);
            
            // Set parameters in the prepared statement
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, activityId);
            preparedStatement.setString(3, status);

            // Execute the update (insert)
            preparedStatement.executeUpdate();
            
            System.out.println("Record is inserted into discount table for name : " + b.getUserId());
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
