
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
 
/**
 *
 * @author This-PC
 */
public class Table{

  
    public static void createTable() {  
    
        
        
        
         String url = "jdbc:sqlite:C:/sqlite/db/Movie.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS movie (\n"  
                + " id integer PRIMARY KEY,\n"  
                + " movie  text NOT NULL,\n"  
                + " actor text NOT NULL,\n"  
                + " actress text NOT NULL,\n"  
                 + " year_of_release text NOT NULL,\n" 
                 + " director text NOT NULL\n" 
                + ");";  
          
        try{  //connection to the database
            Connection conn = DriverManager.getConnection(url); 
            //using statement for the connection object
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    
    public static void main(String[] args) {  
        //call the method
        createTable();  
       
    }  
   
    
}
