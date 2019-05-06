package org.intl.newtifier.dao;

import java.sql.Date;
import java.util.List;

import org.intl.newtifier.model.Item;

public interface IItemDAO {

	public List<Item> getAllItems();

	public List<Item> getAllItemsBeforeDate(Date date);

	public Item getItemById(String id);

	public List<Item> getItemBySource(String source);

	public void delteItemById(String id);
	
	public void putItem(Item id);
	
}