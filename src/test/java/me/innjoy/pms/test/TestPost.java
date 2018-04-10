package me.innjoy.pms.test;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestPost {
    @Test
    public void name() throws Exception {
        String url = "http://localhost:8080/test/post";
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> paramLists = new ArrayList<>();
        paramLists.add(new BasicNameValuePair("time", "哈哈哈"));
        HttpEntity httpEntity = new UrlEncodedFormEntity(paramLists, "utf-8");
        httpPost.setEntity(httpEntity);

        // HttpResponse response = httpClient.execute(httpPost);
        // Assert.notNull(response, "response, null");
        // HttpEntity entity = response.getEntity();
        // Assert.notNull(entity, "entity null");
        //
        // System.out.println(EntityUtils.toString(entity));
    }
}
