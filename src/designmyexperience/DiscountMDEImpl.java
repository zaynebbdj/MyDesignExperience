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
import java.time.LocalDate;
/**
 *
 * @author proza
 */
public class DiscountMDEImpl implements DiscountMDE {
    
    public Discount getDiscount(int discountId){
        Discount currentDiscount = new Discount();
        Connection dbConnection = null;
        Statement statement=null;
        LocalDate dateStart = null;
        LocalDate dateEnd = null;
        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();
            
            ResultSet rs=statement.executeQuery("SELECT * FROM discount WHERE discount_id = "+ discountId);           ///////////////////
            
            
            if(rs.next()) {
                
                dateStart = rs.getDate("start_date").toLocalDate();
                int yearStart = dateStart.getYear();
                int monthStart = dateStart.getMonthValue();
                int dayStart = dateStart.getDayOfMonth();


                dateEnd = rs.getDate("start_date").toLocalDate();
                int yearEnd = dateEnd.getYear();
                int monthEnd = dateEnd.getMonthValue();
                int dayEnd = dateEnd.getDayOfMonth();
                
                // Create Activity object
                currentDiscount = new Discount(
                    rs.getInt("discount_id"),
                    rs.getInt("user_id"),
                    rs.getInt("activity_id"),
                    rs.getInt("percent"),
                    dayStart, monthStart, yearStart, 
                    dayEnd, monthEnd, yearEnd
                        
                );
                
                
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
            
            
            return currentDiscount;
        }
    }
    
    public void addDiscount(Discount d){
    
        Connection dbConnection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        
        // Set the fileds of the activity to add
        int userId = d.getUserId();
        int activityId = d.getActivityId();
        int percent = d.getPercent();
        
        int yearStart = d.getStartYear();
        int monthStart = d.getStartMonth();
        int dayStart = d.getStartDay();
        
        int yearEnd = d.getEndYear();
        int monthEnd = d.getEndMonth();
        int dayEnd = d.getEndDay();      

        
        String dateFormattedStart = String.format("%04d-%02d-%02d", yearStart, monthStart, dayStart);
        String dateFormattedEnd = String.format("%04d-%02d-%02d", yearEnd, monthEnd, dayEnd);

        // sql request
        String sql = "INSERT INTO discount (user_id, activity_id, percent, start_date, end_date) "
               + "VALUES (?, ?, ?, ?, ?)";
        
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
            preparedStatement.setInt(3, percent);
            preparedStatement.setString(4, dateFormattedStart);  
            preparedStatement.setString(5, dateFormattedEnd); 

            System.out.println(dateFormattedStart);
            System.out.println(dateFormattedEnd);
            // Execute the update (insert)
            preparedStatement.executeUpdate();
            
            System.out.println("Record is inserted into activity table for name : " + d.getPercent());
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
    
    public ArrayList<Discount> getAllDiscount(int userId){
        ArrayList<Discount> discounts = new ArrayList<Discount>();
        
        Connection dbConnection = null;
        Statement statement = null;
        LocalDate dateStart = null;
        LocalDate dateEnd = null;
        
        try{
            System.out.println("try 1");
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();
            
            ResultSet rs=statement.executeQuery("SELECT * FROM discount WHERE user_id = 5");          
            
            while(rs.next()) {
                dateStart = rs.getDate("start_date").toLocalDate();
                int yearStart = dateStart.getYear();
                int monthStart = dateStart.getMonthValue();
                int dayStart = dateStart.getDayOfMonth();


                dateEnd = rs.getDate("start_date").toLocalDate();
                int yearEnd = dateEnd.getYear();
                int monthEnd = dateEnd.getMonthValue();
                int dayEnd = dateEnd.getDayOfMonth();

                // Create Activity object
                Discount d = new Discount(
                    rs.getInt("discount_id"),
                    rs.getInt("user_id"),
                    rs.getInt("activity_id"),
                    rs.getInt("percent"),
                    dayStart, monthStart, yearStart, 
                    dayEnd, monthEnd, yearEnd
                );
                System.out.println("ajout de: "+ d.getPercent());
                discounts.add(d);
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
        }
        
        return discounts;
    }
    public ArrayList<Discount> getAllDiscountActivity(int activityId){
        ArrayList<Discount> discounts = new ArrayList<Discount>();
        
        Connection dbConnection = null;
        Statement statement = null;
        LocalDate dateStart = null;
        LocalDate dateEnd = null;
        
        try{
            System.out.println("try 1");
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();
            
            ResultSet rs=statement.executeQuery("SELECT * FROM discount WHERE activity_id = "+ activityId);          
            
            while(rs.next()) {
                dateStart = rs.getDate("start_date").toLocalDate();
                int yearStart = dateStart.getYear();
                int monthStart = dateStart.getMonthValue();
                int dayStart = dateStart.getDayOfMonth();


                dateEnd = rs.getDate("start_date").toLocalDate();
                int yearEnd = dateEnd.getYear();
                int monthEnd = dateEnd.getMonthValue();
                int dayEnd = dateEnd.getDayOfMonth();

                // Create Activity object
                Discount d = new Discount(
                    rs.getInt("discount_id"),
                    rs.getInt("user_id"),
                    rs.getInt("activity_id"),
                    rs.getInt("percent"),
                    dayStart, monthStart, yearStart, 
                    dayEnd, monthEnd, yearEnd
                );
                System.out.println("ajout de: "+ d.getPercent());
                discounts.add(d);
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
        }
        
        return discounts;
    }
}
