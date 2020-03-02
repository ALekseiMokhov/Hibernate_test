package buiseness_logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("Connection has been created");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Error!");
            e.printStackTrace();
        }
        return connection;
    }
}
