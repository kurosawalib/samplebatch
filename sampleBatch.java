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

        //接続文字列stag
        String urlstag = "jdbc:postgres://jmopkgaacujnrd:b96f1d51e0f8c5b4005e74214c20ad68092d0b812cb159c61359ef9af2202eec@ec2-54-211-77-238.compute-1.amazonaws.com:5432/d7ltsc29vhuu3a";
        String userstag = "jmopkgaacujnrd";
        String passwordstag = "b96f1d51e0f8c5b4005e74214c20ad68092d0b812cb159c61359ef9af2202eec";
        
        //接続文字列prod
        String urlprod = "jdbc:postgres://ptltpixklvsumm:6b1a26b33577f4e04e521416393badbfad62e5b115d36f01561594d99946b99a@ec2-54-211-77-238.compute-1.amazonaws.com:5432/ddrisp58urbbho";
        String userprod = "ptltpixklvsumm";
        String passwordprod = "6b1a26b33577f4e04e521416393badbfad62e5b115d36f01561594d99946b99a";

        try{
            //PostgreSQLへ接続(stag)
            conn = DriverManager.getConnection(urlstag, userstag, passwordstag);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //INSERT文の実行
            sql = "INSERT INTO jdbc_test VALUES (2, 'bbb')";
            stmt.executeUpdate(sql);
            conn.commit();
        }
        catch (SQLException e){
            try{
            //PostgreSQLへ接続(prod)
            conn = DriverManager.getConnection(urlprod, userprod, passwordprod);

            //自動コミットOFF
            conn.setAutoCommit(false);

            //INSERT文の実行
            sql = "INSERT INTO jdbc_test VALUES (2, 'bbb')";
            stmt.executeUpdate(sql);
            conn.commit();
            }
            catch (SQLException e){
               e.printStackTrace();
            }
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
