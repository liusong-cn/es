package com.yngj.es.elasticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Index;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Administrator
 * @date: 2021/1/26 23:01
 */
@RestController
public class DocumentController {

    @Autowired
    private JestClient jestClient;

    @PutMapping("/createDocument")
    public String createDocument() throws IOException {
//        Map<String, Object> doc = new HashMap<>();
//        doc.put("name", "liusong");
//        doc.put("age", 28);
//        doc.put("height", 170);
//        JestResult result = jestClient.execute(new Index.Builder(doc).index("person").build());
//        return result.getJsonString();

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("47.108.133.131", 9200, "http")
                        ));
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("1").source(jsonMap);
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
        return "response.get";
    }
}
