import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class App {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/jdbc_masyarakat";
        String username = "root";
        String password = "";
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM masyarakat");

            while (resultSet.next()) {
                String namadb = resultSet.getString("nama");
                String nisdb = resultSet.getString("nis");
                System.out.println(namadb + " | " + nisdb);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
