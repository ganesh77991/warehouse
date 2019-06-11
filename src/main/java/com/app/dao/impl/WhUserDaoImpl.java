package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository

public class WhUserDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer createWhUserType(WhUserType user) {
		return (Integer) ht.save(user);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

	@Override
	public WhUserType getOneWhUserTypeById(Integer omId) {
		return ht.get(WhUserType.class, omId);
	}

	@Override
	public void deleteWhUserType(Integer omId) {
		ht.delete(new WhUserType(omId));

	}

	@Override
	public void updateWhUserType(WhUserType om) {
		ht.update(om);

	}

	@Override
	public List<WhUserType> getWhUserTypesByType(String userType) {
		
		
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) ht.findByCriteria(DetachedCriteria.forClass(WhUserType.class)
		.add(Restrictions.eq("type",userType))
		);
		
		return list;
	}

}
