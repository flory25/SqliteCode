import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Select {

   //connect to datanase
    //retutn the connection
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/sqlite/db/Movie.db";
        Connection conn = null;
       try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
           // System.out.println(e.getMessage());
       }
        return conn;
    }

    
    /**
     * select all rows in the  table
     */
    public void selectAll(){
        String sql = "SELECT * FROM movie";
        
        try (Connection conn = this.connect();
                //creatig the statement or the connection object
             Statement stmt  = conn.createStatement();
                //excute the sql
             ResultSet row    = stmt.executeQuery(sql)){ 
            
            // loop through the result set
            while (row.next()) {
                //get method to get all the data from the table
                System.out.println(row.getInt("id") +  "\t" + 
                                   row.getString("movie") + "\t\t" +
                                    row.getString("actor") + "\t\t" +
                                    row.getString("actress") + "\t\t" +
                                     row.getString("year_of_release") + "\t\t" +
                                   row.getString("director"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Select record = new Select();
        record.selectAll();
    }
}

