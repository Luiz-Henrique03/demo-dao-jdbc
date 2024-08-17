package model.DAO;

public class DaoFactoory {
	
	public static SellerDAO createSellerDAO() {
		return new SellerDaoJDBC();
	}
}
