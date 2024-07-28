package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.db;

public class main_DELETE {
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			
			conn = db.getConnection();
			st = conn.prepareStatement("DELETE FROM aleatorio WHERE id = ?");
			
			st.setInt(1, 6);
			
			System.out.println("Affected Rows: " + st.executeUpdate());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			st.close();
			conn.close();
		}
	}
}
