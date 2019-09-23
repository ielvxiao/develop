package com.lvxiao.elasticsearch;


import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/9/10 5:53 下午
 */
public class EsTest {
    public final static String HOST="localhost";

    //http请求的端口是9200，客户端是9300
    public final static int PORT = 9300;

    public final static String CLUSTERNAME = "es-cluster";

    public static TransportClient getConnection() throws Exception {

        Settings settings = Settings.builder()
                .put("client.transport.sniff", false) //增加嗅探机制，找到ES集群
                .put("cluster.name", CLUSTERNAME)  // 设置集群名称
                .put("thread_pool.search.size", 20)// 增加线程池个数，暂时设为20
                .build();
        // 创建client
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddresses(new TransportAddress(InetAddress.getByName(HOST), PORT));

        return client;
    }

    /*
     * 添加
     * 索引和类型是必需的，而id部分是可选的。如果不指定ID，ElasticSearch会为我们生成一个ID。
     */
    public void add() throws Exception{
        try {
            XContentBuilder content = XContentFactory.jsonBuilder().startObject()
                    .field("name","吕啸")
                    .field("age",20)
                    .field("job","pro")
                    .endObject();

            String index = "data";   // 索引值
            String type ="person";   // 类型
            String id="2";           // id值
            TransportClient client = getConnection();
            IndexResponse iresp = client.prepareIndex(index, type,id).setSource(content).get();
            client.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /*
     * 添加索引:传入json字符串
     * id 自动创建
     *
     * */
    public void addJsonstr() throws Exception{
        String jsonstr = "{\"userName\":\"Tom\",\"date\":\"2018-11-7\",\"msg\":\"where are you\"}";
        TransportClient client = getConnection();
        IndexResponse iresp = client.prepareIndex("chat", "msg").setSource(jsonstr,XContentType.JSON).get();
        client.close();
        System.err.println(iresp.getIndex());
        System.err.println(iresp.getId());
        System.out.println(iresp.status());

    }

    /*
     * 添加索引:传入json
     *
     * */
    public void addJSON() throws Exception{

        JSONObject json = new JSONObject();
        json.put("userName", "allen");
        json.put("date", new Date().toString());
        json.put("msg", "hello  allen");

        TransportClient client = getConnection();
        IndexResponse iresp = client.prepareIndex("chat", "msg","3").setSource(json,XContentType.JSON).get();

        client.close();
        System.err.println(iresp.getIndex());
        System.err.println(iresp.getId());
        System.out.println(iresp.status());

    }

    /*
     * 创建索引-传入Map对象
     *
     * */
    public void addMap() throws Exception{
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userName", "吕啸");
        map.put("sendDate", new Date());
        map.put("msg", "hahahah");

        TransportClient client = getConnection();
        IndexResponse response = client.prepareIndex("momo", "msg","1").setSource(map).get();

    }

    /*
     * 获取数据
     */
    public void get(String index,String type,String id) throws Exception{
        TransportClient client = getConnection();
        GetResponse  result = client.prepareGet(index,type,id).get();
        System.out.println(result.getSourceAsString());
        System.out.println(result.getType());
        System.out.println(result.getVersion());
        System.err.println(result.getIndex());
        System.err.println(result.getId());

        client.close();
    }

    /*
     * 更新
     */
    public void update() throws Exception{
        XContentBuilder content = XContentFactory.jsonBuilder().startObject();
        content.field("age",22);
        content.field("job","boss");
        content.endObject();
        UpdateRequest request = new UpdateRequest("data","person","1");
        request.doc(content);
        TransportClient client = getConnection();
        UpdateResponse resp = client.update(request).get();
        client.close();
    }

    /*
     * 删除
     */
    public void delete() throws Exception{
        TransportClient client = getConnection();
        DeleteResponse  response = client.prepareDelete("data","person","1").get();
        client.close();
        System.out.println(response.getResult());
    }

    /*
     * 关闭
     */
    public static void closeConnect(TransportClient client){
        if(null !=client){
            client.close();
        }
    }


    public static void main(String[] args) throws Exception {
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("price", 260);
        MatchQueryBuilder builder = QueryBuilders.matchQuery("brand", "哥");
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().should(matchPhraseQueryBuilder).must(builder);
        TransportClient client = getConnection();
        SearchRequestBuilder requestBuilder = client.prepareSearch("commodity")
                .setTypes("commodity")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(queryBuilder);
        SearchResponse searchResponse = requestBuilder.setExplain(true).get();
        SearchHits searchHits = searchResponse.getHits();
        for (SearchHit searchHit : searchHits.getHits()) {
            System.out.println(searchHit.getSourceAsString());
        }
    }

}
