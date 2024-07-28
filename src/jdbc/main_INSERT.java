/*package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.db;

public class main_INSERT {

    public static void main(String[] args) throws SQLException {
        
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = db.getConnection();
            st = conn.prepareStatement("INSERT INTO aleatorio(login,senha) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, "Ronaldo");
            st.setString(2, "777");
            
            int rowsAffected = st.executeUpdate();
            
            System.out.println("Rows affected: " + rowsAffected);
            
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long id = generatedKeys.getLong(1);
                        System.out.println("Inserted ID: " + id);
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (st != null) st.close();
            if (conn != null) conn.close();
        }
    }
}
*/