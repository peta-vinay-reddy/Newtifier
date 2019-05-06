package org.intl.newtifier.service;

import java.util.List;

import org.intl.newtifier.dao.IItemDAO;
import org.intl.newtifier.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemService implements IItemService {

	@Autowired
	IItemDAO dao;

	@Override
	public void addItem(Item item) {

	}

	@Override
	public void addItems(List<Item> items) {
		for(Item item : items)
			dao.putItem(item);
	}

	@Override
	public void deleteItemById(String id) {

	}

	@Override
	public Item getItemById(String id) {
		return null;
	}

}
