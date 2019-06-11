package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ItemDao;
import com.app.model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private HibernateTemplate ht;
	
	public Integer createItem(Item item) {
		// TODO Auto-generated method stub
		System.out.println("ItemDaoImpl.createItem()");
		System.out.println("-----------");
		System.out.println(item);
		Integer val=(Integer) ht.save(item);
		System.out.println(val);
		System.out.println("-----------");
		return val;
	}

	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return ht.loadAll(Item.class);
	}

	public Item getOneItemById(Integer itemId) {
		// TODO Auto-generated method stub
		return ht.get(Item.class, itemId);
	}

	public void deleteItem(Integer itemId) {
		// TODO Auto-generated method stub
		ht.delete(new Item(itemId));

	}

	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		ht.update(item);

	}

	@Override
	public boolean isUomConnectedWithItem(Integer uomId) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Long> rowsCount= (List<Long>) ht.findByCriteria( DetachedCriteria.forClass(Item.class)
		.setProjection(Projections.rowCount())
		.add(Restrictions.eq("uom.id", uomId))
		);
		
		return rowsCount.get(0)!=0?true:false;
	}

}
		