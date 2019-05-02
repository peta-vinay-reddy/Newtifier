package org.intl.newtifier.parser;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.intl.newtifier.model.Item;
import org.intl.newtifier.model.RSSFeed;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class NdtvRSSFeedParser implements RSSFeedParser {

	@Override
	public List<Item> getItems(RSSFeed rssFeed) throws JAXBException, MalformedURLException {
		JAXBContext jc = JAXBContext.newInstance(NdtvRSSFeed.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		NdtvRSSFeed feed = (NdtvRSSFeed) unmarshaller.unmarshal(new URL(rssFeed.getUrl()));

		ArrayList<Item> items = new ArrayList<Item>();
		for (NdtvItem ndtvItem : feed.channel.ndtvItems) {
			Item item = new Item();
			item.setLink(ndtvItem.link);
			item.setDate(null);
			item.setCoverImage(null);
			item.setDescription(ndtvItem.e);
			item.setSource("");
			item.setTitle(ndtvItem.title);
			System.out.println(ndtvItem.link + "--" + ndtvItem.updated);
			items.add(item);
		}
		return items;
	}

	@XmlRootElement(name = "rss")
	@XmlAccessorType(XmlAccessType.FIELD)
	private static class NdtvRSSFeed {

		@XmlElement(name = "channel")
		private Channel channel;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Channel {

		@XmlElement(name = "item")
		private List<NdtvItem> ndtvItems;
	}

	private static class NdtvItem {

		@XmlElement(name = "title")
		private String title;

		@XmlElement(name = "description")
		private String e;

		@XmlElement(name = "link")
		private String link;

		@XmlElement(name = "a10:updated")
		private String updated;
		
	}

	/*private static class DateAdapter extends XmlAdapter<String, Instant> {

		//private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

		@Override
		public String marshal(Instant v) throws Exception {
			return v.format(v);
		}

		@Override
		public Instant unmarshal(String v) throws Exception {
			return Instant.parse(v);
		}
	}*/

}
