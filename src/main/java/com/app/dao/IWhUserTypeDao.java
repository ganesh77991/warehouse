package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {

	public Integer createWhUserType(WhUserType user);
		
	public List<WhUserType> getAllWhUserTypes();

	public WhUserType getOneWhUserTypeById(Integer omId);

	public void deleteWhUserType(Integer omId);

	public void updateWhUserType(WhUserType om);
	
	public List<WhUserType> getWhUserTypesByType(String userType);
}
