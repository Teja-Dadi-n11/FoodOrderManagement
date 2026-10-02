package com.cp.service.impl;

import org.opensearch.action.index.IndexRequest;

import org.opensearch.action.index.IndexResponse;
import org.opensearch.action.search.SearchRequest;
import org.opensearch.action.search.SearchRequestBuilder;
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.index.query.BoolQueryBuilder;
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cp.dto.OutletMappingRequestDto;
import com.cp.helper.MapperFactory;
import com.cp.service.OpenSearchOutletService;

import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class OpenSearchOutletServiceImpl implements OpenSearchOutletService {
	
	@Autowired
	private RestHighLevelClient restHighLevelClient;
	private ObjectMapper objectMapper = MapperFactory.INSTANCE.getInstance();
    
	@Value("${outlet.index.name}")
	private String outletIndexName;
	@Override
	public String indexOutlet(OutletMappingRequestDto outletMappingRequestDto) {
		try {
		
		String stringMappingDTO = objectMapper.writeValueAsString(outletMappingRequestDto);
		IndexRequest indexRequest=new IndexRequest().index(outletIndexName).source(stringMappingDTO,XContentType.JSON);
		IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
		if(indexResponse!=null) {
			return "Success";
		}else {
			return "Failed";
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "Success";
	}
	@Override
	public String getOutletByName(String outletName) {
		try {
		SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder().query(QueryBuilders.matchQuery("outletname", outletName));
		SearchRequest searchRequest=new SearchRequest(outletIndexName).source(searchSourceBuilder);
		SearchResponse searchResponse=restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		
		if(searchResponse==null) {
			return "Failure";
		}else {
			return searchResponse.toString();
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
		
	}
	@Override
	public String searchByFullText(String searchText, Double userLatitude, Double userLongitude) {
		try {
			BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery()
					.must(QueryBuilders.multiMatchQuery(searchText, "outletname","cusinename"))
					.filter(QueryBuilders.geoDistanceQuery("outletlocation").point(userLatitude,userLongitude).distance("2km"));
			SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder().query(boolQueryBuilder);
			SearchRequest searchRequest=new SearchRequest().source(searchSourceBuilder);
			SearchResponse search=restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			
			if(search!=null) {
				return search.toString();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

}
