package DB;


import java.sql.DriverManager;
import java.sql.SQLException;

import org.mariadb.jdbc.Connection;

public class db {
    private static final String URL = "jdbc:mariadb://localhost:3306/teste";
    private static final String USER = "usuario_teste";
    private static final String PASSWORD = "maycon123";

    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = db.getConnection()) {
            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Falha na conexão: " + e.getMessage());
        }
    }
}
