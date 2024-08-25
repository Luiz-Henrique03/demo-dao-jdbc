package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mariadb.jdbc.Connection;

import DAO.Department;
import DAO.Seller;
import DB.db;

public class SellerDaoJDBC implements SellerDAO{

	private Connection conn;
	
		
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	public SellerDaoJDBC() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		Department dp = new Department();
		Seller obj = new Seller();

		try {
			
			st = conn.prepareStatement("SELECT funcionarios.*, department.name AS deepname FROM funcionarios JOIN department ON funcionarios.departamento = department.id WHERE funcionarios.id = ?;");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				dp.setId(rs.getInt("id"));
				dp.setName(rs.getString("deepname"));
				
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("nome"));
				obj.setBaseSalary(rs.getDouble("salario"));
				obj.setDepartment(dp);
				return obj;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
