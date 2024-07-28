/*package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import DB.db;

public class main_GET {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM aleatorio");
			
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + " + " + rs.getString("login"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
			rs.close();
		
		}

	}

}
*/