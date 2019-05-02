package org.intl.newtifier.model;

import java.util.Date;

public class Item {

	private String title;
	private String description;
	private String link;
	private String coverImage;
	private String source;
	private Date date;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", description=" + description + ", link=" + link + ", coverImage=" + coverImage
				+ ", source=" + source + ", date=" + date + "]";
	}

}
