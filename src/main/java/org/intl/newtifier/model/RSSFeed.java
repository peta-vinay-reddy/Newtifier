package org.intl.newtifier.model;

public class RSSFeed {

	private String url;
	private String source;
	private Parser parser;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	@Override
	public String toString() {
		return "RSSFeed [url=" + url + ", source=" + source + ", parser=" + parser + "]";
	}

}
