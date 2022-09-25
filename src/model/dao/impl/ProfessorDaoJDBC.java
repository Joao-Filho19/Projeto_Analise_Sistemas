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
import model.dao.ProfessorDao;
import model.entities.Aluno;
import model.entities.Professor;
import model.entities.enums.Modalidade;

public class ProfessorDaoJDBC implements ProfessorDao{

	private Connection conn;
	
	public ProfessorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Professor obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO professor "
					+ "(nome, cpf, modalidade,telefone) "
					+ "VALUES "
					+ "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setString(3, String.valueOf(obj.getModalidade()));
			st.setString(4, obj.getTelefone());
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
	public void update(Professor obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE professor "
					+ "SET nome = ?, cpf = ?, modalidade = ?, telefone = ? "
					+ "WHERE id = ?");
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setString(3, String.valueOf(obj.getModalidade()));
			st.setString(4, obj.getTelefone());
			st.setInt(5, obj.getId());
			
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
			st = conn.prepareStatement("DELETE FROM professor WHERE Id = ?");
			
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
	public Professor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM professor WHERE Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Professor obj = new Professor();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setCpf(rs.getString("cpf"));
				obj.setModalidade(Modalidade.valueOf(rs.getString("modalidade")));
				obj.setTelefone(rs.getString("telefone"));
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
	public List<Professor> finAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = conn.prepareStatement(
				"SELECT * FROM professor ORDER BY nome");
			rs = st.executeQuery();

			List<Professor> list = new ArrayList<>();

			while (rs.next()) {
				Professor obj = new Professor();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				obj.setCpf(rs.getString("cpf"));
				obj.setModalidade(Modalidade.valueOf(rs.getString("modalidade")));
				obj.setTelefone(rs.getString("telefone"));
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
