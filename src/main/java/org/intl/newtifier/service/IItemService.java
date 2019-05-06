package org.intl.newtifier.service;

import java.util.List;

import org.intl.newtifier.model.Item;

public interface IItemService {

	public void addItem(Item item);

	public void addItems(List<Item> items);

	public void deleteItemById(String id);

	public Item getItemById(String id);

}