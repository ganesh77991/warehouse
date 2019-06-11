package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface ItemService {
	
	public Integer createItem(Item item);

	public List<Item> getAllItems();

	public Item getOneItemById(Integer itemId);

	public void deleteItem(Integer itemId);

	public void updateItem(Item item);

	public boolean isUomConnectedWithItem(Integer uomId);
	

}
