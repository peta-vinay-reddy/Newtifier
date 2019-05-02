package org.intl.newtifier;

import java.util.List;

import org.intl.newtifier.model.Item;
import org.intl.newtifier.model.RSSFeed;
import org.intl.newtifier.parser.EspnRSSFeedParser;
import org.intl.newtifier.parser.NdtvRSSFeedParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewtifierApplication implements CommandLineRunner {

	@Autowired
	NdtvRSSFeedParser parser;

	public static void main(String[] args) {
		SpringApplication.run(NewtifierApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RSSFeed feed = new RSSFeed();
		feed.setUrl("https://sports.ndtv.com/rss/cricket");
		List<Item> items = parser.getItems(feed);
		System.out.println(items.size());
	}
}