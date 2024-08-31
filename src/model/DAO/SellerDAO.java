package model.DAO;

import java.sql.SQLException;
import java.util.List;

import DAO.Department;
import DAO.Seller;

public interface SellerDAO {
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	
	Seller findById(Integer id) throws SQLException;
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
}
