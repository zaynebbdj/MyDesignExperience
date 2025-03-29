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
    
    
    public void addBooking(Booking booking){
        
        Connection dbConnection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        
        // setting of the booking filed
        int userId = booking.getUserId();
        int activityId = booking.getActivityId();
        
        int year = booking.getYear();
        int month = booking.getMonth();
        int day = booking.getDay();
        String booking_date = String.format("%04d-%02d-%02d", year, month, day);
        
        String status = booking.getStatus().name();
        
        
        String sql = "INSERT INTO booking (user_id, activity_id,booking_date,status) " + 
                "VALUES (?,?,?,?)";
        
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
            preparedStatement.setString(3, booking_date);
            preparedStatement.setString(4, status);

            // Execute the update (insert)
            preparedStatement.executeUpdate();
            
            System.out.println("Record is inserted into discount table for name : " + booking.getUserId());
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
