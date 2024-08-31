package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mariadb.jdbc.Connection;

import DAO.Department;
import DAO.Seller;

public class SellerDaoJDBC implements SellerDAO {

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
	public Seller findById(Integer id) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		Department dp = null;
		Seller obj = null;

		try {
			st = conn.prepareStatement(
				"SELECT funcionarios.*, department.name AS deepname " +
				"FROM funcionarios JOIN department " +
				"ON funcionarios.departamento = department.id " +
				"WHERE funcionarios.id = ?;");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				dp = instantiateDepartment(rs);
				obj = instantiateSeller(rs, dp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("id"));
		obj.setName(rs.getString("nome"));
		obj.setBaseSalary(rs.getDouble("salario"));
		obj.setDepartment(dep);
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dp = new Department();
		dp.setId(rs.getInt("departamento"));
		dp.setName(rs.getString("deepname"));
		return dp;
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		Seller obj = null;

		try {
			st = conn.prepareStatement(
				"SELECT funcionarios.*, department.name AS deepname " +
				"FROM funcionarios " +
				"INNER JOIN department ON funcionarios.departamento = department.id " +
				"ORDER BY funcionarios.nome;");
			
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<Seller>();
			Map<Integer, Department> map = new HashMap<Integer, Department>();
			
			while (rs.next()) {
				Department dep = map.get(rs.getInt("departamento"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("departamento"), dep);
				}
				obj = instantiateSeller(rs, dep);
				list.add(obj);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Seller obj = null;

		try {
			st = conn.prepareStatement(
				"SELECT funcionarios.*, department.name AS deepname " +
				"FROM funcionarios " +
				"INNER JOIN department ON funcionarios.departamento = department.id " +
				"WHERE funcionarios.departamento = ? " +
				"ORDER BY funcionarios.nome;");
			st.setInt(1, department.getId());
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<Seller>();
			Map<Integer, Department> map = new HashMap<Integer, Department>();
			
			while (rs.next()) {
				Department dep = map.get(rs.getInt("departamento"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("departamento"), dep);
				}
				obj = instantiateSeller(rs, dep);
				list.add(obj);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
