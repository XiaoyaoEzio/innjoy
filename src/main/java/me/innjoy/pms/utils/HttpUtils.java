package me.innjoy.pms.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.meituan.hotel.lock.client.common.BaseParam;
import com.meituan.hotel.lock.client.exception.APIException;
import com.meituan.hotel.lock.client.results.APIResult;
import com.meituan.hotel.lock.client.utils.AuthUtils;
import me.innjoy.pms.pojo.dto.ResultDto;
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
import java.util.Map;

/**
 *
 */
@Component
public class HttpUtils {
    private static String baseUrl;
    private static String appId;
    private static String appSecret;

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static <T> ResultDto sendRequest(String uri, BaseParam param, Class<T> resultClass) throws APIException {
        // 生成请求
        HttpPost httpPost = new HttpPost(baseUrl + uri);

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
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert httpResponse != null;
        Integer code = httpResponse.getStatusLine().getStatusCode();
        HttpEntity responseEntity = httpResponse.getEntity();
        String respJson = null;
        try {
            respJson = EntityUtils.toString(responseEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject res = JSONObject.parseObject(respJson);
        APIResult<T> result = new APIResult<>();
        result.setStatus(res.getIntValue("status"));
        result.setMessage(res.getString("message"));
        result.setData(res.getObject("data", resultClass));

        if (result.getStatus() == 0) {
            return ResultDto.success();
        } else {
            System.out.println(result.getStatus());
            System.out.println(result.getMessage());
            return ResultDto.failure("服务器错误");
        }

    }

    @Value("${meituan.baseurl}")
    public void setBaseUrl(String baseUrl) {
        HttpUtils.baseUrl = baseUrl;
    }

    @Value("${meituan.appid}")
    public void setAppId(String appId) {
        HttpUtils.appId = appId;
    }

    @Value("${meituan.appsecret}")
    public void setAppSecret(String appSecret) {
        HttpUtils.appSecret = appSecret;
    }
}
