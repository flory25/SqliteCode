import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class Insert {
       
//creating connection to the database
    private Connection connect() {  
     
    
        // SQLite connection string  
        String url = "jdbc:sqlite:C:/sqlite/db/Movie.db";  
        Connection conn = null;  
        try {  
            
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
         return conn;
    }
   
  
    public void insert(String movie,String actor,String actress,String year,String director ) {  
        //sql for inserting into the table
        String sql = "INSERT INTO movie(movie,actor,actress,year_of_release,director) VALUES(?,?,?,?,?)";  
   
        try{  
            
            Connection conn = this.connect();  
            //prepared staement for accept the parameter in the sql query
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, movie);  
            pstmt.setString(2,actor );  
            pstmt.setString(3,actress );
            pstmt.setString(4,year ); 
            pstmt.setString(5,director ); 
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
              
        }  
    }  
   
    public static void main(String[] args) {  
   
        Insert record = new Insert();  
        // insert data   
          record.insert("Alice in Wonderland","Johnny Depp","Mia Wasikowska","2010","Tim Burton");  
          record.insert("3 Idiots","Amir Khan","kareena Kapoor","2009","RajKumar Hirani"); 
          record.insert("Greatest Showman","Zack Effron","Zendaya","2017","Michael Gracey"); 
    }
    
}
