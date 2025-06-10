package banana.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnection {

    public Connection getConnection() {
        Connection conn = null;

        try {
         
            String url = "jdbc:postgresql://localhost:5432/banana";
            String user = "postgres";
            String password = "postgres";
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar no PostgreSQL: " + e.getMessage());
        }

        return conn;
    }
}
