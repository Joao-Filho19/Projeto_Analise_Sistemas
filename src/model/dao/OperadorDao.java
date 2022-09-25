package model.dao;

import java.util.List;

import model.entities.Operador;

public interface OperadorDao {
	void insert(Operador obj);
	void update(Operador obj);
	void deleteById(Integer id);
	Operador findById(Integer id);
	List<Operador> finAll();
}
