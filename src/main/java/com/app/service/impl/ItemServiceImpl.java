package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ItemDao;
import com.app.model.Item;
import com.app.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao dao;
	
	@Override
	@Transactional
	public Integer createItem(Item item) {
		// TODO Auto-generated method stub
		return dao.createItem(item);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return dao.getAllItems();
	}

	@Override
	@Transactional(readOnly=true)
	public Item getOneItemById(Integer itemId) {
		// TODO Auto-generated method stub
		return dao.getOneItemById(itemId);
	}

	@Override
	@Transactional
	public void deleteItem(Integer itemId) {
		// TODO Auto-generated method stub
		dao.deleteItem(itemId);

	}

	@Override
	@Transactional
	public void updateItem(Item item) {
		// TODO Auto-generated method stub

		dao.updateItem(item);
	}

	@Override
	public boolean isUomConnectedWithItem(Integer uomId) {
		// TODO Auto-generated method stub
		return dao.isUomConnectedWithItem(uomId);
	}

	

}
