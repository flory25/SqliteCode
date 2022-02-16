import java.sql.Connection;  
import java.sql.DatabaseMetaData;  
import java.sql.DriverManager;  
import java.sql.SQLException; 
 
public class Movie {
    //create the movie database
    public static void createNewDatabase(String fileName) {  
   
        String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;  
   
        try {  
            //connect to the data base
            Connection conn = DriverManager.getConnection(url);  
            if (conn != null) {  
                DatabaseMetaData meta = conn.getMetaData(); //to get the JDBC name 
                //if there is no exception it will print the message
                System.out.println("The driver name is " + meta.getDriverName());  
                System.out.println("A database has been created.");  
            }  
   
        } catch (SQLException e) {  
            //if there an exception it will print the message
            System.out.println(e.getMessage());  
        }  
    }  
  
    public static void main(String[] args) {  
        //call the method in main
        createNewDatabase("Movie.db");  
    }  
    
}
