package DAO;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.DAO.DaoFactoory;
import model.DAO.SellerDAO;

public class main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		SellerDAO sellerDAO = DaoFactoory.createSellerDAO();
		Seller seller = sellerDAO.findById(3);
		System.out.println("Test 1 ------------------------ FindById");
		System.out.println(seller);
		System.out.println("Test 2 ------------------------ FindByDepartment");
		Department departamento = new Department(2,null);
		List<Seller> list = sellerDAO.findByDepartment(departamento);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}

		
	}

}
