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

        //接続文字列
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "libgate1234";

        try{
            //PostgreSQLへ接続
            conn = DriverManager.getConnection(url, user, password);

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