package DB;

import java.util.*;
import java.sql.*;
public class DBconnect {
    private Connection connection;
    private String jdbcUrl = "jdbc:mysql://localhost:3306/DB";
    private String jdbcUsername = "root";
    private String jdbcPassword = null;
    public DBconnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
        }
        catch(SQLException e) {
            System.out.print(e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
