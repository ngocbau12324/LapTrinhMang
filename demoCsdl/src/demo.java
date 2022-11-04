import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class demo {
    private static final String hostName = "localhost";
    private static final String userName = "root";
    private static final String password = "";
    private static final String dbName = "dlsv";
    private static final String url = "jdbc:mysql://" + hostName + ":3306/" + dbName;

    public static Connection ketNoi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection conn = DriverManager.getConnection(url, userName, password);
            Connection connection=DriverManager.getConnection(url,userName,password);
            System.out.println("Ket noi db thanh cong!");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ket noi that bai!");
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conn = demo.ketNoi();
        String sql="select * from sinhvien";

        try{
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2));
                conn.close();
            }
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
