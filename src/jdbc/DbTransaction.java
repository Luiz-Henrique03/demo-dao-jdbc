package jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import DB.db;

public class DbTransaction {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE funcionarios SET salario = 7000 WHERE departamento = 1");
						
			
			int rows2 = st.executeUpdate("UPDATE funcionarios SET salario = 3000 WHERE departamento = 3");
			
			conn.commit();
				
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			
			conn.close();
			st.close();
		}
		

		

	}

}
