package DAO;

import java.sql.SQLException;
import java.util.Date;

import model.DAO.DaoFactoory;
import model.DAO.SellerDAO;

public class main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		SellerDAO sellerDAO = DaoFactoory.createSellerDAO();
		Seller seller = sellerDAO.findById(3);
		System.out.println("Test 1 ------------------------ FindById");
		System.out.println(seller);
	}

}
