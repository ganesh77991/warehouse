package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer createUom(Uom uom) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(uom);
	}

	@Override
	public List<Uom> getAllUoms() {
		// TODO Auto-generated method stub
		return ht.loadAll(Uom.class);
	}

	@Override
	public Uom getOneUomById(Integer uomId) {
		// TODO Auto-generated method stub
		
		return ht.get(Uom.class, uomId);
	}

	@Override
	public void deleteUom(Integer uomId) {
		// TODO Auto-generated method stub
		Uom uom=new Uom(uomId);
		System.out.println("delete...");
		ht.delete(uom);
		
	}

	@Override
	public void updateUom(Uom uom) {
		// TODO Auto-generated method stub
		System.out.println("jjjjjjjjj"+uom);
		ht.update(uom);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUomModelExist(String model) {
		// TODO Auto-generated method stub
		
	  List<Long> rowsCount=(List<Long>) ht.findByCriteria(DetachedCriteria.forClass(Uom.class)
	.setProjection(Projections.rowCount())
	.add(Restrictions.eq("model", model))
	);
		
		return rowsCount.get(0)!=0?true:false;
	}

}
