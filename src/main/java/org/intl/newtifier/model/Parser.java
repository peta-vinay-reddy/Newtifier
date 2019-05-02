package org.intl.newtifier.model;

public enum Parser {

	ESPN_RSS_FEED_PARSER("ESPN_RSS_FEED_PARSER"), NDTV_RSS_FEED_PARSER("NDTV_RSS_FEED_PARSER"), DEFAULT_RSS_FEED_PARSER(
			"DEFAULT_RSS_FEED_PARSER");

	private String value;

	Parser(String value) {
		this.value = value;
	}

	public String toString() {
		return this.value;
	}
}