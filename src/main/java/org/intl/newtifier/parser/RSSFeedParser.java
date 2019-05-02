package org.intl.newtifier.parser;

import java.util.List;

import org.intl.newtifier.model.Item;
import org.intl.newtifier.model.RSSFeed;

public interface RSSFeedParser {

	public List<Item> getItems(RSSFeed feed) throws Exception;

}