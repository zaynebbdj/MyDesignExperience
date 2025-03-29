/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designmyexperience;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author proza
 */
public class ActivityMDEImpl implements ActivityMDE {
    
    public void deleteActivity(int activityId){
    
        Connection dbConnection = null;
        Statement statement=null;
        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();
            
            int rowsAffected = statement.executeUpdate("DELETE FROM activity WHERE activity_id = " + activityId);

            if (rowsAffected > 0) {
                System.out.println("Activity deleted successfully.");
            } else {
                System.out.println("No activity found with ID: " + activityId);
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
    
    }
    
    public Activity getActivity(int activityId){
        Activity currentActivity = new Activity();
        Connection dbConnection = null;
        Statement statement=null;
        LocalDate date = null;
        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();
            
            ResultSet rs=statement.executeQuery("SELECT * FROM activity WHERE activity_id = "+ activityId);           ///////////////////
            
            
            if(rs.next()) {
                
                date = rs.getDate("activity_date").toLocalDate();
                int year = date.getYear();
                int month = date.getMonthValue();
                int day = date.getDayOfMonth();
                // Create Activity object
                currentActivity = new Activity(
                    rs.getInt("activity_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    ActivityTheme.valueOf(rs.getString("theme").toUpperCase()),
                    rs.getInt("user_id"),
                    day, month, year, 
                    rs.getDouble("fee"),
                    rs.getString("address"),
                    rs.getInt("max_participants"),
                    rs.getInt("duration"),
                    rs.getString("image_path")
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
            
            
            return currentActivity;
        }
    }
    
    public ArrayList<Activity> getAllActivityThemeFee(String theme , String feeString){
    
        ArrayList<Activity> activities = new ArrayList<Activity>();
        Connection dbConnection = null;
        Statement statement=null;
        LocalDate date = null;
        ResultSet rs =null;
        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();
        
            
            
        String query = "SELECT * FROM activity WHERE 1=1"; 

        if (!theme.equals("ALL")) {
            query += " AND theme = '" + theme + "'";
        }

        if (!feeString.equals("ALL")) {
            if (feeString.equals("<10£")) {
                query += " AND fee < 10.00";
            } else if (feeString.equals("[10£;20£]")) {
                query += " AND fee BETWEEN 10.00 AND 20.00";
            } else if (feeString.equals("[20£;50£]")) {
                query += " AND fee BETWEEN 20.00 AND 50.00";
            } else if (feeString.equals("[50£;100£]")) {
                query += " AND fee BETWEEN 50.00 AND 100.00";
            } else if (feeString.equals(">100£")) {
                query += " AND fee > 100.00";
            }
        }

        // Exécuter la requête finale
        rs = statement.executeQuery(query);


        
        
            while(rs.next()) {
                
                date = rs.getDate("activity_date").toLocalDate();
                int year = date.getYear();
                int month = date.getMonthValue();
                int day = date.getDayOfMonth();
                
                // Create Activity object
                Activity a = new Activity(
                    rs.getInt("activity_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    ActivityTheme.valueOf(rs.getString("theme").toUpperCase()),
                    rs.getInt("user_id"),
                    day, month, year, 
                    rs.getDouble("fee"),
                    rs.getString("address"),
                    rs.getInt("max_participants"),
                    rs.getInt("duration"),
                    rs.getString("image_path")
                );
                System.out.println("ajout de: "+ a.getName());
                activities.add(a);
                
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
        
        
        return activities;
    }
    
    public void addActivity(Activity activity){
        Connection dbConnection = null;
        Statement statement=null;
        PreparedStatement preparedStatement = null;
        
        // Set the fields of the activity to add
        String name = activity.getName();
        String description = activity.getDescription(); 
        String theme = activity.getThemeStr().toLowerCase();
        int ownerId = activity.getOwnerId();
        double fee = activity.getFee();
        String address = activity.getAddress();
        int maxParticipant = activity.getMaxParticipant();
        int duration = activity.getDuration();
        String imagePath = activity.getImagePath();

        int year = activity.getYear();
        int month = activity.getMonth();
        int day = activity.getDay();
        
        String dateFormatted = String.format("%04d-%02d-%02d", year, month, day);
        
        // sql request
        String sql = "INSERT INTO activity (name, description, theme, activity_date, user_id, fee, address, max_participants, duration, image_path) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            preparedStatement.setString(10, imagePath);

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
    public void updateActivity(Activity activity){
        System.out.println("updateActivity ID:" + activity.getActivityId());
        Connection dbConnection = null;
        Statement statement=null;
        PreparedStatement preparedStatement = null;
        
        // Set the fields of the activity to add
        String name = activity.getName();
        String description = activity.getDescription(); 
        String theme = activity.getThemeStr().toLowerCase();
        int ownerId = activity.getOwnerId();
        double fee = activity.getFee();
        String address = activity.getAddress();
        int maxParticipant = activity.getMaxParticipant();
        int duration = activity.getDuration();
        String imagePath = activity.getImagePath();

        int year = activity.getYear();
        int month = activity.getMonth();
        int day = activity.getDay();
        
        String dateFormatted = String.format("%04d-%02d-%02d", year, month, day);
        String sql = "UPDATE activity SET name = ?, description = ?, theme = ?, activity_date = ?, user_id = ?, fee = ?, address = ?, max_participants = ?, duration = ?, image_path = ? WHERE activity_id = ?"; 
        // sql request
        String sql1 = "INSERT INTO activity (name, description, theme, activity_date, user_id, fee, address, max_participants, duration, image_path) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            preparedStatement.setString(10, imagePath);
            preparedStatement.setInt(11, activity.getActivityId());

            // Execute the update (insert)
            preparedStatement.executeUpdate();
            
            System.out.println("Record is updated activity table for name : " + activity.getName());
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
    
    public ArrayList<Activity> getAllActivity(int ownerId){
    
        ArrayList<Activity> activities = new ArrayList<Activity>();
        Connection dbConnection = null;
        Statement statement=null;
        LocalDate date = null;
        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();
            
            ResultSet rs=statement.executeQuery("SELECT * FROM activity WHERE user_id = "+ ownerId);           ///////////////////
            
            
            while(rs.next()) {
                
                date = rs.getDate("activity_date").toLocalDate();
                int year = date.getYear();
                int month = date.getMonthValue();
                int day = date.getDayOfMonth();
                
                // Create Activity object
                Activity a = new Activity(
                    rs.getInt("activity_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    ActivityTheme.valueOf(rs.getString("theme").toUpperCase()),
                    rs.getInt("user_id"),
                    day, month, year, 
                    rs.getDouble("fee"),
                    rs.getString("address"),
                    rs.getInt("max_participants"),
                    rs.getInt("duration"),
                    rs.getString("image_path")
                );
                System.out.println("ajout de: "+ a.getName());
                activities.add(a);
                
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
        
        
        return activities;
    }
    public ArrayList<Activity> getAllActivityTheme(String theme){
    
        ArrayList<Activity> activities = new ArrayList<Activity>();
        Connection dbConnection = null;
        Statement statement=null;
        LocalDate date = null;
        ResultSet rs =null;
        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();
            
            if(theme.equals("ALL")){
                rs=statement.executeQuery("SELECT * FROM activity");
            }else{
                rs=statement.executeQuery("SELECT * FROM activity WHERE theme = '"+ theme +"'");     
            }
            
            
            while(rs.next()) {
                
                date = rs.getDate("activity_date").toLocalDate();
                int year = date.getYear();
                int month = date.getMonthValue();
                int day = date.getDayOfMonth();
                
                // Create Activity object
                Activity a = new Activity(
                    rs.getInt("activity_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    ActivityTheme.valueOf(rs.getString("theme").toUpperCase()),
                    rs.getInt("user_id"),
                    day, month, year, 
                    rs.getDouble("fee"),
                    rs.getString("address"),
                    rs.getInt("max_participants"),
                    rs.getInt("duration"),
                    rs.getString("image_path")
                );
                System.out.println("ajout de: "+ a.getName());
                activities.add(a);
                
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
        
        
        return activities;
    }
    
    public ArrayList<Activity> getAllActivityTheme(int ownerId, String theme){
    
        ArrayList<Activity> activities = new ArrayList<Activity>();
        Connection dbConnection = null;
        Statement statement=null;
        LocalDate date = null;
        ResultSet rs =null;
        try{
            // Create Connecction to my database
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.createStatement();
            
            if(theme.equals("ALL")){
                rs=statement.executeQuery("SELECT * FROM activity");
            }else{
                rs=statement.executeQuery("SELECT * FROM activity WHERE user_id = '" + ownerId+"'AND theme = '"+ theme +"'");     
            }
            
            
            while(rs.next()) {
                
                date = rs.getDate("activity_date").toLocalDate();
                int year = date.getYear();
                int month = date.getMonthValue();
                int day = date.getDayOfMonth();
                
                // Create Activity object
                Activity a = new Activity(
                    rs.getInt("activity_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    ActivityTheme.valueOf(rs.getString("theme").toUpperCase()),
                    rs.getInt("user_id"),
                    day, month, year, 
                    rs.getDouble("fee"),
                    rs.getString("address"),
                    rs.getInt("max_participants"),
                    rs.getInt("duration"),
                    rs.getString("image_path")
                );
                System.out.println("ajout de: "+ a.getName());
                activities.add(a);
                
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
        
        
        return activities;
    }
}
