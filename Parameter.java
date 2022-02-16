import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class Parameter {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string usinf JDBC
        String url = "jdbc:sqlite:C:/sqlite/db/Movie.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * select all rows in the warehouses table
     */
    public void selectParam(){
        //sql with parameter
        String sql = "SELECT id,movie,actor,actress FROM movie";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet row    = stmt.executeQuery(sql)){
            
            // loop through the row till its true
            while (row.next()) {
                //get method to get the data that we want
                System.out.println(row.getInt("id") +  "\t" + 
                                    row.getString("movie") + "\t" +
                                   row.getString("actor") + "\t" +
                                   row.getString("actress"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parameter record = new Parameter();
        record.selectParam();
    }

}
