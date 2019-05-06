package org.intl.newtifier;

import java.util.List;

import org.intl.newtifier.model.Item;
import org.intl.newtifier.model.RSSFeed;
import org.intl.newtifier.parser.RSSFeedParser;
import org.intl.newtifier.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewtifierApplication implements CommandLineRunner {

	@Autowired
	RSSFeedParser parser;

	@Autowired
	IItemService itemService;
	
	public static void main(String[] args) {
		SpringApplication.run(NewtifierApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		RSSFeed feed = new RSSFeed();
		feed.setUrl("http://www.espncricinfo.com/rss/content/story/feeds/0.xml");
		List<Item> items = parser.getItems(feed);
		System.out.println(items.size());
		itemService.addItems(items);
	}
}