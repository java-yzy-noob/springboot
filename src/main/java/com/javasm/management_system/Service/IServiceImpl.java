package com.javasm.management_system.Service;

import com.javasm.management_system.Dao.IDao;
import com.javasm.management_system.Entity.TestData;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class IServiceImpl implements IService {

    @Resource
    private IDao id;
    @Resource
    SolrClient solrClient;

    @Override
    public List<TestData> getTr_data(int limit, int start, String theKey, String date_start, String date_end) {
        return id.getTr_data(limit, start, theKey, date_start, date_end);
    }

    @Override
    public List<TestData> getAllTr_data(String theKey, String date_start, String date_end) {
        return id.getAllTr_data(theKey, date_start, date_end);
    }

    @Override
    public List searchList(String key) {
        //  创建solr查询对象
        SolrQuery solrQuery = new SolrQuery();
        // 设定通配查询条件
        solrQuery.setQuery(key);

        try {
            QueryResponse queryResponse = solrClient.query("javasm", solrQuery);
            SolrDocumentList results = queryResponse.getResults();
            for (SolrDocument solrDocument : results) {
                System.out.println(solrDocument);
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String addContent() {
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        solrInputDocument.setField("s_id","aaaa");
        solrInputDocument.setField("content","aaaa_a");
        try {
            solrClient.add("javasm", solrInputDocument);
            UpdateResponse updateResponse = solrClient.commit("javasm");
            return updateResponse.toString();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
