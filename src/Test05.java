import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test05 {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://192.168.3.66:15430/postgres";
        String username = "gpadmin";
        String password = "gpadmin";
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select " + "id" + " from " + "public.student"
                + " where '1'='2'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

    }
}
