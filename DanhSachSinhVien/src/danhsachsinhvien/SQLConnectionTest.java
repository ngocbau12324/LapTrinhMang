import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class SQLConnectionTest {
    public static void main(String[] args) {
        var server="NGUYENNGOCBAU\\MSSQLSERVER01";
        var user="sa";
        var password="123456";
        var db="test";
        var port=1433;
        SQLServerDataSource ds=new SQLServerDataSource();
        ds.setServerName(server);
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setPortNumber(port);
        try(Connection conn=ds.getConnection()){
            System.out.println("Thanhf cong");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
