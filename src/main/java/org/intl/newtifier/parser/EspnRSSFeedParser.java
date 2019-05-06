package org.intl.newtifier.parser;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
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
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class EspnRSSFeedParser implements RSSFeedParser {

	@Override
	public List<Item> getItems(RSSFeed rssFeed) throws JAXBException, MalformedURLException {
		JAXBContext jc = JAXBContext.newInstance(EspnRSSFeed.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		EspnRSSFeed feed = (EspnRSSFeed) unmarshaller.unmarshal(new URL(rssFeed.getUrl()));

		ArrayList<Item> items = new ArrayList<Item>();
		for (EspnItem espnItem : feed.channel.espnItems) {
			Item item = new Item();
			item.setLink(espnItem.link);
			item.setDate(espnItem.date);
			item.setCoverImage(espnItem.coverImage);
			item.setDescription(espnItem.description);
			item.setSource("ESPN");
			item.setTitle(espnItem.title);
			System.out.println(espnItem.link + "--" + espnItem.date);
			items.add(item);
		}
		return items;
	}

	@XmlRootElement(name = "rss")
	@XmlAccessorType(XmlAccessType.FIELD)
	private static class EspnRSSFeed {

		@XmlElement(name = "channel")
		private Channel channel;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Channel {

		@XmlElement(name = "item")
		private List<EspnItem> espnItems;
	}

	private static class EspnItem {

		@XmlElement(name = "title")
		private String title;

		@XmlElement(name = "description")
		private String description;

		@XmlElement(name = "coverImage")
		private String coverImage;

		@XmlElement(name = "link")
		private String link;

		@XmlElement(name = "pubDate")
		@XmlJavaTypeAdapter(DateAdapter.class)
		private Date date;
	}

	private static class DateAdapter extends XmlAdapter<String, Date> {

		private final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");

		@Override
		public String marshal(Date v) throws Exception {
			return dateFormat.format(v);
		}

		@Override
		public Date unmarshal(String v) throws Exception {
			return dateFormat.parse(v);
		}

	}
}
