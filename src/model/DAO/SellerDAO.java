package model.DAO;

import java.util.List;

import DAO.Seller;

public interface SellerDAO {
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	
	Seller findById(Integer id);
	List<Seller> findAll();
}
