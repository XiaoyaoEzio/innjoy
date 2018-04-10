package me.innjoy.pms.utils;

import com.alibaba.fastjson.JSON;
import com.meituan.hotel.lock.client.common.BaseParam;
import com.meituan.hotel.lock.client.utils.AuthUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Component
public class PostUtils {
    private static String baseUrl;
    private static String appId;
    private static String appSecret;

    public static Map<String, String> executePost(String url, BaseParam param) throws IOException {
        // 生成请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(baseUrl + url);

        // 设置请求体
        param.setTimestamp(System.currentTimeMillis());
        StringEntity httpEntity = new StringEntity(JSON.toJSONString(param), "utf-8");
        httpPost.setEntity(httpEntity);

        // 设置请求头
        param.setAppId(appId);
        Map<String, String> header = AuthUtils.getHeader(param, appId, appSecret);
        String headerKey = "Authorization";
        String headerValue = header.get(headerKey);
        httpPost.setHeader(headerKey, headerValue);
        httpPost.setHeader("Content-type", "application/json; charset=utf-8");

        // 发送请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        Integer code = httpResponse.getStatusLine().getStatusCode();
        HttpEntity responseEntity = httpResponse.getEntity();
        String respJson = EntityUtils.toString(responseEntity);

        Map<String, String> map = new HashMap<>();
        map.put("code", code.toString());
        map.put("response", respJson);
        return map;
    }

    @Value("${meituan.baseurl}")
    public void setBaseUrl(String baseUrl) {
        PostUtils.baseUrl = baseUrl;
    }

    @Value("${meituan.appid}")
    public void setAppId(String appId) {
        PostUtils.appId = appId;
    }

    @Value("${meituan.appsecret}")
    public void setAppSecret(String appSecret) {
        PostUtils.appSecret = appSecret;
    }
}
