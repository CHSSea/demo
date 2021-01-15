import java.sql.*;

public class HbasePhoenix {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        //String url = "jdbc:phoenix:master:2181";

        Connection connection = DriverManager.getConnection("jdbc:phoenix:106.15.251.138:2181", "", "");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("ID"));
        }
    }
}
