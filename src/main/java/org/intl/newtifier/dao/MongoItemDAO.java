package org.intl.newtifier.dao;

import java.sql.Date;
import java.util.List;

import org.intl.newtifier.model.Item;

public class MongoItemDAO implements IItemDAO{
	
	@Override
	public List<Item> getAllItems() {
		return null;
	}

	@Override
	public List<Item> getAllItemsBeforeDate(Date date) {
		return null;
	}

	@Override
	public Item getItemById(String id) {
		return null;
	}

	@Override
	public List<Item> getItemBySource(String source) {
		return null;
	}

	@Override
	public void delteItemById(String id) {
		
	}

	@Override
	public void putItem(Item id) {
		// TODO Auto-generated method stub
		
	}

}
