package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer createOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		System.out.println(om);

		return (Integer) ht.save(om);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		// TODO Auto-generated method stub
		return ht.loadAll(OrderMethod.class);
	}

	@Override
	public OrderMethod getOneOrderMethodById(Integer omId) {
		// TODO Auto-generated method stub
		return ht.get(OrderMethod.class, omId);
	}

	@Override
	public void deleteOrderMethod(Integer omId) {

		ht.delete(new OrderMethod(omId));

	}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		ht.update(om);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMethod> getOrderMethodByMode(String mode) {
		// TODO Auto-generated method stub

		//String hql = " from " + OrderMethod.class.getName() + " where mode=?";

		//return (List<OrderMethod>) ht.find(hql, mode);
		
		return (List<OrderMethod>) ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class)
				.add(Restrictions.eq("mode", mode))
				);	
	}

}
