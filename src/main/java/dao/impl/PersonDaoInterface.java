package dao.impl;

import java.sql.SQLException;

import domain.Person;

public interface PersonDaoInterface {

	void  insertPerson(Person p) throws SQLException;
	
	void updatePerson(Person p) throws SQLException;
	
	void selectPerson(Person p) throws SQLException;
	
	void selectAllPerson(Person p) throws SQLException;
	
	void deletePerson(Person p) throws SQLException;
	
	void deleteAllPerson(Person p) throws SQLException;
}
