package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.AlunoDao;
import model.dao.OperadorDao;
import model.dao.ProfessorDao;
import model.entities.Aluno;
import model.entities.Operador;
import model.entities.Professor;
import model.entities.enums.Modalidade;

public class OperadorDaoJDBC implements OperadorDao{

	private Connection conn;
	
	public OperadorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Operador obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO operador "+
					"(cpf,senha) "+ 
					 "VALUES "+
					"(?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getCpf());
			st.setString(2, obj.getSenha());
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
			
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
			}
		
	}

	@Override
	public void update(Operador obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE operador "
					+ "SET cpf = ?, senha = ? "
					+ "WHERE id = ?");
			
			st.setString(1, obj.getCpf());
			st.setString(2, obj.getSenha());
			st.setInt(3, obj.getId());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM operador WHERE Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Operador findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM operador WHERE Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Operador obj = new Operador();
				obj.setId(rs.getInt("id"));
				obj.setCpf(rs.getString("cpf"));
				obj.setSenha(rs.getString("senha"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Operador> finAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = conn.prepareStatement(
				"SELECT id,cpf FROM operador");
			rs = st.executeQuery();

			List<Operador> list = new ArrayList<>();

			while (rs.next()) {
				Operador obj = new Operador();
				obj.setId(rs.getInt("id"));
				obj.setCpf(rs.getString("cpf"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

}
