package com.yngj.es.elasticsearch;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author: Administrator
 * @date: 2021/1/26 21:47
 */
@RestController
public class IndexController {

    @Resource
    private JestClient jestClient;

    @PostMapping("/createIndex")
    public String createIndex(String indexName) throws IOException {
        CreateIndex index = new CreateIndex.Builder(indexName).build();
        JestResult result = jestClient.execute(index);
        return result.getJsonString();
    }

    @DeleteMapping("/deleteIndex")
    public String deleteIndex(String indexName) throws IOException {
        DeleteIndex index = new DeleteIndex.Builder(indexName).build();
        JestResult result = jestClient.execute(index);
        return result.getJsonString();
    }
}
