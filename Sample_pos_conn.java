import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample_pos_conn {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        
        String urlprod = "jdbc:postgres://ptltpixklvsumm:6b1a26b33577f4e04e521416393badbfad62e5b115d36f01561594d99946b99a@ec2-54-211-77-238.compute-1.amazonaws.com:5432/ddrisp58urbbho";
        String userprod = "ptltpixklvsumm";
        String passwordprod = "6b1a26b33577f4e04e521416393badbfad62e5b115d36f01561594d99946b99a";

        try{
            conn = DriverManager.getConnection(urlprod, userprod, passwordprod);

            conn.setAutoCommit(false);

            String sql = "INSERT INTO jdbc_test VALUES (2, 'bbb')";
            stmt.executeUpdate(sql);
            conn.commit();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(rset != null)rset.close();
                if(stmt != null)stmt.close();
                if(conn != null)conn.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        }
    }
}