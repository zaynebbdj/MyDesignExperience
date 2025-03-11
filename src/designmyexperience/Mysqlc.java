package designmyexperience;

import java.sql.*;

/**
 *
 * @author mysqltest
 */
public class Mysqlc {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
        try {
                // db parameters - ptest is the name of the database
                String url       = "jdbc:mysql://localhost:3306/Myproject";     ///////////////////
                String user      = "root";
                String password  = "";

                // create a connection to the database
                conn = DriverManager.getConnection(url, user, password);
                // more processing here
                // ...   
                Statement stmt=conn.createStatement(); 
                ResultSet rs=stmt.executeQuery("select * from user");           ///////////////////
                while(rs.next()) 
                System.out.println(rs.getInt(2)+"  "+rs.getString(1));          ///////////////////

            } catch(SQLException e) {
                 System.out.println(e.getMessage());
            } finally {
                 try{
                         if(conn != null)
                         conn.close();
                     }catch(SQLException ex){
                            System.out.println(ex.getMessage());
                    }
                 /*INSERT INTO User (username, password, user_type, name, firstname, email, phone)
                VALUES 
                ('john_doe', 'hashedpassword1', 'customer', 'Doe', 'John', 'john.doe@example.com', '123456789'),
                ('alice_smith', 'hashedpassword2', 'customer', 'Smith', 'Alice', 'alice.smith@example.com', '987654321'),
                ('adventure_club', 'hashedpassword3', 'business_owner', 'Club', 'Adventure', 'contact@adventureclub.com', '1122334455'),
                ('nature_tours', 'hashedpassword4', 'business_owner', 'Tours', 'Nature', 'info@naturetours.com', '6677889900');*/

        }       
    } 
}