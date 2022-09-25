package model.dao;

import db.DB;
import model.dao.impl.AlunoDaoJDBC;
import model.dao.impl.ProfessorDaoJDBC;
import model.dao.impl.OperadorDaoJDBC;

public class DaoFactory {

	public static AlunoDao createAlunoDao() {
		return new AlunoDaoJDBC(DB.getConnection());
	}
	public static ProfessorDao createProfessorDao() {
		return new ProfessorDaoJDBC(DB.getConnection());
	}
	
	public static OperadorDao createOperadorDao() {
		return new OperadorDaoJDBC(DB.getConnection());
	}
	
}