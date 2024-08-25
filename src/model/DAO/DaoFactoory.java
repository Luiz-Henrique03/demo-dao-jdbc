package model.DAO;

import java.sql.SQLException;

import DB.db;

public class DaoFactoory {
	
	public static SellerDAO createSellerDAO() throws SQLException {
		return new SellerDaoJDBC(db.getConnection());
	}
}
