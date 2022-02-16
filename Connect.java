import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//connect to sqlite datbase using sqlite-JDBC
public class Connect {
     /**
     * Connect to a sample database
     */
    public static void connect() {

        Connection conn = null;//when there is no connection yet
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/Movie.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            //if there is no exception it will print the the output
            System.out.println("Connect sucessfully  to SQLite database movie.");
            
        } catch (SQLException e) {
            // if there exception it will print this message
            System.out.println(e.getMessage());
        } finally {
            try {
                //if there is connection we will close the connction
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        connect();
		
    }
}
