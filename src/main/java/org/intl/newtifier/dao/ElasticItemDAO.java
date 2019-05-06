package org.intl.newtifier.dao;

import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.intl.newtifier.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ElasticItemDAO implements IItemDAO {

	private RestClient restClient;

	public ElasticItemDAO() {
		this.restClient = RestClient.builder(new HttpHost("192.168.0.106", 9200, "http")).build();
	}

	@Override
	public List<Item> getAllItems() {
		return null;
	}

	@Override
	public List<Item> getAllItemsBeforeDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItemById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemBySource(String source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delteItemById(String id) {
		// TODO Auto-generated method stub

	}

	public int putItem(String index, String type, String json) {

		Map<String, String> params = Collections.emptyMap();
		HttpEntity entity = new NStringEntity(json, ContentType.APPLICATION_JSON);
		Response response = null;
		try {
			response = restClient.performRequest("POST", "/" + index + "/" + type, params, entity);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response.getStatusLine().getStatusCode();

	}

	@Override
	public void putItem(Item item) {
		try {
			String json = new ObjectMapper().writeValueAsString(item);
			System.out.println(json);
			putItem("itemidx", "_doc", json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}